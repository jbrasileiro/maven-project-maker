package org.npe4j.mpmaker.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.npe4j.mpmaker.commons.StringUtil;
import org.npe4j.mpmaker.commons.io.GenericFileMarshaller;
import org.npe4j.mpmaker.commons.io.jaxb.GenericJAXBMarshaller;
import org.npe4j.mpmaker.core.builder.POMBuilder;
import org.npe4j.mpmakerxml.xml.pom.XMLProjectObjectModel;
import org.nullpointer4j.mvn.project.maker.test.commons.TIResourceBundle;

public class POMTransformerImpTest {

    private static final TIResourceBundle BUNDLE = new TIResourceBundle();
    private POMTransformerImp test;

    @Before
    public void setUp() {
        GenericFileMarshaller marshaller = new GenericJAXBMarshaller();
        test = new POMTransformerImp(marshaller);
    }

    private POMBuilder getBuilder() {
        return new POMBuilder();
    }

    private XMLProjectObjectModel build(
        final POMBuilder builder) {
        return builder.build();
    }

    @Ignore
    @Test
    public void toXMLEmpty() {
        String result = test.toXML(build(getBuilder()));
        String actual = StringUtil.normalizeXML(result);
        Assert.assertEquals(TIResourceBundle.get("TI_POM_EMPTY"), actual);
    }

    @Test
    public void toXMLEmpty_temp() {
        String result = test.toXML(build(getBuilder()));
        String actual = StringUtil.normalizeXML(result);
        Assert.assertEquals(TIResourceBundle.get("TI_POM_EMPTY_INVERTED"), actual);
    }
}
