import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class TestDesign extends JPanel {

	public TestDesign() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
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
		
	}

}
