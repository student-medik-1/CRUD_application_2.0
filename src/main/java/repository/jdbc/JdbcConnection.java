package repository.jdbc;

import java.sql.*;

public class JdbcConnection {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATA_BASE_URL = "jdbc:mysql://localhost:3306/MySQL?useUnicode=true&serverTimezone=UTC";
    private static final String USER = "Yhtyyar";
    private static final String PASSWORD = "Ilyas-2009";

    private static Connection connection;

    private JdbcConnection() {

    }



    public static synchronized Connection getConnection() {

        if (connection == null) {

            try {
                Class.forName(JDBC_DRIVER);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                 connection = DriverManager.getConnection(DATA_BASE_URL, USER, PASSWORD);

                 connection.createStatement(
                         ResultSet.TYPE_SCROLL_SENSITIVE,
                         ResultSet.CONCUR_UPDATABLE
                 );



            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    public static void closeConnection() {

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
