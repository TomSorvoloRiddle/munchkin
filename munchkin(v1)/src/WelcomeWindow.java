import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeWindow extends JFrame {
	// Atributos de la clase
	private JPanel panelStart;
	private JPanel panelRepartir;
	private JTextField tFNombreP;
	private int puntos = 10;
	
	// Constructor vacío de la clase
	public WelcomeWindow() {
		// ** Nuestra ventana:
		this.setTitle("Aventura Munchkin");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Cuando cerramos con la X, el programa sigue en ejecución, con esta línea lo paramos
		this.setSize(520,400); //Tamaño de la ventana
		this.setLocationRelativeTo(null); // Esto hace que se centre la ventana
		panelStart = new JPanel();
		panelStart.setLayout(null);
		this.getContentPane().add(panelStart);
		
		JLabel lblLogo = new JLabel("LOGO");
		lblLogo.setBounds(234, 68, 46, 14);
		panelStart.add(lblLogo);
		
		JLabel lblEmpezarPartida = new JLabel("\u00BFQuieres empezar una nueva aventura?");
		lblEmpezarPartida.setBounds(143, 131, 241, 14);
		panelStart.add(lblEmpezarPartida);
		
		JLabel lblNombrePersonaje = new JLabel("\u00BFC\u00F3mo quieres que se llame el personaje?");
		lblNombrePersonaje.setBounds(132, 156, 241, 14);
		panelStart.add(lblNombrePersonaje);
		
		JButton btnEmpezar = new JButton("\u00A1Empezar!");
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				initRepartirPanel();
			}
		});
		btnEmpezar.setBounds(200, 241, 110, 23);
		btnEmpezar.setEnabled(false);
		panelStart.add(btnEmpezar);
		
		tFNombreP = new JTextField();
		tFNombreP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(tFNombreP.getText() != "") {
					btnEmpezar.setEnabled(true);
				}
			}
		});
		tFNombreP.setBounds(150, 193, 199, 20);
		panelStart.add(tFNombreP);
		tFNombreP.setColumns(20);
		
	}
	
	/*
	 * initRepartirPanel();
	 * Método que iniciará el panel panelRepartir para solicitar los datos
	 */
	private void initRepartirPanel() {
		panelRepartir = new JPanel();
		panelRepartir.setLayout(null);
		
		JLabel lblReparticionHab = new JLabel("Repartición de habilidad (Puntos totales: "+puntos+")");
		lblReparticionHab.setBounds(20, 20, 250, 15);
		panelRepartir.add(lblReparticionHab);
		
		JLabel lblAtaqueRep = new JLabel("ATAQUE:");
		lblAtaqueRep.setBounds(25, 50, 50, 15);
		panelRepartir.add(lblAtaqueRep);
		
		JLabel lblDefensaRep = new JLabel("ATAQUE:");
		lblAtaqueRep.setBounds(25, 50, 50, 15);
		panelRepartir.add(lblAtaqueRep);
		
		changePanel(this, panelStart, panelRepartir);
	}
	/*
	 * changePanel()
	 * Método que cambiará el panel visible.
	 * Se le pasará el panel que tiene que dejar de verse y el panel que se tiene que ver
	 * @param JFrame activo, JPanel que queremos retirar, JPanel que queramos activar
	 * @return void
	 */
	private void changePanel(JFrame activeWindow, JPanel pnlDesactivar, JPanel pnlActivar) {
		pnlDesactivar.setVisible(false);
		activeWindow.getContentPane().add(pnlActivar);
	}
}
