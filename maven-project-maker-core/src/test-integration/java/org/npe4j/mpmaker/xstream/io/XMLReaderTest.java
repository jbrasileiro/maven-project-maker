package org.npe4j.mpmaker.xstream.io;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.npe4j.mpmaker.commons.io.FileReader;
import org.npe4j.mpmaker.commons.io.GenericFileMarshaller;
import org.npe4j.mpmaker.commons.io.jaxb.GenericJAXBMarshaller;
import org.npe4j.mpmaker.core.xml.POMXMLMarshaller;
import org.npe4j.mpmakerxml.xml.pom.XMLProjectObjectModel;

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
    public void writePOM() {
        XMLProjectObjectModel o = new XMLProjectObjectModel();
        File result = marshaller.writePOM(o, new File(folder.getRoot(), "/POM/pom.xml"));
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

    private File getFile(
        final String name) {
        String path = "/file/POM/jaxb/".concat(name);
        String file = getClass().getResource(path).getFile();
        return new File(file);
    }
}
