package org.example.service;

import java.sql.SQLException;

import org.example.model.Maquina;
import org.example.repository.MaquinaDAO;

public class ServiceOrdemPeca 
{
    public static String serviceAssociarOrdem(String nome, String setor)
    {

        try
        {
            sucesso = MaquinaDAO.cadastrarMaquinaDAO(maquina);
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
