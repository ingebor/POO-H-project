import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class MenuPaciente extends JFrame {

	private JPanel contentPane;
	private JPanel panelIngreso;
	private JButton btnIngresoSintomas;
	private JButton btnBuscarSintomas;
	private JButton btnBuscarMedicina;
	private JButton btnVolver;
	private CatalogoSalud catalogo = new CatalogoSalud();
	private JTextField txtBuscarSintomas;
	private JTextField txtMedicamentos;
	private JComboBox comboBoxDolor_de_cabeza;
	private JComboBox comboBoxDolorEstomago;
	private JComboBox comboBoxVomito;
	private JComboBox comboBoxDiarrea; 
	private JComboBox comboBoxEstornudo; 
	private JComboBox comboBoxTos;
	private JComboBox comboBoxDolorGeneral;
	private JComboBox comboBoxFaltaEnergia;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					try {
			            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			                if ("Nimbus".equals(info.getName())) {
			                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
			                    break;
			                }
			            }
			        } catch (ClassNotFoundException ex) {
			            java.util.logging.Logger.getLogger(MenuPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			        } catch (InstantiationException ex) {
			            java.util.logging.Logger.getLogger(MenuPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			        } catch (IllegalAccessException ex) {
			            java.util.logging.Logger.getLogger(MenuPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
			            java.util.logging.Logger.getLogger(MenuPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			        }
					MenuPaciente frame = new MenuPaciente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.  boolean dolorCabeza, boolean dolorEstomago, boolean vomito, boolean diarrea, boolean estornudo, boolean tos, boolean dolorGeneral, boolean faltaEnergia
	 */
	public MenuPaciente() {
		getContentPane().setLayout(null);
		
		panelIngreso = new JPanel();
		panelIngreso.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Busqueda de enfermedad por sintomas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelIngreso.setBounds(10, 11, 517, 358);
		getContentPane().add(panelIngreso);
		panelIngreso.setLayout(null);
		
		JLabel lblIntruccion = new JLabel("Indique qu\u00E9 s\u00EDntomas padece:");
		lblIntruccion.setBounds(10, 21, 221, 19);
		panelIngreso.add(lblIntruccion);
		lblIntruccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lbldolorCabeza = new JLabel("Dolor de Cabeza:");
		lbldolorCabeza.setBounds(10, 51, 142, 14);
		panelIngreso.add(lbldolorCabeza);
		
		JLabel lbldolorEstomago = new JLabel("Dolor de Estomago:");
		lbldolorEstomago.setBounds(10, 76, 142, 14);
		panelIngreso.add(lbldolorEstomago);
		
		JLabel lblvomito = new JLabel("Vomitos:");
		lblvomito.setBounds(10, 101, 142, 14);
		panelIngreso.add(lblvomito);
		lblvomito.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lbldiarrea = new JLabel("Diarrea:");
		lbldiarrea.setBounds(10, 126, 142, 14);
		panelIngreso.add(lbldiarrea);
		lbldiarrea.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblestornudo = new JLabel("Estornudo:");
		lblestornudo.setBounds(10, 151, 142, 14);
		panelIngreso.add(lblestornudo);
		
		JLabel lbltos = new JLabel("Tos:");
		lbltos.setBounds(10, 176, 142, 14);
		panelIngreso.add(lbltos);
		
		JLabel lbldolorGeneral = new JLabel("Dolor General:");
		lbldolorGeneral.setBounds(10, 201, 142, 14);
		panelIngreso.add(lbldolorGeneral);
		
		JLabel lblfaltaEnergia = new JLabel("Falta de energia:");
		lblfaltaEnergia.setBounds(11, 226, 141, 14);
		panelIngreso.add(lblfaltaEnergia);
		
		comboBoxDolor_de_cabeza = new JComboBox();
		comboBoxDolor_de_cabeza.setBounds(148, 51, 55, 20);
		panelIngreso.add(comboBoxDolor_de_cabeza);
		comboBoxDolor_de_cabeza.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		comboBoxDolorEstomago = new JComboBox();
		comboBoxDolorEstomago.setBounds(148, 73, 55, 20);
		panelIngreso.add(comboBoxDolorEstomago);
		comboBoxDolorEstomago.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		comboBoxVomito = new JComboBox();
		comboBoxVomito.setBounds(148, 98, 55, 20);
		panelIngreso.add(comboBoxVomito);
		comboBoxVomito.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		comboBoxDiarrea = new JComboBox();
		comboBoxDiarrea.setBounds(148, 123, 55, 20);
		panelIngreso.add(comboBoxDiarrea);
		comboBoxDiarrea.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		comboBoxEstornudo = new JComboBox();
		comboBoxEstornudo.setBounds(148, 148, 55, 20);
		panelIngreso.add(comboBoxEstornudo);
		comboBoxEstornudo.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		comboBoxTos = new JComboBox();
		comboBoxTos.setBounds(148, 173, 55, 20);
		panelIngreso.add(comboBoxTos);
		comboBoxTos.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		comboBoxDolorGeneral = new JComboBox();
		comboBoxDolorGeneral.setBounds(148, 198, 55, 20);
		panelIngreso.add(comboBoxDolorGeneral);
		comboBoxDolorGeneral.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		comboBoxFaltaEnergia = new JComboBox();
		comboBoxFaltaEnergia.setBounds(148, 223, 55, 20);
		panelIngreso.add(comboBoxFaltaEnergia);
		comboBoxFaltaEnergia.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		btnIngresoSintomas = new JButton("Ingresar Sintomas");
		btnIngresoSintomas.setBounds(10, 251, 165, 23);
		panelIngreso.add(btnIngresoSintomas);
		
		txtBuscarSintomas = new JTextField();
		txtBuscarSintomas.setBounds(247, 65, 235, 102);
		panelIngreso.add(txtBuscarSintomas);
		txtBuscarSintomas.setColumns(10);
		
		JLabel lblSintomasText = new JLabel("Sintomas");
		lblSintomasText.setBounds(247, 51, 235, 14);
		panelIngreso.add(lblSintomasText);
		
		txtMedicamentos = new JTextField();
		txtMedicamentos.setBounds(247, 234, 235, 84);
		panelIngreso.add(txtMedicamentos);
		txtMedicamentos.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Medicamentos necesarios:");
		lblNewLabel.setBounds(249, 201, 148, 14);
		panelIngreso.add(lblNewLabel);
		
		btnBuscarSintomas = new JButton("Buscar Sintomas");
		btnBuscarSintomas.setBounds(328, 172, 148, 23);
		panelIngreso.add(btnBuscarSintomas);
		
		btnBuscarMedicina = new JButton("Buscar Medicinas");
		btnBuscarMedicina.setBounds(328, 324, 150, 23);
		panelIngreso.add(btnBuscarMedicina);
		
		btnVolver = new JButton("Volver a Inicio");
		btnVolver.setBounds(311, 21, 171, 23);
		panelIngreso.add(btnVolver);
		
		

	}
}
