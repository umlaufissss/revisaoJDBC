package org.example.ConnectionFactory;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory 
{
    private final String URL = "jdbc:mysql://localhost:3307/RevisaoSQl?useSSL=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "mysqlPW";

    public Connection Conexao() throws SQLException
    {
        return DriverManager.getConnection(URL, RO)
    }
}
