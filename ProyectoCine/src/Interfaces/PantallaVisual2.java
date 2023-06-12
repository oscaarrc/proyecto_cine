package Interfaces;

import Conexiones.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class PantallaVisual2 extends JFrame {
    private JPanel MainPanelVisual2;
    private JButton lastButton;
    private JPanel MainPanelVisual;
    private JLabel TITULO1;
    private JLabel TITULO2;
    private JLabel TITULO3;
    private JLabel TITULO4;
    private JLabel GeneroText1;
    private JLabel DurationText1;
    private JLabel ClasificacionText1;
    private JLabel GeneroText2;
    private JLabel DurationText2;
    private JLabel ClasificationText2;
    private JLabel GeneroText4;
    private JLabel DurationText4;
    private JLabel ClasificationText4;
    private JLabel GeneroText3;
    private JLabel DurationText3;
    private JLabel ClasificationText3;

    public PantallaVisual2(){
        setContentPane(MainPanelVisual);
        //TITULO DE LA PANTALLA
        setTitle("Menú Visual");
        setResizable(false);
        //LOCALIZACION DE LA INTERFAZ EN LA PANTALLA
        setLocationByPlatform(true);
        //TAMAÑO DE LA INTERFAZ EN PANTALLA
        setSize(1200, 500);
        //COLOR DE FONDO
        MainPanelVisual.setBackground(Color.getHSBColor(154, 197, 244));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        mostrarPeliculas();

        //LAST BUTTON
        lastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SwingUtilities.invokeLater(() -> new PantallaVisual().setVisible(true));
            }
        });
    }

    private void mostrarPeliculas() {
        Conexion.bdConnection();

        try {
            Conexion.setStatement(Conexion.getConnection().createStatement());
            String consulta = "SELECT titulo, genero, duracion, clasificacion FROM peliculas";
            PreparedStatement preparedStatement = Conexion.getConnection().prepareStatement(consulta);
            preparedStatement.execute("USE proyecto_cine");
            Conexion.setResultado(Conexion.getStatement().executeQuery(consulta));

            ArrayList<String> titulos = new ArrayList<>();
            ArrayList<String> generos = new ArrayList<>();
            ArrayList<Integer> duraciones = new ArrayList<>();
            ArrayList<String> clasificaciones = new ArrayList<>();

            while (Conexion.getResultado().next()) {

                titulos.add(Conexion.getResultado().getString(1));
                generos.add(Conexion.getResultado().getString(2));
                duraciones.add(Conexion.getResultado().getInt(3));
                clasificaciones.add(Conexion.getResultado().getString(4));
            }

            //Titulos
            TITULO1.setText(titulos.get(4).toUpperCase());
            TITULO2.setText(titulos.get(5).toUpperCase());
            TITULO3.setText(titulos.get(6).toUpperCase());
            TITULO4.setText(titulos.get(7).toUpperCase());
            //Generos
            GeneroText1.setText(generos.get(4));
            GeneroText2.setText(generos.get(5));
            GeneroText3.setText(generos.get(6));
            GeneroText4.setText(generos.get(7));
            //Duraciones
            DurationText1.setText(String.valueOf(duraciones.get(4)));
            DurationText2.setText(String.valueOf(duraciones.get(5)));
            DurationText3.setText(String.valueOf(duraciones.get(6)));
            DurationText4.setText(String.valueOf(duraciones.get(7)));
            //Clasificaciones
            ClasificacionText1.setText(clasificaciones.get(4));
            ClasificationText2.setText(clasificaciones.get(5));
            ClasificationText3.setText(clasificaciones.get(6));
            ClasificationText4.setText(clasificaciones.get(7));

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

