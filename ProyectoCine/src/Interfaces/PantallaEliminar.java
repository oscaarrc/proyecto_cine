package Interfaces;

import javax.swing.*;

public class PantallaEliminar extends JFrame{
    private JPanel MainPanelEliminar;
    private JLabel DeleteLabel;
    private JTextField IdText;
    private JLabel IdLabel;
    private JButton DeleteButton;



    public PantallaEliminar(){
        setContentPane(MainPanelEliminar);
        //TITULO DE LA PANTALLA
        setTitle("Menú Eliminar");
        //LOCALIZACION DE LA INTERFAZ EN LA PANTALLA
        setLocationByPlatform(true);
        //TAMAÑO DE LA INTERFAZ EN PANTALLA
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}

