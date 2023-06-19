package br.com.pablo.chamados.model;

import br.com.pablo.chamados.dto.QtdPorLocalidadeDto;
import br.com.pablo.chamados.mapper.ChamadoMapper;
import br.com.pablo.chamados.repository.Connection;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.*;

@Service
public class ChamadoService {

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
}

