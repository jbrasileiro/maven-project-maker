package org.npe4j.mpmaker.core.builder;

import org.npe4j.mpmaker.bean.BasicPOMInformation;
import org.npe4j.mpmaker.core.enums.TypePOMPacking;
import org.npe4j.mpmakerxml.xml.pom.XMLProjectObjectModel;

public final class SimplePOMBuilder
    extends
    AbstractXMLProjectObjectModelBuilder {

    private static String modelVersion = "4.0.0";

    public SimplePOMBuilder(
        final String groupId,
        final String artifactId,
        final String name,
        final String version,
        final TypePOMPacking packing) {
        super(new POMBuilder()
            .withModelVersion(modelVersion)
            .withGroupId(groupId)
            .withArtifactId(artifactId)
            .withName(name)
            .withVersion(version)
            .withPackaging(packing));
    }

    public SimplePOMBuilder(
        final BasicPOMInformation info) {
        this(info.getGroupId(),
            info.getArtifactId(),
            info.getName(),
            info.getVersion(),
            info.getPacking());
    }

    @Override
    public XMLProjectObjectModel build() {
        return new XMLProjectObjectModel(this);
    }
}
