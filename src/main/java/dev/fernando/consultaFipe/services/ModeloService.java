package dev.fernando.consultaFipe.services;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.fernando.consultaFipe.converters.IConverter;
import dev.fernando.consultaFipe.enums.TipoVeiculoEnum;
import dev.fernando.consultaFipe.models.Modelo;
import dev.fernando.consultaFipe.dto.ModeloDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {
    @Autowired
    private ConsultaApi api;
    @Autowired
    private IConverter converter;
    public List<Modelo> consultarModelos(TipoVeiculoEnum tipo, Integer codigoMarca) {
        ModeloDTO dto = this.converter.convert(this.api.consultar("/" + tipo.getValue() + "/marcas/" + codigoMarca + "/modelos"), ModeloDTO.class);
        return dto.modelos().stream().toList();
    }
}
