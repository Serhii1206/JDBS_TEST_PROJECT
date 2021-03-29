package database;

import entity.Clients;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class Database {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setAutoCommit(false);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("No connectNo connect");
//            connection.close();
        }
        return connection;
    }
}
