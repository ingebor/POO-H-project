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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * @author Grupo 6 POO Seccion 21
 * Crea una ventana para un usuario paciente de la aplicacion
 */
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
	private JButton btnVolver_1;
	private static MenuPaciente frame;
	private JPanel NombreDeMedicamento;
	private JButton INSTRUCT;
	private JButton CerrarInstruct;
	private JButton btnListo;
	private JLabel lbllisto;
	private JLabel lblAdIngresarSintomas;
	private JScrollPane scrollPane;
	private JTextArea textPaneResultado;
	private JScrollPane scrollPane_1;
	private JTextArea textPaneBuscarEnfermedad;
	private JScrollPane scrollPane_2;
	private JTextArea textPaneMedicamentos;
	private JButton btnInstruccion;
	private JButton btnLimpiar;
	
	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					
					frame = new MenuPaciente();
					frame.setBounds(30, 30,750, 670);
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
		setResizable(false);
		getContentPane().setBackground(new Color(176, 224, 230));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBounds(10, 21, 644, 19);
		miListener oyente = new miListener();
		
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
		btnIngresoSintomas.setEnabled(false);
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
		
		btnListo = new JButton("Listo");
		btnListo.setBounds(222, 221, 70, 25);
		miListener escuchar = new miListener();
		btnListo.addActionListener(escuchar);
		panelIngreso.add(btnListo);
		
		JLabel lblPresionelistoPara = new JLabel("Presione ");
		lblPresionelistoPara.setBounds(237, 186, 55, 16);
		panelIngreso.add(lblPresionelistoPara);
		
		lbllisto = new JLabel("\"Listo\"");
		lbllisto.setBounds(251, 200, 41, 16);
		panelIngreso.add(lbllisto);
		
		lblAdIngresarSintomas = new JLabel("");
		lblAdIngresarSintomas.setBounds(187, 254, 105, 16);
		panelIngreso.add(lblAdIngresarSintomas);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 319, 286, 177);
		panelIngreso.add(scrollPane);
		
		textPaneResultado = new JTextArea();
		scrollPane.setViewportView(textPaneResultado);
		textPaneResultado.setLineWrap(true);
		
		btnLimpiar = new JButton("limpiar ");
		btnLimpiar.setBounds(195, 256, 97, 25);
		miListener limp = new miListener();
		btnLimpiar.addActionListener(limp);
		panelIngreso.add(btnLimpiar);
		
		NombreDeMedicamento = new JPanel();
		NombreDeMedicamento.setBackground(new Color(173, 216, 230));
		NombreDeMedicamento.setBounds(324, 341, 401, 265);
		getContentPane().add(NombreDeMedicamento);
		NombreDeMedicamento.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar medicamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		NombreDeMedicamento.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre del medicamento:");
		lblNewLabel.setBounds(10, 22, 161, 14);
		NombreDeMedicamento.add(lblNewLabel);
		
		textLaMedicina = new JTextField();
		textLaMedicina.setBounds(171, 15, 220, 28);
		NombreDeMedicamento.add(textLaMedicina);
		textLaMedicina.setColumns(10);
		
		btnBuscarMedicina = new JButton("Buscar Medicinas");
		btnBuscarMedicina.setEnabled(true);
		btnBuscarMedicina.setBounds(241, 218, 150, 23);
		NombreDeMedicamento.add(btnBuscarMedicina);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(20, 49, 363, 157);
		NombreDeMedicamento.add(scrollPane_2);
		
		textPaneMedicamentos = new JTextArea();
		scrollPane_2.setViewportView(textPaneMedicamentos);
		textPaneMedicamentos.setLineWrap(true);
		
		JPanel Nombre_De_Enfermedad = new JPanel();
		Nombre_De_Enfermedad.setBackground(new Color(176, 196, 222));
		Nombre_De_Enfermedad.setBounds(322, 80, 401, 261);
		getContentPane().add(Nombre_De_Enfermedad);
		Nombre_De_Enfermedad.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar enfermedad ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Nombre_De_Enfermedad.setLayout(null);
		
		btnBuscarEnfermedad = new JButton("Buscar Enfermedad");
		btnBuscarEnfermedad.setEnabled(true);
		btnBuscarEnfermedad.setBounds(241, 227, 150, 23);
		Nombre_De_Enfermedad.add(btnBuscarEnfermedad);
		
		
		
		JLabel lblBuscarEnfermedad = new JLabel("Nombre de la Enfermedad:");
		lblBuscarEnfermedad.setBounds(10, 32, 161, 14);
		Nombre_De_Enfermedad.add(lblBuscarEnfermedad);
		
		txtLaEnfermedad = new JTextField();
		txtLaEnfermedad.setBounds(183, 24, 208, 30);
		Nombre_De_Enfermedad.add(txtLaEnfermedad);
		txtLaEnfermedad.setColumns(10);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(20, 58, 358, 157);
		Nombre_De_Enfermedad.add(scrollPane_1);
		
		textPaneBuscarEnfermedad = new JTextArea();
		scrollPane_1.setViewportView(textPaneBuscarEnfermedad);
		textPaneBuscarEnfermedad.setLineWrap(true);
		
		JLabel lblPaciene = new JLabel("PACIENTE");
		lblPaciene.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblPaciene.setBounds(32, 18, 225, 49);
		getContentPane().add(lblPaciene);
		
		btnInstruccion = new JButton("Instrucciones de ayuda");
		btnInstruccion.setBounds(379, 29, 322, 23);
		miListener oyente1 = new miListener();
		btnInstruccion.addActionListener(oyente1);
		getContentPane().add(btnInstruccion);
		
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
		
	}
	
	public int habilitarBoton() {
		int habilitado = 0;
		if(comboBoxDolor_de_cabeza.getSelectedItem().equals(" ")||comboBoxDolorEstomago.getSelectedItem().equals(" ")||comboBoxVomito.getSelectedItem().equals(" ")
				||comboBoxDiarrea.getSelectedItem().equals(" ")||comboBoxEstornudo.getSelectedItem().equals(" ")||comboBoxTos.getSelectedItem().equals(" ")
				||comboBoxDolorGeneral.getSelectedItem().equals(" ")||comboBoxFaltaEnergia.getSelectedItem().equals(" "))
		{
			habilitado++;
		}
		
		else if (!comboBoxDolor_de_cabeza.getSelectedItem().equals("")&&!comboBoxDolorEstomago.getSelectedItem().equals(" ")&&!comboBoxVomito.getSelectedItem().equals(" ")
				&& !comboBoxDiarrea.getSelectedItem().equals(" ")&&!comboBoxEstornudo.getSelectedItem().equals(" ")&&!comboBoxTos.getSelectedItem().equals(" ")&&!comboBoxDolorGeneral.getSelectedItem().equals(" ")
				&& !comboBoxFaltaEnergia.getSelectedItem().equals(" ")) {
			habilitado = habilitado +2;
		}
		return habilitado;
	}
	
	
	
	private class miListener implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==btnListo) {
				int habilitarBoton = habilitarBoton();
				if (habilitarBoton == 2) {
					btnIngresoSintomas.setEnabled(true);
					lblAdIngresarSintomas.setText(null);
				}
				else {
					JOptionPane.showMessageDialog(null,"Hay campos inválidos, por favor complete la selección de los síntomas.","Infor box: "+"Advertencia",JOptionPane.INFORMATION_MESSAGE);
					//lblAdIngresarSintomas.setText("Campos invalidos");
					btnIngresoSintomas.setEnabled(false);
				}
				
			}
			if (e.getSource() ==  btnBuscarEnfermedad)
			{
				if(txtLaEnfermedad.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Ingrese el nombre de una enfermedad por favor.","Infor box: "+"Advertencia",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
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
			}
			
			if (e.getSource() == btnLimpiar) {
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
				if(textLaMedicina.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Ingrese el nombre de la medicina por favor.","Infor box: "+"Advertencia",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					textPaneMedicamentos.setText(catalogo.VerMedicina(textLaMedicina.getText()));
				}
				
			}
			if (e.getSource() ==  btnVolver)
			{
	
				frame.dispose();
			
			}
			if(e.getSource() == btnInstruccion)
			{
				JLabel primera = new JLabel("<html><b>Búsqueda de enfermedad por síntomas:</b> <body> En esta sección deberá de<br> seleccionar 'Si' en los síntomas que esté padeciendo y 'No' en los<br>síntomas que no esté padeciendo, luego debe presionar el botón<br>'Listo' y, si ha ingresado los datos correctamente, se le permitirá<br>ingresar los síntomas y obtener sus resultados."
						+ "<br><br><b>Buscar enfermedad:</b> En esta sección deberá ingresar correctamente<br>el nombre de la enfermedad de la que desea saber las especificaciones."
						+ "<br><br><b>Buscar medicamento:</b> En esta sección deberá ingresar correctamente<br>el nombre de la enfermedad de la que desea saber las especificaciones.</body>");
				JOptionPane.showMessageDialog(null,primera,"Infor box: "+"Instrucciones",JOptionPane.PLAIN_MESSAGE);
			}
			
		}
		
		
	}
}
