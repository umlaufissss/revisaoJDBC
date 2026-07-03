package org.example.service;

import java.time.LocalDate;

import org.example.model.OrdemManutencao;

public class ServiceOrdem 
{
    public static void cadastrarOrdemService(int maquina, int tecnico)
    {
        LocalDate data_solicitacao = LocalDate.now();
        boolean sucesso = false;

        var ordem = new OrdemManutencao(maquina, tecnico, data_solicitacao, "PENDENTE");

        
    }
}
