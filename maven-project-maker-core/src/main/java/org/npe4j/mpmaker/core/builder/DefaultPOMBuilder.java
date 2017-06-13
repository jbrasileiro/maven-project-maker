package org.npe4j.mpmaker.core.builder;

import java.util.Collection;
import java.util.LinkedList;

import org.npe4j.mpmaker.bean.BasicPOMInformation;
import org.npe4j.mpmaker.core.xml.custom.XMLProperty;
import org.npe4j.mpmaker.core.xml.pom.XMLPropertyGroup;

public final class DefaultPOMBuilder
    extends
    AbstractXMLProjectObjectModelBuilder {

    public DefaultPOMBuilder(
        final BasicPOMInformation info) {
        super(new SimplePOMBuilder(info));
        getBean().setProperties(properties());
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
        Collection<XMLProperty> set = newLinkedList();
        set.add(newXMLProperty("project.property.folder", "${basedir}/src/properties"));
        return set;
    }

    protected Collection<XMLProperty> getPluginVersionProperties() {
        Collection<XMLProperty> set = newLinkedList();
        set.add(newXMLProperty("version-maven-compiler-plugin", "3.6.1"));
        set.add(newXMLProperty("version-maven-resources-plugin", "3.0.1"));
        set.add(newXMLProperty("version-sonar-maven-plugin", "3.2"));
        set.add(newXMLProperty("version-properties-maven-plugin", "1.0.0"));
        set.add(newXMLProperty("version-build-helper-maven-plugin", "3.0.0"));
        set.add(newXMLProperty("version-maven-failsafe-plugin", "2.20"));
        return set;
    }

    protected Collection<XMLProperty> getDependencyVersionProperties() {
        Collection<XMLProperty> set = newLinkedList();
        set.add(newXMLProperty("version-junit", "4.12"));
        set.add(newXMLProperty("version-mockito-all", "1.10.19"));
        return set;
    }

    private Collection<XMLProperty> newLinkedList() {
        return new LinkedList<>();
    }
}
