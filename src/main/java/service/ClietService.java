package service;

import database.Database;
import entity.Clients;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClietService {
    private static final String SELECT = "SELECT * FROM clients";
    private static final String SELECT_BY_FHONE = "SELECT * FROM clients WHERE phone = ?";
    private static final String SELECT_BY_NAME = "SELECT * FROM clients WHERE name = ?";
    private static final String SAVE_CUSTOMER_QUERY = "INSERT INTO clients(name,email,phone,about,age)VALUES(?,?,?,?,?)";
    private static final String DELETE_CLIENT_ID_QUERY = "DELETE FROM clients WHERE id = ?";
    private static final String DELETE_CLIENT_ID_name = "DELETE FROM clients WHERE name = ?";
    private static final String UPDATE_CLIENT_NAME = "UPDATE clients SET email = ? WHERE id = ?";

    public List<Clients> getAll() {
        List<Clients> clients = new ArrayList<>();
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()) {
                Clients client = new Clients();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                client.setAge(resultSet.getInt("age"));
                clients.add(client);
            }
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clients;
    }

    public static List<Clients> finePhone(long phone) throws SQLException {
        List<Clients> clients = new ArrayList<>();
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_FHONE);
            preparedStatement.setLong(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Clients client = new Clients();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                client.setAge(resultSet.getInt("age"));
                clients.add(client);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public static List<Clients> findName(String name) {
        List<Clients> clients = new ArrayList<>();
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Clients client = new Clients();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                client.setAge(resultSet.getInt("age"));
                clients.add(client);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return clients;
    }

    public static void save(Clients clients) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CUSTOMER_QUERY)) {
            preparedStatement.setString(1, clients.getName());
            preparedStatement.setString(2, clients.getEmail());
            preparedStatement.setLong(3, clients.getPhone());
            preparedStatement.setString(4, clients.getAbout());
            preparedStatement.setInt(5, clients.getAge());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void delete(Clients client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT_ID_QUERY)) {
            preparedStatement.setInt(1, client.getId());
            preparedStatement.execute();
            connection.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteName(Clients clients) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT_ID_name)) {
            preparedStatement.setString(1, clients.getName());
            preparedStatement.execute();
            connection.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void upDate(Clients clients) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENT_NAME)) {
            preparedStatement.setString(1, clients.getEmail());
            preparedStatement.setInt(2, clients.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


