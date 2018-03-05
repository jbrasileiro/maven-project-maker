package org.npe4j.mpmakerxml.xml.pom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("plugins")
public class XMLPluginGroup {

    @XStreamImplicit(
        itemFieldName = "plugin")
    private List<XMLPlugin> plugins = new ArrayList<>();

    public List<XMLPlugin> getPlugins() {
        return plugins;
    }

    public void setPlugins(
        final List<XMLPlugin> plugins) {
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
