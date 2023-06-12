package Interfaces;

import Conexiones.Conexion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PantallaEliminar extends JFrame{
    private final int minMov = 1;
    private static int peliculas = 8;

    public static int getPeliculas() {
        return peliculas;
    }

    public static void setPeliculas(int peliculas) {
        PantallaEliminar.peliculas = peliculas;
    }

    private JPanel MainPanelEliminar;
    private JLabel DeleteLabel;
    private JTextField IdText;
    private JLabel IdLabel;
    private JButton BTok;
    private JButton BTback;


    public PantallaEliminar(){

        setContentPane(MainPanelEliminar);
        setResizable(false);
        //TITULO DE LA PANTALLA
        setTitle("Menú Eliminar");
        //LOCALIZACION DE LA INTERFAZ EN LA PANTALLA
        setLocationByPlatform(true);
        //TAMAÑO DE LA INTERFAZ EN PANTALLA
        setSize(450,300);
        //COLOR DE FONDO
        MainPanelEliminar.setBackground(Color.getHSBColor(154, 197, 244));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        BTback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SwingUtilities.invokeLater(()-> new PantallaPrincipal().setVisible(true));
            }
        });

        BTok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conexion.bdConnection();
                PreparedStatement preparedStatement = null;
                try {
                    if (peliculas == minMov) {
                        JOptionPane.showInternalMessageDialog(null,
                                "Mínimo alcanzado (1). La base de datos debe de tener al menos una película registrada.");
                    } else {
                        int textoID = Integer.parseInt(IdText.getText());
                        String consulta = "DELETE FROM `peliculas` where `id` = ?";
                        preparedStatement = Conexion.getConnection().prepareStatement(consulta);
                        preparedStatement.setInt(1, textoID);
                        preparedStatement.execute("USE proyecto_cine");
                        preparedStatement.executeUpdate();
                        peliculas--;
                    }
                }
                catch (Exception exception) {
                    System.out.println("Error: No se pudo eliminar la película. " + exception.getMessage());
                }

                setVisible(false);
                SwingUtilities.invokeLater(()-> new PantallaPrincipal().setVisible(true));
            }
        });
    }

}

