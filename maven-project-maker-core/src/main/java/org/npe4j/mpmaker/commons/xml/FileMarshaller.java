package org.npe4j.mpmaker.commons.xml;

import java.io.File;

import org.npe4j.mpmaker.core.xml.pom.XMLProjectObjectModel;

public interface FileMarshaller {

    XMLProjectObjectModel readPOM(
        File file);

    File writePOM(
        XMLProjectObjectModel o,
        File file);
}
