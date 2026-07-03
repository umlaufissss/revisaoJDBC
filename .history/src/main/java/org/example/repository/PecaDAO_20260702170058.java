package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.ConnectionFactory.ConnectionFactory;
import org.example.model.Peca;

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
            stmt.setString(2, peca.getEstoque());

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
}
