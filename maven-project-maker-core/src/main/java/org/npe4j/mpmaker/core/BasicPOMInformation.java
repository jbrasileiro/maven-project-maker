package org.npe4j.mpmaker.core;

import org.npe4j.mpmaker.core.enums.TypePOMPacking;

public interface BasicPOMInformation {

    String getGroupId();

    String getArtifactId();

    String getName();

    String getVersion();

    TypePOMPacking getPacking();
}
