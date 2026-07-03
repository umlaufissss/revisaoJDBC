package org.example.repository;

import java.sql.Connection;

import org.example.model.Peca;

public class PecaDAO 
{
    public static boolean pecaExiste(Peca peca)
    {
        String sql = """
                SELECT id FROM Peca WHERE nome = ?
                """;

       try(Connection conn = Conn) 
    }
}
