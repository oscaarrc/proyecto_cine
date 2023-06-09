package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaVisual2 extends JFrame {
    private JPanel MainPanelVisual2;
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
        setContentPane(MainPanelVisual2);
        //TITULO DE LA PANTALLA
        setTitle("Menú Visual");
        //LOCALIZACION DE LA INTERFAZ EN LA PANTALLA
        setLocationByPlatform(true);
        //TAMAÑO DE LA INTERFAZ EN PANTALLA
        setSize(1200,500);
        //COLOR DE FONDO
        MainPanelVisual2.setBackground(Color.getHSBColor(154, 197, 244));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //NEXT BUTTON
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SwingUtilities.invokeLater(()-> new PantallaVisual2().setVisible(true));
            }
        });

        //LAST BUTTON
        lastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SwingUtilities.invokeLater(()-> new PantallaVisual2().setVisible(true));
            }
        });
    }
}
