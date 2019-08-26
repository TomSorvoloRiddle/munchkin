import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.BorderLayout;

public class WelcomeWindow extends JFrame {
	// Atributos de la clase
	// Paneles con los que se trabaja
	private JPanel panelContenedor;
	private JPanel panelStart;
	private JPanel panelRepartir;
	private JPanel panelPartida1;
	
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
		this.setSize(800,650); //Tamaño de la ventana
		this.setLocationRelativeTo(null); // Esto hace que se centre la ventana
		
		panelContenedor = new JPanel();
		//panelContenedor.setBackground(Color.BLACK);
		this.setContentPane(panelContenedor);
		panelContenedor.setVisible(true);
		
		panelStart = new JPanel();
		panelStart.setLayout(new GridBagLayout());
		
		ImageIcon imgIconoMunchkin = new ImageIcon("Munchkin_texto_personaje.jpg");
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(imgIconoMunchkin.getImage()));
		GridBagConstraints cLblLogo = new GridBagConstraints();
		cLblLogo.insets = new Insets(0, 0, 30, 0);
		cLblLogo.ipady = 50;
		cLblLogo.fill = GridBagConstraints.CENTER;
		cLblLogo.gridx = 0;
		cLblLogo.gridy = 0;
		cLblLogo.gridwidth = (int) 0.5;
		panelStart.add(lblLogo, cLblLogo);
		
		JLabel lblEmpezarPartida = new JLabel("¿Quieres empezar una nueva aventura?");
		GridBagConstraints cLblEmpezarPartida = new GridBagConstraints();
		cLblEmpezarPartida.insets = new Insets(0, 0, 10, 0);
		cLblEmpezarPartida.fill = GridBagConstraints.CENTER;
		cLblEmpezarPartida.gridx = 0;
		cLblEmpezarPartida.gridy = 1;
		cLblEmpezarPartida.gridwidth = (int) 0.5;
		panelStart.add(lblEmpezarPartida, cLblEmpezarPartida);
		
		JLabel lblNombrePersonaje = new JLabel("¿Cómo quieres que se llame tu personaje?");
		GridBagConstraints cLblNombrePersonaje = new GridBagConstraints();
		cLblNombrePersonaje.insets = new Insets(0, 0, 10, 0);
		cLblNombrePersonaje.fill = GridBagConstraints.CENTER;
		cLblNombrePersonaje.gridx = 0;
		cLblNombrePersonaje.gridy = 2;
		cLblNombrePersonaje.gridwidth = (int) 0.5;
		panelStart.add(lblNombrePersonaje, cLblNombrePersonaje);
		
		btnEmpezar = new JButton("¡Empezar!");
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jugador = new Player(tFNombreP.getText());
				try {
					initRepartirPanel();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints cBtnEmpezar = new GridBagConstraints();
		cBtnEmpezar.fill = GridBagConstraints.CENTER;
		cBtnEmpezar.gridx = 0;
		cBtnEmpezar.gridy = 4;
		cBtnEmpezar.gridwidth = (int) 0.5;
		btnEmpezar.setEnabled(false);
		panelStart.add(btnEmpezar, cBtnEmpezar);
		
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
		panelContenedor.setLayout(new BorderLayout(0, 0));
		GridBagConstraints cTFNombreP = new GridBagConstraints();
		cTFNombreP.insets = new Insets(0, 0, 10, 0);
		cTFNombreP.fill = GridBagConstraints.CENTER;
		cTFNombreP.gridx = 0;
		cTFNombreP.gridy = 3;
		cTFNombreP.gridwidth = (int) 0.5;
		panelStart.add(tFNombreP, cTFNombreP);
		tFNombreP.setColumns(20);

		panelContenedor.add(panelStart);
		panelStart.setVisible(true);
		
	}
	
	/*
	 * initRepartirPanel();
	 * Método que iniciará el panel panelRepartir para solicitar los datos ataque, defensa y velocidad
	 * @param void
	 * @return void
	 */
	private void initRepartirPanel() throws InterruptedException{
		panelRepartir = new JPanel();
		panelRepartir.setLayout(new GridBagLayout());
		this.setTitle("Aventura Munchkin: "+ jugador.getName());
		
		btnCrearPersonaje = new JButton("Empezar aventura");
		btnCrearPersonaje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent aE) {
				try {
					initPanelPartida1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints cBtnCrearPersonaje = new GridBagConstraints();
		cBtnCrearPersonaje.fill = GridBagConstraints.CENTER;
		cBtnCrearPersonaje.gridx = 0;
		cBtnCrearPersonaje.gridy = 6;
		btnCrearPersonaje.setEnabled(false);
		panelRepartir.add(btnCrearPersonaje, cBtnCrearPersonaje);
		
		lblReparticionHab = new JLabel("Repartición de habilidad (Puntos totales: "+puntos+")");
		GridBagConstraints cLblReparticionHab = new GridBagConstraints();
		cLblReparticionHab.fill = GridBagConstraints.CENTER;
		cLblReparticionHab.gridx = 0;
		cLblReparticionHab.gridy = 1;
		panelRepartir.add(lblReparticionHab, cLblReparticionHab);
		
		JLabel lblAtaqueRep = new JLabel("ATAQUE:");
		GridBagConstraints cLblAtaqueRep = new GridBagConstraints();
		cLblAtaqueRep.fill = GridBagConstraints.CENTER;
		cLblAtaqueRep.gridx = 0;
		cLblAtaqueRep.gridy = 2;
		panelRepartir.add(lblAtaqueRep, cLblAtaqueRep);
		
		tFAtaqueRep = new JTextField();
		tFAtaqueRep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent kE) {
				comprobarDatosIniciales("Ataque");
				comprobacionFinal();
			}
		});
		GridBagConstraints cTFAtaqueRep = new GridBagConstraints();
		cTFAtaqueRep.fill = GridBagConstraints.HORIZONTAL;
		cTFAtaqueRep.gridx = 2;
		cTFAtaqueRep.gridy = 2;
		
		panelRepartir.add(tFAtaqueRep, cTFAtaqueRep);
		
		JLabel lblDefensaRep = new JLabel("DEFENSA:");
		GridBagConstraints cLblDefensaRep = new GridBagConstraints();
		cLblDefensaRep.fill = GridBagConstraints.WEST;
		cLblDefensaRep.gridx = 0;
		cLblDefensaRep.gridy = 3;
		panelRepartir.add(lblDefensaRep, cLblDefensaRep);
		
		tFDefensaRep = new JTextField();
		tFDefensaRep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent kE) {
				comprobarDatosIniciales("Defensa");
				comprobacionFinal();
			}
		});
		GridBagConstraints cTFDefensaRep = new GridBagConstraints();
		cTFDefensaRep.fill = GridBagConstraints.HORIZONTAL;
		cTFDefensaRep.gridx = 2;
		cTFDefensaRep.gridy = 3;
		panelRepartir.add(tFDefensaRep, cTFDefensaRep);
		
		JLabel lblVelocidadRep = new JLabel("VELOCIDAD:");
		GridBagConstraints cLblVelocidadRep = new GridBagConstraints();
		cLblVelocidadRep.fill = GridBagConstraints.WEST;
		cLblVelocidadRep.gridx = 0;
		cLblVelocidadRep.gridy = 4;
		panelRepartir.add(lblVelocidadRep, cLblVelocidadRep);
		
		tFVelocidadRep = new JTextField();
		tFVelocidadRep.addKeyListener(new KeyAdapter() {		
			@Override
			public void keyReleased(KeyEvent kE) {
				comprobarDatosIniciales("Velocidad");
				comprobacionFinal();
			}
		});
		GridBagConstraints cTFVelocidadRep = new GridBagConstraints();
		cTFVelocidadRep.fill = GridBagConstraints.HORIZONTAL;
		cTFVelocidadRep.gridx = 2;
		cTFVelocidadRep.gridy = 4;
		panelRepartir.add(tFVelocidadRep, cTFVelocidadRep);
		
		changePanel(panelStart, panelRepartir);
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
	 * initPanelPartida1();
	 * Método que iniciará el panel para empezar una partida
	 * @param void
	 * @return void
	 */
	private void initPanelPartida1() throws InterruptedException{
		System.out.println("Se ha pulsado el botón Empezar aventura");
		crearJugador();
		
		panelPartida1 = new JPanel();		
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		JLabel lblHistoria1 = new JLabel("Un buen día, "+jugador.getName()+" se levantó de la cama y dijo: ¡Voy a cambiar el mundo!");
		GridBagConstraints cLblHistoria1 = new GridBagConstraints();
		cLblHistoria1.fill = GridBagConstraints.CENTER;
		cLblHistoria1.gridx = 0;
		cLblHistoria1.gridy = 0;
		cLblHistoria1.gridwidth = (int) 0.5;
		this.add(lblHistoria1, cLblHistoria1);
		
		JLabel lblHistoria2 = new JLabel("Lo que "+jugador.getName()+" no sabía es que el camino para cambiar el mundo no iba a ser fácil...");
		GridBagConstraints cLblHistoria2 = new GridBagConstraints();
		cLblHistoria2.gridx = 0;
		cLblHistoria2.gridy = 1;
		cLblHistoria2.gridwidth = (int) 0.5;
		this.add(lblHistoria2, cLblHistoria2);
		
		JLabel lblHistoria3 = new JLabel("Bienvenido a esta aventura en la que para ganar, tendrás que enfrentarte a todo tipo de criaturas.");
		GridBagConstraints cLblHistoria3 = new GridBagConstraints();
		cLblHistoria3.gridx = 0;
		cLblHistoria3.gridy = 2;
		cLblHistoria3.gridwidth = (int) 0.5;
		this.add(lblHistoria3, cLblHistoria3);
		
		JLabel lblHistoria4 = new JLabel("Hazte fuerte y derrota al malvado jefe final");
		GridBagConstraints cLblHistoria4 = new GridBagConstraints();
		cLblHistoria4.gridx = 0;
		cLblHistoria4.gridy = 3;
		cLblHistoria4.gridwidth = (int) 0.5;
		this.add(lblHistoria4, cLblHistoria4);
		
		changePanel(panelRepartir, panelPartida1);
	}
	
	/*
	 * crearJugador();
	 * Método que le da los stats iniciales al jugador (En realidad el jugador ya se ha creado en el panel anterior con el nombre)
	 * @param void
	 * @return void
	 */
	private void crearJugador() {
		jugador.setAtaque(atqDefinitivo);
		jugador.setDefensa(defDefinitiva);
		jugador.setVelocidad(velDefinitiva);
		jugador.describe();
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
		panelContenedor.add(pnlActivar);
		pnlActivar.setVisible(true);
	}
	
	/**
	 * pausar();
	 * Método que le indicas un tiempo en milisegundos (1000 -> 1seg) y pausará la ejecución del programa
	 * @throws InterruptedException 
	 * @param int - Tiempo que estará pausado el programa
	 */
	static void pausar(int tiempo) throws InterruptedException {
		Thread.sleep(tiempo);
	}
}
