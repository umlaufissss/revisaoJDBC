package org.example.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.model.Maquina;
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

    public static List<Maquina> listarOperacional() throws SQLException
    {
        String sql = """
        SELECT id, nome, setor FROM Maquina WHERE status = 'OPERACIONAL'
        """;

        List<Maquina> maquinas = new ArrayList<>();

        try(Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt =  conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String setor = rs.getString("setor");

                var maquina = new Maquina(id, nome, setor, "OPERACIONAL");
                maquinas.add(maquina);
            }
        }
        return maquinas;
    }
}
