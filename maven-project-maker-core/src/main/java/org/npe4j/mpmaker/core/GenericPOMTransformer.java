package org.npe4j.mpmaker.core;

import org.npe4j.mpmaker.commons.TransformerTo;
import org.npe4j.mpmaker.core.xml.pom.XMLProjectObjectModel;

public interface GenericPOMTransformer<I>
    extends
    TransformerTo<I, XMLProjectObjectModel> {

    String toXML(
        XMLProjectObjectModel in);
}
