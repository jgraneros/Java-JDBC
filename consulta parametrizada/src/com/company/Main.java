package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String cadenaConexion = "jdbc:mysql://localhost:3306/curso";
        try (   Connection connection = DriverManager.getConnection(cadenaConexion, "root", "<YOUR_PASSWORD>");
                PreparedStatement sentence = generarConsultaParametrizada("select * from persona where nombre = ?", "pepe", connection);
                ResultSet rs = sentence.executeQuery();

                ) {

            while(rs.next()){
                System.out.println(rs.getString("nombre"));
                System.out.println(rs.getString("apellidos"));
                System.out.println(rs.getString("edad"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static PreparedStatement generarConsultaParametrizada(String sql, String nombre, Connection connection) throws SQLException {
        PreparedStatement consultaParametrizada = connection.prepareStatement(sql);
        consultaParametrizada.setString(1, nombre);
        return consultaParametrizada;
    }
}
