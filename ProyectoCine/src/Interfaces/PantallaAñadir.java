package Interfaces;

import Conexiones.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;

public class PantallaAñadir extends JFrame {

    private final int maxMov = 8;
    private JPanel MainPanelAñadir;
    private JTextField NameText;
    private JTextField GenreText;
    private JLabel NameLabel;
    private JLabel DescriptionLabel;
    private JButton BTback;
    private JButton BTok;
    private JTextField DurationText;
    private JTextField RatingText;

    public PantallaAñadir(){
        setContentPane(MainPanelAñadir);
        //TITULO DE LA PANTALLA
        setTitle("Menú Añadir");
        //LOCALIZACION DE LA INTERFAZ EN LA PANTALLA
        setLocationByPlatform(true);
        //TAMAÑO DE LA INTERFAZ EN PANTALLA
        setSize(450,300);
        //COLOR DE FONDO
        MainPanelAñadir.setBackground(Color.getHSBColor(154, 197, 244));
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
                try {
                    if (PantallaEliminar.getPeliculas() == maxMov){
                        JOptionPane.showInternalMessageDialog(null,
                                "Máximo alcanzado (8). Debes eliminar al menos una película para añadir una nueva.");
                    }
                    else {
                        String consulta = "INSERT INTO peliculas (titulo, genero, duracion, clasificacion) values (?, ?, ?, ?);";
                        PreparedStatement preparedStatement = Conexion.getConnection().prepareStatement(consulta);

                        //Asignamos los datos de la bd
                        preparedStatement.setString(1, NameText.getText());
                        preparedStatement.setString(2, GenreText.getText());
                        preparedStatement.setInt(3, Integer.parseInt(DurationText.getText()));
                        preparedStatement.setString(4, RatingText.getText());
                        preparedStatement.execute("USE proyecto_cine");
                        preparedStatement.executeUpdate();
                        PantallaEliminar.setPeliculas(+1);
                    }
                }
                catch (Exception exception) {
                    JOptionPane.showInternalMessageDialog(null,
                            "Error: No se pudo añadir la película. " + exception.getMessage());
                }
                setVisible(false);
                SwingUtilities.invokeLater(() -> new PantallaPrincipal().setVisible(true));
            }
        });
    }
}
