package org.example.service;

import java.time.LocalDate;

import org.example.model.OrdemManutencao;
import org.example.repository.OrdemDAO;

public class ServiceOrdem 
{
    public static void cadastrarOrdemService(int maquina, int tecnico)
    {
        LocalDate data_solicitacao = LocalDate.now();
        boolean sucesso = false;

        var ordem = new OrdemManutencao(maquina, tecnico, data_solicitacao, "PENDENTE");

        sucesso = OrdemDAO.cadastrarOrdem(ordem)
        
    }
}
