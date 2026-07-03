package org.example.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.example.model.OrdemManutencao;
import org.example.repository.MaquinaDAO;
import org.example.repository.OrdemDAO;

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
        List<OrdemManutencao> ordens = new ArrayList<>();
        try
        {
            ordens = OrdemDAO.listarPendencias();
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }

        if(ordens.isEmpty())
        {
            return null;
        }

        return ordens;
    }

    public static void buscarPorId(int id) throws SQLException
    {
        boolean Nexiste = MaquinaDAO.buscarPorId(id);

        if (Nexiste) 
        {
            System.out.println("Máquina não existe");
        }
    }
}
