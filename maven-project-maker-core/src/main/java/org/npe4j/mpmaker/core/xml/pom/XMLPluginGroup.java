package org.npe4j.mpmaker.core.xml.pom;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("plugins")
public class XMLPluginGroup {

    @XStreamImplicit(
        itemFieldName = "plugin")
    private List<XMLPlugin> dependencies;
}
