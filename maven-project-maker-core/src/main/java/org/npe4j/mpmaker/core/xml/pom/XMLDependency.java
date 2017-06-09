package org.npe4j.mpmaker.core.xml.pom;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("dependency")
public class XMLDependency
    extends
    XMLArtifact {

    @XStreamAlias("scope")
    private String scope;
}
