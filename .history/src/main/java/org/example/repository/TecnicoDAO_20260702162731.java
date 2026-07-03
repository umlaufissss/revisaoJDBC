package org.example.repository;

import org.example.model.Tecnico;

public class TecnicoDAO 
{
    public static void cadastrarTecnicoDAO(Tecnico tecnico)
    {
        String sql = """
                INSERT INTO Tecnico (nome, especialidade) VALUES (?,?)
                """;
    }    
}
