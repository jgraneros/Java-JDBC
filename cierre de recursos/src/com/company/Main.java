package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {

        String cadenaConexion = "jdbc:mysql://localhost:3306/curso";
        try(Connection connection = DriverManager.getConnection(cadenaConexion, "root", "<YOUR_PASSWORD>");
            Statement sentence = connection.createStatement();){

            sentence.executeUpdate("insert into persona (nombre, apellidos, edad) values ('juan', 'jose', 30)");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }



}
