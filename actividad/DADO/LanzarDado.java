package DADO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LanzarDado extends JFrame {

    private JButton boton;
    private JLabel etiqueta;

    public LanzarDado() {
        setTitle("Lanzar Dado");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        boton = new JButton("Lanzar Dado");
        boton.setBounds(60, 50, 210, 50);

        etiqueta = new JLabel("----", SwingConstants.CENTER);
        etiqueta.setFont(new Font("ARIAL", Font.BOLD, 70));
        etiqueta.setBounds(50, 150, 230, 100);

       
        add(boton);
        add(etiqueta);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = (int)(Math.random() * 6) + 1;
                etiqueta.setText(String.valueOf(numero));
            }
        });
        
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LanzarDado();
            }
        });
    }
}