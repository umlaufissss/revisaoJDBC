package org.example.model;

import java.time.LocalDate;
import java.util.Date;

public class OrdemManutencao 
{
    private int id;
    private Maquina maquina;
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

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
