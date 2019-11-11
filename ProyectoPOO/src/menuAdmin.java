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
 * @author Grupo 6
 * @date 04/11/2019
 * La clase proporciona un menu para el administrador
 */
public class menuAdmin {

	private JFrame frame;
	private JTextField tfNDU;
	private JTextField tfNDC;
	private JPanel panelNDoctor;
	private JPanel panelBorrarD;
	private JButton btnAgregar;
	private JButton btnVolver;
	private JButton btnBorrar;
	private CatalogoSalud catalogo;
	private JLabel lblIngreseElNombre;
	private JLabel lblNombreDeUsuario_1;
	private JTextField tfUsBo;

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
		frame.setResizable(false);
		frame.setBounds(100, 100, 730, 289);
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
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
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
		
		panelBorrarD = new JPanel();
		panelBorrarD.setBorder(new TitledBorder(null, "Eliminar Doctor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBorrarD.setBounds(338, 11, 366, 176);
		frame.getContentPane().add(panelBorrarD);
		panelBorrarD.setLayout(null);
		
		lblIngreseElNombre = new JLabel("Ingrese el nombre de usuario del doctor y pulse borrar:");
		lblIngreseElNombre.setBounds(10, 22, 346, 14);
		panelBorrarD.add(lblIngreseElNombre);
		
		lblNombreDeUsuario_1 = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario_1.setBounds(10, 47, 121, 14);
		panelBorrarD.add(lblNombreDeUsuario_1);
		
		tfUsBo = new JTextField();
		tfUsBo.setBounds(130, 44, 197, 27);
		panelBorrarD.add(tfUsBo);
		tfUsBo.setColumns(10);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.setBounds(10, 94, 89, 23);
		panelBorrarD.add(btnBorrar);
		btnBorrar.addActionListener(oyente);
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
			
			if(e.getSource() == btnBorrar) {
				if(!tfUsBo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, catalogo.borrarDoctor(tfUsBo.getText()));
					tfUsBo.setText(null);
				}else {
					JOptionPane.showMessageDialog(null, "No ingreso doctor para borrar!");
				}
			}
		}
		
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
