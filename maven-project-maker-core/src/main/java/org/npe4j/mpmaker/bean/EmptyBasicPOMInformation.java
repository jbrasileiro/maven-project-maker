package org.npe4j.mpmaker.bean;

import org.npe4j.mpmaker.core.enums.TypePOMPacking;

public final class EmptyBasicPOMInformation
    implements
    BasicPOMInformation {

    @Override
    public String getGroupId() {
        return "";
    }

    @Override
    public String getArtifactId() {
        return "";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getVersion() {
        return "";
    }

    @Override
    public TypePOMPacking getPacking() {
        return TypePOMPacking.POM;
    }
}
