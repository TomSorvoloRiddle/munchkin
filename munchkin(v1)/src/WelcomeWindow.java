import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeWindow extends JFrame {
	// Atributos de la clase
	// Paneles con los que se trabaja
	private JPanel panelStart;
	private JPanel panelRepartir;
	
	// Objetos de datos
	private JTextField tFNombreP;
	private JTextField tFAtaqueRep;
	private JTextField tFDefensaRep;
	private JTextField tFVelocidadRep;
	private JLabel lblReparticionHab;
	
	// Control de botones
	private JButton btnEmpezar;
	private JButton btnCrearPersonaje;
	
	// Player
	private Player jugador;
	private int atqDefinitivo;
	private int defDefinitiva;
	private int velDefinitiva;
	
	// Variables de control
	private boolean ctrlAtqHab = false;
	private boolean ctrlDefHab = false;
	private boolean ctrlVelHab = false;
	private final int TotalPuntos = 10;
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
		lblNombrePersonaje.setBounds(132, 156, 250, 14);
		panelStart.add(lblNombrePersonaje);
		
		btnEmpezar = new JButton("¡Empezar!");
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jugador = new Player(tFNombreP.getText());
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
				if(!tFNombreP.getText().isEmpty()) {
					btnEmpezar.setEnabled(true);
				} else {
					btnEmpezar.setEnabled(false);
				}
			}
		});
		tFNombreP.setBounds(150, 193, 199, 20);
		panelStart.add(tFNombreP);
		tFNombreP.setColumns(20);
		
	}
	
	/*
	 * initRepartirPanel();
	 * Método que iniciará el panel panelRepartir para solicitar los datos ataque, defensa y velocidad
	 * @param void
	 * @return void
	 */
	private void initRepartirPanel() {
		panelRepartir = new JPanel();
		panelRepartir.setLayout(null);
		this.setTitle("Aventura Munchkin: "+ jugador.getName());
		
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
		
		lblReparticionHab = new JLabel("Repartición de habilidad (Puntos totales: "+puntos+")");
		lblReparticionHab.setBounds(20, 20, 260, 15);
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
		
		tFDefensaRep = new JTextField();
		tFDefensaRep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent kE) {
				comprobarDatosIniciales("Defensa");
				comprobacionFinal();
			}
		});
		tFDefensaRep.setBounds(110, 72, 70, 20);
		panelRepartir.add(tFDefensaRep);
		
		JLabel lblVelocidadRep = new JLabel("VELOCIDAD:");
		lblVelocidadRep.setBounds(25, 100, 80, 15);
		panelRepartir.add(lblVelocidadRep);
		
		tFVelocidadRep = new JTextField();
		tFVelocidadRep.addKeyListener(new KeyAdapter() {		
			@Override
			public void keyReleased(KeyEvent kE) {
				comprobarDatosIniciales("Velocidad");
				comprobacionFinal();
			}
		});
		tFVelocidadRep.setBounds(110, 97, 70, 20);
		panelRepartir.add(tFVelocidadRep);
		
		changePanel(panelStart, panelRepartir);
	}
	
	/*
	 * initPanelPartida1();
	 * Método que iniciará el panel para empezar una partida
	 * @param void
	 * @return void
	 */
	private void initPanelPartida1(){
		System.out.println("Se ha pulsado el botón Empezar aventura");
		jugador.setAtaque(atqDefinitivo);
		jugador.setDefensa(defDefinitiva);
		jugador.setVelocidad(velDefinitiva);
		jugador.describe();
	}
	
	/*
	 * comprobarDatosIniciales();
	 * Método al que le pasaremos qué tipo de habilidad comprobar y verá que todo sea correcto
	 * @param
	 * @return boolean
	 */
	private void comprobarDatosIniciales(String habilidad) {
		switch(habilidad) {
		case "Ataque":
			ctrlAtqHab = false;
			String isNumAtq = tFAtaqueRep.getText();
			int num;
			puntos = TotalPuntos; // Como la comprobación se tiene que hacer siempre, reseteamos la variable para que tenga 10 puntos, que se restarán si en los otros TextFields hay datos
			// Calculamos cuantos puntos ha colocado el usuario en todos los TextFields
			if(!tFDefensaRep.getText().isEmpty()) {
				puntos = puntos - Integer.parseInt(tFDefensaRep.getText());
				ctrlDefHab = true;
			}
			if(!tFVelocidadRep.getText().isEmpty()) {
				if(puntos >= Integer.parseInt(tFVelocidadRep.getText())) {
					puntos = puntos - Integer.parseInt(tFVelocidadRep.getText());
				} else {
					puntos =  Integer.parseInt(tFVelocidadRep.getText()) - puntos;
				}
				ctrlVelHab = true;
			}
			boolean atqOk = true;
			// Aquí comprobamos que lo que el usuario introduce sea un número y no una letra
			try {
				num = Integer.parseInt(isNumAtq);
				//Controlamos que el número no sea mayor a 10
				if(num > puntos) {
					ctrlAtqHab = false;
					atqOk = false;
				} else {
					puntos = puntos-num;
				}
			} catch(NumberFormatException nFEAtq) {
				btnCrearPersonaje.setEnabled(false);
				ctrlAtqHab = false;
				atqOk = false;
				if(!tFAtaqueRep.getText().isEmpty()) {
					tFAtaqueRep.setText("");
					System.err.println("No has introducido un número válido en Ataque");
				}
			}
			if(atqOk) {
				ctrlAtqHab = true;
			}
			lblReparticionHab.setText("Repartición de habilidad (Puntos totales: "+puntos+")");
			break;
		case "Defensa":
			ctrlDefHab = false;
			String isNumDef = tFDefensaRep.getText();
			int x;
			puntos = TotalPuntos;
			// Calculamos cuantos puntos ha colocado el usuario en todos los TextFields
			if(!tFAtaqueRep.getText().isEmpty()) {
				puntos = puntos - Integer.parseInt(tFAtaqueRep.getText());
				ctrlAtqHab = true;
			}
			if(!tFVelocidadRep.getText().isEmpty()) {
				if(puntos >= Integer.parseInt(tFVelocidadRep.getText())) {
					puntos = puntos - Integer.parseInt(tFVelocidadRep.getText());
				} else {
					puntos =  Integer.parseInt(tFVelocidadRep.getText()) - puntos;
				}
				ctrlVelHab = true;
			}
			boolean defOk = true;
			try {
				x = Integer.parseInt(isNumDef);
				//Controlamos que el número no sea mayor a 10
				if(x > puntos) {
					ctrlDefHab = false;
					defOk = false;
				} else {
					puntos = puntos - x;
				}
			} catch(NumberFormatException nFEDef) {
				btnCrearPersonaje.setEnabled(false);
				ctrlDefHab = false;
				defOk = false;
				if(!tFDefensaRep.getText().isEmpty()) {
					tFDefensaRep.setText("");
					System.err.println("No has introducido un número válido en Defensa");
				}
			}
			if(defOk) {
				ctrlDefHab = true;
			}
			lblReparticionHab.setText("Repartición de habilidad (Puntos totales: "+puntos+")");
			break;
		case "Velocidad":
			ctrlVelHab = false;
			String isNumVel = tFVelocidadRep.getText();
			int i;
			puntos = TotalPuntos;
			// Calculamos cuantos puntos ha colocado el usuario en todos los TextFields anteriores
			if(!tFAtaqueRep.getText().isEmpty()) {
				puntos = puntos - Integer.parseInt(tFAtaqueRep.getText());
				ctrlAtqHab = true;
			}
			if(!tFDefensaRep.getText().isEmpty()) {
				if(puntos >= Integer.parseInt(tFDefensaRep.getText())) {
					puntos = puntos - Integer.parseInt(tFDefensaRep.getText());
				} else {
					puntos = Integer.parseInt(tFDefensaRep.getText()) - puntos;
				}
				ctrlDefHab = true;
			}
			boolean velOk = true;
			try {
				i = Integer.parseInt(isNumVel);
				// Controlamos que el número no sea mayor a 10
				if(i > puntos) {
					ctrlVelHab = false;
					velOk = false;
				} else {
					puntos = puntos - i;
				}
			} catch(NumberFormatException nFEVel) {
				btnCrearPersonaje.setEnabled(false);
				ctrlVelHab = false;
				velOk = false;
				if(!tFVelocidadRep.getText().isEmpty()) {
					tFVelocidadRep.setText("");
					System.err.println("No has introducido un número válido en Velocidad");
				}
			}
			if(velOk) {
				ctrlVelHab = true;
			}
			lblReparticionHab.setText("Repartición de habilidad (Puntos totales: "+puntos+")");
			break;
		default:
			System.err.println("No se ha pasado una opción válida de habilidad");
			break;
		}
	}
	/*
	 * comprobacionFinal();
	 * Método al que le pasaremos las variables de control y cambiará el botón en activo si todo está correcto
	 * @param
	 * @return
	 */
	private void comprobacionFinal() {
		if(ctrlAtqHab && ctrlDefHab && ctrlVelHab) {
			atqDefinitivo = Integer.parseInt(tFAtaqueRep.getText());
			defDefinitiva = Integer.parseInt(tFDefensaRep.getText());
			velDefinitiva = Integer.parseInt(tFVelocidadRep.getText());
			btnCrearPersonaje.setEnabled(true);
		} else {
			btnCrearPersonaje.setEnabled(false);
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
