package org.example.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.example.model.OrdemManutencao;
import org.example.util.ConnectionFactory;

public class OrdemDAO
{
    public static boolean  cadastrarOrdem(OrdemManutencao ordem) throws SQLException
    {
        String sql = """
        INSERT INTO OrdemManutencao 
        (idMaquina, idTecnico, dataSolicitacao, status)
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

    public static List<OrdemManutencao> listarPendencias() throws SQLException
    {
        String sql = """
        SELECT id, idMaquina, idTecnico, dataSolicitacao, status FROM OrdemManutencao WHERE status = 'PENDENTE'
        """;

        List<OrdemManutencao> ordem = new ArrayList<>();

        try(Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt =  conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt("id");
                int idMaquina = rs.getInt("idMaquina");
                int idTecnico = rs.getInt("idTecnico");
                LocalDate dataSolicitacao = rs.getDate("dataSolicitacao").toLocalDate();
                String status = rs.getString("status");

                var ordemMan = new OrdemManutencao(id, idMaquina, idTecnico, dataSolicitacao, status);
                ordem.add(ordemMan);
            }
        return ordem;
        }
    }

    public static boolean  buscarPorId(int id) throws SQLException
    {
        String sql = """
        SELECT id FROM OrdemManutencao WHERE id = ?
        """;

        try(Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            return !rs.next();
        }
    }

    public static void alterarStatus(int id) throws SQLException
    {
        String sql = """
        UPDATE OrdemManutencao SET status = 'EXECUTADA' WHERE id = ? """;

        try(Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, id);

            stmt.exe
        }
    }
}
