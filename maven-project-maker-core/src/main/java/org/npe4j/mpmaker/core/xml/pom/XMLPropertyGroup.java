package org.npe4j.mpmaker.core.xml.pom;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAnyElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("properties")
public class XMLPropertyGroup {

    @XmlAnyElement
    private final Set<JAXBElement<String>> properties = new HashSet<>();

    public void add(
        final XMLProperty property) {
        if (!properties.contains(property)) {
            properties.add(property);
        }
    }
}
