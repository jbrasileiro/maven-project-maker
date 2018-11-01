package org.npe4j.mpmaker.core.xml;

import java.io.File;

import org.npe4j.mpmaker.commons.io.GenericFileMarshaller;
import org.npe4j.mpmakerxml.xml.pom.XMLProjectObjectModel;

public final class POMXMLMarshaller
    implements
    POMFileMarshaller {

    private final GenericFileMarshaller xmlReader;

    public POMXMLMarshaller(
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
