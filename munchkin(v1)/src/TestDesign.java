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
	JPanel panelStart;
	JButton btnEmpezar;
	Player jugador;
	JTextField tFNombreP;
	

	public TestDesign() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		panelStart = new JPanel();
		panelStart.setLayout(new GridBagLayout());
		
		JLabel lblLogo = new JLabel("LOGO");
		GridBagConstraints cLblLogo = new GridBagConstraints();
		cLblLogo.insets = new Insets(0, 0, 40, 0);
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
		//panelContenedor.setLayout(new BorderLayout(0, 0));
		GridBagConstraints cTFNombreP = new GridBagConstraints();
		cTFNombreP.insets = new Insets(0, 0, 10, 0);
		cTFNombreP.fill = GridBagConstraints.CENTER;
		cTFNombreP.gridx = 0;
		cTFNombreP.gridy = 3;
		cTFNombreP.gridwidth = (int) 0.5;
		panelStart.add(tFNombreP, cTFNombreP);
		tFNombreP.setColumns(20);

		//panelContenedor.add(panelStart);
		panelStart.setVisible(true);
		
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
