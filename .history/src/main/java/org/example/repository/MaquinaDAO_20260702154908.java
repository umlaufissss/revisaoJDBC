package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.example.ConnectionFactory.ConnectionFactory;
import org.example.model.Maquina;

public class MaquinaDAO 
{
    public void cadastrarMaquinaDAO(Maquina maquina) throws SQLException
    {
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
            if(linhasAfetadas )
        }
    }
}
