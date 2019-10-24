package org.npe4j.mpmakerxml.xml.pom;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("dependencyManagement")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLDependencyManagement {

    @XmlElement
    private XMLDependencyGroup dependencies;

    public XMLDependencyGroup getDependencies() {
        return dependencies;
    }

    public void setDependencies(
        final XMLDependencyGroup dependencies) {
        this.dependencies = dependencies;
    }

    public void add(
        final XMLDependency value) {
        dependencies.add(value);
    }

    public void addAll(
        final Collection<XMLDependency> values) {
        dependencies.addAll(values);
    }
}
