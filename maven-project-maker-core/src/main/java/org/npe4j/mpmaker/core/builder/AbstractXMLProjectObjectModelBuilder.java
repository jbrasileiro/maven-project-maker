package org.npe4j.mpmaker.core.builder;

import java.util.Locale;

import org.npe4j.mpmaker.commons.dp.BeanDPBuilder;
import org.npe4j.mpmaker.commons.dp.TemplateDPBuilder;
import org.npe4j.mpmaker.core.enums.TypePOMPacking;
import org.npe4j.mpmakerxml.xml.custom.XMLProperty;
import org.npe4j.mpmakerxml.xml.pom.XMLBuild;
import org.npe4j.mpmakerxml.xml.pom.XMLDependencyGroup;
import org.npe4j.mpmakerxml.xml.pom.XMLDependencyManagement;
import org.npe4j.mpmakerxml.xml.pom.XMLModuleGroup;
import org.npe4j.mpmakerxml.xml.pom.XMLPluginManagement;
import org.npe4j.mpmakerxml.xml.pom.XMLProjectObjectModel;
import org.npe4j.mpmakerxml.xml.pom.XMLPropertyGroup;

abstract class AbstractXMLProjectObjectModelBuilder
    extends
    TemplateDPBuilder<XMLProjectObjectModel>
    implements
    XMLProjectObjectModelBPBuilder {

    public AbstractXMLProjectObjectModelBuilder(
        final BeanDPBuilder<XMLProjectObjectModel> builder) {
        super(builder);
    }

    public AbstractXMLProjectObjectModelBuilder() {
        super(new XMLProjectObjectModel());
    }

    public final AbstractXMLProjectObjectModelBuilder withModelVersion(
        final String modelVersion) {
        getBean().setModelVersion(modelVersion);
        return this;
    }

    public final AbstractXMLProjectObjectModelBuilder withArtifactId(
        final String artifactId) {
        getBean().setArtifactId(artifactId);
        return this;
    }

    public final AbstractXMLProjectObjectModelBuilder withGroupId(
        final String groupId) {
        getBean().setGroupId(groupId);
        return this;
    }

    public final AbstractXMLProjectObjectModelBuilder withVersion(
        final String version) {
        getBean().setVersion(version);
        return this;
    }

    public final AbstractXMLProjectObjectModelBuilder withPackaging(
        final String packaging) {
        return withPackaging(TypePOMPacking.valueOf(packaging));
    }

    public final AbstractXMLProjectObjectModelBuilder withPackaging(
        final TypePOMPacking packaging) {
        getBean().setPackaging(packaging.name().toLowerCase(Locale.US));
        return this;
    }

    public final AbstractXMLProjectObjectModelBuilder withName(
        final String name) {
        getBean().setName(name);
        return this;
    }

    public final AbstractXMLProjectObjectModelBuilder withProperties(
        final XMLPropertyGroup properties) {
        getBean().setProperties(properties);
        return this;
    }

    public final AbstractXMLProjectObjectModelBuilder addProperty(
        final XMLProperty property) {
        if(getBean().getProperties() == null){
            getBean().setProperties(new XMLPropertyGroup());
        }
        getBean().getProperties().add(property);
        return this;
    }

    public final AbstractXMLProjectObjectModelBuilder withModules(
        final XMLModuleGroup modules) {
        getBean().setModules(modules);
        return this;
    }

    public final AbstractXMLProjectObjectModelBuilder withDependencyManagement(
        final XMLDependencyManagement dependencyManagement) {
        getBean().setDependencyManagement(dependencyManagement);
        return this;
    }

    public final AbstractXMLProjectObjectModelBuilder withDependencies(
        final XMLDependencyGroup dependencies) {
        getBean().setDependencies(dependencies);
        return this;
    }

    public final AbstractXMLProjectObjectModelBuilder withBuild(
        final XMLBuild build) {
        getBean().setBuild(build);
        return this;
    }

    public AbstractXMLProjectObjectModelBuilder withPluginManagement(
        final XMLPluginManagement pluginManagement) {
        XMLBuild build = new XMLBuild();
        build.setPluginManagement(pluginManagement);
        getBean().setBuild(build);
        return this;
    }
}
