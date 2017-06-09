package org.npe4j.mpmaker.core.xml.pom;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("build")
public class XMLBuild {

    private XMLPluginManagement pluginManagement;
    private XMLPluginGroup plugins;
}
