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

public class MenuPaciente extends JFrame {

	private JPanel contentPane;
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
		
		JLabel lbldolorCabeza = new JLabel("Dolor de Cabeza:");
		lbldolorCabeza.setBounds(10, 47, 83, 14);
		getContentPane().add(lbldolorCabeza);
		
		JComboBox comboBoxDolor_de_cabeza = new JComboBox();
		comboBoxDolor_de_cabeza.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		comboBoxDolor_de_cabeza.setBounds(113, 44, 41, 20);
		getContentPane().add(comboBoxDolor_de_cabeza);
		
		JLabel lbldolorEstomago = new JLabel("Dolor de Estomago:");
		lbldolorEstomago.setBounds(10, 72, 94, 14);
		getContentPane().add(lbldolorEstomago);
		
		JComboBox comboBoxDolorEstomago = new JComboBox();
		comboBoxDolorEstomago.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		comboBoxDolorEstomago.setBounds(113, 69, 41, 20);
		getContentPane().add(comboBoxDolorEstomago);
		
		JLabel lblvomito = new JLabel("Vomitos:");
		lblvomito.setBounds(10, 97, 41, 14);
		lblvomito.setHorizontalAlignment(SwingConstants.TRAILING);
		getContentPane().add(lblvomito);
		
		JComboBox comboBoxVomito = new JComboBox();
		comboBoxVomito.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		comboBoxVomito.setBounds(113, 94, 41, 20);
		getContentPane().add(comboBoxVomito);
		
		JLabel lbldiarrea = new JLabel("Diarrea:");
		lbldiarrea.setBounds(10, 122, 39, 14);
		lbldiarrea.setHorizontalAlignment(SwingConstants.TRAILING);
		getContentPane().add(lbldiarrea);
		
		JComboBox comboBoxDiarrea = new JComboBox();
		comboBoxDiarrea.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		comboBoxDiarrea.setBounds(113, 119, 41, 20);
		getContentPane().add(comboBoxDiarrea);
		
		JLabel lblestornudo = new JLabel("Estornudo:");
		lblestornudo.setBounds(10, 147, 53, 14);
		getContentPane().add(lblestornudo);
		
		JComboBox comboBoxEstornudo = new JComboBox();
		comboBoxEstornudo.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		comboBoxEstornudo.setBounds(113, 144, 41, 20);
		getContentPane().add(comboBoxEstornudo);
		
		JLabel lbltos = new JLabel("Tos:");
		lbltos.setBounds(10, 172, 21, 14);
		getContentPane().add(lbltos);
		
		JComboBox comboBoxTos = new JComboBox();
		comboBoxTos.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		comboBoxTos.setBounds(113, 169, 41, 20);
		getContentPane().add(comboBoxTos);
		
		JLabel lbldolorGeneral = new JLabel("Dolor General:");
		lbldolorGeneral.setBounds(10, 197, 69, 14);
		getContentPane().add(lbldolorGeneral);
		
		JComboBox comboBoxDolorGeneral = new JComboBox();
		comboBoxDolorGeneral.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		comboBoxDolorGeneral.setBounds(113, 194, 41, 20);
		getContentPane().add(comboBoxDolorGeneral);
		
		JLabel lblfaltaEnergia = new JLabel("Falta de energia:");
		lblfaltaEnergia.setBounds(10, 223, 82, 14);
		getContentPane().add(lblfaltaEnergia);
		
		JComboBox comboBoxFaltaEnergia = new JComboBox();
		comboBoxFaltaEnergia.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		comboBoxFaltaEnergia.setBounds(113, 220, 41, 20);
		getContentPane().add(comboBoxFaltaEnergia);
		
		JButton btnIngresoSintomas = new JButton("Ingresar Sintomas");
		btnIngresoSintomas.setBounds(10, 257, 119, 23);
		getContentPane().add(btnIngresoSintomas);
		
		JButton btnBuscarSintomas = new JButton("Buscar Sintomas");
		btnBuscarSintomas.setBounds(346, 181, 111, 23);
		getContentPane().add(btnBuscarSintomas);
		
		JButton btnBuscarMedicina = new JButton("Buscar Medicinas");
		btnBuscarMedicina.setBounds(344, 338, 113, 23);
		getContentPane().add(btnBuscarMedicina);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(394, 9, 63, 23);
		getContentPane().add(btnVolver);
		
		JLabel lblIntruccion = new JLabel("Ingrese los sintomas que padece:");
		lblIntruccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIntruccion.setBounds(10, 0, 255, 37);
		getContentPane().add(lblIntruccion);
		
		txtBuscarSintomas = new JTextField();
		txtBuscarSintomas.setBounds(222, 60, 235, 114);
		getContentPane().add(txtBuscarSintomas);
		txtBuscarSintomas.setColumns(10);
		
		JLabel lblSintomasText = new JLabel("Sintomas:");
		lblSintomasText.setBounds(222, 42, 69, 14);
		getContentPane().add(lblSintomasText);
		
		txtMedicamentos = new JTextField();
		txtMedicamentos.setBounds(222, 243, 235, 84);
		getContentPane().add(txtMedicamentos);
		txtMedicamentos.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Medicamentos necesarios:");
		lblNewLabel.setBounds(222, 223, 148, 14);
		getContentPane().add(lblNewLabel);
		
		

	}
}
