@XmlSchema(
    namespace = "http://custom/bean",
    elementFormDefault = XmlNsForm.QUALIFIED,
    xmlns = {
        @XmlNs(
            prefix = "b",
            namespaceURI = "http://b/")
    })
package org.npe4j.mpmaker.core.xml.custom;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
