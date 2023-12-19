package dev.fernando.consultaFipe.principal;

import dev.fernando.consultaFipe.converters.AnoConverter;
import dev.fernando.consultaFipe.converters.MarcaConverter;
import dev.fernando.consultaFipe.enums.TipoVeiculoEnum;
import dev.fernando.consultaFipe.models.Ano;
import dev.fernando.consultaFipe.models.Fipe;
import dev.fernando.consultaFipe.models.Marca;
import dev.fernando.consultaFipe.models.Modelo;
import dev.fernando.consultaFipe.services.AnoService;
import dev.fernando.consultaFipe.services.FipeService;
import dev.fernando.consultaFipe.services.MarcaService;
import dev.fernando.consultaFipe.services.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Principal {
    @Autowired
    private MarcaService marcaService;
    @Autowired
    private ModeloService modeloService;
    @Autowired
    private AnoService anoService;
    @Autowired
    private MarcaConverter marcaConverter;
    @Autowired
    private AnoConverter anoConverter;
    @Autowired
    private FipeService fipeService;
    private final Scanner scanner = new Scanner(System.in);
    public void exibeMenu() {
        TipoVeiculoEnum tipoEscolhido = obterTipoVeiculo();
        Integer codigoMarca = obterCodigoDaMarca(tipoEscolhido);
        Integer codigoModelo = obterCodigoDoModelo(tipoEscolhido, codigoMarca);
        exibeFipe(tipoEscolhido, codigoMarca, codigoModelo);
    }
    public TipoVeiculoEnum obterTipoVeiculo() {
        System.out.println("Selecione o Tipo de Veículo: ");
        Arrays.stream(TipoVeiculoEnum.values()).forEach(tp -> System.out.println(tp.getValue().toUpperCase()));
        String tipoDeVeiculo = this.scanner.nextLine();
        return TipoVeiculoEnum.fromString(tipoDeVeiculo);
    }

    public Integer obterCodigoDaMarca(TipoVeiculoEnum tipoVeiculo) {
        List<Marca> marcas = this.marcaService
                .consultarMarcas(tipoVeiculo)
                .stream()
                .map(this.marcaConverter::fromDTO)
                .sorted(Comparator.comparing(Marca::getCodigo))
                .toList();

        System.out.println("Escolha uma marca:");
        marcas.forEach(System.out::println);

        System.out.println("Informe o código da marca:");
        Integer codigoMarca = this.scanner.nextInt();
        this.scanner.nextLine();
        return codigoMarca;
    }

    public Integer obterCodigoDoModelo(TipoVeiculoEnum tipoVeiculo, Integer codigoMarca) {
        List<Modelo> modelos = this.modeloService
                .consultarModelos(tipoVeiculo, codigoMarca)
                .stream()
                .sorted(Comparator.comparing(Modelo::codigo))
                .collect(Collectors.toList());

        modelos.forEach(System.out::println);
        System.out.println("Informe um trecho do modelo de um veículo para consulta: ");

        String trecho = this.scanner.nextLine();
        List<Modelo> modelosFiltrados = modelos
                .stream()
                .filter(modelo->modelo.nome().toUpperCase().contains(trecho.toUpperCase()))
                .collect(Collectors.toList());

        modelosFiltrados.forEach(System.out::println);
        System.out.println("Informe o código do modelo:");
        Integer codigoModelo = this.scanner.nextInt();
        this.scanner.nextLine();
        return codigoModelo;
    }

    public void exibeFipe(TipoVeiculoEnum tipoVeiculo, Integer codigoMarca, Integer codigoModelo) {
        this.anoService
                .consultarAnos(tipoVeiculo, codigoMarca, codigoModelo)
                .stream()
                .map(dto-> {
                    Ano ano = this.anoConverter.fromDTO(dto);
                    return this.fipeService.consultarFipe(tipoVeiculo, codigoMarca, codigoModelo, ano.getCodigo());
                })
                .forEach(System.out::println);
    }
}
