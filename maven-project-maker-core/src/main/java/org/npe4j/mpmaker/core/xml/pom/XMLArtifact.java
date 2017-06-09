package org.npe4j.mpmaker.core.xml.pom;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public abstract class XMLArtifact {

    @XStreamAlias("groupId")
    private String groupId;
    @XStreamAlias("artifactId")
    private String artifactId;
    @XStreamAlias("version")
    private String version;
    @XStreamAlias("packaging")
    private String packaging;
}
