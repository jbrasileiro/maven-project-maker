package org.npe4j.mpmakerxml.xml.pom;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("plugin")
public class XMLPlugin
    extends
    XMLArtifact {
    private XMLPluginConfiguration configuration;
}
