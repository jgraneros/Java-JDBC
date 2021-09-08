package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        String connectionString = "jdbc:mysql://localhost:3306/curso";
        try(
                Connection connection = DriverManager.getConnection(connectionString, "root", "<YOUR_PASSWORD>");
                Statement sentence = connection.createStatement();
                ResultSet rs = sentence.executeQuery("select * from persona");
                ) {

                while(rs.next()){
                    System.out.println(rs.getString("nombre"));
                    System.out.println(rs.getString("apellidos"));
                    System.out.println(rs.getString("edad"));
                }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
