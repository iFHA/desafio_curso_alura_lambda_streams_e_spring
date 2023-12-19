package dev.fernando.consultaFipe.services;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.fernando.consultaFipe.dto.AnoDTO;
import dev.fernando.consultaFipe.enums.TipoVeiculoEnum;
import dev.fernando.consultaFipe.models.Fipe;
import dev.fernando.consultaFipe.dto.MarcaDTO;
import dev.fernando.consultaFipe.models.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FipeService {
    @Autowired
    private ConsultaApi api;
    public Fipe consultarFipe(TipoVeiculoEnum tipo, Integer codigoMarca, Integer codigoModelo, String codigoAno) {
        String url = "/" + tipo.getValue() + "/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos/" + codigoAno;
        return this.api.consultar(url, new TypeReference<Fipe>(){});
    }
}
