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
        List<Maquina> maquinas = new ArrayList<>();
        try
        {
            maquinas = MaquinaDAO.listarOperacional();
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }

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

        if (existe) 
        {
            System.out.println("Máquina não existe");
        }
    }
}
