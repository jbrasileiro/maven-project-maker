package org.npe4j.mpmaker.core.xml.pom;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class XMLProperty
    extends
    JAXBElement<String> {

    private static final long serialVersionUID = -8897906940955846207L;

    public XMLProperty(
        final String name,
        final String value) {
        super(new QName(name), String.class, value);
    }
}
