package Interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaVisual extends JFrame{
    private JPanel MainPanelVisual;
    private JTextField NameText;
    private JTextField DescriptionText;
    private JTextField ReleaseText;
    private JLabel NameLabel;
    private JLabel DescriptionLabel;
    private JLabel ReleaseLabel;
    private JLabel imgLabel;
    private JButton nextButton;
    private JButton lastButton;

    public PantallaVisual(){
        setContentPane(MainPanelVisual);
        //TITULO DE LA PANTALLA
        setTitle("Menú Visual");
        //LOCALIZACION DE LA INTERFAZ EN LA PANTALLA
        setLocationByPlatform(true);
        //TAMAÑO DE LA INTERFAZ EN PANTALLA
        setSize(1200,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        //NEXT BUTTON
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //LAST BUTTON
        lastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
