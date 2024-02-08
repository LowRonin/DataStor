package server;

import java.sql.*;

public class DBaseHandler {
    private static final String dbhost = "jdbc:postgresql://localhost:5432/Auth";
    private static final String dblogin = "postgres";
    private static final String dbpass = "Ghostrecon777&";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbhost, dblogin, dbpass);
    }

    public static String getLogin(Connection connection, String clLogin) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select login from \"Auth\".public.\"Users\" where login = (?) ");
        statement.setString(1, clLogin);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String result = resultSet.getString("login");
            System.out.println(result);
            return String.valueOf(result);
        }

        return "";
    }
}
