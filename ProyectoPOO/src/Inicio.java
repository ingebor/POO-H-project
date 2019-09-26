/**
 * @author Grupo 2 POO Seccion 21
 * @date 05/09/2019
 * Segunda presentacion de proyecto
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

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
		frame.getContentPane().setBackground(new Color(255, 239, 213));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblInicio = new JLabel("Inicio");
		
		JLabel lblInstrucciones = new JLabel("INSTRUCCIONES");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(230, 230, 250));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Doctor ", "Paciente"}));
		
		JLabel lblSeleccionarCategora = new JLabel("Seleccionar categoria");
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(new Color(176, 224, 230));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(184)
					.addComponent(lblInicio)
					.addContainerGap(231, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(256, Short.MAX_VALUE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(142))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnIngresar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(52)
							.addComponent(lblInstrucciones)
							.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
							.addComponent(lblSeleccionarCategora)))
					.addGap(114))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(lblInicio)
							.addGap(18)
							.addComponent(lblInstrucciones))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(lblSeleccionarCategora)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnIngresar)
					.addContainerGap(110, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
