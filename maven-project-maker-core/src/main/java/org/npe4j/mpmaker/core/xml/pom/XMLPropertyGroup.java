package org.npe4j.mpmaker.core.xml.pom;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAnyElement;

import org.npe4j.mpmaker.core.xml.custom.XMLProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("properties")
public class XMLPropertyGroup {

    @XmlAnyElement
    private final Set<XMLProperty> properties = new HashSet<>();

    public Set<XMLProperty> getProperties() {
        return Collections.unmodifiableSet(properties);
    }

    public void add(
        final XMLProperty property) {
        properties.add(property);
    }

    public void addAll(
        final Set<XMLProperty> set) {
        properties.addAll(set);
    }
}
