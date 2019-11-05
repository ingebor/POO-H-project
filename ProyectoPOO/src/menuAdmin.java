import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * @author Grupo 2
 * @date 04/11/2019
 * La clase proporciona un menu para el administrador
 */
public class menuAdmin {

	private JFrame frame;
	private JTextField tfNDU;
	private JTextField tfNDC;
	private JPanel panelNDoctor;
	private JButton btnAgregar;
	private JButton btnVolver;
	private CatalogoSalud catalogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuAdmin window = new menuAdmin();
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
	public menuAdmin() {
		initialize();
		catalogo = new CatalogoSalud();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 354, 289);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelNDoctor = new JPanel();
		panelNDoctor.setBorder(new TitledBorder(null, "Nuevo Doctor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNDoctor.setBounds(10, 11, 318, 176);
		frame.getContentPane().add(panelNDoctor);
		panelNDoctor.setLayout(null);
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos del doctor y pulse agregar:");
		lblIngreseLosDatos.setBounds(10, 21, 298, 14);
		panelNDoctor.add(lblIngreseLosDatos);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setBounds(10, 51, 141, 14);
		panelNDoctor.add(lblNombreDeUsuario);
		
		JLabel lblContrasena = new JLabel("Contrasena:");
		lblContrasena.setBounds(10, 88, 141, 14);
		panelNDoctor.add(lblContrasena);
		
		tfNDU = new JTextField();
		tfNDU.setBounds(134, 48, 174, 27);
		panelNDoctor.add(tfNDU);
		tfNDU.setColumns(10);
		
		tfNDC = new JTextField();
		tfNDC.setBounds(134, 85, 174, 27);
		panelNDoctor.add(tfNDC);
		tfNDC.setColumns(10);
		
		miListener oyente = new miListener();
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBounds(10, 135, 89, 23);
		panelNDoctor.add(btnAgregar);
		btnAgregar.addActionListener(oyente);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(20, 208, 89, 23);
		frame.getContentPane().add(btnVolver);
		btnVolver.addActionListener(oyente);
	}

	private class miListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btnAgregar) {
				String usuario = tfNDU.getText();
				String contrasena = tfNDC.getText();
				
				if(usuario != null && contrasena != null && !usuario.equals("") && !contrasena.equals("")) {
					JOptionPane.showMessageDialog(null, catalogo.agregarDoctor(usuario, contrasena));
					
					tfNDU.setText("");
					tfNDC.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Dejo algun campo vacio. Intente de nuevo");
				}
				
			}
			
			if(e.getSource() == btnVolver) {
				Inicio inicio = new Inicio();
				inicio.getFrame().setVisible(true);
				frame.dispose();
			}
		}
		
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
