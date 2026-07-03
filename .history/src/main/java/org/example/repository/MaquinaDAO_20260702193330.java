package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.model.Maquina;
import org.example.util.ConnectionFactory;

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

            return linhasAfetadas > 0;
        }
    }

    public static boolean maquinaExisteDAO(Maquina maquina) throws SQLException
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

            return !rs.next();
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

    public static void atualizarMaquina(int id) throws SQLException
    {
        String sql = """
        UPDATE Maquina SET status = 'EM_MANUTENÇAÕ'
        WHERE id = ?
        """;

        try(Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }

    public static int procurarPorId(int id) throws SQLException
    {
        String sql = """
        SELECT id FROM Maquina WHERE id = ?
        """;

        try(Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, id);

            int linhasstmt.executeUpdate();

            return id;
        }
    }
}
