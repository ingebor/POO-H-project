import java.awt.EventQueue;
// LOL 

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.awt.Color;

/**
 * @author Grupo 6 POO Seccion 21
 * @date 
 * Crea la ventana de Inicio de la aplicacion
 */
public class Inicio {

	private JFrame frame;
	private JTextField textUsuario;
	private JPasswordField passwordField;
	private static Inicio window;
	private CatalogoSalud catalogo;
	private JTextField tfUsAdmin;
	private JTextField tfCnAdmin;
	private JPasswordField pfAdmin;
	private JButton btnIngresarAdmin;
	private JButton button;
	private JButton btnIngresar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String []args) {
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Inicio();
					window.frame.setVisible(true);
					JOptionPane.showMessageDialog(null, "Colaborador:\nPara ingresar como medico, utilice \"doctor\"\ncomo usuario y \"12345\" como contrase�a.\n"
							+ "\nPara ingresar como administrador, utilice \"Grupo2\"\ncomo usuario y \"ElWatt123\" como contrase�a.");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor de Inicio.
	 */
	public Inicio() {
		catalogo = new CatalogoSalud();
		initialize();
		
	}

	/**
	 * Incicializa los contenidos del JFrame
	 */
	private void initialize() {
		miListener oyente = new miListener();
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 629, 258);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		
		JLabel lblVerificacion = new JLabel("INICIO - VERIFICACION DE IDENTIDAD ");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 255));
		
		JLabel lblPaciente = new JLabel("PACIENTE");
		lblPaciente.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		
		button = new JButton("INGRESAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPaciente nuevoPaciente = new MenuPaciente(); 
				nuevoPaciente.newScreen();
				window.frame.dispose();
				
				
			}
		});
		button.addActionListener(oyente);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGap(97)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPaciente)
						.addComponent(button))
					.addContainerGap(83, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(19)
					.addComponent(lblPaciente)
					.addGap(41)
					.addComponent(button)
					.addGap(75))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panelAdmin = new JPanel();
		panelAdmin.setBackground(new Color(224, 255, 255));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblVerificacion)
							.addGap(203))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelAdmin, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(lblVerificacion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelAdmin, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelAdmin.setLayout(null);
		panelAdmin.setVisible(false);
		
		JLabel lblAdministrador = new JLabel("ADMINISTRADOR");
		lblAdministrador.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAdministrador.setBounds(10, 11, 305, 19);
		panelAdmin.add(lblAdministrador);
		
		tfUsAdmin = new JTextField();
		tfUsAdmin.setBounds(116, 36, 187, 27);
		panelAdmin.add(tfUsAdmin);
		tfUsAdmin.setColumns(10);
		
		pfAdmin = new JPasswordField();
		pfAdmin.setBounds(116, 72, 187, 27);
		panelAdmin.add(pfAdmin);
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setBounds(10, 41, 96, 14);
		panelAdmin.add(lblUsuario);
		
		JLabel lblContrasena_1 = new JLabel("CONTRASENA:");
		lblContrasena_1.setBounds(10, 77, 96, 14);
		panelAdmin.add(lblContrasena_1);
		
		
		
		btnIngresarAdmin = new JButton("INGRESAR");
		btnIngresarAdmin.setBounds(358, 52, 103, 27);
		panelAdmin.add(btnIngresarAdmin);
		btnIngresarAdmin.addActionListener(oyente);
		
		JLabel lblNewLabel = new JLabel("USUARIO: ");
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		
		JLabel lblContrasena = new JLabel("Clave: ");
		
		passwordField = new JPasswordField();
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				List <Doctor> listaDoc = catalogo.getListadoDoctores();
				
				char key[]= passwordField.getPassword(); 
				String clave= new String(key); 
				
				int i = 0;
				boolean acceso = false;
				while(i < listaDoc.size() && !acceso) {
					if((textUsuario.getText().equals(listaDoc.get(i).getNombreUsuario()) && clave.equals(listaDoc.get(i).getContrasena()))){
						acceso = true;
					}
					i++;
				}
				
				if((textUsuario.getText().equals("doctor") && clave.equals("12345"))) {
					acceso = true;
				}
				
				if (acceso) { 
					
					MenuDoctor nuevo = new MenuDoctor(); 
					nuevo.newScreen();
					window.frame.dispose();
				}
				
				
				else {
					passwordField.setText("");					
				}
				}
				
				catch (Exception ex) {
					
					//JOptionPane.showMessageDialog(null, "Est� ingresando un valor inv�lido, vuelva a intentarlo por favor.","Infor box: "+"Advertencia",JOptionPane.INFORMATION_MESSAGE);
			
					
				}
				
				}
				
			}
		);
		btnIngresar.addActionListener(oyente);
		
		JLabel lblMedico = new JLabel("COLABORADOR");
		lblMedico.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		
		
		
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap(19, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(17))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblContrasena, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textUsuario, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addComponent(passwordField, Alignment.LEADING, 181, 181, 181)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(107)
							.addComponent(btnIngresar))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(110)
							.addComponent(lblMedico)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblMedico)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContrasena))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnIngresar)
					.addGap(26))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	/**
	 * @author Grupo 6
	 * Clase privada que implementa ActionListener para atrapar eventos
	 */
	private class miListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btnIngresarAdmin) {
				if(tfUsAdmin.getText().equals("Grupo2") && pfAdmin.getText().equals("ElWatt123")) {
					menuAdmin NmenuA = new menuAdmin();
					NmenuA.getFrame().setVisible(true);
					frame.dispose();
				} else {

					JOptionPane.showMessageDialog(null, "No ingres� la informacion adecuada, intente de nuevo por favor.","Infor box: "+"Advertencia",JOptionPane.INFORMATION_MESSAGE);
					passwordField.setText("");

				}
			}
			
			if(e.getSource() == button) {
				frame.dispose();
			}
			
			if(e.getSource() == btnIngresar) {
				
				boolean accesoFinal = false;
				
				List <Doctor> listaDoc = catalogo.getListadoDoctores();
				
				char key[]= passwordField.getPassword(); 
				String clave= new String(key); 
				
				int i = 0;
				boolean acceso = false;
				while(i < listaDoc.size() && !acceso) {
					if((textUsuario.getText().equals(listaDoc.get(i).getNombreUsuario()) && clave.equals(listaDoc.get(i).getContrasena()))){
						acceso = true;
					}
					i++;
				}
				
				if((textUsuario.getText().equals("doctor") && clave.equals("12345"))) {
					acceso = true;
				}
				
				if(acceso) {
					frame.dispose();
				}
				
				if(!acceso) {
					if(textUsuario.getText().equals("Grupo2") && passwordField.getText().equals("ElWatt123")) {
						menuAdmin NmenuA = new menuAdmin();
						NmenuA.getFrame().setVisible(true);
						accesoFinal = true;
						frame.dispose();
					}
					if(!accesoFinal) {
						JOptionPane.showMessageDialog(null, "No ingres� la informacion adecuada, intente de nuevo por favor.","Infor box: "+"Advertencia",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
				
			}
		}
		
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
