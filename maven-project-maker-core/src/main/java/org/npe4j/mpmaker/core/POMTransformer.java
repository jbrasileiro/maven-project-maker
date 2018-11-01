package org.npe4j.mpmaker.core;

import org.npe4j.mpmaker.bean.BasicPOMInformation;
import org.npe4j.mpmaker.commons.dp.BeanDPBuilder;
import org.npe4j.mpmaker.core.enums.TypeProjectMaven;
import org.npe4j.mpmakerxml.xml.pom.XMLProjectObjectModel;

public interface POMTransformer
    extends
    GenericPOMTransformer<BeanDPBuilder<XMLProjectObjectModel>> {

    XMLProjectObjectModel transform(
        TypeProjectMaven type,
        BasicPOMInformation info);
}
