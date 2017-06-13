package org.npe4j.mpmaker.core;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;

public final class CustomSortedSet<E extends Comparable<E>>
    extends
    AbstractSortedSet<E> {

    private static final long serialVersionUID = -8574859360463315185L;

    public CustomSortedSet() {
        super();
    }

    public CustomSortedSet(
        final Collection<? extends E> colletion) {
        super(colletion);
    }

    public CustomSortedSet(
        final Comparator<? super E> comparator) {
        super(comparator);
    }

    public CustomSortedSet(
        final SortedSet<E> set) {
        super(set);
    }
}
