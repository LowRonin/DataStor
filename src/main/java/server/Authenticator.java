package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
?????? ????????????->?????? ???????->????? ?????????????? ??? ?????? ????????
 ? ???? ???????????? ? ????->??????????? ????? ?????? ?????? ?? ???? ?????? ???? ?????
 ? ????? ?????? ???? ???????????
 */

public class Authenticator {

    private static String clLogin;
    private static String clPass;




    public static boolean auth(String login, String pass) {
         clLogin = login;
         clPass = pass;

        try {
            Connection connection = DBaseHandler.getConnection();
            String dbLogin = DBaseHandler.getLogin(connection,clLogin);
            System.out.println(clLogin);
            System.out.println(dbLogin);
            if (clLogin == dbLogin) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
