package org.example.service;

import java.sql.SQLException;

import org.example.model.Maquina;
import org.example.model.Tecnico;
import org.example.repository.MaquinaDAO;

public class ServiceTecnico 
{
    public static String cadastrarTecnico(String nome, String especialidade)
    {
        boolean sucesso = false, existe = false;
        //Exec. 3 Verificação de Nome
        if(nome.isBlank() || nome.isEmpty())
        {
            return "Nome é obrigatório";
        }

        var maquina = new Tecnico(nome, especialidade, "OPERACIONAL");

        //Exec. 3 Validação se a máquina existe no setor
        try
        {
            existe = MaquinaDAO.maquinaExisteDAO(maquina);
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }

        if(!existe)
        {
            return "Erro! Máquina já existe neste setor!";
        }
        //Exec. 5 Mensagem de sucesso
        else
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
