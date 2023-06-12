package Conexiones;

import javax.swing.*;
import java.sql.*;

public class Conexion {

    private static Statement statement;

    public static Statement getStatement() {
        return statement;
    }

    public static void setStatement(Statement statement) {
        Conexion.statement = statement;
    }

    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    String bd = "proyecto_cine";
     String ip = "localhost";
     String puerto = "3306";
     String chain = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;
     private static ResultSet resultado = null;

    public static ResultSet getResultado() {
        return resultado;
    }

    public static void setResultado(ResultSet resultado) {
        Conexion.resultado = resultado;
    }

    static int numConexiones = 1;


    public static void bdConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/", "root", "");

            if (numConexiones<3) {
                JOptionPane.showInternalMessageDialog(null,
                        "Conexión realizada con éxito (" + numConexiones++ + ")");
            }
        }
        catch(Exception e){
            JOptionPane.showInternalMessageDialog(null, "Se ha producido un error: " + e.getMessage());
        }
    }
}
