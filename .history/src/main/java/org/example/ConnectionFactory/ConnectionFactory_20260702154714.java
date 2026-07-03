package org.example.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory 
{
    private static final String URL = "jdbc:mysql://localhost:3307/RevisaoSQl?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "mysqlPW";

    public static Connection Conexao() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
