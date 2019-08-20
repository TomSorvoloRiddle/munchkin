import javax.swing.JFrame;
import javax.swing.JPanel;

public class WelcomeWindow extends JFrame {
	// Atributos de la clase
	private JPanel panel;
	
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
	}
}
