package org.example.service;

import java.time.LocalDate;

import org.example.model.Maquina;
import org.example.model.OrdemManutencao;
import org.example.model.Tecnico;

public class ServiceOrdem 
{
    public static void cadastrarOrdemService(int maquina, int tecnico)
    {
        LocalDate data_solicitacao = LocalDate.now();

        var ordem = new OrdemManutencao(maquina, tecnico, "PENDENTE", data_solicitacao);

        

    }
}
