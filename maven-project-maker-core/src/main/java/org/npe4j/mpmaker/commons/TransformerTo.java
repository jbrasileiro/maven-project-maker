package org.npe4j.mpmaker.commons;

public interface TransformerTo<I, O> {

    O transform(
        I in);
}
