import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
//            connection.setAutoCommit(false);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed())
                System.out.println("DataBase connect");
            if (connection != null) {
                System.out.println("connection.close");
                connection.close();
                if (connection.isClosed())
                    System.out.println("DataBase connect");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Is not connected bd");
        }
        return connection;
    }
}
