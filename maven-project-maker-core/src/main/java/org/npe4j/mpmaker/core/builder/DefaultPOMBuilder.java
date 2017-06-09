package org.npe4j.mpmaker.core.builder;

import org.npe4j.mpmaker.core.BasicPOMInformation;
import org.npe4j.mpmaker.core.xml.pom.XMLProperty;

public final class DefaultPOMBuilder
    extends
    AbstractXMLProjectObjectModelBuilder {

    public DefaultPOMBuilder(
        final BasicPOMInformation info) {
        super(new SimplePOMBuilder(info)
            .addProperty(new XMLProperty("name", "value")));
    }
}
