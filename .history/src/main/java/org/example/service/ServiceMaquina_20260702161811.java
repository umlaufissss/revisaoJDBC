package org.example.service;

import java.sql.SQLException;

import org.example.model.Maquina;
import org.example.repository.MaquinaDAO;

public class ServiceMaquina 
{
    public static String serviceCadastrarMaquina(String nome, String setor)
    {

        boolean sucesso = false, existe = false;
        //Exec. 3 Verificação de Nome
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
            System.out.println();
        }
        try
        {
            sucesso = MaquinaDAO.cadastrarMaquinaDAO(maquina);
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        //Exec. 5 Mensagem de sucesso
        if(!sucesso)
        {
            return "Erro ao inserir no banco de dados!";
        }

        return "Máquina inserida com sucesso!";
    }
}
