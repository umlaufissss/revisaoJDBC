package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static Map<Peca, Double> verificarEstoque() throws SQLException
    {
        String sql = """
        SELECT p.id, p.nome, p.estoque, o.quantidade
        FROM Peca p
        JOIN OrdemPeca o ON p.id = o.idPeca
        """;

        Map<Peca, Double> verificarEstoque = new HashMap<>();

        try(Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double estoque = rs.getDouble("estoque");
                double quantidade = rs.getDouble("quantidade");

                var peca = new Peca(id, nome, estoque);
                verificarEstoque.put(peca, quantidade);
            }
        }

        return verificarEstoque;
    }

    public static void alterarEstoque(double quantidade, int id)
    {
        String sql = """
                UPDATE Peca SET estoque = estoque - ? WHERE id = ?
                """;

        try(Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setD
        }
    }
}
