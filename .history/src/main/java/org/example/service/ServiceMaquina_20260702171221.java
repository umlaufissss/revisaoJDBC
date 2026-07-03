package org.example.service;

import java.sql.SQLException;

import org.example.model.Maquina;
import org.example.repository.MaquinaDAO;

public class ServiceMaquina 
{
    public static String serviceCadastrarMaquina(String nome, String setor)
    {

        boolean sucesso = false, Nexiste = false;
        //Exec. 3 Verificação de Nome
        if(nome.isBlank() || nome.isEmpty())
        {
            return "Nome é obrigatório";
        }
        //Exec. 3 Verificação de Setor
        else if(setor.isBlank() || setor.isEmpty())
        {
            return "Setor é obrigatório";
        }

        var maquina = new Maquina(nome, setor, "OPERACIONAL");

        //Exec. 3 Validação se a máquina existe no setor
        try
        {
            Nexiste = MaquinaDAO.maquinaExisteDAO(maquina);
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }

        if(!Nexiste)
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

    public static List<Maquina> listarOperacionaisService()
    {
        
    }
}
