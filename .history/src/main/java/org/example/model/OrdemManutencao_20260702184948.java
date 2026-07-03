package org.example.model;

import java.time.LocalDate;

public class OrdemManutencao 
{
    private int id;
    private int maquina;
    private Tecnico tecnico;
    private LocalDate dataSolicitacao;
    private String status;

    public OrdemManutencao(int id, Maquina maquina, Tecnico tecnico, String status, LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
        this.id = id;
        this.maquina = maquina;
        this.status = status;
        this.tecnico = tecnico;
    }

    public OrdemManutencao(Maquina maquina, Tecnico tecnico, String status, LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
        this.maquina = maquina;
        this.status = status;
        this.tecnico = tecnico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
