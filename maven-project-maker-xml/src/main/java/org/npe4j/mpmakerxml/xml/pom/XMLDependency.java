package org.npe4j.mpmakerxml.xml.pom;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.npe4j.mpmaker.commons.util.ToStringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("dependency")
public class XMLDependency
    extends
    XMLArtifact {

    @XStreamAlias("scope")
    private String scope;

    public final String getScope() {
        return scope;
    }

    public final void setScope(
        final String scope) {
        this.scope = scope;
    }

    @Override
    public boolean equals(
        final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof XMLDependency
                && super.equals(obj)) {
            EqualsBuilder builder = new EqualsBuilder();
            XMLDependency o = (XMLDependency) obj;
            builder.append(scope, o.scope);
            return builder.isEquals();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(super.hashCode());
        builder.append(scope);
        return builder.hashCode();
    }

    @Override
    public String toString() {
        return ToStringUtils.toString(this);
    }
}
