package org.example.service;

import java.sql.SQLException;

import org.example.model.Tecnico;
import org.example.repository.TecnicoDAO;

public class ServiceTecnico 
{
    public static String cadastrarTecnico(String nome, String especialidade)
    {
        boolean sucesso = false, Nexiste = false;

        //Exec. 3 Verificação de Nome
        if(nome.isBlank() || nome.isEmpty())
        {
            return "Nome é obrigatório";
        }

        var tecnico = new Tecnico(nome, especialidade);

        //Exec. 3 Validação se a máquina existe no setor
        try 
        {
            Nexiste = TecnicoDAO.tecnicoDuplo(tecnico);
        } 
        catch (SQLException e) 
        {
            System.err.println(e);
        }
    
        if(existe)
        {
            return "Erro! Técnico duplicado, reveja as informações";
        }
        //Exec. 5 Mensagem de sucesso;
        else
        {
            //Pegando a resposta da DAO;
            try
            {
                sucesso = TecnicoDAO.cadastrarTecnicoDAO(tecnico);
            }
            catch(SQLException e)
            {
                System.err.println(e);
            }

            //Retornando as mensagens de erro ou acerto;
            if(!sucesso)
            {
                return "Erro! Falha ao inserir no banco de dados!";
            }

            return "Máquina inserida com sucesso!";
        }
    }    
}
