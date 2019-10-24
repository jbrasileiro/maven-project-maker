package org.npe4j.mpmakerxml.xml.pom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("dependencies")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLDependencyGroup {

    @XStreamImplicit(keyFieldName = "dependency",
        itemFieldName = "dependency")
    @XmlElement(
        name = "dependency")
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
        if (dependencies == null) {
            dependencies = new ArrayList<>();
        }
        dependencies.add(dependency);
    }

    public void addAll(
        final Collection<XMLDependency> values) {
        if (dependencies == null) {
            dependencies = new ArrayList<>();
        }
        dependencies.addAll(values);
    }
}
