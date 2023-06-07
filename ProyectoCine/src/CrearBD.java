import java.sql.*;
import javax.swing.JOptionPane;

public class CrearBD extends Conexion{

    public CrearBD() {
        connection = null;
        this.bd = "proyecto_cine";
        this.ip = "localhost";
        this.puerto = "3306";
        this.chain = "jdbc:mysql://" + ip + ":" + puerto + "/";
       
        this.resultado = null;
        this.driver = "com.mysql.cj.jdbc.Driver";
    }
 

    @Override
    public Connection myConnection() {
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(chain, "root", "");
            Statement createST = connection.createStatement();
            createST.executeUpdate("DROP DATABASE IF EXISTS proyecto_cine;");
            createST.executeUpdate("CREATE DATABASE proyecto_cine;");
            createST.executeUpdate("USE proyectoCine;");
            createST.close();
            connection.close();
            JOptionPane.showInternalMessageDialog(null, "Conexión realizada con éxito");
            
        }
        catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Ocurrió un error al crear a la base de datos: " + e.getMessage());
        }
        return connection;
    }
    
    public boolean insertData() {
        String queryTable = "CREATE TABLE 'peliculas'('ID' int(100) PRIMARY KEY AUTO_INCREMENT," +
                            "'titulo' varchar(255) NOT NULL," +
                            "'genero' varchar(100) DEFAULT NULL,"+
                            "'duracion' int(11) DEFAULT NULL,"+
                            "'clasificacion' varchar(50) DEFAULT NULL);";
        
        String queryInsert = "INSERT INTO 'peliculas' ('ID', 'titulo', 'genero', 'duracion', 'clasificacion') VALUES" +
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
            PreparedStatement pst = connection.prepareStatement(queryTable);
            resultado = pst.executeQuery();
            pst = connection.prepareStatement(queryInsert);
            resultado = pst.executeQuery();
            return true;
        }
        catch(SQLException e){
        JOptionPane.showInternalMessageDialog(null, "Ocurrió un error en la inserción de datos: " + e.getMessage());
        return false;
        }    
    }
   
    
    
}
