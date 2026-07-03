package org.example.service;

import java.sql.SQLException;
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

        try
        {
            sucesso = OrdemDAO.cadastrarOrdem(ordem);
        }
            catch(SQLException e)
        {
            System.err.println(e);
        }

        if(sucesso)
        {
            //serviceMaquina
            return "Ordem de manutenção criada com sucesso!";
        }
        return;
    }
}
