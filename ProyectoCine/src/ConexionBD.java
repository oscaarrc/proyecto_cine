


public class ConexionBD {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        
        if(CrearBD.CrearBD()){
            System.out.println("Todo bien");
            
        }
        else{
        System.out.println("Todo mal");
        }
        CrearBD.createDatabase();
        CrearBD.insertData();
        conexion.myConnection();
    }
}
