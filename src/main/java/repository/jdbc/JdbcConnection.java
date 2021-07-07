package repository.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    private static final String DATA_BASE_URL = "jdbc:mysql://localhost:3306/MySQL";
    private static final String USER = "Yhtyyar";
    private static final String PASSWORD = "Ilyas-2009";

    private static Connection connection;


    public static Connection getConnection() {

        if (connection == null) {

            try {
                connection = DriverManager.getConnection(DATA_BASE_URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

}
