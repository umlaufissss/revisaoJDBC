package org.example.repository;

import java.sql.Connection;

import org.example.model.Maquina;

public class MaquinaDAO 
{
    public void cadastrarMaquinaDAO(Maquina maquina)
    {
        String sql = """
        INSERT INTO Maquina (nome, setor, status) VALUES (?,?,?)
                """;

        try(Connection conn = Conne)
    }
}
