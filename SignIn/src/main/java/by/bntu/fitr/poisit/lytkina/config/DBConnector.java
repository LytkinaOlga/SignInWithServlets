package by.bntu.fitr.poisit.lytkina.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    public static final String URL = "jdbc:mysql://localhost:3305/signinwithserlets?serverTimezone=Europe/Minsk";
    public static final String USER = "root";
    public static final String PASS = "1488";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
