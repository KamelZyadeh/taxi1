package com.java.tutorial;

import org.postgresql.Driver;
import java.sql.*;

public class ConnectionBuilder {

    private static Connection connection;
    private static final String url = "jdbc:postgresql://localhost:5432/taxi";
    private static final String username = "postgres";
    private static final String password = "12345";

    private ConnectionBuilder() {

    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
