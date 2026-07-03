package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.example.model.OrdemManutencao;
import org.example.model.Peca;
import org.example.util.ConnectionFactory;

public class PecaDAO 
{
    public static boolean cadastrarPecaDAO(Peca peca) throws SQLException
    {
        String sql = """
                INSERT INTO Peca (nome, estoque) VALUES (?,?)
                """;

        try(Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, peca.getNome());
            stmt.setDouble(2, peca.getEstoque());

            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        }
    }


    public static boolean pecaExiste(Peca peca) throws SQLException
    {
        String sql = """
                SELECT id FROM Peca WHERE nome = ?
                """;

       try(Connection conn = ConnectionFactory.Conexao();
       PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, peca.getNome());

            ResultSet rs = stmt.executeQuery();

            return !rs.next();
        } 
    }

    public static List<Peca> listarTudo() throws SQLException
    {
        String sql = "SELECT id, nome, estoque FROM Peca";


        List<Peca> pecas = new ArrayList<>();

        try(Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double especialidade = rs.getDouble("estoque");

                var peca = new Peca(id, nome, especialidade);
                pecas.add(peca);
            }
        }
        return pecas;
    }

    public static boolean buscarPorId(int id) throws SQLException
    {
        String sql = """
        SELECT id FROM Peca WHERE id = ?
        """;

        try(Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            return !rs.next();
        }
    }

    public static HashMap<OrdemManutencao, Integer> verificarEstoque() 
    {
        String sql = """
        SELECT p.id, p.nome, p.estoque, o.quantidade
        FROM Peca p
        JOIN OrdemPeca o ON p.id = o.idPeca
        """;

        tr
    }
}
