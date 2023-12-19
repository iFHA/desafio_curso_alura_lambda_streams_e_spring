package dev.fernando.consultaFipe.converters;

import dev.fernando.consultaFipe.dto.MarcaDTO;
import dev.fernando.consultaFipe.models.Marca;
import org.springframework.stereotype.Component;

@Component
public class MarcaConverter {
    public Marca fromDTO (MarcaDTO dto) {
        return new Marca(Integer.parseInt(dto.codigo()), dto.nome());
    }
}
