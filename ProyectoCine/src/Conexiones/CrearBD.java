package Conexiones;

import java.sql.*;
import javax.swing.JOptionPane;

public class CrearBD{

    public static boolean createDatabase(){
        try{
            Conexion.bdConnection();
            Conexion.setStatement(Conexion.getConnection().createStatement());
            Conexion.getStatement().executeUpdate("DROP DATABASE IF EXISTS proyecto_cine;");
            Conexion.getStatement().executeUpdate("CREATE DATABASE proyecto_cine;");
            Conexion.getStatement().execute("USE proyecto_cine;");
            return true;
        }
        catch(Exception e){
            JOptionPane.showInternalMessageDialog(null,
                    "Ocurrió un error al crear la base de datos: " + e.getMessage());
            return false;
        }
    }


    public static boolean insertData() {

        String queryTable = "CREATE TABLE peliculas(ID int(100) PRIMARY KEY AUTO_INCREMENT," +
                "titulo varchar(255) DEFAULT NULL," +
                "genero varchar(100) DEFAULT NULL,"+
                "duracion int(11) DEFAULT 0,"+
                "clasificacion varchar(50) DEFAULT NULL);";

        String queryInsert = "INSERT INTO peliculas (titulo, genero, duracion, clasificacion) VALUES" +
                "('Como Dios manda', 'Comedia', 99, 'PG-7')," +
                "('Los osos no existen', 'Drama', 107, 'PG-12')," +
                "('Spider-Man: Cruzando el Multiverso', 'Animación', 141, 'Todos los públicos')," +
                "('The Boogeyman: El hombre del saco', 'Terror', 98, 'PG-16')," +
                "('La sirenita', 'Fantasía', 134, 'Todos los públicos')," +
                "('Fast & Furious X', 'Acción', 140, 'PG-12')," +
                "('Super Mario Bros: La película', 'Animación', 93, 'Todos los públicos')," +
                "('Guardianes de la galaxia: Volumen 3', 'Fantasía', 150, 'PG-12');";
        try{
            Conexion.bdConnection();
            Conexion.getStatement().executeUpdate(queryTable);
            Conexion.getStatement().executeUpdate(queryInsert);
            Conexion.getStatement().close();
            Conexion.getConnection().close();
            return true;
        }
        catch(SQLException e){
            JOptionPane.showInternalMessageDialog(null,
                    "Ocurrió un error durante la inserción de datos: " + e.getMessage());
            return false;
        }
    }


}
