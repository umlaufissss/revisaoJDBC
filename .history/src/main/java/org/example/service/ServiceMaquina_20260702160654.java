package org.example.service;

import java.sql.SQLException;

import org.example.model.Maquina;
import org.example.repository.MaquinaDAO;

public class ServiceMaquina 
{
    public static void serviceCadastrarMaquina(String nome, String setor)
    {

        boolean sucesso = false;
        //Exec. 3 Nome
        if(nome.isBlank() || nome.isEmpty())
        {
            return "Nome é obrigatório";
        }
        //Exec. 3 Setor
        else if(setor.isBlank() || setor.isEmpty())
        {
            return "Setor é obrigatório";
        }

        var maquina = new Maquina(nome, setor, "OPERACIONAL");

        try
        {
            sucesso = MaquinaDAO.cadastrarMaquinaDAO(maquina);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        //Exec. 5
        if(!sucesso)
        {
            System.out.println("Erro ao inserir no banco de dados!");
        }

        return "Máquina inserida com sucesso!";
    }
}
