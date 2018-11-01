package org.npe4j.mpmaker.bean;

import java.util.Locale;

import org.npe4j.mpmaker.core.enums.TypePOMPacking;

public final class BasicPOMInformationImp
    implements
    BasicPOMInformation {

    private final String groupId;
    private final String artifactId;
    private final String name;
    private final String version;
    private final String packing;

    public BasicPOMInformationImp(
        final String groupId,
        final String artifactId,
        final String version,
        final String packing) {
        this(groupId, artifactId, null, version, packing);
    }

    public BasicPOMInformationImp(
        final String groupId,
        final String artifactId,
        final String name,
        final String version,
        final String packing) {
        super();
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.name = name;
        this.version = version;
        this.packing = packing;
    }

    @Override
    public String getGroupId() {
        return groupId;
    }

    @Override
    public String getArtifactId() {
        return artifactId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public TypePOMPacking getPacking() {
        return TypePOMPacking.valueOf(packing.toUpperCase(Locale.US));
    }
}
