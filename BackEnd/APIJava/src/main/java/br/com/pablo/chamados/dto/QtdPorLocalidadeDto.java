package br.com.pablo.chamados.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class QtdPorLocalidadeDto {

    private Integer quantidade;
    private String Localidade;
    private List<String> chamados;

    public QtdPorLocalidadeDto() {
        chamados = new ArrayList<>();
        quantidade = 1;
    }


}
