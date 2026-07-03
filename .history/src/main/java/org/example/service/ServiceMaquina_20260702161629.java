package org.example.service;

import java.sql.SQLException;

import org.example.model.Maquina;
import org.example.repository.MaquinaDAO;

public class ServiceMaquina 
{
    public static void serviceCadastrarMaquina(String nome, String setor)
    {

        boolean sucesso = false, existe = false;
        //Exec. 3 Nome
        if(nome.isBlank() || nome.isEmpty())
        {
            System.out.println("Nome é obrigatório");
        }
        //Exec. 3 Setor
        else if(setor.isBlank() || setor.isEmpty())
        {
            System.out.println("Setor é obrigatório");
        }

        var maquina = new Maquina(nome, setor, "OPERACIONAL");

        try
        {
            existe = MaquinaDAO.maquinaExisteDAO(maquina);
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        try
        {
            sucesso = MaquinaDAO.cadastrarMaquinaDAO(maquina);
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        //Exec. 5
        if(!sucesso)
        {
            System.out.println("Erro ao inserir no banco de dados!");
        }

        System.out.println("Máquina inserida com sucesso!");
    }
}
