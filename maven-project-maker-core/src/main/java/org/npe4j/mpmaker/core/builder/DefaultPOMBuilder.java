package org.npe4j.mpmaker.core.builder;

import java.util.Set;

import org.npe4j.mpmaker.bean.BasicPOMInformation;
import org.npe4j.mpmaker.commons.util.SetUtils;
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
        Set<XMLProperty> set = SetUtils.newLinkedHashSet();
        addAll(set, getProjectProperties());
        addAll(set, getPluginVersionProperties());
        addAll(set, getDependencyVersionProperties());
        result.addAll(set);
        return result;
    }

    private void addAll(
        final Set<XMLProperty> set,
        final Set<XMLProperty> add) {
        for (XMLProperty each : add) {
            set.add(each);
        }
    }

    private Set<XMLProperty> getProjectProperties() {
        Set<XMLProperty> set = SetUtils.newLinkedHashSet();
        set.add(newXMLProperty("project.property.folder", "${basedir}/src/properties"));
        return set;
    }

    protected Set<XMLProperty> getPluginVersionProperties() {
        Set<XMLProperty> set = SetUtils.newLinkedHashSet();
        set.add(newXMLProperty("version-maven-compiler-plugin", "3.6.1"));
        set.add(newXMLProperty("version.maven-resources-plugin", "3.0.1"));
        set.add(newXMLProperty("version.sonar-maven-plugin", "3.2"));
        set.add(newXMLProperty("version.build-helper-maven-plugin", "1.0.0"));
        set.add(newXMLProperty("version.maven-failsafe-plugin", "3.0.0"));
        return set;
    }

    protected Set<XMLProperty> getDependencyVersionProperties() {
        Set<XMLProperty> set = SetUtils.newLinkedHashSet();
        set.add(newXMLProperty("version.junit", "4.12"));
        set.add(newXMLProperty("version.mockito-all", "1.10.19"));
        return set;
    }
}
