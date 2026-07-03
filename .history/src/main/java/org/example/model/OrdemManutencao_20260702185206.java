package org.example.model;

import java.time.LocalDate;

public class OrdemManutencao 
{
    private int id;
    private int idMquina;
    private int idTecnico;
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

    public int getIdMquina() {
        return idMquina;
    }

    public void setIdMquina(int idMquina) {
        this.idMquina = idMquina;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
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
