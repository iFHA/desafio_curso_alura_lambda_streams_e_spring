package dev.fernando.consultaFipe.converters;

import java.util.List;

public interface IConverter {
    <T,S> T convert(S objeto, Class<T> classe);
    <T,S> List<T> convertToList(S objeto, Class<T> classe);
}
