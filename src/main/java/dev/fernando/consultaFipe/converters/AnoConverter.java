package dev.fernando.consultaFipe.converters;

import dev.fernando.consultaFipe.dto.AnoDTO;
import dev.fernando.consultaFipe.models.Ano;
import dev.fernando.consultaFipe.models.Fipe;
import org.springframework.stereotype.Component;

@Component
public class AnoConverter {
    public Ano fromDTO(AnoDTO dto) {
        Integer ano = Integer.parseInt(dto.codigo().split("-")[0]);
        return new Ano(dto.codigo(), ano, dto.nome());
    }

}
