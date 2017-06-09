package org.npe4j.mpmaker.commons.dp;

import java.util.Objects;

import org.npe4j.mpmaker.commons.BeanValidator;
import org.npe4j.mpmaker.commons.NoValidation;

public abstract class TemplateDPBuilder<T>
    implements
    BeanDPBuilder<T> {

    private final T bean;
    private final BeanValidator<T> validator;

    public TemplateDPBuilder(
        final BeanDPBuilder<T> builder) {
        this(builder.build(), new NoValidation<>());
    }

    public TemplateDPBuilder(
        final BeanDPBuilder<T> builder,
        final BeanValidator<T> validator) {
        this(builder.build(), validator);
    }

    protected TemplateDPBuilder(
        final T bean) {
        this(bean, new NoValidation<>());
    }

    protected TemplateDPBuilder(
        final T bean,
        final BeanValidator<T> validator) {
        super();
        Objects.requireNonNull(bean);
        Objects.requireNonNull(validator);
        this.bean = bean;
        this.validator = validator;
    }

    @Override
    public final T getBean() {
        return bean;
    }

    @Override
    public final T build() {
        T object = getBean();
        if (validator.validate(object)) {
            return object;
        } else {
            throw new IllegalArgumentException(object.toString());
        }
    }
}
