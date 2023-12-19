package dev.fernando.consultaFipe.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
public class ConsultaApi {
    private final HttpClient client = HttpClient.newHttpClient();
    private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1";

    public String consultar(String url) {
        url = this.BASE_URL + url; //URLEncoder.encode(url, StandardCharsets.UTF_8);
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        try {
            HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
