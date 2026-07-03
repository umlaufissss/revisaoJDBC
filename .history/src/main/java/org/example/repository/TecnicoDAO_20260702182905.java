package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.ConnectionFactory.ConnectionFactory;
import org.example.model.Tecnico;

import com.mysql.cj.xdevapi.Result;

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
    
    public static boolean tecnicoDuplo(Tecnico tecnico) throws SQLException
    {
        String sql = "SELECT id FROM Tecnico WHERE nome = ? AND especialidade = ?";

        try(Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, tecnico.getNome());
            stmt.setString(2, tecnico.getEspecialidade());

            ResultSet rs = stmt.executeQuery();

            return !rs.next();
        }
    }

    public static List<Tecnico> listarTudo() throws SQLException
    {
        String sql = "SELECT id, nome, especialidade FROM Tecnico";


        List<Tecnico> tecnicos = new ArrayList<>();

        try(Connection conn = ConnectionFactory.Conexao();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String especialidade = rs.getString("especialidade");

                var tecnico = new Tecnico(id, nome, especialidade)
            }
        }
    }
}
