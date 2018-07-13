package com.dod.nightwingky.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static String URL = "jdbc:mysql://127.0.0.1/dod_book_system?characterEncoding=UTF8";
    private static String USER = "root";
    private static String PASSWORD = "";

//    private static String sqlConnection =

    private static Connection connection = null;

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
