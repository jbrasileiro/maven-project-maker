package org.npe4j.mpmakerxml.xml.custom;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.npe4j.mpmaker.commons.CustomProperty;
import org.npe4j.mpmaker.commons.util.ToStringUtils;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class XMLProperty
    extends
    JAXBElement<String>
    implements
    Comparable<XMLProperty>{

    private static final long serialVersionUID = -8897906940955846207L;
    private static final String NAMESPACE = "http://maven.apache.org/POM/4.0.0";
    private final CustomProperty<String> property;

    public XMLProperty(
        final String name,
        final String value) {
        super(new QName(NAMESPACE, name, ""), String.class, null, value);
        property = new CustomProperty<>(name, value);
    }

    public CustomProperty<String> getProperty() {
        return property;
    }

    @Override
    public boolean equals(
        final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof XMLProperty) {
            EqualsBuilder builder = new EqualsBuilder();
            XMLProperty o = (XMLProperty) obj;
            builder.append(property, o.property);
            return builder.isEquals();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(property);
        return builder.hashCode();
    }

    @Override
    public String toString() {
        return ToStringUtils.toString(this);
    }

    @Override
    public int compareTo(
        final XMLProperty o) {
        return new CompareToBuilder().append(property, o.property).build();
    }
}
