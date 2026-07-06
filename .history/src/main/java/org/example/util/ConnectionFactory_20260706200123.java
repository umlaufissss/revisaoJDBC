package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory 
{
    private static ConnectionFactory connectionInstance;

    private ConnectionFactory(){}

    public static ConnectionFactory getInstance()
    {
        if
    }

    private static final String URL = "jdbc:mysql://localhost:3356/RevisaoJDBC?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "mysqlPW";

    public static Connection Conexao() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
