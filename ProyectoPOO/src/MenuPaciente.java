import java.awt.BorderLayout;
//lol2
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
	private JPanel PanelInstruct;
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
	private JButton btnVolver_1;
	private static MenuPaciente frame;
	private JPanel NombreDeMedicamento;
	private JButton INSTRUCT;
	private JLabel lblEnElPanel;
	private JTextPane txtpnEnEstePanel;
	private JLabel lblEnElPanel_1;
	private JTextPane txtpnEnEstePanel_1;
	private JLabel lblNewLabel_1;
	private JTextPane txtpnEnEstePanel_2;
	private JButton CerrarInstruct;
	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					
					frame = new MenuPaciente();
					frame.setBounds(30, 30,700, 570);
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
		getContentPane().setBackground(new Color(176, 224, 230));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBounds(10, 21, 644, 19);
		miListener oyente = new miListener();
				
				JPanel PanelInstruct = new JPanel();
				PanelInstruct.setBounds(0, 0, 539, 368);
				getContentPane().add(PanelInstruct);
				PanelInstruct.setEnabled(false);
				PanelInstruct.setLayout(null);
				
				JButton CerrarInstruct = new JButton("Cerrar");
				CerrarInstruct.setBounds(440, 334, 89, 23);
				PanelInstruct.add(CerrarInstruct);
				
				lblEnElPanel = new JLabel("En el panel \"Busqueda por enfermedad por Sintomas\": ");
				lblEnElPanel.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblEnElPanel.setBounds(10, 24, 400, 32);
				PanelInstruct.add(lblEnElPanel);
				
				txtpnEnEstePanel = new JTextPane();
				txtpnEnEstePanel.setText("En este panel podra ingresar los sintomas que usted padece, para que despues le salgas los resultados de las posibles enfermedades que puede tener.");
				txtpnEnEstePanel.setBounds(214, 53, 196, 78);
				PanelInstruct.add(txtpnEnEstePanel);
				
				lblEnElPanel_1 = new JLabel("En el panel \"Buscar Enfermedad\":");
				lblEnElPanel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblEnElPanel_1.setBounds(10, 170, 239, 14);
				PanelInstruct.add(lblEnElPanel_1);
				
				txtpnEnEstePanel_1 = new JTextPane();
				txtpnEnEstePanel_1.setText("En este panel solo es necesario que ingrese el nombre de una enfermedad y luego se le dispondra informacion sobre esto.");
				txtpnEnEstePanel_1.setBounds(172, 186, 170, 78);
				PanelInstruct.add(txtpnEnEstePanel_1);
				
				lblNewLabel_1 = new JLabel("En el panel \"Buscar Medicamentos\":");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1.setBounds(10, 277, 279, 14);
				PanelInstruct.add(lblNewLabel_1);
				
				txtpnEnEstePanel_2 = new JTextPane();
				txtpnEnEstePanel_2.setText("En este panel solo es necesario que ingrese el nombre de un medicamento y luego se le dispondra informacion sobre esto.");
				txtpnEnEstePanel_2.setBounds(50, 302, 239, 55);
				PanelInstruct.add(txtpnEnEstePanel_2);
		
				panelIngreso = new JPanel();
				panelIngreso.setBackground(new Color(224, 255, 255));
				panelIngreso.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Busqueda de enfermedad por sintomas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panelIngreso.setBounds(10, 80, 302, 525);
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
				comboBoxDolor_de_cabeza.setModel(new DefaultComboBoxModel(new String[] {" ","Si", "No"}));
				
				
				
				comboBoxDolorEstomago = new JComboBox();
				comboBoxDolorEstomago.setBounds(148, 73, 55, 20);
				panelIngreso.add(comboBoxDolorEstomago);
				comboBoxDolorEstomago.setModel(new DefaultComboBoxModel(new String[] {" ","Si", "No"}));
				
				
				
				
				comboBoxVomito = new JComboBox();
				comboBoxVomito.setBounds(148, 98, 55, 20);
				panelIngreso.add(comboBoxVomito);
				comboBoxVomito.setModel(new DefaultComboBoxModel(new String[] {" ","Si", "No"}));
				
						
						
						comboBoxDiarrea = new JComboBox();
						comboBoxDiarrea.setBounds(148, 123, 55, 20);
						panelIngreso.add(comboBoxDiarrea);
						comboBoxDiarrea.setModel(new DefaultComboBoxModel(new String[] {" ","Si", "No"}));
						
								
								
								comboBoxEstornudo = new JComboBox();
								comboBoxEstornudo.setBounds(148, 148, 55, 20);
								panelIngreso.add(comboBoxEstornudo);
								comboBoxEstornudo.setModel(new DefaultComboBoxModel(new String[] {" ","Si", "No"}));
								
								
								
								comboBoxTos = new JComboBox();
								comboBoxTos.setBounds(148, 173, 55, 20);
								panelIngreso.add(comboBoxTos);
								comboBoxTos.setModel(new DefaultComboBoxModel(new String[] {" ","Si", "No"}));
								
								
								
								comboBoxDolorGeneral = new JComboBox();
								comboBoxDolorGeneral.setBounds(148, 198, 55, 20);
								panelIngreso.add(comboBoxDolorGeneral);
								comboBoxDolorGeneral.setModel(new DefaultComboBoxModel(new String[] {" ","Si", "No"}));
								
								
								
								comboBoxFaltaEnergia = new JComboBox();
								comboBoxFaltaEnergia.setBounds(148, 223, 55, 20);
								panelIngreso.add(comboBoxFaltaEnergia);
								comboBoxFaltaEnergia.setModel(new DefaultComboBoxModel(new String[] {" ","Si", "No"}));
								
								
								btnIngresoSintomas = new JButton("Ingresar Sintomas");
								btnIngresoSintomas.addActionListener(oyente);
								btnIngresoSintomas.setBounds(10, 251, 165, 23);
								panelIngreso.add(btnIngresoSintomas);
								
								btnVolver = new JButton("Volver a Inicio");
								btnVolver.addActionListener(oyente);
								btnVolver.setBounds(463, 11, 0, 0);
								panelIngreso.add(btnVolver);
								
								JLabel lblResultados = new JLabel("Resultados:");
								lblResultados.setBounds(10, 283, 83, 14);
								panelIngreso.add(lblResultados);
								
								textPaneResultado = new JTextPane();
								textPaneResultado.setBounds(10, 308, 282, 206);
								panelIngreso.add(textPaneResultado);
		
		NombreDeMedicamento = new JPanel();
		NombreDeMedicamento.setBackground(new Color(173, 216, 230));
		NombreDeMedicamento.setBounds(324, 341, 401, 265);
		getContentPane().add(NombreDeMedicamento);
		NombreDeMedicamento.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ingrese el nombre del medicamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		NombreDeMedicamento.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre del medicamento:");
		lblNewLabel.setBounds(10, 22, 141, 14);
		NombreDeMedicamento.add(lblNewLabel);
		
		textPaneMedicamentos = new JTextPane();
		textPaneMedicamentos.setBounds(10, 47, 381, 160);
		NombreDeMedicamento.add(textPaneMedicamentos);
		
		textLaMedicina = new JTextField();
		textLaMedicina.setBounds(146, 15, 245, 28);
		NombreDeMedicamento.add(textLaMedicina);
		textLaMedicina.setColumns(10);
		
		btnBuscarMedicina = new JButton("Buscar Medicinas");
		btnBuscarMedicina.setBounds(241, 218, 150, 23);
		NombreDeMedicamento.add(btnBuscarMedicina);
		
		JPanel Nombre_De_Enfermedad = new JPanel();
		Nombre_De_Enfermedad.setBackground(new Color(176, 196, 222));
		Nombre_De_Enfermedad.setBounds(322, 80, 401, 261);
		getContentPane().add(Nombre_De_Enfermedad);
		Nombre_De_Enfermedad.setBorder(new TitledBorder(null, "Ingrese el nombre de la enfermedad", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Nombre_De_Enfermedad.setLayout(null);
		
		textPaneBuscarEnfermedad = new JTextPane();
		textPaneBuscarEnfermedad.setBounds(10, 65, 381, 151);
		Nombre_De_Enfermedad.add(textPaneBuscarEnfermedad);
		
		btnBuscarEnfermedad = new JButton("Buscar Enfermedad");
		btnBuscarEnfermedad.setBounds(241, 227, 150, 23);
		Nombre_De_Enfermedad.add(btnBuscarEnfermedad);
		
		
		
		JLabel lblBuscarEnfermedad = new JLabel("Nombre de la Enfermedad:");
		lblBuscarEnfermedad.setBounds(10, 32, 142, 14);
		Nombre_De_Enfermedad.add(lblBuscarEnfermedad);
		
		txtLaEnfermedad = new JTextField();
		txtLaEnfermedad.setBounds(147, 24, 244, 30);
		Nombre_De_Enfermedad.add(txtLaEnfermedad);
		txtLaEnfermedad.setColumns(10);
		
		JLabel lblPaciene = new JLabel("PACIENTE");
		lblPaciene.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblPaciene.setBounds(32, 18, 225, 49);
		getContentPane().add(lblPaciene);
		
		JButton INSTRUCT = new JButton("Instrucciones de ayuda");
		INSTRUCT.setBounds(379, 29, 322, 23);
		getContentPane().add(INSTRUCT);
		
		btnVolver_1 = new JButton("Volver");
		btnVolver_1.setBounds(285, 28, 89, 23);
		getContentPane().add(btnVolver_1);
		btnVolver_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Inicio volver = new Inicio();
				volver.main(null);
				frame.dispose();
			}
		});
		btnBuscarEnfermedad.addActionListener(oyente);
		btnBuscarMedicina.addActionListener(oyente);
		
		
		if(comboBoxDolor_de_cabeza.getSelectedItem().equals(" "))
		{
			btnIngresoSintomas.setEnabled(false);
		}
		if(comboBoxDolorEstomago.getSelectedItem().equals(" "))
		{
			btnIngresoSintomas.setEnabled(false);
		}
		if(comboBoxVomito.getSelectedItem().equals(" "))
		{
			btnIngresoSintomas.setEnabled(false);
		}
		if(comboBoxDiarrea.getSelectedItem().equals(" "))
		{
			btnIngresoSintomas.setEnabled(false);
		}
		if(comboBoxEstornudo.getSelectedItem().equals(" "))
		{
			btnIngresoSintomas.setEnabled(false);
		}
		if(comboBoxTos.getSelectedItem().equals(" "))
		{
			btnIngresoSintomas.setEnabled(false);
		}
		if(comboBoxDolorGeneral.getSelectedItem().equals(" "))
		{
			btnIngresoSintomas.setEnabled(false);
		}
		if(comboBoxFaltaEnergia.getSelectedItem().equals(" "))
		{
			btnIngresoSintomas.setEnabled(false);
		}

		

		
		
		
		

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
				if(comboBoxDolor_de_cabeza.getSelectedItem().equals("Si")) //
				{
					dolorCabeza = true;
				}
				if(comboBoxDolor_de_cabeza.getSelectedItem().equals("No"))
				{
					dolorCabeza = false;
				}
				if(comboBoxDolorEstomago.getSelectedItem().equals("Si"))//
				{
					dolorEstomago = true;
				}
				if(comboBoxDolorEstomago.getSelectedItem().equals("No"))
				{
					dolorEstomago = false;
				}
				if(comboBoxVomito.getSelectedItem().equals("Si"))//
				{
					vomito = true;
				}
				if(comboBoxVomito.getSelectedItem().equals("No"))
				{
					vomito = false;
				}
				if(comboBoxDiarrea.getSelectedItem().equals("Si"))//
				{
					diarrea = true;
				}
				if(comboBoxVomito.getSelectedItem().equals("No"))
				{
					diarrea = false;
				}
				if(comboBoxEstornudo.getSelectedItem().equals("Si"))//
				{
					estornudo = true;
				}
				if(comboBoxEstornudo.getSelectedItem().equals("No"))
				{
					estornudo = false;
				}
				if(comboBoxTos.getSelectedItem().equals("Si"))//
				{
					tos = true;
				}
				if(comboBoxTos.getSelectedItem().equals("No"))
				{
					tos = false;
				}
				if(comboBoxDolorGeneral.getSelectedItem().equals("Si"))//
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
				comboBoxDolor_de_cabeza.setSelectedItem(" ");
				comboBoxFaltaEnergia.setSelectedItem(" ");
				comboBoxDolorEstomago.setSelectedItem(" ");
				comboBoxVomito.setSelectedItem(" ");
				comboBoxDiarrea.setSelectedItem(" ");
				comboBoxEstornudo.setSelectedItem(" ");
				comboBoxTos.setSelectedItem(" ");
				comboBoxDolorGeneral.setSelectedItem(" ");
				comboBoxFaltaEnergia.setSelectedItem(" ");
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
				Inicio nuevo = new Inicio(); 
	
				frame.dispose();
			
			}
			if(e.getSource() == INSTRUCT)
			{
				
				PanelInstruct.setEnabled(true);
				
			}
			if(e.getSource() == CerrarInstruct)
			{
				
				PanelInstruct.setEnabled(false);
			}
		}
		
		
	}
}
