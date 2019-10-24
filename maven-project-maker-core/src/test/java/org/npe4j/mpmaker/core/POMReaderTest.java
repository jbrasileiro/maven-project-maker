package org.npe4j.mpmaker.core;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.npe4j.mpmaker.commons.io.jaxb.GenericJAXBMarshaller;
import org.npe4j.mpmaker.core.xml.POMXMLMarshaller;
import org.npe4j.mpmakerxml.xml.custom.XMLProperty;
import org.npe4j.mpmakerxml.xml.pom.XMLDependency;
import org.npe4j.mpmakerxml.xml.pom.XMLDependencyGroup;
import org.npe4j.mpmakerxml.xml.pom.XMLDependencyManagement;
import org.npe4j.mpmakerxml.xml.pom.XMLProjectObjectModel;
import org.npe4j.mpmakerxml.xml.pom.XMLPropertyGroup;

public class POMReaderTest {

	@Test
	public void read() {
		readDependency(new File("C:\\.rep\\git\\NFeCloud\\nfe-authorize"), new File("c:\\.tmp\\properties.log"));
		generateBOM(new File("C:\\.rep\\git\\NFeCloud\\nfe-authorize"), new File("c:\\.tmp\\pom.xml"));
	}

	private void generateBOM(
		File directory,
		File output) {
		generateBOM(Arrays.asList(directory), output);
	}

	private void generateBOM(
		Collection<File> directory,
		File output) {

		List<File> files = scanPOM(directory);
		PomVO vo = new PomVO();
		for (File each : files) {
			XMLProjectObjectModel pom = new POMXMLMarshaller(new GenericJAXBMarshaller()).readPOM(each);
			vo.add(pom.getProperties());
			vo.add(pom.getDependencyManagement());
			vo.add(pom.getDependencies());
		}

		XMLProjectObjectModel pom = new XMLProjectObjectModel();
		pom.setModelVersion("4.0.0");
		pom.setGroupId("org.jbrasileiro");
		pom.setArtifactId("genetator-bom");
		pom.setVersion("0.0.1-SNAPSHOT");
		pom.setPackaging("pom");

		pom.setProperties(vo.toXMLPropertyGroup());
		pom.setDependencyManagement(vo.toDependenciesManagement());
		pom.setDependencies(vo.toXMLDependencyGroup());
		new POMXMLMarshaller(new GenericJAXBMarshaller()).writePOM(pom, output);
	}

	private void readDependency(File input, File output) {
		String result = readDependency(input);
		write(output, result);
	}

	private void write(
		File output,
		String result) {
		try {
			FileUtils.writeStringToFile(output, result, "UTF-8");
		}
		catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	private List<File> scanPOM(Collection<File> files) {
		List<File> result = new ArrayList<>();
		for (File each : files) {
			result.addAll(scanPOM(each));
		}
		return result;
	}

	private List<File> scanPOM(File file) {
		if(file.isDirectory()) {
			return scanDirectory(file);
		} else {
			if("pom.xml".equals(file.getName())) {
				return Arrays.asList(file);
			} else {
				throw new IllegalArgumentException(file.getPath() + " not a pom.xml.");
			}
		}

	}

	private List<File> scanDirectory(
		File file) {
		List<File> result = new ArrayList<>();
		File[] files = file.listFiles(filterPOM());
		if (files.length > 0) {
			if (files.length > 1) {
				throw new IllegalArgumentException(file.getPath().concat(" with more pom.xml."));
			}
			else {
				result.add(files[0]);
			}
		}
		File[] directories = file.listFiles(filterDirectory());
		if (directories != null && directories.length > 0) {
			for (File eachDirectory : directories) {
				result.addAll(scanPOM(eachDirectory));
			}
		}
		return result;
	}

	private String readDependency(File file) {
		List<File> files = scanPOM(file);
		StringBuilder builder = new StringBuilder();
		for (File each : files) {
			builder.append(read(each));
		}
		return builder.toString();
	}

	class PomVO {

		private final List<XMLDependency> dependencies = new ArrayList<>();
		private final List<XMLDependency> dependenciesManagement = new ArrayList<>();
		private final List<XMLProperty> properties = new ArrayList<>();

		public List<XMLDependency> getDependencies() {
			return dependencies;
		}

		public List<XMLDependency> getDependenciesManagement() {
			return dependenciesManagement;
		}

		public List<XMLProperty> getProperties() {
			return properties;
		}

		public void add(
			XMLDependencyGroup dependencies) {
			if (Objects.nonNull(dependencies)) {
				this.dependencies.addAll(dependencies.getDependencies());
			}
		}

		public void add(
			XMLPropertyGroup properties) {
			if (Objects.nonNull(properties)) {
				this.properties.addAll(properties.getProperties());
			}
		}

		public void add(
			XMLDependencyManagement dependencyManagement) {
			if(Objects.nonNull(dependencyManagement)
					&& Objects.nonNull(dependencyManagement.getDependencies())) {
				this.dependenciesManagement.addAll(dependencyManagement.getDependencies().getDependencies());
			}
		}

		public XMLDependencyGroup toXMLDependencyGroup() {
			Collections.sort(this.dependencies);
			XMLDependencyGroup result = new XMLDependencyGroup();
			result.setDependencies(dependencies);
			return result;
		}

		public XMLDependencyManagement toDependenciesManagement() {
			Collections.sort(this.dependenciesManagement);
			XMLDependencyManagement result = new XMLDependencyManagement();
			XMLDependencyGroup group = new XMLDependencyGroup();
			group.setDependencies(dependenciesManagement);
			result.setDependencies(group);
			return result;
		}

		public XMLPropertyGroup toXMLPropertyGroup() {
			Collections.sort(this.properties);
			return new XMLPropertyGroup(this.properties);
		}

	}

	private String read(File each) {
		try {
			String result = readFile(each);
			StringBuilder builder = new StringBuilder();
			builder.append("###############################");
			builder.append("\n");
			builder.append(each.getPath());
			builder.append("\n");
//			String dependencyManagement = sub(result, "<dependencyManagement>", "</dependencyManagement>");
//			builder.append(dependencyManagement);
//			builder.append("\n");
//			String dependencies = sub(result.replace(dependencyManagement, ""), "<dependencies>", "</dependencies>");
//			builder.append(dependencies);

			String properties = sub(result, "<properties>", "</properties>");
			builder.append(properties);

			builder.append("\n");
			builder.append("###############################");
			builder.append("\n");
			return builder.toString();
		}
		catch (IOException e) {
			StringBuilder builder = new StringBuilder();
			builder.append("###############################");
			builder.append("could not read : ".concat(each.getPath()));
			builder.append(e.getMessage());
			builder.append(e.toString());
			builder.append("###############################");
			return builder.toString();
		}
	}

	private String readFile(
		File each)
		throws IOException {
		return FileUtils.readFileToString(each, "UTF-8");
	}

	private String sub(String value, String sStart, String sEnd) {
		int start = value.indexOf(sStart);
		if (start == -1) {
			return "";
		}
		int end = value.indexOf(sEnd);
		return value.substring(start, end + sEnd.length());
	}

	private FilenameFilter filterPOM() {
		return new POMFilenameFilter();
	}

	private FileFilter filterDirectory() {
		return file -> file.isDirectory();
	}

}

final class POMFilenameFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		return dir.isDirectory() && name != null && new File(dir.getPath().concat("\\").concat(name)).isFile()
				&& name.equals("pom.xml");
	}

}