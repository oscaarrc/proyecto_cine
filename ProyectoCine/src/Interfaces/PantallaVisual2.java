package Interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaVisual2 extends JFrame {
    private JPanel MainPanelVisual;
    private JLabel NameLabel;
    private JTextField DescriptionText;
    private JLabel ReleaseLabel;
    private JTextField ReleaseText;
    private JTextField NameText;
    private JLabel imgLabel;
    private JLabel DescriptionLabel;
    private JButton lastButton;
    private JButton nextButton;

    public PantallaVisual2(){
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
