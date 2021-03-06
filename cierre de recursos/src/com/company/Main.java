package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        Statement sentence = null;
        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String cadenaConexion = "jdbc:mysql://localhost:3306/curso";
            connection = DriverManager.getConnection(cadenaConexion, "root", "<YOUR_PASSWORD>");
            sentence = connection.createStatement();
            sentence.executeUpdate("insert into persona (nombre, apellidos, edad) values ('pepe', 'perez', 20)");
            sentence.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(sentence != null){
                    sentence.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
