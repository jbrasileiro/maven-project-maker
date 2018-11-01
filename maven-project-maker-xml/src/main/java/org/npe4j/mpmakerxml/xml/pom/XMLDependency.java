package org.npe4j.mpmakerxml.xml.pom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.npe4j.mpmaker.commons.util.ToStringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("dependency")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    propOrder = {
        "groupId"
        ,"artifactId"
        ,"version"
        ,"packaging"
        , "scope"
    })
public class XMLDependency
    extends
    XMLArtifact
    implements
    Comparable<XMLDependency> {

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

    @Override
    public int compareTo(
        final XMLDependency o) {
        if(this == o) {
            return 0;
        }
        if(o == null) {
            return -1;
        }
        return new CompareToBuilder()
                .append(getGroupId(), o.getGroupId())
                .append(getArtifactId(), o.getArtifactId())
                .append(getPackaging(), o.getPackaging())
                .append(getVersion(), o.getVersion())
                .append(getScope(), o.getScope())
                .build();
    }
}
