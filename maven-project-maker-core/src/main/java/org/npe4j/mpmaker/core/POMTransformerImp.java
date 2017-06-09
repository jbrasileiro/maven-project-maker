package org.npe4j.mpmaker.core;

import org.npe4j.mpmaker.commons.dp.BeanDPBuilder;
import org.npe4j.mpmaker.commons.io.GenericFileMarshaller;
import org.npe4j.mpmaker.core.xml.pom.XMLProjectObjectModel;

public final class POMTransformerImp
    implements
    POMTransformer {

    private final GenericFileMarshaller marshaller;

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
}
