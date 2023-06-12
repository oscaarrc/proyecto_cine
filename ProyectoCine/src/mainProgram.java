import Conexiones.*;
import Interfaces.PantallaPrincipal;

import javax.swing.*;
import java.util.Scanner;
public class mainProgram {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        try {
            //Creación base de datos
            CrearBD.createDatabase();
            CrearBD.insertData();

            //MENÚ
            System.out.println("""
                ¿Que operación desea realizar?
                1.- Realizar programa principal
                2.- Salir
                """);
            System.out.print("Elige una opción: ");
            int option = read.nextInt();

            if (option<1 || option>2){
                throw new Exception("Error: La opción debe estar entre 1 y 2");
            }

            //PROGRAMA PRINCIPAL
            if (option == 1) {
                new PantallaPrincipal();
            }
            else {
                System.out.println("Programa finalizado.");
                //Cierra el programa
                System.exit(0);
            }

        }
        catch (Exception e){
            JOptionPane.showInternalMessageDialog(null, e.getMessage());
            //Cierra el programa
            System.exit(0);
        }

    }
}