package org.example.service;

import java.sql.SQLException;

import org.example.model.OrdemPeca;
import org.example.repository.OrdemPecaDAO;

public class ServiceOrdemPeca 
{
    public static String serviceAssociarOrdem(int idOrdem, int idPeca, double quantidade)
    {
        boolean sucesso = false;

        var ordemPeca = new OrdemPeca(idOrdem, idPeca, quantidade);
        try
        {
            sucesso = OrdemPecaDAO.cadastrarOrdemPeca(ordemPeca);
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }

        if(!sucesso)
        {
            return "Erro! Falha ao inserir no banco de dados!";
        }

            return "Máquina inserida com sucesso!";
        }
    }
}
