package Interfaces;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.*;

public class PantallaPrincipal extends JFrame{
    private JPanel MainPanel;
    private JLabel LabelPrincipal;
    private JButton ViewButton;
    private JButton AddButton;
    private JButton DeleteButton;

    public PantallaPrincipal(){
        setContentPane(MainPanel);
        //TITULO DE LA PANTALLA
        setTitle("Menú Principal");
        //LOCALIZACION DE LA INTERFAZ EN LA PANTALLA
        setLocationByPlatform(true);
        //TAMAÑO DE LA INTERFAZ EN PANTALLA
        setSize(450,300);
        //COLOR DE FONDO
        MainPanel.setBackground(Color.getHSBColor(154, 197, 244));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //BOTON DE VIEW ALL
        ViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setResizable(false);
                setVisible(false);
                SwingUtilities.invokeLater(()-> new PantallaVisual().setVisible(true));
            }
        });


        //BOTON DE ADD
        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SwingUtilities.invokeLater(()-> new PantallaAñadir().setVisible(true));
            }
        });


        //BOTON DE DELETE
        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SwingUtilities.invokeLater(()->new PantallaEliminar().setVisible(true));
            }
        });

    }

}
