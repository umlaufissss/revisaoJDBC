package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.ConnectionFactory.ConnectionFactory;
import org.example.model.Maquina;

public class MaquinaDAO 
{
    public static boolean cadastrarMaquinaDAO(Maquina maquina) throws SQLException
    {
        //Exec. 4
        String sql = """
        INSERT INTO Maquina (nome, setor, status) VALUES (?,?,?)
                """;

        try(Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, maquina.getNome());
            stmt.setString(2, maquina.getSetor());
            stmt.setString(3, maquina.getStatus());

            int linhasAfetadas = stmt.executeUpdate();

            if(linhasAfetadas > 0)
            { 
                return true;
            }
            
            return false;
        }
    }

    public static void maquinaExisteDAO(Maquina maquina) throws SQLException
    {
        String sql = """
                SELECT id FROM Maquina WHERE nome = ? AND setor = ?
                """;

        try(Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, maquina.getNome());
            stmt.setString(2, maquina.getSetor());

            ResultSet rs = stmt.executeQuery();

            

        }
    }
}
