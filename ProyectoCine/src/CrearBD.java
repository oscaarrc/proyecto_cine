import java.sql.*;
import javax.swing.JOptionPane;

public class CrearBD{

    private static Statement statement;
    private static Connection conexion;
    public static boolean CrearBD() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            CrearBD.conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/", "root", "");
            CrearBD.statement = conexion.createStatement();
            JOptionPane.showInternalMessageDialog(null, "Conexión realizada con éxito");
            return true;
        }
        catch(Exception e){
        JOptionPane.showInternalMessageDialog(null, "Se ha producido un error: " + e.getMessage());
        return false;
        }
    }
 
   
    public static void createDatabase(){
        try{
            CrearBD.statement = CrearBD.conexion.createStatement();
            CrearBD.statement.executeUpdate("DROP DATABASE IF EXISTS proyecto_cine;");
            CrearBD.statement.executeUpdate("CREATE DATABASE proyecto_cine;");
            CrearBD.statement.execute("USE proyecto_cine;");
        }
        catch(Exception e){
            System.out.println("Ocurrió un error al crear la base de datos: " + e.getMessage());
        }
    }
   
    
    public static boolean insertData() {
        String queryTable = "CREATE TABLE peliculas(ID int(100) PRIMARY KEY AUTO_INCREMENT," +
                            "titulo varchar(255) NOT NULL," +
                            "genero varchar(100) DEFAULT NULL,"+
                            "duracion int(11) DEFAULT NULL,"+
                            "clasificacion varchar(50) DEFAULT NULL);";
        
        String queryInsert = "INSERT INTO peliculas (ID, titulo, genero, duracion, clasificacion) VALUES" +
                            "(1, 'Como Dios manda', 'Comedia', 99, 'PG-7')," +
                            "(2, 'Los osos no existen', 'Drama', 107, 'PG-12')," +
                            "(3, 'Spider-Man: Cruzando el Multiverso', 'Animación', 141, 'Todos los públicos')," +
                            "(4, 'The Boogeyman: El hombre del saco', 'Terror', 98, 'PG-16')," +
                            "(5, 'Toro salvaje', 'Drama', 124, 'PG-12')," +
                            "(6, 'La sirenita', 'Fantasía', 134, 'Todos los públicos')," +
                            "(7, 'Fast & Furious X', 'Acción', 140, 'PG-12')," +
                            "(8, 'Las ocho montañas', 'Drama', 147, 'PG-12')," +
                            "(9, 'Guardianes de la galaxia: Volumen 3', 'Fantasía', 150, 'PG-12')," +
                            "(10, 'Beau tiene miedo', 'Drama', 178, 'PG-16')," +
                            "(11, 'Super Mario Bros: La película', 'Animación', 93, 'Todos los públicos');" ;
        try{
            
            CrearBD.statement.executeUpdate(queryTable);
            CrearBD.statement.executeUpdate(queryInsert);
            CrearBD.statement.close();
            CrearBD.conexion.close();
            return true;
        }
        catch(SQLException e){
        JOptionPane.showInternalMessageDialog(null, "Ocurrió un error en la inserción de datos: " + e.getMessage());
        return false;
        }    
    }
   
    
    
}
