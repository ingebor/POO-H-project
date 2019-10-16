import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextPane;

public class MenuDoctor {

	private JFrame frame;
	private JTextField txtnombremed;
	private JTextField txtpreciomed;
	private JTextField txtingestionmed;
	private JTextField txtmedtipo;
	private JTextField txtdosismed;
	private JTextField txtenfermedadmed;
	private JTextField txtnotasmed;
	private JTextField txtnombreenf;
	private JTextField txtmedicamentoenf;
	private JTextField txtnotasenf;
	private JButton btnAgregarMed;
	private JComboBox cmbdolorcabezaenf;
	private JComboBox cmbdolorestomagoenf;
	private JComboBox cmbvomitoenf;
	private JComboBox cmbdiarreaenf;
	private JComboBox cmbestornudosenf;
	private JComboBox cmbtosenf;
	private JComboBox cmbdolorcuerpoenf;
	private JComboBox cmbfaltaenergiaenf;
	private JButton btnAgregarEnf;
	private JComboBox cmbDolorEstomagoA;
	private JComboBox cmbDolorCabezaA;
	private JComboBox cmbVomitoA;
	private JComboBox cmbDiarreaA;
	private JComboBox cmbEstornudosA;
	private JComboBox cmbTosA;
	private JComboBox cmbFaltaEnergiaA;
	private JComboBox cmbDolorCuerpo;
	private static MenuDoctor window;
	
	CatalogoSalud catalogo = new CatalogoSalud();
	Enfermedad enfermedad = new Enfermedad();
	Medicina medicina = new Medicina();
	private JTextField tfNombreActuaMed;
	private JTextField tfActuaPrecio;
	private JTextField tfActuaIngestion;
	private JTextField tfActuaTipo;
	private JTextField tfDosisActua;
	private JTextField tfEnfMedActua;
	private JButton btnBuscar;
	private JButton btnActualizar;
	private JButton btnBuscarEnf;
	private JButton btnActualizacionA;
	private JTextPane tpActuaMed;
	private JTextField tfNombreEnfA;
	private JTextField tfMedicamentoA;
	private JTextField textNotasEnfA;
	
	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		
		
		window = new MenuDoctor();
		window.frame.setVisible(true);	
	}

	/**
	 * Create the application.
	 */
	public MenuDoctor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1300, 616);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//Primer panel para ingresar un medicamento
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Agregar Medicina", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setBounds(6, 38, 301, 398);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 32, 56, 16);
		panel_1.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(12, 59, 56, 16);
		panel_1.add(lblPrecio);
		
		JLabel lblIngestion = new JLabel("Ingestion:");
		lblIngestion.setBounds(12, 86, 69, 16);
		panel_1.add(lblIngestion);
		
		JLabel lblNewLabel = new JLabel("Tipo de");
		lblNewLabel.setBounds(12, 113, 56, 16);
		panel_1.add(lblNewLabel);
		
		JLabel lblMedicamento_1 = new JLabel("medicamento:");
		lblMedicamento_1.setBounds(12, 128, 93, 16);
		panel_1.add(lblMedicamento_1);
		
		JLabel lblDosis = new JLabel("Dosis: ");
		lblDosis.setBounds(12, 155, 56, 16);
		panel_1.add(lblDosis);
		
		JLabel lblEnfermedad = new JLabel("Enfermedad:");
		lblEnfermedad.setBounds(12, 182, 93, 16);
		panel_1.add(lblEnfermedad);
		
		JLabel lblNotasAdicionales = new JLabel("Notas adicionales: ");
		lblNotasAdicionales.setBounds(12, 215, 153, 16);
		panel_1.add(lblNotasAdicionales);
		
		//Nombre del medicamento
		txtnombremed = new JTextField();
		txtnombremed.setBounds(125, 29, 173, 22);
		panel_1.add(txtnombremed);
		txtnombremed.setColumns(10);
		
		//Precio del medicamento
		txtpreciomed = new JTextField();
		txtpreciomed.setBounds(125, 59, 173, 22);
		panel_1.add(txtpreciomed);
		txtpreciomed.setColumns(10);
		
		//Ingestion del medicamento
		txtingestionmed = new JTextField();
		txtingestionmed.setBounds(125, 86, 173, 22);
		panel_1.add(txtingestionmed);
		txtingestionmed.setColumns(10);
		
		//Tipo de medicamento
		txtmedtipo = new JTextField();
		txtmedtipo.setBounds(125, 120, 173, 22);
		panel_1.add(txtmedtipo);
		txtmedtipo.setColumns(10);
		
		//Dosis de medicamento
		txtdosismed = new JTextField();
		txtdosismed.setBounds(125, 155, 173, 22);
		panel_1.add(txtdosismed);
		txtdosismed.setColumns(10);
		
		//Enfermedad relacionada a medicamento
		txtenfermedadmed = new JTextField();
		txtenfermedadmed.setBounds(125, 182, 173, 22);
		panel_1.add(txtenfermedadmed);
		txtenfermedadmed.setColumns(10);
		
		//Notas adicionales del medicamento
		txtnotasmed = new JTextField();
		txtnotasmed.setBounds(12, 242, 286, 76);
		panel_1.add(txtnotasmed);
		txtnotasmed.setColumns(10);
		
		//Boton para agregar el medicamento
		btnAgregarMed = new JButton("Agregar");
		btnAgregarMed.setBounds(200, 342, 97, 25);
		MiListener oyente1 = new MiListener();
		btnAgregarMed.addActionListener(oyente1);
		panel_1.add(btnAgregarMed);
		
		
		//Ingresar datos de enfermedad
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Agregar Enfermedad", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_2.setBackground(new Color(176, 224, 230));
		panel_2.setBounds(322, 38, 302, 398);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNombre_1 = new JLabel("Nombre: ");
		lblNombre_1.setBounds(12, 30, 107, 16);
		panel_2.add(lblNombre_1);
		
		JLabel lblDolorDeCabeza = new JLabel("Dolor de cabeza:");
		lblDolorDeCabeza.setBounds(12, 57, 107, 16);
		panel_2.add(lblDolorDeCabeza);
		
		JLabel lblDolorDeEstomago = new JLabel("Dolor de estomago: ");
		lblDolorDeEstomago.setBounds(12, 84, 118, 16);
		panel_2.add(lblDolorDeEstomago);
		
		JLabel lblVomito = new JLabel("Vomito:");
		lblVomito.setBounds(12, 111, 56, 16);
		panel_2.add(lblVomito);
		
		JLabel lblDiarrea = new JLabel("Diarrea: ");
		lblDiarrea.setBounds(153, 111, 56, 16);
		panel_2.add(lblDiarrea);
		
		JLabel lblEstornudos = new JLabel("Estornudos:");
		lblEstornudos.setBounds(12, 138, 76, 16);
		panel_2.add(lblEstornudos);
		
		JLabel lblTos = new JLabel("Tos:");
		lblTos.setBounds(163, 138, 56, 16);
		panel_2.add(lblTos);
		
		JLabel lblDolorDeCuerpo = new JLabel("Dolor de cuerpo: ");
		lblDolorDeCuerpo.setBounds(12, 165, 107, 16);
		panel_2.add(lblDolorDeCuerpo);
		
		JLabel lblNewLabel_1 = new JLabel("Falta de energia:");
		lblNewLabel_1.setBounds(12, 198, 107, 16);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblMedicamento_2 = new JLabel("Medicamento:");
		lblMedicamento_2.setBounds(12, 225, 93, 16);
		panel_2.add(lblMedicamento_2);
		
		JLabel lblNotasAdicionales_1 = new JLabel("Notas adicionales:");
		lblNotasAdicionales_1.setBounds(12, 252, 118, 16);
		panel_2.add(lblNotasAdicionales_1);
		
		//Nombre de la enfermedad
		txtnombreenf = new JTextField();
		txtnombreenf.setBounds(83, 27, 207, 22);
		panel_2.add(txtnombreenf);
		txtnombreenf.setColumns(10);
		
		//Dolor de cabeza
		cmbdolorcabezaenf = new JComboBox();
		cmbdolorcabezaenf.setBounds(128, 57, 66, 22);
		panel_2.add(cmbdolorcabezaenf);
		cmbdolorcabezaenf.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		//Dolor de estomago
		cmbdolorestomagoenf = new JComboBox();
		cmbdolorestomagoenf.setBounds(128, 84, 66, 22);
		panel_2.add(cmbdolorestomagoenf);
		cmbdolorestomagoenf.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		//Vomito
		cmbvomitoenf = new JComboBox();
		cmbvomitoenf.setBounds(83, 111, 60, 22);
		panel_2.add(cmbvomitoenf);
		cmbvomitoenf.setModel(new DefaultComboBoxModel(new String[] {"Si", "No\t\t"}));
		
		//Diarrea
		cmbdiarreaenf = new JComboBox();
		cmbdiarreaenf.setBounds(215, 108, 64, 22);
		panel_2.add(cmbdiarreaenf);
		cmbdiarreaenf.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		//Estornudos
		cmbestornudosenf = new JComboBox();
		cmbestornudosenf.setBounds(83, 138, 60, 22);
		panel_2.add(cmbestornudosenf);
		cmbestornudosenf.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		//Tos
		cmbtosenf = new JComboBox();
		cmbtosenf.setBounds(215, 135, 64, 22);
		panel_2.add(cmbtosenf);
		cmbtosenf.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		//Dolor de cuerpo
		cmbdolorcuerpoenf = new JComboBox();
		cmbdolorcuerpoenf.setBounds(128, 165, 66, 22);
		panel_2.add(cmbdolorcuerpoenf);
		cmbdolorcuerpoenf.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		//Falta de energia
		cmbfaltaenergiaenf = new JComboBox();
		cmbfaltaenergiaenf.setBounds(128, 195, 66, 22);
		panel_2.add(cmbfaltaenergiaenf);
		cmbfaltaenergiaenf.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		//Medicamento relacionado a enfermedad
		txtmedicamentoenf = new JTextField();
		txtmedicamentoenf.setBounds(93, 225, 197, 22);
		panel_2.add(txtmedicamentoenf);
		txtmedicamentoenf.setColumns(10);
		
		//Notas adicionales de enfermedad
		txtnotasenf = new JTextField();
		txtnotasenf.setBounds(12, 279, 278, 67);
		panel_2.add(txtnotasenf);
		txtnotasenf.setColumns(10);
		
		//Boton para agregar enfermedad
		btnAgregarEnf = new JButton("Agregar");
		btnAgregarEnf.setBounds(194, 357, 97, 25);
		MiListener oyente2 = new MiListener();
		btnAgregarEnf.addActionListener(oyente2);
		panel_2.add(btnAgregarEnf);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio volver = new Inicio();
				volver.main(null);
				window.frame.dispose();
			}
		});
		btnVolver.setBounds(600, 532, 117, 29);
		panel.add(btnVolver);
		
		JLabel lblMedicoFunciones = new JLabel("MEDICO - FUNCIONES DE ADMINISTRADOR");
		lblMedicoFunciones.setBounds(230, 17, 293, 16);
		panel.add(lblMedicoFunciones);
		
		JPanel panelActuaMed = new JPanel();
		panelActuaMed.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Actualizar Medicina", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panelActuaMed.setBackground(new Color(135, 206, 250));
		panelActuaMed.setBounds(636, 38, 288, 398);
		panel.add(panelActuaMed);
		panelActuaMed.setLayout(null);
		
		JLabel lblNombreMedActua = new JLabel("Ingrese el nombre de la medicina y pulse buscar:");
		lblNombreMedActua.setBounds(10, 26, 268, 14);
		panelActuaMed.add(lblNombreMedActua);
		
		tfNombreActuaMed = new JTextField();
		tfNombreActuaMed.setBounds(10, 51, 160, 27);
		panelActuaMed.add(tfNombreActuaMed);
		tfNombreActuaMed.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(180, 50, 89, 23);
		panelActuaMed.add(btnBuscar);
		btnBuscar.addActionListener(oyente1);
		
		JLabel lblAtributos = new JLabel("Atributos de la medicina:");
		lblAtributos.setBounds(10, 82, 200, 14);
		panelActuaMed.add(lblAtributos);
		
		JLabel lblActuaPrecioMed = new JLabel("Precio:");
		lblActuaPrecioMed.setBounds(10, 101, 46, 14);
		panelActuaMed.add(lblActuaPrecioMed);
		
		tfActuaPrecio = new JTextField();
		tfActuaPrecio.setBounds(93, 98, 185, 27);
		panelActuaMed.add(tfActuaPrecio);
		tfActuaPrecio.setColumns(10);
		
		JLabel lblIngestionActua = new JLabel("Ingestion:");
		lblIngestionActua.setBounds(10, 128, 64, 14);
		panelActuaMed.add(lblIngestionActua);
		
		tfActuaIngestion = new JTextField();
		tfActuaIngestion.setBounds(93, 124, 185, 27);
		panelActuaMed.add(tfActuaIngestion);
		tfActuaIngestion.setColumns(10);
		
		JLabel lblTipoDeActua = new JLabel("Tipo de\r\n");
		lblTipoDeActua.setBounds(10, 153, 69, 14);
		panelActuaMed.add(lblTipoDeActua);
		
		JLabel lblmedicamentoActua = new JLabel("medicamento:");
		lblmedicamentoActua.setBounds(10, 168, 81, 14);
		panelActuaMed.add(lblmedicamentoActua);
		
		tfActuaTipo = new JTextField();
		tfActuaTipo.setBounds(93, 157, 185, 27);
		panelActuaMed.add(tfActuaTipo);
		tfActuaTipo.setColumns(10);
		
		JLabel lblDosisActua = new JLabel("Dosis: ");
		lblDosisActua.setBounds(10, 193, 46, 14);
		panelActuaMed.add(lblDosisActua);
		
		tfDosisActua = new JTextField();
		tfDosisActua.setBounds(93, 185, 185, 27);
		panelActuaMed.add(tfDosisActua);
		tfDosisActua.setColumns(10);
		
		JLabel lblEnfermedadMedActua = new JLabel("Enfermedad:");
		lblEnfermedadMedActua.setBounds(10, 218, 81, 14);
		panelActuaMed.add(lblEnfermedadMedActua);
		
		tfEnfMedActua = new JTextField();
		tfEnfMedActua.setBounds(93, 212, 185, 27);
		panelActuaMed.add(tfEnfMedActua);
		tfEnfMedActua.setColumns(10);
		
		JLabel lblNotasActuaMed = new JLabel("Notas Adicionales:");
		lblNotasActuaMed.setBounds(10, 247, 123, 14);
		panelActuaMed.add(lblNotasActuaMed);
		
		tpActuaMed = new JTextPane();
		tpActuaMed.setBounds(10, 270, 268, 74);
		panelActuaMed.add(tpActuaMed);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(189, 355, 89, 23);
		panelActuaMed.add(btnActualizar);
		btnActualizar.setEnabled(false);
		
		JPanel panelActualizacionEnf = new JPanel();
		panelActualizacionEnf.setBounds(942, 38, 300, 398);
		panel.add(panelActualizacionEnf);
		panelActualizacionEnf.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Actualizar Enfermedad", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panelActualizacionEnf.setBackground(Color.ORANGE);
		panelActualizacionEnf.setLayout(null);
		
		JLabel lblNombreEnfA = new JLabel("Ingrese el nombre de la enfermedad");
		lblNombreEnfA.setBounds(10, 13, 231, 16);
		panelActualizacionEnf.add(lblNombreEnfA);
		
		tfNombreEnfA = new JTextField();
		tfNombreEnfA.setBounds(0, 33, 160, 28);
		panelActualizacionEnf.add(tfNombreEnfA);
		tfNombreEnfA.setColumns(10);
		
		JLabel lblSintomas = new JLabel("Sintomas de la enfermedad:");
		lblSintomas.setBounds(0, 61, 185, 16);
		panelActualizacionEnf.add(lblSintomas);
		
		JLabel lblDolorDeCabezaA = new JLabel("Dolor de cabeza:");
		lblDolorDeCabezaA.setBounds(10, 85, 97, 16);
		panelActualizacionEnf.add(lblDolorDeCabezaA);
		
		JLabel lblDolorDeEstomagoA = new JLabel("Dolor de estomago:");
		lblDolorDeEstomagoA.setBounds(10, 114, 114, 16);
		panelActualizacionEnf.add(lblDolorDeEstomagoA);
		
		JLabel lblVomitoA = new JLabel("Vomito:");
		lblVomitoA.setBounds(10, 143, 56, 16);
		panelActualizacionEnf.add(lblVomitoA);
		
		JLabel lblDiarreaA = new JLabel("Diarrea:");
		lblDiarreaA.setBounds(140, 149, 56, 16);
		panelActualizacionEnf.add(lblDiarreaA);
		
		JLabel lblEstornudosA = new JLabel("Estornudos:");
		lblEstornudosA.setBounds(-2, 182, 68, 16);
		panelActualizacionEnf.add(lblEstornudosA);
		
		JLabel lblTosA = new JLabel("Tos:");
		lblTosA.setBounds(150, 178, 36, 16);
		panelActualizacionEnf.add(lblTosA);
		
		JLabel lblFaltaDeEnergiaA = new JLabel("Falta de energia:");
		lblFaltaDeEnergiaA.setBounds(8, 206, 130, 16);
		panelActualizacionEnf.add(lblFaltaDeEnergiaA);
		
		JLabel lblMedicamentoA = new JLabel("Medicamento:");
		lblMedicamentoA.setBounds(0, 267, 97, 16);
		panelActualizacionEnf.add(lblMedicamentoA);
		
		tfMedicamentoA = new JTextField();
		tfMedicamentoA.setText("");
		tfMedicamentoA.setBounds(85, 264, 185, 22);
		panelActualizacionEnf.add(tfMedicamentoA);
		tfMedicamentoA.setColumns(10);
		
		JLabel lblNotasAdicionalesA = new JLabel("Notas Adicionales:");
		lblNotasAdicionalesA.setBounds(0, 296, 114, 16);
		panelActualizacionEnf.add(lblNotasAdicionalesA);
		
		textNotasEnfA = new JTextField();
		textNotasEnfA.setBounds(10, 318, 260, 42);
		panelActualizacionEnf.add(textNotasEnfA);
		textNotasEnfA.setColumns(10);
		
		cmbDolorCabezaA = new JComboBox();
		cmbDolorCabezaA.setBounds(108, 82, 47, 22);
		panelActualizacionEnf.add(cmbDolorCabezaA);
		cmbDolorCabezaA.setModel(new DefaultComboBoxModel(new String[] {"si", "no"}));
		
		cmbDolorEstomagoA = new JComboBox();
		cmbDolorEstomagoA.setBounds(130, 114, 55, 22);
		panelActualizacionEnf.add(cmbDolorEstomagoA);
		cmbDolorEstomagoA.setModel(new DefaultComboBoxModel(new String[] {"si ", "no"}));
		
		cmbVomitoA = new JComboBox();
		cmbVomitoA.setBounds(64, 143, 43, 22);
		panelActualizacionEnf.add(cmbVomitoA);
		cmbVomitoA.setModel(new DefaultComboBoxModel(new String[] {"si", "no"}));
		
		cmbDiarreaA = new JComboBox();
		cmbDiarreaA.setBounds(204, 146, 47, 22);
		panelActualizacionEnf.add(cmbDiarreaA);
		cmbDiarreaA.setModel(new DefaultComboBoxModel(new String[] {"si", "no"}));
		
		cmbEstornudosA = new JComboBox();
		cmbEstornudosA.setBounds(76, 179, 48, 22);
		panelActualizacionEnf.add(cmbEstornudosA);
		cmbEstornudosA.setModel(new DefaultComboBoxModel(new String[] {"si", "no"}));
		
		cmbTosA = new JComboBox();
		cmbTosA.setBounds(198, 179, 47, 22);
		panelActualizacionEnf.add(cmbTosA);
		cmbTosA.setModel(new DefaultComboBoxModel(new String[] {"si", "no"}));
		
		cmbFaltaEnergiaA = new JComboBox();
		cmbFaltaEnergiaA.setBounds(115, 207, 56, 22);
		panelActualizacionEnf.add(cmbFaltaEnergiaA);
		cmbFaltaEnergiaA.setModel(new DefaultComboBoxModel(new String[] {"si", "no"}));
		
		cmbDolorCuerpo = new JComboBox();
		cmbDolorCuerpo.setBounds(130, 235, 36, 22);
		panelActualizacionEnf.add(cmbDolorCuerpo);
		cmbDolorCuerpo.setModel(new DefaultComboBoxModel(new String[] {"si", "no"}));
		
		
		btnBuscarEnf = new JButton("Buscar");
		btnBuscarEnf.setBounds(172, 35, 97, 25);
		panelActualizacionEnf.add(btnBuscarEnf);
		btnBuscarEnf.addActionListener(oyente2);
		
		btnActualizacionA = new JButton("Actualizacion");
		btnActualizacionA.setBounds(173, 360, 115, 25);
		panelActualizacionEnf.add(btnActualizacionA);
		btnActualizacionA.setEnabled(false);
		
		JLabel lblDolorDeCuerpoA = new JLabel("Dolor de cuerpo:");
		lblDolorDeCuerpoA.setBounds(10, 238, 97, 16);
		panelActualizacionEnf.add(lblDolorDeCuerpoA);
		
		
	}
	//Listener para realizar acciones luego de presionar los botones
	private class MiListener implements ActionListener{
		@Override 
		public void actionPerformed(java.awt.event.ActionEvent e) {
			//Si se presiona el primer boton
			if (e.getSource()==btnAgregarMed) {
				//medicina.setNombre(txtnombremed.getText());
				//medicina.setDosis(txtdosismed.getText());
				//medicina.setIngestion(txtingestionmed.getText());
				//double pr = Double.parseDouble(txtpreciomed.getText());
				//medicina.setPrecio(pr);
				//medicina.setTiposMedicina(txtmedtipo.getText());
				//medicina.setNotasAdicionales(txtnotasmed.getText());
				//medicina.setNombreEnf(txtenfermedadmed.getText());
				catalogo.agregarMedicina(txtnombremed.getText(),txtpreciomed.getText(),txtingestionmed.getText(), txtmedtipo.getText(), txtdosismed.getText(), txtnotasmed.getText(),txtenfermedadmed.getText());
			}
			if (e.getSource()==btnAgregarEnf) {
				/*enfermedad.setNombre(txtnombreenf.getText());
				enfermedad.setNotasAdicionales(txtnotasenf.getText());
				enfermedad.setNombreMed(txtmedicamentoenf.getText());*/
				
				String diarr = (String)cmbdiarreaenf.getSelectedItem();
				/*boolean diarrea = false;
				if(diarr.equals("Si")) {
					diarrea = true;
				}
				else if (diarr.equals("No")){
					diarrea = false;
				}
				enfermedad.setDiarrea(diarrea);*/
				
				String dolor1 = (String)cmbdolorcabezaenf.getSelectedItem();
				/*boolean dolorC = false;
				if(dolor1.equals("Si")) {
					dolorC = true;
				}
				else if (dolor1.equals("No")) {
					dolorC=false;
				}
				enfermedad.setDolorCabeza(dolorC);*/
				
				String dolor2 = (String)cmbdolorestomagoenf.getSelectedItem();
				/*boolean dolorE = false;
				if (dolor2.equals("Si")) {
					dolorE = true;
				}
				else if (dolor2.equals("No")) {
					dolorE = false;
				}
				enfermedad.setDolorEstomago(dolorE);*/
				
				String dolor3 =(String)cmbdolorcuerpoenf.getSelectedItem();
				/*boolean dolorG = false;
				if (dolor3.equals("Si")) {
					dolorG = true;
				}
				else if (dolor3.equals("No")) {
					dolorG = false;
				}
				enfermedad.setDolorGeneral(dolorG);*/
				
				String est = (String)cmbestornudosenf.getSelectedItem();
				/*boolean estornudo = false;
				if (est.equals("Si")) {
					estornudo = true;
				}
				if (est.equals("No")) {
					estornudo = false;
				}
				enfermedad.setEstornudo(estornudo);*/
				
				String ener = (String)cmbfaltaenergiaenf.getSelectedItem();
				/*boolean energia = false;
				if (ener.equals("Si")) {
					energia = true;
				}
				else if (ener.equals("No")){
					energia = false;
				}
				enfermedad.setFaltaEnergia(energia);*/
			
				String to = (String)cmbtosenf.getSelectedItem();
				/*boolean tos = false;
				if(to.equals("Si")) {
					tos = true;
				}
				else if (to.equals("No")) {
					tos = false;
				}
				enfermedad.setTos(tos);*/
				
				String vom = (String)cmbvomitoenf.getSelectedItem();
				/*boolean vomito = false;
				if (vom.equals("Si")) {
					vomito = true;
				}
				else if (vom.equals("No")) {
					vomito = false;
				}
				enfermedad.setVomito(vomito);*/
				
				catalogo.agregarEnfermedad(txtnombreenf.getText(), dolor1, dolor2, vom, diarr, est, to, dolor3, ener, txtnotasenf.getText(), txtmedicamentoenf.getText());
			}
			if (e.getSource() == btnBuscar) {
				if(!tfNombreActuaMed.getText().equals("")) {
					Medicina buscada = catalogo.buscarMed(tfNombreActuaMed.getText());
					tfActuaPrecio.setText(String.valueOf(buscada.getPrecio()));
					tfActuaIngestion.setText(buscada.getIngestion());
					tfActuaTipo.setText(buscada.getTiposMedicina());
					tfDosisActua.setText(buscada.getDosis());
					tfEnfMedActua.setText(buscada.getNombreEnf());
					tpActuaMed.setText(buscada.getNotasAdicionales());
					
					btnActualizar.setEnabled(true);
					JOptionPane.showMessageDialog(null, "Se le han colocado los valores actuales de los atributos\nen las casillas correspondientes. Cambie los valores que desee\n"
							+ "y de click en actualizar");
				}else {
					JOptionPane.showMessageDialog(null, "No ingreso nombre de la medicina!");
				}
			}
			if (e.getSource() == btnActualizar) {
				try {
				JOptionPane.showMessageDialog(null, catalogo.acualizarMedicina(tfNombreActuaMed.getText(), Double.parseDouble(tfActuaPrecio.getText()), tfActuaIngestion.getText(), 
						tfActuaTipo.getText(), tfDosisActua.getText(), tpActuaMed.getText(), tfEnfMedActua.getText()));
					
				btnActualizar.setEnabled(false);
				}catch(Exception e0) {
					
				}
			}
		}
	}
}
