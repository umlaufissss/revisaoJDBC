package org.example.repository;

import java.sql.SQLException;

import org.example.model.OrdemManutencao;

public class Ordem 
{
    public static void cadastrarOrdem(OrdemManutencao ordem) throws SQLException
    {
        String sql = """
        INSERT INTO OrdemManutencao 
        (idMaquina, idTecnico, dataSolicitacao, status)
        VALUES """;
    }
}
