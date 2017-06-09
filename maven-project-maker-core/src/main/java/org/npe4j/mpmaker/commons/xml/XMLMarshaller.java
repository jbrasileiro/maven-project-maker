package org.npe4j.mpmaker.commons.xml;

import java.io.File;

import org.npe4j.mpmaker.commons.io.GenericFileMarshaller;
import org.npe4j.mpmaker.core.xml.pom.XMLProjectObjectModel;

public final class XMLMarshaller
    implements
    FileMarshaller {

    private final GenericFileMarshaller xmlReader;

    public XMLMarshaller(
        final GenericFileMarshaller xmlReader) {
        super();
        this.xmlReader = xmlReader;
    }

    @Override
    public XMLProjectObjectModel readPOM(
        final File file) {
        return xmlReader.unmarshal(XMLProjectObjectModel.class, file);
    }

    @Override
    public File writePOM(
        final XMLProjectObjectModel o,
        final File file) {
        return xmlReader.marshal(XMLProjectObjectModel.class, o, file);
    }
}
