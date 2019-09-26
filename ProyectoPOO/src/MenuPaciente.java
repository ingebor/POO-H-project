import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JOptionPane;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JTextPane;

public class MenuPaciente extends JFrame {

	private JPanel contentPane;
	private JPanel panelIngreso;
	private JButton btnIngresoSintomas;
	private JButton btnBuscarEnfermedad;
	private JButton btnBuscarMedicina;
	private JButton btnVolver;
	private CatalogoSalud catalogo = new CatalogoSalud();
	private JComboBox comboBoxDolor_de_cabeza;
	private JComboBox comboBoxDolorEstomago;
	private JComboBox comboBoxVomito;
	private JComboBox comboBoxDiarrea; 
	private JComboBox comboBoxEstornudo; 
	private JComboBox comboBoxTos;
	private JComboBox comboBoxDolorGeneral;
	private JComboBox comboBoxFaltaEnergia;
	private boolean dolorCabeza, dolorEstomago, vomito, diarrea, estornudo, tos, dolorGeneral, faltaEnergia;
	private JTextField txtLaEnfermedad;
	private JTextField textLaMedicina;
	private JTextPane textPaneBuscarEnfermedad;
	private JTextPane textPaneMedicamentos;
	private JTextPane textPaneResultado;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		panelIngreso = new JPanel();
		panelIngreso.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Busqueda de enfermedad por sintomas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelIngreso.setBounds(10, 11, 644, 473);
		getContentPane().add(panelIngreso);
		panelIngreso.setLayout(null);
		
		JLabel lblIntruccion = new JLabel("Indique que sintomas padece:");
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
		
		
		
		JLabel lblBuscarEnfermedad = new JLabel("Nombre de la Enfermedad:");
		lblBuscarEnfermedad.setBounds(338, 51, 156, 14);
		panelIngreso.add(lblBuscarEnfermedad);
		
		JLabel lblNewLabel = new JLabel("Nombre del medicamento");
		lblNewLabel.setBounds(338, 267, 156, 14);
		panelIngreso.add(lblNewLabel);
		
		miListener oyente = new miListener();
		
		btnBuscarEnfermedad = new JButton("Buscar Enfermedad");
		btnBuscarEnfermedad.addActionListener(oyente);
		btnBuscarEnfermedad.setBounds(484, 222, 150, 23);
		panelIngreso.add(btnBuscarEnfermedad);
		
		
		btnIngresoSintomas = new JButton("Ingresar Sintomas");
		btnIngresoSintomas.addActionListener(oyente);
		btnIngresoSintomas.setBounds(10, 251, 165, 23);
		panelIngreso.add(btnIngresoSintomas);
		
		btnBuscarMedicina = new JButton("Buscar Medicinas");
		btnBuscarMedicina.addActionListener(oyente);
		btnBuscarMedicina.setBounds(484, 439, 150, 23);
		panelIngreso.add(btnBuscarMedicina);
		
		btnVolver = new JButton("Volver a Inicio");
		btnVolver.addActionListener(oyente);
		btnVolver.setBounds(463, 11, 171, 23);
		panelIngreso.add(btnVolver);
		
		JLabel lblResultados = new JLabel("Resultados:");
		lblResultados.setBounds(10, 283, 83, 14);
		panelIngreso.add(lblResultados);
		
		txtLaEnfermedad = new JTextField();
		txtLaEnfermedad.setBounds(504, 38, 130, 30);
		panelIngreso.add(txtLaEnfermedad);
		txtLaEnfermedad.setColumns(10);
		
		textLaMedicina = new JTextField();
		textLaMedicina.setBounds(504, 256, 130, 28);
		panelIngreso.add(textLaMedicina);
		textLaMedicina.setColumns(10);
		
		textPaneBuscarEnfermedad = new JTextPane();
		textPaneBuscarEnfermedad.setBounds(338, 76, 296, 139);
		panelIngreso.add(textPaneBuscarEnfermedad);
		
		textPaneMedicamentos = new JTextPane();
		textPaneMedicamentos.setBounds(338, 294, 296, 134);
		panelIngreso.add(textPaneMedicamentos);
		
		textPaneResultado = new JTextPane();
		textPaneResultado.setBounds(10, 305, 282, 157);
		panelIngreso.add(textPaneResultado);
		
		

		
		
		
		

	}
	
	private class miListener implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() ==  btnBuscarEnfermedad)
			{
				if(txtLaEnfermedad.getText().equals(null))
				{
					JOptionPane.showMessageDialog(null,"Ingrese el nombre de una enfermedad porfavor.","Infor box: "+"Advertencia",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					
					//catalogo.verEnfermedad(txtLaEnfermedad.getText());
					textPaneBuscarEnfermedad.setText(catalogo.verEnfermedad(txtLaEnfermedad.getText()));
				}
			 
			}
			if (e.getSource() ==  btnIngresoSintomas)
			{
				if(comboBoxDolor_de_cabeza.getSelectedItem().equals("Si"))
				{
					dolorCabeza = true;
				}
				if(comboBoxDolor_de_cabeza.getSelectedItem().equals("No"))
				{
					dolorCabeza = false;
				}
				if(comboBoxDolorEstomago.getSelectedItem().equals("Si"))
				{
					dolorEstomago = true;
				}
				if(comboBoxDolorEstomago.getSelectedItem().equals("No"))
				{
					dolorEstomago = false;
				}
				if(comboBoxVomito.getSelectedItem().equals("Si"))
				{
					vomito = true;
				}
				if(comboBoxVomito.getSelectedItem().equals("No"))
				{
					vomito = false;
				}
				if(comboBoxDiarrea.getSelectedItem().equals("Si"))
				{
					diarrea = true;
				}
				if(comboBoxVomito.getSelectedItem().equals("No"))
				{
					diarrea = false;
				}
				if(comboBoxEstornudo.getSelectedItem().equals("Si"))
				{
					estornudo = true;
				}
				if(comboBoxEstornudo.getSelectedItem().equals("No"))
				{
					estornudo = false;
				}
				if(comboBoxTos.getSelectedItem().equals("Si"))
				{
					tos = true;
				}
				if(comboBoxTos.getSelectedItem().equals("No"))
				{
					tos = false;
				}
				if(comboBoxDolorGeneral.getSelectedItem().equals("Si"))
				{
					dolorGeneral = true;
				}
				if(comboBoxDolorGeneral.getSelectedItem().equals("No"))
				{
					dolorGeneral = false;
				}
				if(comboBoxFaltaEnergia.getSelectedItem().equals("Si"))
				{
					faltaEnergia = true;
				}
				if(comboBoxFaltaEnergia.getSelectedItem().equals("No"))
				{
					faltaEnergia = false;
				}
				
				textPaneResultado.setText(catalogo.buscarEnfermedad(dolorCabeza, dolorEstomago, vomito, diarrea, estornudo, tos, dolorGeneral, faltaEnergia));
			}
			if (e.getSource() ==  btnBuscarMedicina)
			{
				if(textLaMedicina.getText().equals(null))
				{
					JOptionPane.showMessageDialog(null,"Ingrese la medicina porfavor.","Infor box: "+"Advertencia",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					//catalogo.VerMedicina(textLaMedicina.getText());
					textPaneMedicamentos.setText(catalogo.VerMedicina(textLaMedicina.getText()));
				}
				
			}
			if (e.getSource() ==  btnVolver)
			{
				//
			
			}
		}
		
		
	}
}
