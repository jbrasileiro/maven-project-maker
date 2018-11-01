package org.npe4j.mpmakerxml.xml.pom;

import java.util.Collection;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("pluginManagement")
public class XMLPluginManagement {

    @XStreamImplicit(
        itemFieldName = "plugins")
    private XMLPluginGroup plugins;

    public XMLPluginGroup getPlugins() {
        return plugins;
    }

    public void setPlugins(
        final XMLPluginGroup plugins) {
        this.plugins = plugins;
    }

    public void add(
        final XMLPlugin value) {
        plugins.add(value);
    }

    public void addAll(
        final Collection<XMLPlugin> values) {
        plugins.addAll(values);
    }
}
