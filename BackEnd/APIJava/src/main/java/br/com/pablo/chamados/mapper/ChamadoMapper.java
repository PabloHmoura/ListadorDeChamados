package br.com.pablo.chamados.mapper;

import br.com.pablo.chamados.model.Chamado;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class ChamadoMapper {

    public List<Chamado> listaDeChamados(List<Map<String, String>> lista) {
        List<Chamado> chamados = new ArrayList<>();

        for (Map<String, String> chamadoMap : lista) {

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
        chamados.sort(Comparator.comparing(Chamado::getLocalizacao));
        List<Chamado> chamadosOrdenados = new ArrayList<>();
        String localizacaoAtual = "";
        for (Chamado chamado: chamados) {

            if (!chamado.getLocalizacao().equals(localizacaoAtual) && chamadosOrdenados.size() > 0){
                Chamado chamadoVazio = new Chamado();
                Chamado chamadoVazio2 = new Chamado();
                chamadosOrdenados.add(chamadoVazio2);
                chamadosOrdenados.add(chamadoVazio);
            }
            chamadosOrdenados.add(chamado);
            localizacaoAtual = chamado.getLocalizacao();
        }
        return chamadosOrdenados;
    }

    public List<Chamado> listaChamadosOrdenados(List<Map<String, String>> lista) {
        List<Chamado> chamados = new ArrayList<>();

        for (Map<String, String> chamadoMap : lista) {

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
        chamados.sort(Comparator.comparing(Chamado::getLocalizacao));

        return chamados;
    }
}
