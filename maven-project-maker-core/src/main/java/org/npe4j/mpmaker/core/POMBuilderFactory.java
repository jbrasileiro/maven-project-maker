package org.npe4j.mpmaker.core;

import org.npe4j.mpmaker.bean.BasicPOMInformation;
import org.npe4j.mpmaker.core.builder.XMLProjectObjectModelBPBuilder;
import org.npe4j.mpmaker.core.enums.TypeProjectMaven;

public interface POMBuilderFactory {

    XMLProjectObjectModelBPBuilder make(
        TypeProjectMaven type,
        BasicPOMInformation info);
}
