package org.npe4j.mpmakerxml.xml.pom;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;

import org.npe4j.mpmakerxml.xml.AbstractXMLMavenGroup;
import org.npe4j.mpmakerxml.xml.custom.XMLProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("properties")
public class XMLPropertyGroup extends AbstractXMLMavenGroup<XMLProperty> {

    @XmlAnyElement
    private final List<XMLProperty> properties = new LinkedList<>();

    public Collection<XMLProperty> getProperties() {
        return new LinkedList<>(properties);
    }

    @Override
    protected List<XMLProperty> getValues() {
        return properties;
    }

}
