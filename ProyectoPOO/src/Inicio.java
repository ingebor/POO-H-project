import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Inicio {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblInicio = new JLabel("INICIO");
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JButton btnIngresar = new JButton("Ingresar");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(184)
					.addComponent(lblInicio)
					.addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
					.addComponent(btnIngresar)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addGap(49))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInicio)
						.addComponent(btnIngresar))
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		
		JLabel lblSeleccionarCategora = new JLabel("SELECCIONAR SU CATEGORIA");
		panel_1.add(lblSeleccionarCategora);
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox);
		comboBox.addItem("MEDICO");
		comboBox.addItem("PACIENTE");
		
		JLabel lblNewLabel = new JLabel("INSTRUCCIONES");
		panel.add(lblNewLabel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
