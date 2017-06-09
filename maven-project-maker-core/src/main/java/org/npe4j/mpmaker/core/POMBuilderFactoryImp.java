package org.npe4j.mpmaker.core;

import java.util.HashMap;
import java.util.Map;

import org.npe4j.mpmaker.core.builder.DefaultPOMBuilder;
import org.npe4j.mpmaker.core.builder.SimplePOMBuilder;
import org.npe4j.mpmaker.core.builder.XMLProjectObjectModelBuilder;
import org.npe4j.mpmaker.core.enums.TypeProjectMaven;

public final class POMBuilderFactoryImp
    implements
    POMBuilderFactory {

    @Override
    public XMLProjectObjectModelBuilder make(
        final TypeProjectMaven type,
        final BasicPOMInformation info) {
        return getMap(info).get(type);
    }

    private Map<TypeProjectMaven, XMLProjectObjectModelBuilder> getMap(
        final BasicPOMInformation info) {
        HashMap<TypeProjectMaven, XMLProjectObjectModelBuilder> result = new HashMap<>();
        result.put(TypeProjectMaven.NONE, new SimplePOMBuilder(info));
        result.put(TypeProjectMaven.DEFAULT, new DefaultPOMBuilder(info));
        return result;
    }
}
