package org.example.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.example.model.OrdemManutencao;
import org.example.model.Tecnico;
import org.example.repository.OrdemDAO;
import org.example.repository.TecnicoDAO;

public class ServiceOrdem 
{
    public static String cadastrarOrdemService(int maquina, int tecnico)
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
            try
            {
                ServiceMaquina.atualizarStatus(maquina);
            }
            catch(SQLException e)
            {
                System.err.println(e);
            }
            return "Ordem de manutenção criada com sucesso!";
        }
        return "Erro! Falha ao criar ordem de manutenção!";
    }

    public static List<OrdemManutencao> listarPendencias()
    {
        List<OrdemManutencao> tecnicos = new ArrayList<>();
        try
        {
            tecnicos = TecnicoDAO.listarTudo();
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }

        if(tecnicos.isEmpty())
        {
            return null;
        }

        return tecnicos;
    }
}
