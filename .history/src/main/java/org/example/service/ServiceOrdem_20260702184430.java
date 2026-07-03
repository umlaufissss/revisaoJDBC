package org.example.service;

import java.time.LocalDate;

import org.example.model.OrdemManutencao;

public class ServiceOrdem 
{
    public static void cadastrarOrdemService(Maquina Maquina, int idTecnico)
    {
        LocalDate data_solicitacao = LocalDate.now();

        var ordem = new OrdemManutencao(maquina, tecnico, status, data_solicitacao)

    }
}
