package org.example.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.model.OrdemPeca;
import org.example.model.Peca;
import org.example.repository.MaquinaDAO;
import org.example.repository.OrdemDAO;
import org.example.repository.PecaDAO;
import org.example.repository.TecnicoDAO;

public class ServicePeca 
{
    public static String serviceCadastroPeca(String nome, double estoque)
    {
        boolean Nexiste = false, sucesso = false;
        
        //Validação dos valores
        if(nome.isBlank() || nome.isEmpty())
        {
            return "Nome é obrigatório";
        }

        if(estoque < 0)
        {
            return "Estoque deve conter um valor positivo";
        }

        var peca = new Peca(nome, estoque);
        try
        {
            Nexiste = PecaDAO.pecaExiste(peca);
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }

        //Retorno de resposta de duplicidade
        if(!Nexiste)
        {
            return "Erro! Essa peça já existe no nosso banco de dados!";
        }
        else
        {
            try 
            {
                sucesso = PecaDAO.cadastrarPecaDAO(peca);
            }
            catch (SQLException e) 
            {
                System.err.println(e);
            }

            //Retorno de resposta de sucesso ou de fracasso
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

        //Receber lista de todas as peças
        try
        {
            pecas = PecaDAO.listarTudo();
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }

        //Tratamento de valor nulo
        if(pecas.isEmpty())
        {
            return null;
        }

        return pecas;
    }

    public static void buscarPorId(int id, double estoque) throws SQLException
    {
        //Procurar por ID
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

    public static Map<Peca, OrdemPeca> verificarEstoque()
    {
        Map<Peca, OrdemPeca> verificar = new HashMap<>();

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

    public static String estoqueSuficiente(Peca peca, double quantidade) throws SQLException
    {
        //Verifica se valor de ordem é suficiente
        if(quantidade > peca.getEstoque())
        {
            return "INSUFICIENTE";
        }
        
        //Diminui estoque em relação ao valor da ordem
        PecaDAO.alterarEstoque(quantidade, peca.getId());

        //Altera o status da ordem de manutenção para executada
        OrdemDAO.alterarStatus(peca.getId());

        //Altera o status da maquina para operacional
        MaquinaDAO.alterarStatus(peca.getId());

        return "SUFICIENTE E ALTERADO";
    }
}
