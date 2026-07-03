package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.example.model.OrdemManutencao;
import org.example.model.OrdemPeca;
import org.example.util.ConnectionFactory;

public class OrdemPecaDAO 
{
    public static boolean  cadastrarOrdemPeca(OrdemPeca ordemPeca) throws SQLException
    {
        String sql = """
        INSERT INTO OrdemPeca 
        (idOrdem, idPeca, dataSolicitacao, status)
        VALUES (?,?,?,?)""";

        try(Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, ordem.getIdMaquina());
            stmt.setInt(2, ordem.getIdTecnico());
            stmt.setDate(3, Date.valueOf(ordem.getDataSolicitacao()));
            stmt.setString(4, ordem.getStatus());

            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;
        }
    }
}
