package org.npe4j.mpmakerxml.xml.pom;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.npe4j.mpmaker.commons.dp.BeanManagable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("project")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(
    namespace = "http://maven.apache.org/POM/4.0.0",
    name = "project")
@XmlAccessorOrder(
    value = XmlAccessOrder.UNDEFINED)
public final class XMLProjectObjectModel
    extends
    XMLArtifact {

    @XStreamAsAttribute
    @XmlAttribute(
        name = "xmlns:xsi")
    private final String xmlnsxsi = "http://www.w3.org/2001/XMLSchema-instance";
    @XStreamAsAttribute
    @XmlAttribute(
        name = "xsi:schemaLocation")
    private final String schema
        = "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd";
    @XStreamAlias("modelVersion")
    @XmlElement
    private String modelVersion;
    @XStreamAlias("groupId")
    @XmlElement
    private String groupId;
    @XStreamAlias("artifactId")
    @XmlElement
    private String artifactId;
    @XStreamAlias("version")
    @XmlElement
    private String version;
    @XStreamAlias("packaging")
    @XmlElement
    private String packaging;
    @XStreamAlias("name")
    @XmlElement
    private String name;
    @XStreamAlias("properties")
    @XmlElement
    private XMLPropertyGroup properties;
    @XStreamAlias("modules")
    @XmlElement
    private XMLModuleGroup modules;
    @XStreamAlias("dependencyManagement")
    @XmlElement
    private XMLDependencyManagement dependencyManagement;
    @XStreamAlias("dependencies")
    @XmlElement
    private XMLDependencyGroup dependencies;
    @XStreamAlias("build")
    @XmlElement
    private XMLBuild build;

    public XMLProjectObjectModel() {
        super();
    }

    public XMLProjectObjectModel(
        final BeanManagable<XMLProjectObjectModel> builder) {
        super();
        XMLProjectObjectModel bean = builder.getBean();
        modelVersion = bean.modelVersion;
        setGroupId(bean.getGroupId());
        setArtifactId(bean.getArtifactId());
        setVersion(bean.getVersion());
        setPackaging(bean.getPackaging());
        name = bean.name;
        properties = bean.properties;
        modules = bean.modules;
        dependencyManagement = bean.dependencyManagement;
        dependencies = bean.dependencies;
        build = bean.build;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(
        final String modelVersion) {
        this.modelVersion = modelVersion;
    }

    @Override
    public String getGroupId() {
        return groupId;
    }

    @Override
    public void setGroupId(
        final String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String getArtifactId() {
        return artifactId;
    }

    @Override
    public void setArtifactId(
        final String artifactId) {
        this.artifactId = artifactId;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public void setVersion(
        final String version) {
        this.version = version;
    }

    @Override
    public String getPackaging() {
        return packaging;
    }

    @Override
    public void setPackaging(
        final String packaging) {
        this.packaging = packaging;
    }

    public String getName() {
        return name;
    }

    public void setName(
        final String name) {
        this.name = name;
    }

    public XMLPropertyGroup getProperties() {
        return properties;
    }

    public void setProperties(
        final XMLPropertyGroup properties) {
        this.properties = properties;
    }

    public XMLModuleGroup getModules() {
        return modules;
    }

    public void setModules(
        final XMLModuleGroup modules) {
        this.modules = modules;
    }

    public XMLDependencyManagement getDependencyManagement() {
        return dependencyManagement;
    }

    public void setDependencyManagement(
        final XMLDependencyManagement dependencyManagement) {
        this.dependencyManagement = dependencyManagement;
    }

    public XMLDependencyGroup getDependencies() {
        return dependencies;
    }

    public void setDependencies(
        final XMLDependencyGroup dependencies) {
        this.dependencies = dependencies;
    }

    public XMLBuild getBuild() {
        return build;
    }

    public void setBuild(
        final XMLBuild build) {
        this.build = build;
    }

    public String getXmlnsxsi() {
        return xmlnsxsi;
    }

    public String getSchema() {
        return schema;
    }
}
