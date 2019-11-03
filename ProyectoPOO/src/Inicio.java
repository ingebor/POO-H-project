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

public class Inicio {

	private JFrame frame;
	private JTextField textUsuario;
	private JPasswordField passwordField;
	private static Inicio window;
	private CatalogoSalud catalogo;

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
					JOptionPane.showMessageDialog(null, "Para ingresar como medico, utilice \"admin\"\ncomo usuario y \"12345\" como contrasenia");
					
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
		catalogo = new CatalogoSalud();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 629, 255);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		
		JLabel lblVerificacion = new JLabel("INICIO - VERIFICACION DE IDENTIDAD ");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 255));
		
		JLabel lblPaciente = new JLabel("PACIENTE");
		lblPaciente.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		
		JButton button = new JButton("INGRESAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPaciente nuevoPaciente = new MenuPaciente(); 
				nuevoPaciente.newScreen();
				window.frame.dispose();
				
			}
		});
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
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(193, Short.MAX_VALUE)
					.addComponent(lblVerificacion)
					.addGap(203))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(lblVerificacion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap(12, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		JLabel lblNewLabel = new JLabel("USUARIO: ");
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		
		JLabel lblContrasena = new JLabel("CONTRASENA: ");
		
		passwordField = new JPasswordField();
		
		JButton btnIngresar = new JButton("INGRESAR");
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
				
				if((textUsuario.getText().equals("admin") && clave.equals("12345"))) {
					acceso = true;
				}
				
				if (acceso) { 
					
					MenuDoctor nuevo = new MenuDoctor(); 
					nuevo.newScreen();
					window.frame.dispose();
				}
				
				else {
					JOptionPane.showMessageDialog(null, "NO ESTA INGRESANDO LA CONTRASENA O EL USUARIO CORRECTAMENTE, VUELVA A INTENTARLO.");

					
				}
				}
				
				catch (Exception ex) {
					
					JOptionPane.showMessageDialog(null, "ESTA INGRESANDO UN VALOR INVALIDO, VUELVA A INTENTARLO.");
			
					
				}
				
				}
				
			}
		);
		
		JLabel lblMedico = new JLabel("MEDICO");
		lblMedico.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		
		
		
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(19)
									.addComponent(lblContrasena, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel)
									.addGap(17)))
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textUsuario, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
								.addComponent(passwordField, Alignment.LEADING)))
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
}
