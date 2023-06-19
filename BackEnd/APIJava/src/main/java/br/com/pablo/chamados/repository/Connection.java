package br.com.pablo.chamados.repository;

import br.com.pablo.chamados.parser.JsonParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Service
public class Connection {

    public List<Map<String, String>> conection() throws IOException, InterruptedException {
        String url = "http://localhost:5000/dados";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
        String body = response.body();
        JsonParser jsonParser = new JsonParser();
        return jsonParser.parse(body);
    }
}
