package org.example.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.model.Peca;
import org.example.repository.PecaDAO;
import org.example.repository.TecnicoDAO;

public class ServicePeca 
{
    public static String serviceCadastroPeca(String nome, double estoque)
    {
        boolean Nexiste = false, sucesso = false;
        //Exec. 3 Validar nome
        if(nome.isBlank() || nome.isEmpty())
        {
            return "Nome é obrigatório";
        }

        //Exec. 3 Validar estoque
        if(estoque < 0)
        {
            return "Estoque deve conter um valor positivo";
        }

        var peca = new Peca(nome, estoque);
        //Exec. 3 Validar duplicidade
        try
        {
            Nexiste = PecaDAO.pecaExiste(peca);
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }

        if(!Nexiste)
        {
            return "Erro! Essa peça já existe no nosso banco de dados!";
        }
        else
        {
            try 
            {
                //Exec. 4
                sucesso = PecaDAO.cadastrarPecaDAO(peca);
            }
            catch (SQLException e) 
            {
                System.err.println(e);
            }

            //Exec. 5
            if(!sucesso)
            {
                return "Erro! Falha ao inserir no banco de dados!";
            }

            return "Peça inserida com sucesso!";
        }
    }

    public static List<Peca> listarTudo()
    {
        List<Peca> pecas = new ArrayList<>();
        try
        {
            pecas = PecaDAO.listarTudo();
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }

        if(pecas.isEmpty())
        {
            return null;
        }

        return pecas;
    }

    public static void buscarPorId(int id, double estoque) throws SQLException
    {
        boolean Nexiste = TecnicoDAO.buscarPorId(id);

        if(Nexiste)
        {
            System.out.println("Ordem não existe");
        }
        else
        {
            if(estoque < 0)
            {
                System.out.println("Quantidade inválida");
            }
        }
    }

    public static Map<Peca, Double> verificarEstoque()
    {
        Map<Peca, Double> verificar = new HashMap<>();

        try
        {
            verificar = PecaDAO.verificarEstoque();
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }

        if(verificar.isEmpty())
        {
            return null;
        }

        return verificar;
    }

    public static String estoqueSuficiente(Peca peca, double quantidade)
    {
        if(quantidade > peca.getEstoque())
        {
            return "INSUFICIENTE";
        }
        
        //diminuir
        //

        return "";
    }
}
