package org.npe4j.mpmaker.core.builder;

import java.util.Collection;

import org.npe4j.mpmaker.bean.BasicPOMInformation;
import org.npe4j.mpmaker.commons.util.CollectionUtils;
import org.npe4j.mpmakerxml.xml.custom.XMLProperty;
import org.npe4j.mpmakerxml.xml.pom.XMLDependency;
import org.npe4j.mpmakerxml.xml.pom.XMLDependencyGroup;
import org.npe4j.mpmakerxml.xml.pom.XMLDependencyManagement;
import org.npe4j.mpmakerxml.xml.pom.XMLPlugin;
import org.npe4j.mpmakerxml.xml.pom.XMLPluginGroup;
import org.npe4j.mpmakerxml.xml.pom.XMLPluginManagement;
import org.npe4j.mpmakerxml.xml.pom.XMLProjectObjectModel;
import org.npe4j.mpmakerxml.xml.pom.XMLPropertyGroup;

public final class DefaultPOMBuilder
    extends
    AbstractXMLProjectObjectModelBuilder {

    private final BasicPOMInformation info;

    public DefaultPOMBuilder(
        final BasicPOMInformation info) {
        this.info = info;
    }

    protected XMLDependencyManagement dependencyManagement() {
        XMLDependencyManagement dependencyManagement = new XMLDependencyManagement();
        XMLDependencyGroup group = new XMLDependencyGroup();
        group.addAll(dependencies());
        dependencyManagement.setDependencies(group);
        return dependencyManagement;
    }

    private XMLProperty newXMLProperty(
        final String name,
        final String value) {
        return new XMLProperty(name, value);
    }

    protected XMLPropertyGroup properties() {
        XMLPropertyGroup result = new XMLPropertyGroup();
        result.addAll(getProjectProperties());
        result.addAll(getPluginVersionProperties());
        result.addAll(getDependencyVersionProperties());
        return result;
    }

    private Collection<XMLProperty> getProjectProperties() {
        Collection<XMLProperty> collection = newLinkedList();
        collection.add(newXMLProperty("project.property.folder", "${basedir}/src/properties"));
        return collection;
    }

    protected Collection<XMLProperty> getPluginVersionProperties() {
        Collection<XMLProperty> collection = newLinkedList();
        collection.add(newXMLProperty("version-maven-compiler-plugin", "3.6.1"));
        collection.add(newXMLProperty("version-maven-resources-plugin", "3.0.1"));
        collection.add(newXMLProperty("version-sonar-maven-plugin", "3.2"));
        collection.add(newXMLProperty("version-properties-maven-plugin", "1.0.0"));
        collection.add(newXMLProperty("version-build-helper-maven-plugin", "3.0.0"));
        collection.add(newXMLProperty("version-maven-failsafe-plugin", "2.20"));
        return collection;
    }

    protected Collection<XMLProperty> getDependencyVersionProperties() {
        Collection<XMLProperty> collection = newLinkedList();
        collection.add(newXMLProperty("version-junit", "4.12"));
        collection.add(newXMLProperty("version-mockito-all", "1.10.19"));
        return collection;
    }

    private <T> Collection<T> newLinkedList() {
        return CollectionUtils.newLinkedList();
    }

    private Collection<XMLDependency> dependencies() {
        Collection<XMLDependency> collection = newLinkedList();
        collection.add(junit());
        collection.add(mockitoAll());
        return collection;
    }

    private XMLDependency junit() {
        String groupId = "junit";
        String artifactId = "junit";
        String version = "${version-junit}";
        String scope = "test";
        return xmlDependency(groupId, artifactId, version, scope);
    }

    private XMLDependency mockitoAll() {
        String groupId = "org.mockito";
        String artifactId = "mockito-all";
        String version = "${version-mockito-all}";
        String scope = "test";
        return xmlDependency(groupId, artifactId, version, scope);
    }

    private XMLDependency xmlDependency(
        final String groupId,
        final String artifactId,
        final String version,
        final String scope) {
        XMLDependency dep = new XMLDependency();
        dep.setGroupId(groupId);
        dep.setArtifactId(artifactId);
        dep.setVersion(version);
        dep.setScope(scope);
        return dep;
    }

    private XMLPluginManagement pluginManagement() {
        XMLPluginManagement result = new XMLPluginManagement();
        result.setPlugins(new XMLPluginGroup());
        result.add(new XMLPlugin());
        return result;
    }

    @Override
    public XMLProjectObjectModel build() {
        return new POMBuilder()
                .with(info)
                .withProperties(properties())
                .withDependencyManagement(dependencyManagement())
                .withPluginManagement(pluginManagement())
                .build();
    }

}
