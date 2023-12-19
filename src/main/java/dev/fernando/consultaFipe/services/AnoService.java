package dev.fernando.consultaFipe.services;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.fernando.consultaFipe.converters.IConverter;
import dev.fernando.consultaFipe.dto.AnoDTO;
import dev.fernando.consultaFipe.enums.TipoVeiculoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnoService {
    @Autowired
    private ConsultaApi api;
    @Autowired
    private IConverter converter;
    public List<AnoDTO> consultarAnos(TipoVeiculoEnum tipo, Integer codigoMarca, Integer codigoModelo) {
        String url = "/" + tipo.getValue() + "/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos";
        return this.converter.convertToList(this.api.consultar(url), AnoDTO.class);
    }
}
