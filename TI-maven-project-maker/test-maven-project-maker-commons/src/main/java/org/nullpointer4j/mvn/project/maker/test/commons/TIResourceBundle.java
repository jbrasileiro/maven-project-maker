package org.nullpointer4j.mvn.project.maker.test.commons;

import java.util.ResourceBundle;

public final class TIResourceBundle {

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("test-key");

    public static String get(
        final String key) {
        return BUNDLE.getString(key);
    }
}
