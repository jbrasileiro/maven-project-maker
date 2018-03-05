package org.npe4j.mpmakerxml.xml;

import java.util.Collection;

public interface XMLMavenGroup<T> {

    void add(
        T value);

    void addAll(
        Collection<T> values);
}
