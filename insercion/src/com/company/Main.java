package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try {
            //Nos registra el driver de mysql
            //podriamos tener mas drivers instalados
            Class.forName("com.mysql.jdbc.Driver");
            String cadenaConexion = "jdbc:mysql://localhost:3306/curso";
            Connection connection = DriverManager.getConnection(cadenaConexion, "root", "<YOUR_PASSWORD>");
            Statement sentence = connection.createStatement();
            sentence.executeUpdate("insert into persona (nombre, apellidos, edad) values ('pepe', 'perez', 20)");
            sentence.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
