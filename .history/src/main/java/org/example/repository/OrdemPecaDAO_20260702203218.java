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
        (idOrdem, idPeca, quantidade)
        VALUES (?,?,?)""";

        try(Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, ordemPeca.getIdOrdem());
            stmt.setInt(2, ordemPeca.getIdPeca());
            stmt.setDouble(, x);(3, );
            stmt.setString(4, ordem.getStatus());

            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;
        }
    }
}
