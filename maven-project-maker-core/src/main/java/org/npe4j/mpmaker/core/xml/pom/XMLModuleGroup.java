package org.npe4j.mpmaker.core.xml.pom;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("modules")
public class XMLModuleGroup {

    @XStreamImplicit(
        itemFieldName = "module")
    private List<String> modules;
}
