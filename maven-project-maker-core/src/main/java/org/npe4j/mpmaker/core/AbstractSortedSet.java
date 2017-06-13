package org.npe4j.mpmaker.core;

import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public abstract class AbstractSortedSet<E extends Comparable<E>>
    extends
    TreeSet<E>
    implements
    NavigableSet<E> {

    private static final long serialVersionUID = 8445848023775567998L;

    public AbstractSortedSet() {
        super();
    }

    public AbstractSortedSet(
        final Collection<? extends E> colletion) {
        super(colletion);
    }

    public AbstractSortedSet(
        final Comparator<? super E> comparator) {
        super(comparator);
    }

    public AbstractSortedSet(
        final SortedSet<E> set) {
        super(set);
    }
}
