package br.com.pablo.chamados.model;

import br.com.pablo.chamados.dto.ChamadoPorRegiaoDto;
import br.com.pablo.chamados.dto.QtdPorLocalidadeDto;
import br.com.pablo.chamados.mapper.ChamadoMapper;
import br.com.pablo.chamados.repository.Connection;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.*;

@Service
public class ChamadoService {

    private final String SUL= "SUL";
    private final String LESTE = "LESTE";
    private final String CENTRO = "CENTRO";
    private final String NORTE = "NORTE";

    Connection connection;
    ChamadoMapper chamados;

    public ChamadoService (Connection connection, ChamadoMapper chamadoMapper){
        this.connection = connection;
        this.chamados = chamadoMapper;
    }
    public List<Chamado> listar() throws IOException, InterruptedException {

        List<Map<String, String>> listaChamados = connection.conection();


        return chamados.listaDeChamados(listaChamados);
    }

    public List<QtdPorLocalidadeDto> listarLocalidadesPorChamado() throws IOException, InterruptedException {
        List<Map<String, String>> listaChamados = connection.conection();
        List<QtdPorLocalidadeDto> listaDeChamado = new ArrayList<>();

        String localizacao = null;
        String localizacaoAtual = null;
        for (Chamado chamado: chamados.listaChamadosOrdenados(listaChamados)) {
            localizacaoAtual = chamado.getLocalizacao();
            if (!Objects.equals(localizacao, chamado.getLocalizacao()) && listaChamados.size() > 1) {
                QtdPorLocalidadeDto qtdPorLocalidadeDto = new QtdPorLocalidadeDto();
                qtdPorLocalidadeDto.setLocalidade(chamado.getLocalizacao());
                qtdPorLocalidadeDto.getChamados().add(chamado.getId());
                listaDeChamado.add(qtdPorLocalidadeDto);
            } else {
                for (QtdPorLocalidadeDto item: listaDeChamado) {
                    if (item.getLocalidade().equals(localizacaoAtual)) {
                        item.getChamados().add(chamado.getId());
                        item.setQuantidade(item.getChamados().size());
                    }
                }
            }
            localizacao = chamado.getLocalizacao();
        }
        listaDeChamado.sort(Comparator.comparing(QtdPorLocalidadeDto::getQuantidade).reversed());
        return listaDeChamado;
    }

    public List<ChamadoPorRegiaoDto> listaChamadoPorRegiao() throws IOException, InterruptedException {
        List<Map<String, String>> listaChamados = connection.conection();
        List<QtdPorLocalidadeDto> listaDeChamado = new ArrayList<>();
        List<ChamadoPorRegiaoDto> chamadoPorRegiaoDtos = new ArrayList<>();
        List<QtdPorLocalidadeDto> listaNorte = new ArrayList<>();
        List<QtdPorLocalidadeDto> listaSul = new ArrayList<>();
        List<QtdPorLocalidadeDto> listaLeste = new ArrayList<>();
        List<QtdPorLocalidadeDto> listaCentro = new ArrayList<>();
        List<QtdPorLocalidadeDto> listaSemRegiao = new ArrayList<>();

        String localizacao = null;
        String localizacaoAtual = null;
        for (Chamado chamado: chamados.listaChamadosOrdenados(listaChamados)) {
            localizacaoAtual = chamado.getLocalizacao();
            if (!Objects.equals(localizacao, chamado.getLocalizacao()) && listaChamados.size() > 1) {
                QtdPorLocalidadeDto qtdPorLocalidadeDto = new QtdPorLocalidadeDto();
                qtdPorLocalidadeDto.setLocalidade(chamado.getLocalizacao());
                qtdPorLocalidadeDto.getChamados().add(chamado.getId());
                listaDeChamado.add(qtdPorLocalidadeDto);
            } else {
                for (QtdPorLocalidadeDto item: listaDeChamado) {
                    if (item.getLocalidade().equals(localizacaoAtual)) {
                        item.getChamados().add(chamado.getId());
                        item.setQuantidade(item.getChamados().size());
                    }
                }
            }
            localizacao = chamado.getLocalizacao();
        }

        for (QtdPorLocalidadeDto itens: listaDeChamado) {
            if (itens.getLocalidade().contains(SUL)){
                listaSul.add(itens);
            } else if (itens.getLocalidade().contains(NORTE)) {
                listaNorte.add(itens);
            } else if (itens.getLocalidade().contains(CENTRO)){
                listaCentro.add(itens);
            } else if (itens.getLocalidade().contains(LESTE)) {
                listaLeste.add(itens);
            } else {
                listaSemRegiao.add(itens);
            }
        }

        ChamadoPorRegiaoDto chamadoPorRegiaoSul = new ChamadoPorRegiaoDto(listaSul, SUL);
        ChamadoPorRegiaoDto chamadoPorRegiaoLeste = new ChamadoPorRegiaoDto(listaLeste, LESTE);
        ChamadoPorRegiaoDto chamadoPorRegiaoCentro = new ChamadoPorRegiaoDto(listaCentro, CENTRO);
        ChamadoPorRegiaoDto chamadoPorRegiaoNorte = new ChamadoPorRegiaoDto(listaNorte, NORTE);
        ChamadoPorRegiaoDto chamadoSemRegiao = new ChamadoPorRegiaoDto(listaSemRegiao, "Sem Região");

        chamadoPorRegiaoDtos.add(chamadoPorRegiaoCentro);
        chamadoPorRegiaoDtos.add(chamadoPorRegiaoLeste);
        chamadoPorRegiaoDtos.add(chamadoPorRegiaoSul);
        chamadoPorRegiaoDtos.add(chamadoPorRegiaoNorte);
        chamadoPorRegiaoDtos.add(chamadoSemRegiao);

        return chamadoPorRegiaoDtos;
    }
}

