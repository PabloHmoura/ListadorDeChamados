package br.com.pablo.chamados.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Chamado {
    private String id;
    private String titulo;
    private String status;
    private String tempoAtendimentoProgresso;
    private String tempoSolucaoProgresso;
    private String requerente;
    private String categoria;
    private String prioridade;
    private String urgencia;
    private String dataAbertura;
    private String atribuidoGrupoTecnico;
    private String atribuidoTecnico;
    private String localizacao;
    private String impacto;
    private String dataSolucao;
    private String solucao;
    private String descricao;
    private String ultimaAtualizacao;

    public Chamado() {
        this.id = "____";
        this.titulo = "___________";
        this.status = "";
        this.tempoAtendimentoProgresso = "";
        this.tempoSolucaoProgresso = "";
        this.requerente = "";
        this.categoria = "____";
        this.prioridade = "";
        this.urgencia = "";
        this.dataAbertura = "";
        this.atribuidoGrupoTecnico = "";
        this.atribuidoTecnico = "";
        this.localizacao = "_________________";
        this.impacto = "";
        this.dataSolucao = "";
        this.solucao = "";
        this.descricao = "";
        this.ultimaAtualizacao = "";
    }

    @Override
    public String toString() {
        return "Chamado{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", status='" + status + '\'' +
                ", tempoAtendimentoProgresso='" + tempoAtendimentoProgresso + '\'' +
                ", tempoSolucaoProgresso='" + tempoSolucaoProgresso + '\'' +
                ", requerente='" + requerente + '\'' +
                ", categoria='" + categoria + '\'' +
                ", prioridade='" + prioridade + '\'' +
                ", urgencia='" + urgencia + '\'' +
                ", dataAbertura=" + dataAbertura +
                ", atribuidoGrupoTecnico='" + atribuidoGrupoTecnico + '\'' +
                ", atribuidoTecnico='" + atribuidoTecnico + '\'' +
                ", localizacao='" + localizacao + '\'' +
                ", impacto='" + impacto + '\'' +
                ", dataSolucao=" + dataSolucao +
                ", solucao='" + solucao + '\'' +
                ", descricao='" + descricao + '\'' +
                ", ultimaAtualizacao=" + ultimaAtualizacao +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTempoAtendimentoProgresso() {
        return tempoAtendimentoProgresso;
    }

    public void setTempoAtendimentoProgresso(String tempoAtendimentoProgresso) {
        this.tempoAtendimentoProgresso = tempoAtendimentoProgresso;
    }

    public String getTempoSolucaoProgresso() {
        return tempoSolucaoProgresso;
    }

    public void setTempoSolucaoProgresso(String tempoSolucaoProgresso) {
        this.tempoSolucaoProgresso = tempoSolucaoProgresso;
    }

    public String getRequerente() {
        return requerente;
    }

    public void setRequerente(String requerente) {
        this.requerente = requerente;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getAtribuidoGrupoTecnico() {
        return atribuidoGrupoTecnico;
    }

    public void setAtribuidoGrupoTecnico(String atribuidoGrupoTecnico) {
        this.atribuidoGrupoTecnico = atribuidoGrupoTecnico;
    }

    public String getAtribuidoTecnico() {
        return atribuidoTecnico;
    }

    public void setAtribuidoTecnico(String atribuidoTecnico) {
        this.atribuidoTecnico = atribuidoTecnico;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getImpacto() {
        return impacto;
    }

    public void setImpacto(String impacto) {
        this.impacto = impacto;
    }

    public String getDataSolucao() {
        return dataSolucao;
    }

    public void setDataSolucao(String dataSolucao) {
        this.dataSolucao = dataSolucao;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(String ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
}
