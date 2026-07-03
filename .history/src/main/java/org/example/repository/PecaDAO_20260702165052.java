package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.example.ConnectionFactory.ConnectionFactory;
import org.example.model.Peca;

public class PecaDAO 
{
    public static boolean pecaExiste(Peca peca) throws SQLException
    {
        String sql = """
                SELECT id FROM Peca WHERE nome = ?
                """;

       try(Connection conn = ConnectionFactory.Conexao();
       PreparedStatement stmt = conn.prepareStatement(sql))
        {

        } 
    }
}
