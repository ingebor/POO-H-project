import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

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
	
	CatalogoSalud catalogo = new CatalogoSalud();
	Enfermedad enfermedad = new Enfermedad();
	Medicina medicina = new Medicina();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
		MenuDoctor window = new MenuDoctor();
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
		frame.setBounds(100, 100, 735, 512);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//Primer panel para ingresar un medicamento
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 327, 465);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMedicamento_3 = new JLabel("Medicamento");
		lblMedicamento_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMedicamento_3.setBounds(38, 13, 115, 16);
		panel_1.add(lblMedicamento_3);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 58, 56, 16);
		panel_1.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(12, 87, 56, 16);
		panel_1.add(lblPrecio);
		
		JLabel lblIngestion = new JLabel("Ingestion:");
		lblIngestion.setBounds(12, 126, 69, 16);
		panel_1.add(lblIngestion);
		
		JLabel lblNewLabel = new JLabel("Tipo de");
		lblNewLabel.setBounds(12, 166, 56, 16);
		panel_1.add(lblNewLabel);
		
		JLabel lblMedicamento_1 = new JLabel("medicamento:");
		lblMedicamento_1.setBounds(12, 189, 93, 16);
		panel_1.add(lblMedicamento_1);
		
		JLabel lblDosis = new JLabel("Dosis: ");
		lblDosis.setBounds(12, 239, 56, 16);
		panel_1.add(lblDosis);
		
		JLabel lblEnfermedad = new JLabel("Enfermedad:");
		lblEnfermedad.setBounds(12, 283, 93, 16);
		panel_1.add(lblEnfermedad);
		
		JLabel lblNotasAdicionales = new JLabel("Notas adicionales: ");
		lblNotasAdicionales.setBounds(12, 336, 118, 16);
		panel_1.add(lblNotasAdicionales);
		
		//Nombre del medicamento
		txtnombremed = new JTextField();
		txtnombremed.setBounds(125, 55, 190, 22);
		panel_1.add(txtnombremed);
		txtnombremed.setColumns(10);
		
		//Precio del medicamento
		txtpreciomed = new JTextField();
		txtpreciomed.setBounds(125, 84, 190, 22);
		panel_1.add(txtpreciomed);
		txtpreciomed.setColumns(10);
		
		//Ingestion del medicamento
		txtingestionmed = new JTextField();
		txtingestionmed.setBounds(125, 123, 190, 22);
		panel_1.add(txtingestionmed);
		txtingestionmed.setColumns(10);
		
		//Tipo de medicamento
		txtmedtipo = new JTextField();
		txtmedtipo.setBounds(125, 186, 190, 22);
		panel_1.add(txtmedtipo);
		txtmedtipo.setColumns(10);
		
		//Dosis de medicamento
		txtdosismed = new JTextField();
		txtdosismed.setBounds(125, 236, 190, 22);
		panel_1.add(txtdosismed);
		txtdosismed.setColumns(10);
		
		//Enfermedad relacionada a medicamento
		txtenfermedadmed = new JTextField();
		txtenfermedadmed.setBounds(125, 280, 190, 22);
		panel_1.add(txtenfermedadmed);
		txtenfermedadmed.setColumns(10);
		
		//Notas adicionales del medicamento
		txtnotasmed = new JTextField();
		txtnotasmed.setBounds(22, 365, 293, 76);
		panel_1.add(txtnotasmed);
		txtnotasmed.setColumns(10);
		
		//Boton para agregar el medicamento
		btnAgregarMed = new JButton("Agregar");
		btnAgregarMed.setBounds(218, 10, 97, 25);
		MiListener oyente1 = new MiListener();
		btnAgregarMed.addActionListener(oyente1);
		panel_1.add(btnAgregarMed);
		
		
		//Ingresar datos de enfermedad
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(329, 0, 388, 465);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblEnfermedad_1 = new JLabel("Enfermedad");
		lblEnfermedad_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEnfermedad_1.setBounds(79, 13, 110, 16);
		panel_2.add(lblEnfermedad_1);
		
		JLabel lblNombre_1 = new JLabel("Nombre: ");
		lblNombre_1.setBounds(12, 48, 56, 16);
		panel_2.add(lblNombre_1);
		
		JLabel lblDolorDeCabeza = new JLabel("Dolor de cabeza:");
		lblDolorDeCabeza.setBounds(12, 82, 107, 16);
		panel_2.add(lblDolorDeCabeza);
		
		JLabel lblDolorDeEstomago = new JLabel("Dolor de estomago: ");
		lblDolorDeEstomago.setBounds(12, 115, 118, 16);
		panel_2.add(lblDolorDeEstomago);
		
		JLabel lblVomito = new JLabel("Vomito:");
		lblVomito.setBounds(12, 153, 56, 16);
		panel_2.add(lblVomito);
		
		JLabel lblDiarrea = new JLabel("Diarrea: ");
		lblDiarrea.setBounds(183, 153, 56, 16);
		panel_2.add(lblDiarrea);
		
		JLabel lblEstornudos = new JLabel("Estornudos:");
		lblEstornudos.setBounds(12, 194, 76, 16);
		panel_2.add(lblEstornudos);
		
		JLabel lblTos = new JLabel("Tos:");
		lblTos.setBounds(189, 194, 56, 16);
		panel_2.add(lblTos);
		
		JLabel lblDolorDeCuerpo = new JLabel("Dolor de cuerpo: ");
		lblDolorDeCuerpo.setBounds(12, 233, 107, 16);
		panel_2.add(lblDolorDeCuerpo);
		
		JLabel lblNewLabel_1 = new JLabel("Falta de energia:");
		lblNewLabel_1.setBounds(12, 266, 107, 16);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblMedicamento_2 = new JLabel("Medicamento:");
		lblMedicamento_2.setBounds(12, 301, 93, 16);
		panel_2.add(lblMedicamento_2);
		
		JLabel lblNotasAdicionales_1 = new JLabel("Notas adicionales:");
		lblNotasAdicionales_1.setBounds(12, 333, 118, 16);
		panel_2.add(lblNotasAdicionales_1);
		
		//Nombre de la enfermedad
		txtnombreenf = new JTextField();
		txtnombreenf.setBounds(156, 42, 220, 22);
		panel_2.add(txtnombreenf);
		txtnombreenf.setColumns(10);
		
		//Dolor de cabeza
		cmbdolorcabezaenf = new JComboBox();
		cmbdolorcabezaenf.setBounds(174, 76, 76, 22);
		panel_2.add(cmbdolorcabezaenf);
		cmbdolorcabezaenf.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		//Dolor de estomago
		cmbdolorestomagoenf = new JComboBox();
		cmbdolorestomagoenf.setBounds(183, 113, 66, 22);
		panel_2.add(cmbdolorestomagoenf);
		cmbdolorestomagoenf.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		//Vomito
		cmbvomitoenf = new JComboBox();
		cmbvomitoenf.setBounds(102, 150, 65, 22);
		panel_2.add(cmbvomitoenf);
		cmbvomitoenf.setModel(new DefaultComboBoxModel(new String[] {"Si", "No\t\t"}));
		
		//Diarrea
		cmbdiarreaenf = new JComboBox();
		cmbdiarreaenf.setBounds(260, 150, 64, 22);
		panel_2.add(cmbdiarreaenf);
		cmbdiarreaenf.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		//Estornudos
		cmbestornudosenf = new JComboBox();
		cmbestornudosenf.setBounds(110, 192, 60, 22);
		panel_2.add(cmbestornudosenf);
		cmbestornudosenf.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		//Tos
		cmbtosenf = new JComboBox();
		cmbtosenf.setBounds(260, 192, 64, 22);
		panel_2.add(cmbtosenf);
		cmbtosenf.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		//Dolor de cuerpo
		cmbdolorcuerpoenf = new JComboBox();
		cmbdolorcuerpoenf.setBounds(182, 230, 66, 22);
		panel_2.add(cmbdolorcuerpoenf);
		cmbdolorcuerpoenf.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		//Falta de energia
		cmbfaltaenergiaenf = new JComboBox();
		cmbfaltaenergiaenf.setBounds(183, 262, 66, 22);
		panel_2.add(cmbfaltaenergiaenf);
		cmbfaltaenergiaenf.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		//Medicamento relacionado a enfermedad
		txtmedicamentoenf = new JTextField();
		txtmedicamentoenf.setBounds(169, 296, 207, 22);
		panel_2.add(txtmedicamentoenf);
		txtmedicamentoenf.setColumns(10);
		
		//Notas adicionales de enfermedad
		txtnotasenf = new JTextField();
		txtnotasenf.setBounds(12, 365, 364, 76);
		panel_2.add(txtnotasenf);
		txtnotasenf.setColumns(10);
		
		//Boton para agregar enfermedad
		btnAgregarEnf = new JButton("Agregar");
		btnAgregarEnf.setBounds(279, 10, 97, 25);
		MiListener oyente2 = new MiListener();
		btnAgregarEnf.addActionListener(oyente2);
		panel_2.add(btnAgregarEnf);
		
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
		}
	}
}
