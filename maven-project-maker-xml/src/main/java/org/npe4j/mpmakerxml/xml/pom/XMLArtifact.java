package org.npe4j.mpmakerxml.xml.pom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.npe4j.mpmaker.commons.util.ToStringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    propOrder = {
        "groupId",
        "artifactId",
        "version",
        "packaging"
    })
public abstract class XMLArtifact {

    @XStreamAlias("groupId")
    @XmlElement(
        name = "groupId")
    private String groupId;
    @XStreamAlias("artifactId")
    @XmlElement(
        name = "artifactId")
    private String artifactId;
    @XStreamAlias("version")
    @XmlElement(
        name = "version")
    private String version;
    @XStreamAlias("packaging")
    @XmlElement(
        name = "packaging")
    private String packaging;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(
        final String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(
        final String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(
        final String version) {
        this.version = version;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(
        final String packaging) {
        this.packaging = packaging;
    }

    @Override
    public boolean equals(
        final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof XMLArtifact) {
            EqualsBuilder builder = new EqualsBuilder();
            XMLArtifact o = (XMLArtifact) obj;
            builder.append(groupId, o.groupId);
            builder.append(artifactId, o.artifactId);
            builder.append(version, o.version);
            builder.append(packaging, o.packaging);
            return builder.isEquals();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(groupId);
        builder.append(artifactId);
        builder.append(version);
        builder.append(packaging);
        return builder.hashCode();
    }

    @Override
    public String toString() {
        return ToStringUtils.toString(this);
    }
}
