package org.npe4j.mpmakerxml.xml;

import java.util.Collection;
import java.util.List;

public abstract class AbstractXMLMavenGroup<T>
    implements
    XMLMavenGroup<T> {

    @Override
    public final void add(
        final T value) {
        getValues().add(value);
    }

    @Override
    public final void addAll(
        final Collection<T> values) {
        getValues().addAll(values);
    }

    protected abstract List<T> getValues();
}
