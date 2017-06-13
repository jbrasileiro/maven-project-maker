package org.npe4j.mpmaker.core.xml.pom;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;

import org.npe4j.mpmaker.core.xml.custom.XMLProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("properties")
public class XMLPropertyGroup {

    @XmlAnyElement
    private final List<XMLProperty> properties = new LinkedList<>();

    public Collection<XMLProperty> getProperties() {
        return new LinkedList<>(properties);
    }

    public void add(
        final XMLProperty property) {
        properties.add(property);
    }

    public void addAll(
        final Collection<XMLProperty> set) {
        properties.addAll(set);
    }
}
