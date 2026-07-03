package org.example.repository;

import org.example.model.Tecnico;

public class TecnicoDAO 
{
    public static void cadastrarTecnicoDAO(Tecnico tecnico) thr
    {
        String sql = """
                INSERT INTO Tecnico (nome, especialidade) VALUES (?,?)
                """;

        try
    }    
}
