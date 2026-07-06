package org.example.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.model.Tecnico;
import org.example.repository.TecnicoDAO;

public class ServiceTecnico 
{
    public static String cadastrarTecnico(String nome, String especialidade)
    {
        boolean sucesso = false, Nexiste = false;

        //Verificação de Nome
        if(nome.isBlank() || nome.isEmpty()){
            return "Nome é obrigatório";
        }

        var tecnico = new Tecnico(nome, especialidade);

        //Validação se a máquina existe no setor
        try {
            Nexiste = TecnicoDAO.tecnicoDuplo(tecnico);
        } 
        catch (SQLException e) {
            System.err.println(e);
        }
    
        //Mensagem de duplicação
        if(!Nexiste){
            return "Erro! Técnico duplicado, reveja as informações";
        }
        //Retorna mensagem de sucesso ou fracasso;
        else{
            try{
                sucesso = TecnicoDAO.cadastrarTecnicoDAO(tecnico);
            }
            catch(SQLException e){
                System.err.println(e);
            }

            if(!sucesso){
                return "Erro! Falha ao inserir no banco de dados!";
            }

            return "Técnico inserido com sucesso!";
        }
    }    

    public static List<Tecnico> listarTodos()
    {
        List<Tecnico> tecnicos = new ArrayList<>();
        //Receber lista de todos os técnicos
        try
        {
            tecnicos = TecnicoDAO.listarTudo();
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }

        //Validação de nulo
        if(tecnicos == null)
        {
            System.out.println("A lista está vazia");
            return null;
        }

        return tecnicos;
    }

    public static boolean buscarPorId(int id) throws SQLException
    {
        //Procurar por ID
        boolean Nexiste = TecnicoDAO.buscarPorId(id);

        //Exibir mensagem de erro
        if(Nexiste)
        {
            System.out.println("Técnico não existe");
            return false;
        }
        return true;
    }

    
}
