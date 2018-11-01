package org.npe4j.mpmaker.commons.io.xstream;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.npe4j.mpmaker.commons.io.GenericFileMarshaller;

import com.thoughtworks.xstream.XStream;

public final class GenericXStreamMarshaller
    implements
    GenericFileMarshaller {

    @Override
    public <O> File marshal(
        final Class<O> clazz,
        final O o,
        final File file) {
        XStream xstream = new XStream();
        xstream.processAnnotations(clazz);
        try {
            FileUtils.writeStringToFile(file, xstream.toXML(o));
            return file;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public <E> String marshal(
        final Class<E> clazz,
        final E o) {
        XStream xstream = new XStream();
        xstream.processAnnotations(clazz);
        return xstream.toXML(o);
    }

    @Override
    public <O> O unmarshal(
        final Class<O> clazz,
        final File file) {
        XStream xstream = new XStream();
        xstream.processAnnotations(clazz);
        return (O) xstream.fromXML(file);
    }
}
