package org.example.repository;

import java.sql.SQLException;

import org.example.model.Tecnico;

public class TecnicoDAO 
{
    public static void cadastrarTecnicoDAO(Tecnico tecnico) throws SQLException
    {
        String sql = """
                INSERT INTO Tecnico (nome, especialidade) VALUES (?,?)
                """;

        try
    }    
}
