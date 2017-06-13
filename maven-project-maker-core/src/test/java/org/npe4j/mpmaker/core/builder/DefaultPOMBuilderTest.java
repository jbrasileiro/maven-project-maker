package org.npe4j.mpmaker.core.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.npe4j.mpmaker.bean.EmptyBasicPOMInformation;
import org.npe4j.mpmaker.core.xml.custom.XMLProperty;
import org.npe4j.mpmaker.core.xml.pom.XMLPropertyGroup;

public class DefaultPOMBuilderTest {

    private DefaultPOMBuilder test;

    @Before
    public void setUp() {
        test = new DefaultPOMBuilder(new EmptyBasicPOMInformation());
    }

    @Test
    public void testDependencyVersionProperties() {
        Collection<XMLProperty> result = test.getDependencyVersionProperties();
        List<XMLProperty> list = new LinkedList<>(result);
        Assert.assertEquals(expected("version-junit", "4.12"), list.get(0));
        Assert.assertEquals(expected("version-mockito-all", "1.10.19"), list.get(1));
    }

    @Test
    public void testPluginVersionProperties() {
        Collection<XMLProperty> result = test.getPluginVersionProperties();
        List<XMLProperty> list = new LinkedList<>(result);
        Assert.assertEquals(expected("version-maven-compiler-plugin", "3.6.1"), list.get(0));
        Assert.assertEquals(expected("version-maven-resources-plugin", "3.0.1"), list.get(1));
        Assert.assertEquals(expected("version-sonar-maven-plugin", "3.2"), list.get(2));
        Assert.assertEquals(expected("version-properties-maven-plugin", "1.0.0"), list.get(3));
        Assert.assertEquals(expected("version-build-helper-maven-plugin", "3.0.0"), list.get(4));
        Assert.assertEquals(expected("version-maven-failsafe-plugin", "2.20"), list.get(5));
    }

    @Test
    public void testProperties() {
        XMLPropertyGroup result = test.properties();
        List<XMLProperty> list = new ArrayList<>(result.getProperties());
        Assert.assertEquals(9, list.size());
        Assert.assertEquals(expected("project.property.folder", "${basedir}/src/properties"),  list.get(0));
        Assert.assertEquals(expected("version-maven-compiler-plugin", "3.6.1"), list.get(1));
        Assert.assertEquals(expected("version-maven-resources-plugin", "3.0.1"), list.get(2));
        Assert.assertEquals(expected("version-sonar-maven-plugin", "3.2"), list.get(3));
        Assert.assertEquals(expected("version-properties-maven-plugin", "1.0.0"), list.get(4));
        Assert.assertEquals(expected("version-build-helper-maven-plugin", "3.0.0"), list.get(5));
        Assert.assertEquals(expected("version-maven-failsafe-plugin", "2.20"), list.get(6));
        Assert.assertEquals(expected("version-junit", "4.12"), list.get(7));
        Assert.assertEquals(expected("version-mockito-all", "1.10.19"), list.get(8));
    }

    private XMLProperty expected(
        final String name,
        final String value) {
        return new XMLProperty(name, value);
    }
}
