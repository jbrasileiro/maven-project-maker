package org.npe4j.mpmaker.commons;

public interface BeanValidator<T> {

    boolean validate(
        T o);
}
