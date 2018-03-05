package org.npe4j.mpmakerxml.xml.pom;

import java.util.Collection;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("dependencyManagement")
public class XMLDependencyManagement {

    @XStreamImplicit(
        itemFieldName = "dependency")
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
