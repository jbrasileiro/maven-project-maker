package org.npe4j.mpmaker.commons;

public final class NoValidation<T>
    implements
    BeanValidator<T> {

    @Override
    public boolean validate(
        final T o) {
        return true;
    }
}
