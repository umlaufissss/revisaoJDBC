package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.example.ConnectionFactory.ConnectionFactory;
import org.example.model.Maquina;

public class MaquinaDAO 
{
    public void cadastrarMaquinaDAO(Maquina maquina) throws SQL
    {
        String sql = """
        INSERT INTO Maquina (nome, setor, status) VALUES (?,?,?)
                """;

        try(Connection conn = ConnectionFactory.Conexao()
        PreparedStatement stmt = conn.prepareStatement(sql))
        {

        }
    }
}
