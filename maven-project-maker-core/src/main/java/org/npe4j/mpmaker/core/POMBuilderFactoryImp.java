package org.npe4j.mpmaker.core;

import java.util.HashMap;
import java.util.Map;

import org.npe4j.mpmaker.bean.BasicPOMInformation;
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
        return getMap(info).get(type).get();
    }

    private Map<TypeProjectMaven, POMBuilderProvider> getMap(
        final BasicPOMInformation info) {
        HashMap<TypeProjectMaven, POMBuilderProvider> result = new HashMap<>();
        result.put(TypeProjectMaven.NONE, newSimplePOMBuilder(info));
        result.put(TypeProjectMaven.DEFAULT, newDefaultPOMBuilder(info));
        return result;
    }

    private POMBuilderProvider newSimplePOMBuilder(
        final BasicPOMInformation info) {
        return () -> new SimplePOMBuilder(info);
    }

    private POMBuilderProvider newDefaultPOMBuilder(
        final BasicPOMInformation info) {
        return () -> new DefaultPOMBuilder(info);
    }
}

interface POMBuilderProvider {

    XMLProjectObjectModelBuilder get();
}
