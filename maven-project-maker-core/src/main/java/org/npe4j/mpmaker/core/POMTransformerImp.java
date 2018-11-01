package org.npe4j.mpmaker.core;

import org.npe4j.mpmaker.bean.BasicPOMInformation;
import org.npe4j.mpmaker.commons.dp.BeanDPBuilder;
import org.npe4j.mpmaker.commons.io.GenericFileMarshaller;
import org.npe4j.mpmaker.commons.io.jaxb.GenericJAXBMarshaller;
import org.npe4j.mpmaker.core.enums.TypeProjectMaven;
import org.npe4j.mpmakerxml.xml.pom.XMLProjectObjectModel;

public final class POMTransformerImp
    implements
    POMTransformer {

    private final GenericFileMarshaller marshaller;
    private final POMBuilderFactory factory = new POMBuilderFactoryImp();

    public POMTransformerImp() {
        this(new GenericJAXBMarshaller());
    }

    public POMTransformerImp(
        final GenericFileMarshaller marshaller) {
        super();
        this.marshaller = marshaller;
    }

    @Override
    public XMLProjectObjectModel transform(
        final BeanDPBuilder<XMLProjectObjectModel> in) {
        if (in == null) {
            throw new IllegalArgumentException();
        } else {
            return in.build();
        }
    }

    @Override
    public String toXML(
        final XMLProjectObjectModel in) {
        if (in == null) {
            throw new IllegalArgumentException();
        } else {
            return marshaller.marshal(XMLProjectObjectModel.class, in);
        }
    }

    /**
     *  {@link Deprecated}
     */
    @Deprecated
    @Override
    public XMLProjectObjectModel transform(
        final TypeProjectMaven type,
        final BasicPOMInformation info) {
        return factory.make(type, info).build();
    }
}
