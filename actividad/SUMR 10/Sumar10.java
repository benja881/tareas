import javax.swing.*;
import java.awt.*;

public class Sumar10 extends JFrame {
    public Sumar10() {
        setTitle("El Sumar +10");
        setSize(330, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    
     JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JTextField txtNumero = new JTextField();
        JButton btnSumar = new JButton("Sumarle 10");
        JLabel lblResultado = new JLabel("Resultado", SwingConstants.CENTER);

  btnSumar.addActionListener(e -> {
            try {
                int num = Integer.parseInt(txtNumero.getText());
                lblResultado.setText("Resultado: " + (num + 10));
            } catch (NumberFormatException ex) {
                lblResultado.setText("Ingrese un número válido");
            }
        });
        
        panel.add(txtNumero);
        panel.add(btnSumar);
        panel.add(lblResultado);
        add(panel);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Sumar10().setVisible(true));
    }
}