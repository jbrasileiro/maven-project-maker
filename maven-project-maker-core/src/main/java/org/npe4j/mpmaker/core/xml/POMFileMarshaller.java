package org.npe4j.mpmaker.core.xml;

import java.io.File;

import org.npe4j.mpmakerxml.xml.pom.XMLProjectObjectModel;

public interface POMFileMarshaller {

    XMLProjectObjectModel readPOM(
        File file);

    File writePOM(
        XMLProjectObjectModel o,
        File file);
}
