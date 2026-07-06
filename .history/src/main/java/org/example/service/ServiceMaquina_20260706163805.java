package org.example.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.model.Maquina;
import org.example.repository.MaquinaDAO;

public class ServiceMaquina 
{
    public static String serviceCadastrarMaquina(String nome, String setor)
    {

        //Tratamento dos valores recebidos
        boolean sucesso = false, Nexiste = false;
        
        if(nome.isBlank() || nome.isEmpty())
        {
            return "Nome é obrigatório";
        }
        
        else if(setor.isBlank() || setor.isEmpty())
        {
            return "Setor é obrigatório";
        }

        var maquina = new Maquina(nome, setor);

        //Validação se a máquina existe no setor
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
        //Retornar mensagem de sucesso ou de erro
        else
        {
            try
            {
                //Mandar para repositório e cadastrar máquina
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
        List<Maquina> maquinas = new ArrayList<>();

        //Receber lista de máquinas operacionais
        try
        {
            maquinas = MaquinaDAO.listarOperacional();
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }

        //Tratamento de 
        if(maquinas.isEmpty())
        {
            return null;
        }

        return maquinas;
    }

    public static void atualizarStatus(int id) throws SQLException
    {
        MaquinaDAO.atualizarMaquina(id);
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
