package org.example.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory 
{
    private static final String URL = "jdbc:mysql://127.:3306/RevisaoJDBC?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "mysqlPW";

    public static Connection Conexao() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
