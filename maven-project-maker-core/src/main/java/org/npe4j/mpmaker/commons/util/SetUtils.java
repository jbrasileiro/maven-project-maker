package org.npe4j.mpmaker.commons.util;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.npe4j.mpmaker.core.CustomSortedSet;
import org.npe4j.mpmaker.core.xml.custom.XMLProperty;

public final class SetUtils {

    private SetUtils() {
        super();
        throw new IllegalStateException(getClass().toString());
    }

    public static <T> Set<T> newLinkedHashSet() {
        return new LinkedHashSet<>();
    }

    public static <T> SortedSet<T> newTreeSet() {
        return new TreeSet<>();
    }

    public static SortedSet<XMLProperty> newCustomSortSet() {
        return new CustomSortedSet<>();
    }
}
