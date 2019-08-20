import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class WelcomeWindow extends JFrame {
	// Atributos de la clase
	private JPanel panel;
	private JTextField tFNombreP;
	
	// Constructor vacío de la clase
	public WelcomeWindow() {
		// ** Nuestra ventana:
		this.setTitle("Aventura Munchkin");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Cuando cerramos con la X, el programa sigue en ejecución, con esta línea lo paramos
		this.setSize(520,400); //Tamaño de la ventana
		this.setLocationRelativeTo(null); // Esto hace que se centre la ventana
		panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		JLabel lblLogo = new JLabel("LOGO");
		lblLogo.setBounds(234, 68, 46, 14);
		panel.add(lblLogo);
		
		JLabel lblEmpezarPartida = new JLabel("\u00BFQuieres empezar una nueva aventura?");
		lblEmpezarPartida.setBounds(150, 131, 220, 14);
		panel.add(lblEmpezarPartida);
		
		JLabel lblNombrePersonaje = new JLabel("\u00BFC\u00F3mo quieres que se llame el personaje?");
		lblNombrePersonaje.setBounds(150, 156, 199, 14);
		panel.add(lblNombrePersonaje);
		
		tFNombreP = new JTextField();
		tFNombreP.setBounds(169, 193, 170, 20);
		panel.add(tFNombreP);
		tFNombreP.setColumns(10);
		
		JButton btnEmpezar = new JButton("\u00A1Empezar!");
		btnEmpezar.setBounds(210, 241, 89, 23);
		btnEmpezar.setEnabled(false);
		panel.add(btnEmpezar);
	}
}
