package dev.fernando.consultaFipe.services;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.fernando.consultaFipe.dto.MarcaDTO;
import dev.fernando.consultaFipe.enums.TipoVeiculoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private ConsultaApi api;
    public List<MarcaDTO> consultarMarcas(TipoVeiculoEnum tipo) {
        return this.api.consultar("/" + tipo.getValue() + "/marcas", new TypeReference<List<MarcaDTO>>(){});
    }
}
