package org.npe4j.mpmakerxml.xml.pom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("dependencies")
public class XMLDependencyGroup {

    @XStreamImplicit(
        itemFieldName = "dependency")
    private List<XMLDependency> dependencies = new ArrayList<>();

    public List<XMLDependency> getDependencies() {
        return dependencies;
    }

    public void setDependencies(
        final List<XMLDependency> dependencies) {
        this.dependencies = dependencies;
    }

    public void add(
        final XMLDependency dependency) {
        dependencies.add(dependency);
    }

    public void addAll(
        final Collection<XMLDependency> values) {
        dependencies.addAll(values);
    }
}
