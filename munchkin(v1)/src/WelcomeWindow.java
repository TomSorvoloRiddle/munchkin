import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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
	private JPanel panelHistoria;
	private JPanel panelPartida;
	private JPanel panelDiario;
	private JPanel panelEnemigo;
	private JPanel panelAccion;
	private JPanel panelEstadistica;
	private JPanel panelNarrativo;
	private JPanel panelCombate;
	
	// Fuentes
	public Font txtDiario = new Font("Calibri", Font.BOLD, 30);
	
	// Objetos de datos
	private JTextField tFNombreP;
	private JTextField tFAtaqueRep;
	private JTextField tFDefensaRep;
	private JTextField tFVelocidadRep;
	private JLabel lblTurno;
	private JLabel lblDiario;
	private JLabel lblReparticionHab;
	private JLabel lblAtaqueMunchkin;
	private JLabel lblDefensaMunchkin;
	private JLabel lblVelocidadMunchkin;
	private JLabel lblNivelMunchkin;
	private JLabel lblVidasMunchkin;
	private JLabel lblCargaMunchkin;
	
	// Control de botones
	private JButton btnEmpezar;
	private JButton btnCrearPersonaje;
	private JButton btnPrimerReto;
	private JButton btnBuscarProblemas;
	private JButton btnDescansar;
	private JButton btnAdmObjetos;
	private JButton btnCombAtq;
	private JButton btnCombPrt;
	private JButton btnCombCrg;
	private JButton btnCombItm;
	
	// Player
	private Player jugadorFull;
	private Player jugadorProgress;
	private int atqDefinitivo;
	private int defDefinitiva;
	private int velDefinitiva;
	private JTextArea tAMnsUser;
	private String sMnsUser;
	
	//Enemigo
	private Enemy enemigo;
	private JLabel lblAtaqueEnemigo;
	private JLabel lblDefensaEnemigo;
	private JLabel lblVelocidadEnemigo;
	
	// Variables de control
	private boolean ctrlAtqHab = false;
	private boolean ctrlDefHab = false;
	private boolean ctrlVelHab = false;
	private final int TotalPuntos = 10;
	private int puntos = 10;
	
	// Control de los dias
	private int diaAventura = 1;
	private int momentoDelDia = 1; // El número máximo de momentoDelDia será TotalMomentos
	private final int TotalMomentos = 3;
	private int descanso = 0;
	
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
				jugadorFull = new Player(tFNombreP.getText());
				jugadorProgress = new Player();
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
		GridBagLayout gBLayoutPnlRepartir = new GridBagLayout();
		gBLayoutPnlRepartir.columnWidths = new int[]{40, 40};
		panelRepartir.setLayout(gBLayoutPnlRepartir);
		this.setTitle("Aventura Munchkin: "+ jugadorFull.getName());
		
		btnCrearPersonaje = new JButton("Empezar aventura");
		btnCrearPersonaje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent aE) {
				try {
					initPanelHistoria();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints cBtnCrearPersonaje = new GridBagConstraints();
		cBtnCrearPersonaje.fill = GridBagConstraints.CENTER;
		cBtnCrearPersonaje.gridx = 0;
		cBtnCrearPersonaje.gridy = 5;
		cBtnCrearPersonaje.gridwidth = 2;
		cBtnCrearPersonaje.insets = new Insets(10,0,0,0);
		btnCrearPersonaje.setEnabled(false);
		panelRepartir.add(btnCrearPersonaje, cBtnCrearPersonaje);
		
		lblReparticionHab = new JLabel("Repartición de habilidad (Puntos totales: "+puntos+")");
		GridBagConstraints cLblReparticionHab = new GridBagConstraints();
		cLblReparticionHab.fill = GridBagConstraints.CENTER;
		cLblReparticionHab.gridx = 0;
		cLblReparticionHab.gridy = 1;
		cLblReparticionHab.gridwidth = 2;
		cLblReparticionHab.insets = new Insets(0, 0, 10, 0);
		panelRepartir.add(lblReparticionHab, cLblReparticionHab);
		
		JLabel lblAtaqueRep = new JLabel("ATAQUE:");
		GridBagConstraints cLblAtaqueRep = new GridBagConstraints();
		cLblAtaqueRep.fill = GridBagConstraints.CENTER;
		cLblAtaqueRep.gridx = 0;
		cLblAtaqueRep.gridy = 2;
		cLblAtaqueRep.insets = new Insets(0, 0, 5, 5);
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
		cTFAtaqueRep.gridx = 1;
		cTFAtaqueRep.gridy = 2;
		panelRepartir.add(tFAtaqueRep, cTFAtaqueRep);
		
		JLabel lblDefensaRep = new JLabel("DEFENSA:");
		GridBagConstraints cLblDefensaRep = new GridBagConstraints();
		cLblDefensaRep.fill = GridBagConstraints.WEST;
		cLblDefensaRep.gridx = 0;
		cLblDefensaRep.gridy = 3;
		cLblDefensaRep.insets = new Insets(0, 0, 5, 5);
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
		cTFDefensaRep.gridx = 1;
		cTFDefensaRep.gridy = 3;
		panelRepartir.add(tFDefensaRep, cTFDefensaRep);
		
		JLabel lblVelocidadRep = new JLabel("VELOCIDAD:");
		GridBagConstraints cLblVelocidadRep = new GridBagConstraints();
		cLblVelocidadRep.fill = GridBagConstraints.WEST;
		cLblVelocidadRep.gridx = 0;
		cLblVelocidadRep.gridy = 4;
		cLblVelocidadRep.insets = new Insets(0, 0, 5, 5);
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
		cTFVelocidadRep.gridx = 1;
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
	 * initpanelHistoria();
	 * Método que iniciará el panel para empezar una partida
	 * @param void
	 * @return void
	 */
	private void initPanelHistoria() throws InterruptedException{
		System.out.println("Se ha pulsado el botón Empezar aventura");
		crearJugador();
		
		panelHistoria = new JPanel();		
		GridBagLayout gridBagLayout = new GridBagLayout();
		panelHistoria.setLayout(gridBagLayout);
		
		JLabel lblHistoria1 = new JLabel("Un buen día, "+jugadorFull.getName()+" se levantó de la cama y dijo: ¡Voy a cambiar el mundo!");
		GridBagConstraints cLblHistoria1 = new GridBagConstraints();
		cLblHistoria1.fill = GridBagConstraints.CENTER;
		cLblHistoria1.gridx = 0;
		cLblHistoria1.gridy = 0;
		cLblHistoria1.insets = new Insets(0,0,10,0);
		panelHistoria.add(lblHistoria1, cLblHistoria1);
		
		JLabel lblHistoria2 = new JLabel("Lo que "+jugadorFull.getName()+" no sabía es que el camino para cambiar el mundo no iba a ser fácil...");
		GridBagConstraints cLblHistoria2 = new GridBagConstraints();
		cLblHistoria2.gridx = 0;
		cLblHistoria2.gridy = 1;
		cLblHistoria2.insets = new Insets(0,0,10,0);
		panelHistoria.add(lblHistoria2, cLblHistoria2);
		
		JLabel lblHistoria3 = new JLabel("Bienvenido/a a esta aventura en la que para ganar, tendrás que enfrentarte a todo tipo de criaturas.");
		GridBagConstraints cLblHistoria3 = new GridBagConstraints();
		cLblHistoria3.gridx = 0;
		cLblHistoria3.gridy = 2;
		cLblHistoria3.insets = new Insets(0,0,10,0);
		panelHistoria.add(lblHistoria3, cLblHistoria3);
		
		JLabel lblHistoria4 = new JLabel("Hazte fuerte y derrota al malvado jefe final");
		GridBagConstraints cLblHistoria4 = new GridBagConstraints();
		cLblHistoria4.gridx = 0;
		cLblHistoria4.gridy = 3;
		panelHistoria.add(lblHistoria4, cLblHistoria4);
		
		btnPrimerReto = new JButton("Ir en busca del primer reto");
		btnPrimerReto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent aE) {
				initPartidaPanel();
			}
		});
		GridBagConstraints cBtnPrimerReto = new GridBagConstraints();
		cBtnPrimerReto.gridx = 0;
		cBtnPrimerReto.gridy = 4;
		cBtnPrimerReto.insets = new Insets(10,0,0,0);
		panelHistoria.add(btnPrimerReto, cBtnPrimerReto);
		
		changePanel(panelRepartir, panelHistoria);
	}
	
	/*
	 * initPrimerRetoPanel();
	 * Método que iniciará el panel PrimerRetoPanel
	 * @param void
	 * @return void
	 */
	private void initPartidaPanel() {
		System.out.println("Se ha pulsado el botón - Ir al primer reto");
		
		panelPartida = new JPanel();
		panelPartida.setLayout(new BorderLayout());
		
		// Programación del apartado Norte de la pantalla
		panelDiario = new JPanel();
		panelPartida.add(panelDiario, BorderLayout.NORTH);
		
		GridBagLayout gBLPnlDiario = new GridBagLayout();
		panelDiario.setLayout(gBLPnlDiario);
		//panelDiario.setBackground(Color.BLUE);
		
		lblDiario = new JLabel(" - Día "+ diaAventura +" de aventura");
		lblDiario.setFont(txtDiario);
		GridBagConstraints cLblDiario = new GridBagConstraints();
		cLblDiario.gridx = 0;
		cLblDiario.gridy = 0;
		cLblDiario.insets = new Insets(10,0,10,100);
		panelDiario.add(lblDiario, cLblDiario);
		
		lblTurno = new JLabel("Turno "+ momentoDelDia +"/"+ TotalMomentos);
		lblTurno.setFont(txtDiario);
		GridBagConstraints cLblTurno = new GridBagConstraints();
		cLblTurno.gridx = 1;
		cLblTurno.gridy = 0;
		panelDiario.add(lblTurno, cLblTurno);
		
		// Programación del apartado Oeste de la pantalla
		panelEnemigo = new JPanel();
		panelPartida.add(panelEnemigo, BorderLayout.WEST);
		GridBagLayout gBLPnlEnemigo = new GridBagLayout();
		panelEnemigo.setLayout(gBLPnlEnemigo);
		
		JLabel lblStatsEnemigo = new JLabel("- STATS ENEMIGO -");
		GridBagConstraints cLblStatsEnemigo = new GridBagConstraints();
		cLblStatsEnemigo.gridx = 0;
		cLblStatsEnemigo.gridy = 0;
		cLblStatsEnemigo.gridwidth = 2;
		cLblStatsEnemigo.insets = new Insets(0,15,0,15);
		panelEnemigo.add(lblStatsEnemigo, cLblStatsEnemigo);
		//panelEnemigo.setBackground(Color.RED);
		
		// Programación del apartado Central de la pantalla
		panelAccion = new JPanel();
		panelPartida.add(panelAccion, BorderLayout.CENTER);
		panelAccion.setBackground(Color.BLACK);
		
		// Programación del apartado Este de la pantalla
		panelEstadistica = new JPanel();
		panelPartida.add(panelEstadistica, BorderLayout.EAST);
		//panelEstadistica.setBackground(Color.GREEN);
		GridBagLayout gBLPnlEstadistica = new GridBagLayout();
		panelEstadistica.setLayout(gBLPnlEstadistica);
		
		JLabel lblStatsMunchkin = new JLabel("- STATS MUNCHKIN -");
		GridBagConstraints cLblStatsMunchkin = new GridBagConstraints();
		cLblStatsMunchkin.gridx = 0;
		cLblStatsMunchkin.gridy = 0;
		cLblStatsMunchkin.gridwidth = 2;
		cLblStatsMunchkin.insets = new Insets(0,15,0,15);
		panelEstadistica.add(lblStatsMunchkin, cLblStatsMunchkin);
		
		JLabel lblNombreMunchkin = new JLabel(jugadorFull.getName());
		GridBagConstraints cLblNombreMunchkin = new GridBagConstraints();
		cLblNombreMunchkin.gridx = 0;
		cLblNombreMunchkin.gridy = 1;
		cLblNombreMunchkin.gridwidth = 2;
		cLblNombreMunchkin.insets = new Insets(0,0,5,0);
		panelEstadistica.add(lblNombreMunchkin, cLblNombreMunchkin);
		
		JLabel lblAtaque = new JLabel("ATAQUE:");
		GridBagConstraints cLblAtaque = new GridBagConstraints();
		cLblAtaque.gridx = 0;
		cLblAtaque.gridy = 2;
		cLblAtaque.insets = new Insets(0,0,5,0);
		panelEstadistica.add(lblAtaque, cLblAtaque);
		
		lblAtaqueMunchkin = new JLabel( String.valueOf( jugadorProgress.getAtaque() ) );
		GridBagConstraints cLblAtaqueMunchkin = new GridBagConstraints();
		cLblAtaqueMunchkin.gridx = 1;
		cLblAtaqueMunchkin.gridy = 2;
		cLblAtaqueMunchkin.insets = new Insets(0,0,5,0);
		panelEstadistica.add(lblAtaqueMunchkin, cLblAtaqueMunchkin);
		
		JLabel lblDefensa = new JLabel("DEFENSA:");
		GridBagConstraints cLblDefensa = new GridBagConstraints();
		cLblDefensa.gridx = 0;
		cLblDefensa.gridy = 3;
		cLblDefensa.insets = new Insets(0,0,5,0);
		panelEstadistica.add(lblDefensa, cLblDefensa);
		
		lblDefensaMunchkin = new JLabel( String.valueOf( jugadorProgress.getDefensa() ) );
		GridBagConstraints cLblDefensaMunchkin = new GridBagConstraints();
		cLblDefensaMunchkin.gridx = 1;
		cLblDefensaMunchkin.gridy = 3;
		cLblDefensaMunchkin.insets = new Insets(0,0,5,0);
		panelEstadistica.add(lblDefensaMunchkin, cLblDefensaMunchkin);
		
		JLabel lblVelocidad = new JLabel("VELOCIDAD:");
		GridBagConstraints cLblVelocidad = new GridBagConstraints();
		cLblVelocidad.gridx = 0;
		cLblVelocidad.gridy = 4;
		cLblVelocidad.insets = new Insets(0,0,5,0);
		panelEstadistica.add(lblVelocidad, cLblVelocidad);
		
		lblVelocidadMunchkin = new JLabel( String.valueOf( jugadorProgress.getVelocidad() ) );
		GridBagConstraints cLblVelocidadMunchkin = new GridBagConstraints();
		cLblVelocidadMunchkin.gridx = 1;
		cLblVelocidadMunchkin.gridy = 4;
		cLblVelocidadMunchkin.insets = new Insets(0,0,5,0);
		panelEstadistica.add(lblVelocidadMunchkin, cLblVelocidadMunchkin);
		
		JLabel lblNivel = new JLabel("NIVEL:");
		GridBagConstraints cLblNivel = new GridBagConstraints();
		cLblNivel.gridx = 0;
		cLblNivel.gridy = 5;
		cLblNivel.insets = new Insets(0,0,5,0);
		panelEstadistica.add(lblNivel, cLblNivel);
		
		lblNivelMunchkin = new JLabel( String.valueOf( jugadorFull.getNivel() ) );
		GridBagConstraints cLblNivelMunchkin = new GridBagConstraints();
		cLblNivelMunchkin.gridx = 1;
		cLblNivelMunchkin.gridy = 5;
		cLblNivelMunchkin.insets = new Insets(0,0,5,0);
		panelEstadistica.add(lblNivelMunchkin, cLblNivelMunchkin);
		
		JLabel lblVidas = new JLabel("VIDAS:");
		GridBagConstraints cLblVidas = new GridBagConstraints();
		cLblVidas.gridx = 0;
		cLblVidas.gridy = 6;
		cLblVidas.insets = new Insets(0,0,5,0);
		panelEstadistica.add(lblVidas, cLblVidas);
		
		lblVidasMunchkin = new JLabel( String.valueOf( jugadorProgress.getVida() ) );
		GridBagConstraints cLblVidasMunchkin = new GridBagConstraints();
		cLblVidasMunchkin.gridx = 1;
		cLblVidasMunchkin.gridy = 6;
		cLblVidasMunchkin.insets = new Insets(0,0,5,0);
		panelEstadistica.add(lblVidasMunchkin, cLblVidasMunchkin);
		
		JLabel lblObjetos = new JLabel("OBJETOS:");
		GridBagConstraints cLblObjetos = new GridBagConstraints();
		cLblObjetos.gridx = 0;
		cLblObjetos.gridy = 7;
		cLblObjetos.gridwidth = 2;
		cLblObjetos.insets = new Insets(0,0,5,0);
		panelEstadistica.add(lblObjetos, cLblObjetos);
		
		/* Aquí se mostrarían todos los objetos que tuviera el munchkin
		 * Para ello, hay que montar una arraylist con todos los objetos
		 * para poder hacer un list.count() y saber cuántos objetos mostrar
		 * y en qué lugar colocar las siguientes estadísticas
		 */
		// Objeto de ejemplo
		JLabel lblObjExample = new JLabel("Ejemplo 1");
		GridBagConstraints cLblObjExample = new GridBagConstraints();
		cLblObjExample.gridx = 0;
		cLblObjExample.gridy = 8;
		cLblObjExample.insets = new Insets(0,0,5,0);
		panelEstadistica.add(lblObjExample, cLblObjExample);
		
		JLabel lblCargaTotal = new JLabel("CARGA TOTAL:");
		GridBagConstraints cLblCargaTotal = new GridBagConstraints();
		cLblCargaTotal.gridx = 0;
		cLblCargaTotal.gridy = 9;
		cLblCargaTotal.insets = new Insets(0,15,5,0);
		panelEstadistica.add(lblCargaTotal, cLblCargaTotal);
		
		lblCargaMunchkin = new JLabel( String.valueOf( jugadorProgress.getCarga() ) );
		GridBagConstraints cLblCargaMunchkin = new GridBagConstraints();
		cLblCargaMunchkin.gridx = 1;
		cLblCargaMunchkin.gridy = 9;
		cLblCargaMunchkin.insets = new Insets(0,0,5,0);
		panelEstadistica.add(lblCargaMunchkin, cLblCargaMunchkin);
		
		// Programación del apartado Sur de la pantalla
		panelNarrativo = new JPanel();
		panelPartida.add(panelNarrativo, BorderLayout.SOUTH);
		GridBagLayout gBLPanelNarrativo = new GridBagLayout();
		//panelNarrativo.setBackground(Color.YELLOW);
		panelNarrativo.setLayout(gBLPanelNarrativo);
		
		// Borde para el JTextArea
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		tAMnsUser = new JTextArea("Puedes realizar 3 acciones durante cada día.\n ¿Qué deseas hacer?\n", 10, 40);
		tAMnsUser.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		tAMnsUser.setEditable(false);
		GridBagConstraints cTAMnsUser = new GridBagConstraints();
		cTAMnsUser.gridx = 0;
		cTAMnsUser.gridy = 0;
		cTAMnsUser.gridheight = 5;
		cTAMnsUser.insets = new Insets(10,0,10,75);
		//panelNarrativo.add(tAMnsUser, cTAMnsUser);
		
		JScrollPane bDesplazamiento = new JScrollPane(tAMnsUser);
		bDesplazamiento.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		bDesplazamiento.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelNarrativo.add(bDesplazamiento, cTAMnsUser);
		
		JLabel lblAcciones = new JLabel(" - ACCIONES - ");
		GridBagConstraints cLblAcciones = new GridBagConstraints();
		cLblAcciones.gridx = 1;
		cLblAcciones.gridy = 0;
		cLblAcciones.gridwidth = 2;
		cLblAcciones.insets = new Insets(10,5,10,0);
		panelNarrativo.add(lblAcciones, cLblAcciones);
		
		btnBuscarProblemas = new JButton("Buscar problemas");
		btnBuscarProblemas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				accionTurno("Problemas");
			}
		});
		GridBagConstraints cBtnBuscarProblemas = new GridBagConstraints();
		cBtnBuscarProblemas.gridx = 1;
		cBtnBuscarProblemas.gridy = 1;
		panelNarrativo.add(btnBuscarProblemas, cBtnBuscarProblemas);
		
		btnDescansar = new JButton("Descansar");
		btnDescansar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				accionTurno("Descansar");
			}
		});
		GridBagConstraints cBtnDescansar = new GridBagConstraints();
		cBtnDescansar.gridx = 1;
		cBtnDescansar.gridy = 2;
		cBtnDescansar.insets = new Insets(5,0,5,0);
		panelNarrativo.add(btnDescansar, cBtnDescansar);
		
		btnAdmObjetos = new JButton("Administrar Objetos");
		btnAdmObjetos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				accionTurno("Objetos");
			}
		});
		GridBagConstraints cBtnAdmObjetos = new GridBagConstraints();
		cBtnAdmObjetos.gridx = 1;
		cBtnAdmObjetos.gridy = 3;
		panelNarrativo.add(btnAdmObjetos, cBtnAdmObjetos);
		
		changePanel(panelHistoria, panelPartida);
	}
	
	/*
	 * initPanelEnemigo();
	 * Método que rellenará el panelEnemigo con los datos del enemigo
	 * @param void
	 * @return void
	 */
	private void initPanelEnemigo() {
		
		JLabel lblNombreEnemigo = new JLabel( enemigo.getNombre() );
		GridBagConstraints cLblNombreEnemigo = new GridBagConstraints();
		cLblNombreEnemigo.gridx = 0;
		cLblNombreEnemigo.gridy = 1;
		cLblNombreEnemigo.gridwidth = 2;
		cLblNombreEnemigo.insets = new Insets(0,0,5,0);
		panelEnemigo.add(lblNombreEnemigo, cLblNombreEnemigo);
		
		JLabel lblAtaque = new JLabel("ATAQUE:");
		GridBagConstraints cLblAtaque = new GridBagConstraints();
		cLblAtaque.gridx = 0;
		cLblAtaque.gridy = 2;
		cLblAtaque.insets = new Insets(0,0,5,0);
		panelEnemigo.add(lblAtaque, cLblAtaque);
		
		lblAtaqueEnemigo = new JLabel( String.valueOf( enemigo.getAtaque() ) );
		GridBagConstraints cLblAtaqueEnemigo = new GridBagConstraints();
		cLblAtaqueEnemigo.gridx = 1;
		cLblAtaqueEnemigo.gridy = 2;
		cLblAtaqueEnemigo.insets = new Insets(0,0,5,0);
		panelEnemigo.add(lblAtaqueEnemigo, cLblAtaqueEnemigo);
		
		JLabel lblDefensa = new JLabel("DEFENSA:");
		GridBagConstraints cLblDefensa = new GridBagConstraints();
		cLblDefensa.gridx = 0;
		cLblDefensa.gridy = 3;
		cLblDefensa.insets = new Insets(0,0,5,0);
		panelEnemigo.add(lblDefensa, cLblDefensa);
		
		lblDefensaEnemigo = new JLabel( String.valueOf( enemigo.getDefensa() ) );
		GridBagConstraints cLblDefensaEnemigo = new GridBagConstraints();
		cLblDefensaEnemigo.gridx = 1;
		cLblDefensaEnemigo.gridy = 3;
		cLblDefensaEnemigo.insets = new Insets(0,0,5,0);
		panelEnemigo.add(lblDefensaEnemigo, cLblDefensaEnemigo);
		
		JLabel lblVelocidad = new JLabel("VELOCIDAD:");
		GridBagConstraints cLblVelocidad = new GridBagConstraints();
		cLblVelocidad.gridx = 0;
		cLblVelocidad.gridy = 4;
		cLblVelocidad.insets = new Insets(0,15,5,0);
		panelEnemigo.add(lblVelocidad, cLblVelocidad);
		
		lblVelocidadEnemigo = new JLabel( String.valueOf( enemigo.getVelocidad() ) );
		GridBagConstraints cLblVelocidadEnemigo= new GridBagConstraints();
		cLblVelocidadEnemigo.gridx = 1;
		cLblVelocidadEnemigo.gridy = 4;
		cLblVelocidadEnemigo.insets = new Insets(0,0,5,0);
		panelEnemigo.add(lblVelocidadEnemigo, cLblVelocidadEnemigo);
		
	}
	
	/*
	 * initPanelCombate();
	 * Método que iniciará los objetos en el panelCombate();
	 * @param void
	 * @retunr void 
	 */
	private void initPanelCombate() {
		panelCombate = new JPanel();
		GridBagLayout gBLPnlCombate = new GridBagLayout();
		panelCombate.setLayout(gBLPnlCombate);
		
		//JTextArea de sucesos:
		GridBagConstraints cTAMnsUser = new GridBagConstraints();
		cTAMnsUser.gridx = 0;
		cTAMnsUser.gridy = 0;
		cTAMnsUser.gridheight = 5;
		cTAMnsUser.insets = new Insets(10,0,10,75);
		panelCombate.add(tAMnsUser, cTAMnsUser);
		
		//Zona de botones de combate:
		JLabel lblAccionesComb = new JLabel("- Acciones de combate -");
		GridBagConstraints gBCLblAccionesComb = new GridBagConstraints();
		gBCLblAccionesComb.gridx = 1;
		gBCLblAccionesComb.gridy = 0;
		gBCLblAccionesComb.gridwidth = 4;
		panelCombate.add(lblAccionesComb, gBCLblAccionesComb);
		
		btnCombAtq = new JButton("Atacar");
		GridBagConstraints gBCBtnCombAtq = new GridBagConstraints();
		gBCBtnCombAtq.gridx = 1;
		gBCBtnCombAtq.gridy = 2;
		panelCombate.add(btnCombAtq, gBCBtnCombAtq);
		
		// Cambio de panel
		panelNarrativo.setVisible(false);
		panelPartida.add(panelCombate, BorderLayout.SOUTH);
		panelCombate.setVisible(true);
	}
	
	/*
	 * accionTurno();
	 * Método que realizará los cambios al decidir el usuario qué hacer en su turno (turno que no sea combate)
	 * @param String Lo que quiere realizar el usuario
	 * @return void
	 */
	private void accionTurno(String accion) {
		
		switch(accion) {
		case "Problemas":
			addToTextArea("Has pulsado buscarte problemas\n", tAMnsUser);
			// Tirada para pifia
			// Encontrar enemigo
			enemigo = new Enemy(1, false);
			// Mostrar el panelEnemigo
			initPanelEnemigo();
			// Cambiar el panelNarrativo por panelCombate
			initPanelCombate();
			// Imagen del enemigo en panelAccion
			// Combate
			avanzaTurno();
			break;
		case "Descansar":
			addToTextArea("Has pulsado descansar\n", tAMnsUser);
			/* Trozo de prueba para el botón descansar
			if(descanso == 0) {
				testRestarVida();
				System.err.println("Le quitamos vida de prueba al jugador");
				jugadorProgress.describe();
			}*/
			recuperacion();
			//System.err.println("Después de pasar por el descanso...");
			refreshLblPlayer();
			jugadorProgress.describe(); // Quitar cuando se actualicen los datos de pantalla
			descanso++;
			avanzaTurno();
			break;
		case "Objetos":
			addToTextArea("Has pulsado administrarte los objetos\n", tAMnsUser);
			avanzaTurno();
			break;
		default:
			System.err.println("No está contemplada esta opción en este método");
			break;
		}
	}
	
	/*
	 * addToTextArea();
	 * Método que al pasarle un texto y un area de texto, agrega el texto pasado
	 * @param String, JTextArea
	 * @return void
	 */
	private void addToTextArea(String texto, JTextArea areaDestino) {
		sMnsUser = areaDestino.getText();
		sMnsUser = sMnsUser + texto;
		areaDestino.setText(sMnsUser);
	}
	
	/*
	 * testRestarVida();
	 * Método que quitará la mitad de la vida del jugador para probar los métodos de recuperación de vida.
	 * @param void
	 * @return void
	 */
	private void testRestarVida() {
		jugadorProgress.setDefensa(jugadorFull.getDefensa()/2);
	}
	
	/*
	 * recuperacion();
	 * Método que se usa para recuperar defensa del personaje, puede suceder porque lo elija el jugador o porque se termine el día
	 * Tendrá varios aspectos a tener en cuenta:
	 * - Se recuperará tanta defensa como nivel tenga el jugador
	 * - Si descansa 2 veces durante el mismo día, la recuperación será la mitad a la del nvl redondeando a la alza. Ej: 3/2= 1,5 --> 2
	 * - Si se descansa por 3 vez, no tendrá efecto o incluso puede que tenga un efecto negativo (Tirar dado de pifia) --> Programable más adelante
	 * ------ POSIBILIDADES DE PIFIA ------
	 * Te vas a sentar y te cortas con una roca afilada -> -X en defensa
	 * Duermes con mala postura -> -X en velocidad
	 * Al despertarte te colocas mal tu forma de ataque -> -X en ataque
	 * Te colocas el calzado al revés -> -X en velocidad
	 * @param void
	 * @return void
	 */
	private void recuperacion() {
		int defMax = jugadorFull.getDefensa();
		float puntosARecuperar = 0;
		boolean descansoOk = false;
		if(descanso >= 2) { // Tirada de pifia para que le ocurra una desgracia mientras descansa. Ej: descansa y tenía una piedra en el culo y le hace perder velocidad... 
			// TO - DO
			System.out.println("El descanso ya no sirve de nada...");
		} else if(descanso == 1) { // El jugador se recupera la mitad de su nivel redondeado a la alza
			System.out.println("No llegas a descansar lo que te gustaría...");
			if(jugadorFull.getNivel()%2 != 0) {
				puntosARecuperar = (float) (jugadorFull.getNivel()/2 + 1);
				//System.err.println("Division: " + (float)(jugadorFull.getNivel()/2));
				//System.err.println("Puntos a recuperar: " + puntosARecuperar);
			} else {
				puntosARecuperar = jugadorFull.getNivel()/2;
			}
			descansoOk = true;
		} else { // Es el primer turno de descanso y puede recuperarse sin problemas
			puntosARecuperar = jugadorFull.getNivel();
			descansoOk = true;
		}
		if(jugadorProgress.getDefensa() == defMax) {
			System.err.println("El jugador está con su defensa máxima. Puede tener consecuencias negativas...");
			descansoOk = false;
		} else if(jugadorProgress.getDefensa() + puntosARecuperar > defMax){
			puntosARecuperar = 0;
			jugadorProgress.setDefensa(jugadorFull.getDefensa());
			descansoOk = false;
		}
		if(descansoOk) {
			jugadorProgress.setDefensa(jugadorProgress.getDefensa() + (int)puntosARecuperar);
		}
	}
	
	/*
	 * refresLblPlayer();
	 * Método que actualizará los datos de los JLabels que hay en pantalla
	 * @param void
	 * @return void
	 */
	private void refreshLblPlayer() {
		lblAtaqueMunchkin.setText( String.valueOf( jugadorProgress.getAtaque() ) );
		lblDefensaMunchkin.setText( String.valueOf( jugadorProgress.getDefensa() ) );
		lblVelocidadMunchkin.setText( String.valueOf( jugadorProgress.getVelocidad() ) );
		lblNivelMunchkin.setText( String.valueOf( jugadorProgress.getNivel() ) );
		lblVidasMunchkin.setText( String.valueOf( jugadorProgress.getVida() ) );
		lblCargaMunchkin.setText( String.valueOf( jugadorProgress.getCarga() ) );
	}
	
	/*
	 * resfreshLblDiario();
	 * Método que actualiza los datos del panelDiario.
	 * @param void
	 * @return void
	 */
	private void refreshLblDiario() {
		lblTurno.setText( String.valueOf( "Turno "+ momentoDelDia +"/"+ TotalMomentos ) );
		lblDiario.setText( String.valueOf( " - Día "+ diaAventura +" de aventura" ) );
	}
	
	/*
	 * avanzaTurno();
	 * Método que revisa si estamos en el último turno del día y hace pasar de turno
	 * Modifica la variable momentoDelDia
	 * @param void
	 * @return void
	 */
	private void avanzaTurno() {
		if(isTurn3()) {
			avanzaDia();
			momentoDelDia = 1;
		} else {
			momentoDelDia++;
		}
		refreshLblDiario();
	}
	
	/*
	 * isTurn3();
	 * Método que devolverá True si estamos en el 3r turno
	 * @param
	 * @return boolean
	 */
	private boolean isTurn3() {
		boolean finDelDia = false;
		if(momentoDelDia >= TotalMomentos) {
			finDelDia = true;
		}
		return finDelDia;
	}
	
	/*
	 * avanzaDía();
	 * Método que hará avanzar un día 
	 * 
	 */
	private void avanzaDia() {
		diaAventura++;
		descanso = 0;
		JOptionPane.showMessageDialog(panelPartida, "Después de un largo día, "+ jugadorFull.getName() + " descansa y se prepara para un nuevo día.");
	}
	
	/*
	 * crearJugador();
	 * Método que le da los stats iniciales al jugador (En realidad el jugador ya se ha creado en el panel anterior con el nombre)
	 * @param void
	 * @return void
	 */
	private void crearJugador() {
		jugadorFull.setAtaque(atqDefinitivo);
		jugadorFull.setDefensa(defDefinitiva);
		jugadorFull.setVelocidad(velDefinitiva);
		jugadorFull.describe();
		jugadorFull.clone(jugadorProgress);
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
	
	/**
	 *  Método randomNumber(int);
	 *  Método que genera un número aleatorio dependiendo del número que le pases
	 *  @return int aleatorio
	 */
	static int randomNumber(int dice) {
		int number;
		Random rnd = new Random();
		number = rnd.nextInt()%dice;
		number = Math.abs(number);
		if(number == 0) {
			number = dice;
		}
		return number;
	}
}
