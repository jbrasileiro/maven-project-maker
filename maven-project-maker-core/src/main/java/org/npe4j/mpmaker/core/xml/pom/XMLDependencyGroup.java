package org.npe4j.mpmaker.core.xml.pom;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("dependencies")
public class XMLDependencyGroup {

    @XStreamImplicit(
        itemFieldName = "dependency")
    private List<XMLDependency> dependencies;
}
