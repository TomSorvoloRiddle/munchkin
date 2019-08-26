import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TestDesign extends JPanel {	
	JPanel panelRepartir;
	public TestDesign() {
		panelRepartir = new JPanel();
		GridBagLayout gbl_panelRepartir = new GridBagLayout();
		gbl_panelRepartir.columnWidths = new int[]{0, 60};
		panelRepartir.setLayout(gbl_panelRepartir);
		BorderLayout border_Layout = new BorderLayout();
		setLayout(border_Layout);
		
		JButton btnCrearPersonaje = new JButton("Empezar aventura");
		GridBagConstraints cBtnCrearPersonaje = new GridBagConstraints();
		cBtnCrearPersonaje.fill = GridBagConstraints.CENTER;
		cBtnCrearPersonaje.gridx = 0;
		cBtnCrearPersonaje.gridy = 5;
		btnCrearPersonaje.setEnabled(false);
		panelRepartir.add(btnCrearPersonaje, cBtnCrearPersonaje);
		
		JLabel lblReparticionHab = new JLabel("Repartición de habilidad");
		GridBagConstraints cLblReparticionHab = new GridBagConstraints();
		cLblReparticionHab.insets = new Insets(0, 0, 10, 0);
		cLblReparticionHab.fill = GridBagConstraints.CENTER;
		cLblReparticionHab.gridx = 0;
		cLblReparticionHab.gridy = 1;
		panelRepartir.add(lblReparticionHab, cLblReparticionHab);
		
		JLabel lblAtaqueRep = new JLabel("ATAQUE:");
		GridBagConstraints cLblAtaqueRep = new GridBagConstraints();
		cLblAtaqueRep.insets = new Insets(0, 0, 0, 10);
		cLblAtaqueRep.anchor = GridBagConstraints.WEST;
		cLblAtaqueRep.fill = GridBagConstraints.CENTER;
		cLblAtaqueRep.gridx = 0;
		cLblAtaqueRep.gridy = 2;
		panelRepartir.add(lblAtaqueRep, cLblAtaqueRep);
		
		JTextField tFAtaqueRep = new JTextField();
		GridBagConstraints cTFAtaqueRep = new GridBagConstraints();
		cTFAtaqueRep.fill = GridBagConstraints.HORIZONTAL;
		cTFAtaqueRep.gridx = 1;
		cTFAtaqueRep.gridy = 2;
		panelRepartir.add(tFAtaqueRep, cTFAtaqueRep);
		
		JLabel lblDefensaRep = new JLabel("DEFENSA:");
		GridBagConstraints cLblDefensaRep = new GridBagConstraints();
		cLblDefensaRep.fill = GridBagConstraints.CENTER;
		cLblDefensaRep.gridx = 0;
		cLblDefensaRep.gridy = 3;
		panelRepartir.add(lblDefensaRep, cLblDefensaRep);
		
		JTextField tFDefensaRep = new JTextField();
		GridBagConstraints cTFDefensaRep = new GridBagConstraints();
		cTFDefensaRep.fill = GridBagConstraints.HORIZONTAL;
		cTFDefensaRep.gridx = 1;
		cTFDefensaRep.gridy = 3;
		panelRepartir.add(tFDefensaRep, cTFDefensaRep);
		
		JLabel lblVelocidadRep = new JLabel("VELOCIDAD:");
		GridBagConstraints cLblVelocidadRep = new GridBagConstraints();
		cLblVelocidadRep.fill = GridBagConstraints.CENTER;
		cLblVelocidadRep.gridx = 0;
		cLblVelocidadRep.gridy = 4;
		panelRepartir.add(lblVelocidadRep, cLblVelocidadRep);
		
		JTextField tFVelocidadRep = new JTextField();
		GridBagConstraints cTFVelocidadRep = new GridBagConstraints();
		cTFVelocidadRep.fill = GridBagConstraints.HORIZONTAL;
		cTFVelocidadRep.gridx = 1;
		cTFVelocidadRep.gridy = 4;
		panelRepartir.add(tFVelocidadRep, cTFVelocidadRep);
		
		/*
		
		JLabel lblHistoria1 = new JLabel("Un buen día, XXX se levantó de la cama y dijo: ¡Voy a cambiar el mundo!");
		GridBagConstraints cLblHistoria1 = new GridBagConstraints();
		cLblHistoria1.fill = GridBagConstraints.CENTER;
		cLblHistoria1.gridx = 0;
		cLblHistoria1.gridy = 0;
		cLblHistoria1.gridwidth = (int) 0.5;
		this.add(lblHistoria1, cLblHistoria1);
		
		JLabel lblHistoria2 = new JLabel("Lo que XXX no sabía es que el camino para cambiar el mundo no iba a ser fácil...");
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
		
		*/
		
	}
}
