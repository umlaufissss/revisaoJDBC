package org.example.service;

import java.time.LocalDate;

import org.example.model.OrdemManutencao;
import org.example.model.Tecnico;

public class ServiceOrdem 
{
    public static void cadastrarOrdemService(Maquina Maquina, Tecnico idTecnico)
    {
        LocalDate data_solicitacao = LocalDate.now();

        var ordem = new OrdemManutencao(maquina, tecnico, status, data_solicitacao)

    }
}
