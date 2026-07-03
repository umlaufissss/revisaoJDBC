package org.example.repository;

import org.example.model.Maquina;

public class MaquinaDAO 
{
    public void cadastrarMaquinaDAO(Maquina maquina)
    {
        String sql = """
        INSERT INTO Maquina (nome, setor, status) VALUES (?,?,?)
                """;

        try
    }
}
