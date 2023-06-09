package Interfaces;

import javax.swing.*;
import java.awt.*;

public class PantallaAñadir extends JFrame {
    private JPanel MainPanelAñadir;
    private JTextField NameText;
    private JTextField imgtext;
    private JTextField DescriptionText;
    private JLabel NameLabel;
    private JLabel ImgLabel;
    private JLabel DescriptionLabel;

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
    }
}
