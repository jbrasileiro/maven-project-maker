package org.npe4j.mpmaker.core.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.npe4j.mpmaker.commons.io.FileReader;
import org.npe4j.mpmaker.commons.io.GenericFileMarshaller;
import org.npe4j.mpmaker.commons.io.jaxb.GenericJAXBMarshaller;
import org.npe4j.mpmakerxml.xml.custom.XMLProperty;
import org.npe4j.mpmakerxml.xml.pom.XMLDependency;
import org.npe4j.mpmakerxml.xml.pom.XMLDependencyGroup;
import org.npe4j.mpmakerxml.xml.pom.XMLDependencyManagement;
import org.npe4j.mpmakerxml.xml.pom.XMLProjectObjectModel;
import org.npe4j.mpmakerxml.xml.pom.XMLPropertyGroup;

public class XMLReaderTest {

    private static final FileReader reader = new FileReader();
    private POMXMLMarshaller marshaller;
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setup() {
        GenericFileMarshaller reader = new GenericJAXBMarshaller();
        marshaller = new POMXMLMarshaller(reader);
    }

    @Test
    public void readPOM() {
        XMLProjectObjectModel result = marshaller.readPOM(getFile("pom-empty.xml"));
        Assert.assertNull(result.getModelVersion());
        Assert.assertNull(result.getBuild());
        Assert.assertNull(result.getDependencies());
        Assert.assertNull(result.getDependencyManagement());
        Assert.assertNull(result.getModules());
    }

    @Test
    public void readPOM_ex03() {
        XMLProjectObjectModel result = marshaller.readPOM(getFile("/pom-02.xml"));
        result.setProperties(toProperties(result));
        result.setDependencies(toDependencies(result));
        marshaller.writePOM(result, new File("c:\\.tmp\\pom.xml"));
    }

    private XMLDependencyGroup toDependencies(
        final XMLProjectObjectModel result) {
        List<XMLDependency> dependencies = result.getDependencies().getDependencies();
        // List<XMLProperty> properties =
        // result.getProperties().getProperties();
        // Map<String, String> map = new HashMap<>();
        // for (XMLDependency xmlDependency : dependencies) {
        // String version = xmlDependency.getVersion();
        // if (version != null && version.contains("${") && has(properties,
        // version)) {
        // xmlDependency.setVersion(get(properties, version).getValue());
        // }
        // addVersion(map, xmlDependency);
        // }
        // List<XMLDependency> ndependencies = new ArrayList<>();
        // for (XMLDependency xmlDependency : dependencies) {
        // if (!ndependencies.contains(xmlDependency) &&
        // xmlDependency.getVersion() != null) {
        // ndependencies.add(xmlDependency);
        // }
        // }
        List<XMLDependency> ndependencies = new ArrayList<>();
        for (XMLDependency xmlDependency : dependencies) {
            if (!ndependencies.contains(xmlDependency) && xmlDependency.getVersion() != null) {
                String version
                    = String.format("${%s}", "version.".concat(xmlDependency.getArtifactId()));
                xmlDependency.setVersion(version);
                ndependencies.add(xmlDependency);
            }
        }
        XMLDependencyGroup gDependencies = new XMLDependencyGroup();
        Collections.sort(ndependencies, (
            o1,
            o2) -> o1.compareTo(o2));
        gDependencies.addAll(ndependencies);
        return gDependencies;
    }

    private void addVersion(
        final Map<String, String> map,
        final XMLDependency o) {
        String id = String.format("%s.%s", o.getGroupId(), o.getArtifactId());
        String version = o.getVersion();
        if (map.containsKey(id)) {
            String oVersion = map.get(id);
            if (oVersion.compareToIgnoreCase(version) < 0) {
                System.err.println(String.format("Replace version of id[%s] from [%s] for/to [%s] ",
                    id, oVersion, version));
                map.put(id, version);
            } else {
                if (oVersion.equals(version)) {
                } else {
                    System.err.println(
                        String.format("No replace version of id [%s] from [%s] for/to [%s] ", id,
                            oVersion, version));
                }
            }
        } else {
            map.put(id, version);
        }
    }

    private XMLPropertyGroup toProperties(
        final XMLProjectObjectModel result) {
        List<XMLProperty> properties = result.getProperties().getProperties();
        List<XMLProperty> nproperties = new ArrayList<>();
        for (XMLProperty xmlProperty : properties) {
            if (!nproperties.contains(xmlProperty)) {
                nproperties.add(xmlProperty);
            }
        }
        XMLPropertyGroup gProperties = new XMLPropertyGroup();
        Collections.sort(nproperties, comparator());
        gProperties.addAll(nproperties);
        return gProperties;
    }

    private boolean has(
        final List<XMLProperty> properties,
        final String version) {
        for (XMLProperty xmlProperty : properties) {
            String value = xmlProperty.getProperty().getName();
            if (value.equals(value.replaceAll("\\$\\{", "").replaceAll("\\}", ""))) {
                return true;
            }
        }
        return false;
    }

    private XMLProperty get(
        final List<XMLProperty> properties,
        final String value) {
        for (XMLProperty xmlProperty : properties) {
            String name = xmlProperty.getProperty().getName();
            if (name.equals(value.replaceAll("\\$\\{", "").replaceAll("\\}", ""))) {
                return xmlProperty;
            }
        }
        throw new IllegalArgumentException();
    }

    private Comparator<XMLProperty> comparator() {
        return (
            o1,
            o2) -> {
            return o1.getProperty().compareTo(o2.getProperty());
        };
    }

    @Test
    public void writePOM() {
        XMLProjectObjectModel pom = new XMLProjectObjectModel();
        File result = marshaller.writePOM(pom, new File(folder.getRoot(), "/POM/pom.xml"));
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n");
        builder.append("<project ");
        builder.append("xmlns=\"http://maven.apache.org/POM/4.0.0\" ");
        builder.append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ");
        builder.append("xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 ");
        builder.append("http://maven.apache.org/xsd/maven-4.0.0.xsd\"");
        builder.append("/>\n");
        Assert.assertEquals(builder.toString(), reader.getContent(result));
    }

    @Test
    public void writePOM_ex02()
        throws Exception {
        XMLProjectObjectModel o = new XMLProjectObjectModel();
        XMLDependencyManagement dependencyManagement = new XMLDependencyManagement();
        dependencyManagement.setDependencies(new XMLDependencyGroup());
        o.setDependencyManagement(dependencyManagement);
        XMLDependency value = new XMLDependency();
        value.setArtifactId("ex");
        o.getDependencyManagement().add(value);
        File result = marshaller.writePOM(o, new File(folder.getRoot(), "/POM/pom.xml"));
        Assert.assertEquals("", FileUtils.readFileToString(result));
    }

    private File getFile(
        final String name) {
        String path = "file/POM/jaxb/".concat(name);
        String file = getClass().getResource(path).getFile();
        return new File(file);
    }
}
