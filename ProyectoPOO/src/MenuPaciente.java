import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class MenuPaciente extends JFrame {

	private JPanel contentPane;
	private JButton btnIngresoSintomas;
	private JButton btnBuscarSintomas;
	private JButton btnBuscarMedicina;
	private JButton btnVolver;
	private CatalogoSalud catalogo = new CatalogoSalud();
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
		lbldolorCabeza.setBounds(10, 8, 83, 14);
		getContentPane().add(lbldolorCabeza);
		
		JComboBox comboBoxDolor_de_cabeza = new JComboBox();
		comboBoxDolor_de_cabeza.setBounds(113, 5, 28, 20);
		getContentPane().add(comboBoxDolor_de_cabeza);
		
		JLabel lbldolorEstomago = new JLabel("Dolor de Estomago:");
		lbldolorEstomago.setBounds(10, 33, 94, 14);
		getContentPane().add(lbldolorEstomago);
		
		JComboBox comboBoxDolorEstomago = new JComboBox();
		comboBoxDolorEstomago.setBounds(113, 30, 28, 20);
		getContentPane().add(comboBoxDolorEstomago);
		
		JLabel lblvomito = new JLabel("Vomitos:");
		lblvomito.setBounds(10, 58, 41, 14);
		lblvomito.setHorizontalAlignment(SwingConstants.TRAILING);
		getContentPane().add(lblvomito);
		
		JComboBox comboBoxVomito = new JComboBox();
		comboBoxVomito.setBounds(113, 55, 28, 20);
		getContentPane().add(comboBoxVomito);
		
		JLabel lbldiarrea = new JLabel("Diarrea:");
		lbldiarrea.setBounds(10, 83, 39, 14);
		lbldiarrea.setHorizontalAlignment(SwingConstants.TRAILING);
		getContentPane().add(lbldiarrea);
		
		JComboBox comboBoxDiarrea = new JComboBox();
		comboBoxDiarrea.setBounds(113, 80, 28, 20);
		getContentPane().add(comboBoxDiarrea);
		
		JLabel lblestornudo = new JLabel("Estornudo:");
		lblestornudo.setBounds(10, 108, 53, 14);
		getContentPane().add(lblestornudo);
		
		JComboBox comboBoxEstornudo = new JComboBox();
		comboBoxEstornudo.setBounds(113, 105, 28, 20);
		getContentPane().add(comboBoxEstornudo);
		
		JLabel lbltos = new JLabel("Tos:");
		lbltos.setBounds(10, 133, 21, 14);
		getContentPane().add(lbltos);
		
		JComboBox comboBoxTos = new JComboBox();
		comboBoxTos.setBounds(113, 130, 28, 20);
		getContentPane().add(comboBoxTos);
		
		JLabel lbldolorGeneral = new JLabel("Dolor General:");
		lbldolorGeneral.setBounds(10, 158, 69, 14);
		getContentPane().add(lbldolorGeneral);
		
		JComboBox comboBoxDolorGeneral = new JComboBox();
		comboBoxDolorGeneral.setBounds(113, 155, 28, 20);
		getContentPane().add(comboBoxDolorGeneral);
		
		JLabel lblfaltaEnergia = new JLabel("Falta de energia:");
		lblfaltaEnergia.setBounds(10, 184, 82, 14);
		getContentPane().add(lblfaltaEnergia);
		
		JComboBox comboBoxFaltaEnergia = new JComboBox();
		comboBoxFaltaEnergia.setBounds(113, 181, 28, 20);
		getContentPane().add(comboBoxFaltaEnergia);
		
		JButton btnIngresoSintomas = new JButton("Ingresar Sintomas");
		btnIngresoSintomas.setBounds(10, 251, 119, 23);
		getContentPane().add(btnIngresoSintomas);
		
		JButton btnBuscarSintomas = new JButton("Buscar Sintomas");
		btnBuscarSintomas.setBounds(139, 251, 111, 23);
		getContentPane().add(btnBuscarSintomas);
		
		JButton btnBuscarMedicina = new JButton("Buscar Medicinas");
		btnBuscarMedicina.setBounds(260, 251, 113, 23);
		getContentPane().add(btnBuscarMedicina);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(416, 309, 63, 23);
		getContentPane().add(btnVolver);
		
		

	}

}
