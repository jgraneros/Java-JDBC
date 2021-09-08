package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        String cadenaConexion = "jdbc:mysql://localhost:3306/curso";
        try(
                Connection connection = DriverManager.getConnection(cadenaConexion, "root", "");
                CallableStatement sentence = connection.prepareCall("{CALL seleccionarPersonas()}");
                ResultSet rs = sentence.executeQuery();
                ){
            while (rs.next()){
                System.out.println(rs.getString("nombre"));
                System.out.println(rs.getString("apellidos"));
                System.out.println(rs.getString("edad"));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
