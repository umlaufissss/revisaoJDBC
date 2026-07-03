package org.example.model;

import java.util.Date;

public class OrdemManutencao 
{
    private int id;
    private Maquina maquina;
    private Tecnico tecnico;
    private Date dataSolicitacao;
    private String status;

    public OrdemManutencao(Date dataSolicitacao, int id, Maquina maquina, String status, Tecnico tecnico) {
        this.dataSolicitacao = dataSolicitacao;
        this.id = id;
        this.maquina = maquina;
        this.status = status;
        this.tecnico = tecnico;
    }

    public OrdemManutencao(Date dataSolicitacao, Maquina maquina, String status, Tecnico tecnico) {
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
