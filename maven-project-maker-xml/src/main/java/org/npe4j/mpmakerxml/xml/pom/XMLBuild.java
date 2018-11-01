package org.npe4j.mpmakerxml.xml.pom;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("build")
public class XMLBuild {

    @XStreamImplicit(
        itemFieldName = "pluginManagement")
    private XMLPluginManagement pluginManagement;
    @XStreamImplicit(
        itemFieldName = "plugins")
    private XMLPluginGroup plugins;

    public XMLPluginManagement getPluginManagement() {
        return pluginManagement;
    }

    public void setPluginManagement(
        final XMLPluginManagement pluginManagement) {
        this.pluginManagement = pluginManagement;
    }

    public XMLPluginGroup getPlugins() {
        return plugins;
    }

    public void setPlugins(
        final XMLPluginGroup plugins) {
        this.plugins = plugins;
    }
}
