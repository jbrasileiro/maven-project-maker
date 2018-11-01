package org.npe4j.mpmaker;

import java.io.File;

import org.npe4j.mpmaker.commons.dp.DPBuilder;
import org.npe4j.mpmaker.core.xml.POMFileMarshaller;
import org.npe4j.mpmakerxml.xml.pom.XMLProjectObjectModel;

public class MavenProjectMaker {

    private final POMFileMarshaller fileMarshaller;

    public MavenProjectMaker(
        final POMFileMarshaller fileMarshaller) {
        super();
        this.fileMarshaller = fileMarshaller;
    }

    public File create(
        final DPBuilder<XMLProjectObjectModel> builder,
        final File file) {
        return fileMarshaller.writePOM(builder.build(), file);
    }
}
