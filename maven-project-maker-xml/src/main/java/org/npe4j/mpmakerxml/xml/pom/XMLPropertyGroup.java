package org.npe4j.mpmakerxml.xml.pom;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.annotation.DomHandler;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.npe4j.mpmakerxml.xml.AbstractXMLMavenGroup;
import org.npe4j.mpmakerxml.xml.custom.XMLProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("properties")
public class XMLPropertyGroup
    extends
    AbstractXMLMavenGroup<XMLProperty> {

    @XmlAnyElement(
        value = DomHandlerXMLXMLProperty.class)
    private final List<XMLProperty> properties;

    public XMLPropertyGroup() {
    	this(new LinkedList<>());
    }

    public XMLPropertyGroup(
		List<XMLProperty> properties) {
		super();
		this.properties = properties;
	}

	public List<XMLProperty> getProperties() {
        return new LinkedList<>(properties);
    }

    @Override
    protected List<XMLProperty> getValues() {
        return properties;
    }
}

class DomHandlerXMLXMLProperty
    implements
    DomHandler<XMLProperty, Result> {

    private final StringWriter xmlWriter = new StringWriter();

    @Override
    public Result createUnmarshaller(
        final ValidationEventHandler errorHandler) {
        return new StreamResult(xmlWriter);
    }

    @Override
    public XMLProperty getElement(
        final Result result) {
        if(result instanceof StreamResult) {
            StreamResult sResult = (StreamResult) result;
            String xml = sResult.getWriter().toString();
            int start = xml.lastIndexOf("</");
            int end = xml.lastIndexOf(">");
            String name = xml.substring(start + 2, end);

            String sub = xml.substring(0, start);
            String value = sub.substring(sub.lastIndexOf(">") + 1);

            return new XMLProperty(name, value);
        }else {
            throw new IllegalArgumentException(result.toString());
        }
    }

    @Override
    public Source marshal(
        final XMLProperty n,
        final ValidationEventHandler errorHandler) {
        try {
            StringReader xmlReader = new StringReader(n.getValue());
            return new StreamSource(xmlReader);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
