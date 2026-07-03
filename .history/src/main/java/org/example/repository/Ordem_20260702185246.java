package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.example.ConnectionFactory.ConnectionFactory;
import org.example.model.OrdemManutencao;

public class Ordem 
{
    public static void cadastrarOrdem(OrdemManutencao ordem) throws SQLException
    {
        String sql = """
        INSERT INTO OrdemManutencao 
        (idMaquina, idTecnico, dataSolicitacao, status)
        VALUES (?,?,?,?)""";

        try(Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, ordem.getIdMquina();
            stmt.setInt(2, ordem.getIdTecnico());
            stmt.setInt(1, ordem.getMaquina().getId());
        }
    }
}
