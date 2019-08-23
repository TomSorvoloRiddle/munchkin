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
	private JTextField tFAtaqueRep;
	private JButton btnEmpezar;
	private JButton btnCrearPersonaje;
	
	private boolean ctrlAtqHab = false;
	private boolean ctrlDefHab = false;
	private boolean ctrlVelHab = false;
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
		
		JLabel lblEmpezarPartida = new JLabel("¿Quieres empezar una nueva aventura?");
		lblEmpezarPartida.setBounds(143, 131, 241, 14);
		panelStart.add(lblEmpezarPartida);
		
		JLabel lblNombrePersonaje = new JLabel("¿Cómo quieres que se llame el personaje?");
		lblNombrePersonaje.setBounds(132, 156, 241, 14);
		panelStart.add(lblNombrePersonaje);
		
		btnEmpezar = new JButton("¡Empezar!");
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
		
		btnCrearPersonaje = new JButton("Empezar aventura");
		btnCrearPersonaje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent aE) {
				initPanelPartida1();
			}
		});
		btnCrearPersonaje.setBounds(200, 47, 140, 70);
		btnCrearPersonaje.setEnabled(false);
		panelRepartir.add(btnCrearPersonaje);
		
		JLabel lblReparticionHab = new JLabel("Repartición de habilidad (Puntos totales: "+puntos+")");
		lblReparticionHab.setBounds(20, 20, 250, 15);
		panelRepartir.add(lblReparticionHab);
		
		JLabel lblAtaqueRep = new JLabel("ATAQUE:");
		lblAtaqueRep.setBounds(25, 50, 70, 15);
		panelRepartir.add(lblAtaqueRep);
		
		tFAtaqueRep = new JTextField();
		tFAtaqueRep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent kE) {
				comprobarDatosIniciales("Ataque");
				comprobacionFinal();
			}
		});
		tFAtaqueRep.setBounds(110, 47, 70, 20);
		panelRepartir.add(tFAtaqueRep);
		
		JLabel lblDefensaRep = new JLabel("DEFENSA:");
		lblDefensaRep.setBounds(25, 75, 70, 15);
		panelRepartir.add(lblDefensaRep);
		
		JTextField tFDefensaRep = new JTextField();
		tFDefensaRep.setBounds(110, 72, 70, 20);
		panelRepartir.add(tFDefensaRep);
		
		JLabel lblVelocidadRep = new JLabel("VELOCIDAD:");
		lblVelocidadRep.setBounds(25, 100, 70, 15);
		panelRepartir.add(lblVelocidadRep);
		
		JTextField tFVelocidadRep = new JTextField();
		tFVelocidadRep.setBounds(110, 97, 70, 20);
		panelRepartir.add(tFVelocidadRep);
		
		changePanel(panelStart, panelRepartir);
	}
	
	/*
	 * initPanelPartida1();
	 * 
	 */
	private void initPanelPartida1(){
		System.out.println("Se ha pulsado el botón Empezar aventura");
	}
	
	/*
	 * comprobarDatosIniciales();
	 * 
	 * @param
	 * @return boolean
	 */
	private void comprobarDatosIniciales(String habilidad) {
		switch(habilidad) {
		case "Ataque":
			String isNum = tFAtaqueRep.getText();
			int num;
			try {
				num = Integer.parseInt(isNum);
			} catch(NumberFormatException nFE) {
				btnCrearPersonaje.setEnabled(false);
				if(!tFAtaqueRep.getText().isEmpty()) {
					System.err.println("No has introducido un número válido");
				}
			}
			//ctrlAtqHab = true;
			break;
		case "Defensa":
			break;
		case "Velocidad":
			break;
		default:
			System.err.println("No se ha pasado una opción válida de habilidad");
			break;
		}
	}
	/*
	 * comprobacionFinal();
	 * Método al que le pasaremos las variables de control de los diferentes JTextField y cambiará el botón en activo si todo está correcto
	 * @param
	 * @return
	 */
	private void comprobacionFinal() {
		if(ctrlAtqHab) {
			btnCrearPersonaje.setEnabled(true);
		}
	}
	/*
	 * changePanel()
	 * Método que cambiará el panel visible.
	 * Se le pasará el panel que tiene que dejar de verse y el panel que se tiene que ver
	 * @param JFrame activo, JPanel que queremos retirar, JPanel que queramos activar
	 * @return void
	 */
	private void changePanel(JPanel pnlDesactivar, JPanel pnlActivar) {
		pnlDesactivar.setVisible(false);
		this.getContentPane().add(pnlActivar);
		pnlActivar.setVisible(true);
	}
}
