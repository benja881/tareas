import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class prueba extends JFrame {
	private JTextField inputField;
	private JButton btnAnalizarTexto, btnOperarNumero, btnJuego;
	private JLabel lblResultado, lblError;
	private int numeroSecreto;

	public prueba() {
		setTitle("Analizador de Dato");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 250);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());

		inputField = new JTextField(15);
		btnAnalizarTexto = new JButton("Analizar Texto");
		btnOperarNumero = new JButton("Operar Número");
		btnJuego = new JButton("Juego");
		lblResultado = new JLabel("Resultado: ");
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,5,5,5);
		gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 3;
		add(inputField, gbc);

		gbc.gridwidth = 1;
		gbc.gridy = 1; gbc.gridx = 0;
		add(btnAnalizarTexto, gbc);
		gbc.gridx = 1;
		add(btnOperarNumero, gbc);
		gbc.gridx = 2;
		add(btnJuego, gbc);

		gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 3;
		add(lblResultado, gbc);
		gbc.gridy = 3;
		add(lblError, gbc);

		// Inicializar número secreto para el juego
		generarNumeroSecreto();

		btnAnalizarTexto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				analizarTexto();
			}
		});

		btnOperarNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operarNumero();
			}
		});

		btnJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jugar();
			}
		});
	}

	private void analizarTexto() {
		String texto = inputField.getText();
		lblError.setText("");
		if (texto.isEmpty()) {
			lblError.setText("Ingrese un texto.");
			lblResultado.setText("Resultado: ");
			return;
		}
		int longitud = texto.length();
		String mayusculas = texto.toUpperCase();
		lblResultado.setText("Longitud: " + longitud + ", Mayúsculas: " + mayusculas);
	}

	private void operarNumero() {
		String texto = inputField.getText();
		lblError.setText("");
		try {
			double numero = Double.parseDouble(texto);
			double raiz = Math.sqrt(numero);
			double potencia = Math.pow(numero, 2);
			lblResultado.setText(String.format("Raíz: %.2f, Potencia: %.2f", raiz, potencia));
		} catch (NumberFormatException ex) {
			lblError.setText("Ingrese un número válido.");
			lblResultado.setText("Resultado: ");
		}
	}

	private void jugar() {
		String texto = inputField.getText();
		lblError.setText("");
		try {
			int intento = Integer.parseInt(texto);
			if (intento < 1 || intento > 10) {
				lblError.setText("Ingrese un número del 1 al 10.");
				return;
			}
			if (intento == numeroSecreto) {
				lblResultado.setText("¡Correcto! El número era " + numeroSecreto + ". Se generó uno nuevo.");
				generarNumeroSecreto();
			} else {
				lblResultado.setText("Incorrecto. Intenta de nuevo.");
			}
		} catch (NumberFormatException ex) {
			lblError.setText("Ingrese un número entero válido.");
			lblResultado.setText("Resultado: ");
		}
	}

	private void generarNumeroSecreto() {
		numeroSecreto = (int)(Math.random() * 10) + 1;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new prueba().setVisible(true);
		});
	}
}
