package br.com.pablo.chamados.model;

import br.com.pablo.chamados.parser.JsonParser;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.*;

@Service
public class ChamadoService {
    public List<Chamado> listar() throws IOException, InterruptedException, ParseException {

        String url = "http://localhost:5000/dados";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
        String body = response.body();
        JsonParser jsonParser = new JsonParser();
        List<Map<String, String>> listaChamados = jsonParser.parse(body);
        System.out.println("Total de chamados: " + listaChamados.size());

        List<Chamado> chamados = new ArrayList<>();

        for (Map<String, String> chamadoMap : listaChamados) {
            Chamado chamado = new Chamado();
            chamado.setAtribuidoGrupoTecnico(chamadoMap.get("Atribuído - Grupo técnico"));
            chamado.setAtribuidoTecnico(chamadoMap.get("Atribuído - Técnico"));
            chamado.setCategoria(chamadoMap.get("Categoria"));
            chamado.setDataSolucao(chamadoMap.get("Data da solução"));
            chamado.setDataAbertura(chamadoMap.get("Data de abertura"));
            chamado.setDescricao(chamadoMap.get("Descrição"));
            chamado.setId(chamadoMap.get("ID"));
            chamado.setTitulo(chamadoMap.get("Título"));
            chamado.setStatus(chamadoMap.get("Status"));
            chamado.setTempoAtendimentoProgresso(chamadoMap.get("Tempo para atendimento + Progresso"));
            chamado.setTempoSolucaoProgresso(chamadoMap.get("Tempo para solução + Progresso"));
            chamado.setRequerente(chamadoMap.get("Requerente - Requerente"));

            chamado.setPrioridade(chamadoMap.get("Prioridade"));
            chamado.setUrgencia(chamadoMap.get("Urgência"));

            chamado.setLocalizacao(chamadoMap.get("Localização"));
            chamado.setImpacto(chamadoMap.get("Impacto"));
            chamado.setSolucao(chamadoMap.get("Solução - Solução"));
            chamado.setUltimaAtualizacao(chamadoMap.get("Última atualização"));

            chamados.add(chamado);
        }

        return chamados;
    }
}

