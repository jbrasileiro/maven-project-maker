package org.npe4j.mpmaker.core.builder;

import org.npe4j.mpmaker.bean.BasicPOMInformation;
import org.npe4j.mpmakerxml.xml.pom.XMLProjectObjectModel;

public final class POMBuilder
    extends
    AbstractXMLProjectObjectModelBuilder {

    public POMBuilder() {
        super();
    }

    public POMBuilder with(
        final BasicPOMInformation info) {
        withGroupId(info.getGroupId());
        withArtifactId(info.getArtifactId());
        withName(info.getName());
        withVersion(info.getVersion());
        withPackaging(info.getPacking());
        return this;
    }

    @Override
    public XMLProjectObjectModel build() {
        return new XMLProjectObjectModel(this);
    }
}
