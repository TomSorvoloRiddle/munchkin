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
import javax.swing.SwingConstants;

public class TestDesign extends JPanel {	
	
	JPanel panelDiario;
	JPanel panelAccion;
	JPanel panelEnemigo;
	JPanel panelEstadistica;
	JPanel panelNarrativo;
	private JLabel lblDiaXDe;
	
	public TestDesign() {
		
		this.setLayout(new BorderLayout());
		
		panelDiario = new JPanel();
		this.add(panelDiario, BorderLayout.NORTH);
		panelDiario.setLayout(new BoxLayout(panelDiario, BoxLayout.X_AXIS));
		
		lblDiaXDe = new JLabel("Dia X de aventura");
		panelDiario.add(lblDiaXDe);
		
		panelEnemigo = new JPanel();
		this.add(panelEnemigo, BorderLayout.WEST);
		
		panelAccion = new JPanel();
		this.add(panelAccion, BorderLayout.CENTER);
		
		panelEstadistica = new JPanel();
		this.add(panelEstadistica, BorderLayout.EAST);
		GridBagLayout gBLPnlEstadistica = new GridBagLayout();
		panelEstadistica.setLayout(gBLPnlEstadistica);
		
		JLabel lblStatsMunchkin = new JLabel("- STATS MUNCHKIN -");
		GridBagConstraints cLblStatsMunchkin = new GridBagConstraints();
		cLblStatsMunchkin.gridx = 0;
		cLblStatsMunchkin.gridy = 0;
		cLblStatsMunchkin.gridwidth = 2;
		panelEstadistica.add(lblStatsMunchkin, cLblStatsMunchkin);
		
		JLabel lblNombreMunchkin = new JLabel("NOMBRE");
		GridBagConstraints cLblNombreMunchkin = new GridBagConstraints();
		cLblNombreMunchkin.gridx = 0;
		cLblNombreMunchkin.gridy = 1;
		cLblNombreMunchkin.gridwidth = 2;
		panelEstadistica.add(lblNombreMunchkin, cLblNombreMunchkin);
		
		panelNarrativo = new JPanel();
		this.add(panelNarrativo, BorderLayout.SOUTH);
		
		
	}
}
