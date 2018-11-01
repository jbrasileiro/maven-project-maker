package org.npe4j.mpmaker.core;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;

import org.npe4j.mpmakerxml.xml.custom.XMLProperty;

public final class XMLPropertySortedSet
    extends
    AbstractSortedSet<XMLProperty> {

    private static final long serialVersionUID = -8574859360463315185L;

    public XMLPropertySortedSet() {
        super();
    }

    public XMLPropertySortedSet(
        final Collection<? extends XMLProperty> colletion) {
        super(colletion);
    }

    public XMLPropertySortedSet(
        final Comparator<? super XMLProperty> comparator) {
        super(comparator);
    }

    public XMLPropertySortedSet(
        final SortedSet<XMLProperty> set) {
        super(set);
    }
}
