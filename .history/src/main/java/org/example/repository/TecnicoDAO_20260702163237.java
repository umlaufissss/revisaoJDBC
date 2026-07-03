package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.example.ConnectionFactory.ConnectionFactory;
import org.example.model.Tecnico;

public class TecnicoDAO 
{
    public static boolean cadastrarTecnicoDAO(Tecnico tecnico) throws SQLException
    {
        String sql = """
                INSERT INTO Tecnico (nome, especialidade) VALUES (?,?)
                """;

        try (Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, tecnico.getNome());
            stmt.setString(2, tecnico.getEspecialidade());

            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;
        }
    }   
    
    public static void tecnicoDuplo(Tecnico tecnico) throws SQLException
    {
        String sql = "SELECT id FROM Tecnico WHERE nome = ? AND especialidade = ?";

        try(Connection conn = Conn)
    }
}
