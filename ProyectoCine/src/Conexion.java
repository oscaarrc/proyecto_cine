import javax.swing.*;
import java.sql.*;

public class Conexion {
    static Connection connection = null;
    String bd = "proyecto_cine";
    String ip = "localhost";
    String puerto = "3306";
    String chain = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;
    
    PreparedStatement statement = null;
    ResultSet resultado = null;
    String driver = "com.mysql.cj.jdbc.Driver";

   
    
    
    
    
    
    
    public Connection myConnection(){
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(chain, "root", "");
            statement= connection.prepareStatement("SELECT * FROM peliculas");
            resultado= statement.executeQuery();

            System.out.println("\t\t\tPELÍCULAS:\n------------------------------------------");
            while (resultado.next()){
                int id = resultado.getInt(1);
                String titulo = resultado.getString(2);
                String genero = resultado.getString(3);
                int duracion = resultado.getInt(4);
                String clasificacion = resultado.getString(5);
                System.out.println("ID: " + id + "\n" +
                        "TÍTULO: " + titulo +
                        "\nGÉNERO: " + genero +
                        "\nDURACIÓN: " + duracion +
                        "\nCLASIFICACIÓN: " + clasificacion + "\n------------------------------------------");
            }

            JOptionPane.showInternalMessageDialog(null, "Conexión realizada con éxito");
        }
        catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "Ocurrió un error al conectarse a la base de datos: " + e.getMessage());
        }
        return connection;
    }

}
