package dev.fernando.consultaFipe.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JsonConverter implements IConverter {
    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public <T, S> T convert(S objeto, Class<T> classe) {
        try {
            return this.mapper.readValue((String)objeto, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T, S> List<T> convertToList(S objeto, Class<T> classe) {
        CollectionType listaType = this.mapper
                .getTypeFactory()
                .constructCollectionType(List.class, classe);
        try {
            return this.mapper.readValue((String) objeto, listaType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
