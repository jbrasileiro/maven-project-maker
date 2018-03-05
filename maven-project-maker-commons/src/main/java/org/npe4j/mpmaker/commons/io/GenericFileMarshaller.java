package org.npe4j.mpmaker.commons.io;

import java.io.File;

public interface GenericFileMarshaller {

    <E> File marshal(
        Class<E> clazz,
        E element,
        File file);

    <E> String marshal(
        Class<E> clazz,
        E element);

    <E> E unmarshal(
        Class<E> clazz,
        File file);
}
