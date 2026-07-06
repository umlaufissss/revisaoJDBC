package org.example.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.model.OrdemManutencao;
import org.example.repository.OrdemDAO;

public class ServiceOrdem 
{
    public static String cadastrarOrdemService(int maquina, int tecnico)
    {
        boolean sucesso = false;

        var ordem = new OrdemManutencao(maquina, tecnico);

        //Mandar para o repositório para cadastrar ordem de manutenção
        try
        {
            sucesso = OrdemDAO.cadastrarOrdem(ordem);
        }
            catch(SQLException e)
        {
            System.err.println(e);
        }

        //Mensagens de sucesso ou fracasso
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

        //Receber lista de pendencias
        try
        {
            ordens = OrdemDAO.listarPendencias();
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }

        //Verificação de resultado nulo
        if(ordens.isEmpty())
        {
            return null;
        }

        return ordens;
    }

    public static void buscarPorId(int id) throws SQLException
    {
        boolean Nexiste = OrdemDAO.buscarPorId(id);

        if (Nexiste) 
        {
            System.out.println("Ordem não existe");
        }
    }
}
