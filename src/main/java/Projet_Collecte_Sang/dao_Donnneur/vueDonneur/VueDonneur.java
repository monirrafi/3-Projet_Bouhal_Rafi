package Projet_Collecte_Sang.dao_Donnneur.vueDonneur;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Projet_Collecte_Sang.actionEvent;
import Projet_Collecte_Sang.dao_Donnneur.controleurDonneur.ControleurDonneur;
import Projet_Collecte_Sang.dao_Donnneur.modelDonneur.Donneur;


import java.util.*;

public class VueDonneur extends JFrame implements actionEvent{
	private ControleurDonneur ctrDonneur = ControleurDonneur.getControleurDonneur();
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JTextField txtAdresse;
	private JTable table;
	private JTextField txtPoids;
	private JTextField txtGroupage;
	private JTextField txtDateNaissance;
	private JComboBox<String> cmbSexe = new JComboBox<>();

	JButton btnAjouter = new JButton();
	JButton btnModifier = new JButton();
	JButton btnSuprimer = new JButton();
	JButton btnLister = new JButton();
	JComboBox<String> cmbNom = new JComboBox<>();
		
	public VueDonneur() {
		action();
		setBackground(new Color(240, 240, 240));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 431);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitre = new JLabel("Mise à jour des donneurs");
		lblTitre.setBackground(new Color(0, 128, 255));
		lblTitre.setForeground(new Color(255, 255, 0));
		lblTitre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblTitre.setBounds(10, 10, 350, 50);
		contentPane.add(lblTitre);
		
		JPanel paneChamps = new JPanel();
		paneChamps.setBackground(new Color(0, 128, 255));
		paneChamps.setBorder(new LineBorder(new Color(0, 0, 0)));
		paneChamps.setBounds(10, 70, 350, 295);
		contentPane.add(paneChamps);
		paneChamps.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(20, 7, 117, 19);
		lblNom.setFont(new Font("Times New Roman", Font.BOLD, 12));
		paneChamps.add(lblNom);
		
		txtNom = new JTextField();
		txtNom.setBounds(142, 5, 198, 19);
		lblNom.setLabelFor(txtNom);
		paneChamps.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPrenom.setBounds(20, 35, 117, 19);
		paneChamps.add(lblPrenom);
		
		txtPrenom = new JTextField();
		lblPrenom.setLabelFor(txtPrenom);
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(142, 33, 198, 19);
		paneChamps.add(txtPrenom);
		
		JLabel lblTel = new JLabel("Telephone");
		lblTel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTel.setBounds(20, 95, 117, 19);
		paneChamps.add(lblTel);
		
		txtTel = new JTextField();
		lblTel.setLabelFor(txtTel);
		txtTel.setColumns(10);
		txtTel.setBounds(142, 93, 198, 19);
		paneChamps.add(txtTel);
		
		JLabel lblEmail = new JLabel("Courriel");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblEmail.setBounds(20, 128, 117, 19);
		paneChamps.add(lblEmail);
		
		txtEmail = new JTextField();
		lblEmail.setLabelFor(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setBounds(142, 126, 198, 19);
		paneChamps.add(txtEmail);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAdresse.setBounds(20, 159, 117, 19);
		paneChamps.add(lblAdresse);
		
		txtAdresse = new JTextField();
		lblAdresse.setLabelFor(txtAdresse);
		txtAdresse.setColumns(10);
		txtAdresse.setBounds(142, 157, 198, 19);
		paneChamps.add(txtAdresse);
		
		txtPoids = new JTextField();
		txtPoids.setColumns(10);
		txtPoids.setBounds(142, 188, 198, 19);
		paneChamps.add(txtPoids);
		
		JLabel lblPoids = new JLabel("Poids");
		lblPoids.setLabelFor(txtPoids);
		lblPoids.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPoids.setBounds(20, 190, 117, 19);
		paneChamps.add(lblPoids);
		
		JLabel lblGroupage = new JLabel("Groupe Sanguin");
		lblGroupage.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblGroupage.setBounds(20, 219, 117, 19);
		paneChamps.add(lblGroupage);
		
		txtGroupage = new JTextField();
		lblGroupage.setLabelFor(txtGroupage);
		txtGroupage.setColumns(10);
		txtGroupage.setBounds(142, 217, 198, 19);
		paneChamps.add(txtGroupage);
		
		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSexe.setBounds(20, 250, 117, 19);
		paneChamps.add(lblSexe);
		
		JLabel lblDateNaissance = new JLabel("Date Naissance");
		lblDateNaissance.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDateNaissance.setBounds(20, 64, 117, 19);
		paneChamps.add(lblDateNaissance);
		
		txtDateNaissance = new JTextField();
		txtDateNaissance.setColumns(10);
		txtDateNaissance.setBounds(142, 62, 198, 19);
		paneChamps.add(txtDateNaissance);
		
		cmbSexe = new JComboBox<>();
		cmbSexe.setModel(new DefaultComboBoxModel<>(new String[] {"Male", "Femelle"}));
		cmbSexe.setBounds(142, 246, 198, 21);
		paneChamps.add(cmbSexe);
		
		JPanel paneTable = new JPanel();
		paneTable.setBackground(new Color(0, 128, 255));
		paneTable.setBounds(370, 70, 545, 234);
		contentPane.add(paneTable);
		paneTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 525, 187);
		paneTable.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Nom", "Prenom", "Date Naissance", "Telephone", "courriel", "Adresse", "Poids", "Groupe Sanguin", "Sexe"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		
		JPanel panelBouton = new JPanel();
		panelBouton.setBackground(new Color(0, 128, 255));
		panelBouton.setBounds(370, 315, 545, 50);
		contentPane.add(panelBouton);
		panelBouton.setLayout(null);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBackground(new Color(255, 128, 0));
		btnAjouter.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnAjouter.setBounds(132, 5, 85, 35);
		panelBouton.add(btnAjouter);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnModifier.setBackground(new Color(255, 128, 0));
		btnModifier.setBounds(238, 5, 102, 35);
		panelBouton.add(btnModifier);
		
		btnSuprimer = new JButton("Suprimer");
		btnSuprimer.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnSuprimer.setBackground(new Color(255, 128, 0));
		btnSuprimer.setBounds(10, 5, 95, 35);
		panelBouton.add(btnSuprimer);
		
		btnLister = new JButton("Afficher tout");
		btnLister.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnLister.setBackground(new Color(255, 128, 64));
		btnLister.setBounds(757, 25, 158, 35);
		contentPane.add(btnLister);
		
		JLabel lblDonneur = new JLabel("Chercher un donneur");
		lblDonneur.setBackground(new Color(0, 128, 255));
		lblDonneur.setForeground(new Color(255, 255, 0));
		lblDonneur.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDonneur.setBounds(382, 25, 196, 28);
		contentPane.add(lblDonneur);
		
		cmbNom = new JComboBox<>(getListeCBox("id"));
		cmbNom.setBounds(588, 31, 159, 21);
		contentPane.add(cmbNom);
	}

	
/*============================================================================================================= */
/*										Fonctions																*/
/*=============================================================================================================*/
public void viderChamps() {
	txtNom.setText("");
	txtPrenom.setText("");
	txtTel.setText("");
	txtEmail.setText("");
	txtAdresse.setText("");
	txtPoids.setText("");
	txtGroupage.setText("");
	txtDateNaissance.setText("");

	
}
public DefaultTableModel remplirTable(String champs,String valeur) {
	ArrayList<Donneur> listeDonneurs = new ArrayList<>();
	
	if(champs.equals("")){
		listeDonneurs = (ArrayList<Donneur>) ctrDonneur.CtrDonneur_GetAll(); 	

	}else{
		
		listeDonneurs = (ArrayList<Donneur>) ctrDonneur.CtrDonneur_GetByChamps(champs, valeur);

	}
	String[] column = {"Nom", "Prenom", "Date Naissance", "Telephone", "courriel", "Adresse", "Poids", "Groupe Sanguin", "Sexe"};
	DefaultTableModel model = new DefaultTableModel(column,0);
	
	
	for(Donneur donneur:listeDonneurs){
			model.addRow(new Object[]{donneur.getNom(),donneur.getPrenom(),donneur.getDateNaissance(),donneur.getTelphone(),donneur.getEmail(),donneur.getAddresse(),donneur.getPoids(),donneur.getGroupage(),donneur.getSexe()});				
		}
	return model;

}

public  String[] getListeCBox(String choix){

		String[] retour =new String[1];
		ArrayList<String>  listeTmp = new ArrayList<String>();
		for(Donneur donneur:ctrDonneur.CtrDonneur_GetAll()){		
					if(choix.equals("id")) {
						listeTmp.add(String.valueOf(donneur.getNom() + "_" + donneur.getPrenom()));
					}
		}
		retour = new String[listeTmp.size()];
		for(int i=0;i<listeTmp.size();i++){
			retour[i]=listeTmp.get(i);
		}
		
		return retour;
	
	}
/*============================================================================================================= */
/*										S-A-R     															    */
/*=============================================================================================================*/
public void Suprimer() {
	if(!txtNom.getText().equals("") & txtNom.getText() != null ){
		String strCle = txtNom.getText();
		int rep = JOptionPane.showConfirmDialog(null, "Voulez-vous suprimer:\n"+ strCle ,"SOUPRESSION", JOptionPane.YES_NO_OPTION);
		if(rep==0){
		int cle = ctrDonneur.CtrDonneur_GetByChamps("NOM", strCle).get(0).getId();
		ctrDonneur.CtrDonneur_Enlever(cle);

		DefaultComboBoxModel<String> modelNum = new DefaultComboBoxModel<>(getListeCBox("id"));
		cmbNom.removeAll();
		cmbNom.setModel(modelNum);

		//sauvgarder();
		//JOptionPane.showMessageDialog(null,"le Donneur "+ strCle + " est suprimer avec succès");
		}	
	}else{
		JOptionPane.showMessageDialog(null,"Choisissez d'abord le nom!?");
	}
	DefaultTableModel modelTable = remplirTable("","");
	table.setModel(modelTable);
	viderChamps();
}
public void ajouter() {
	if(!txtNom.getText().equals("") & txtNom.getText() != null ){
		String strCle = txtNom.getText();
		if(ctrDonneur.CtrDonneur_GetByChamps("NOM", strCle).size() != 0){
				int rep = JOptionPane.showConfirmDialog(null, "le donneur "+ strCle +"  existe déjà!!\n Voulez-vous le modifier?","AJOUT", JOptionPane.YES_NO_OPTION);
				if(rep==0){
					modifierDonneur();
				}			
		}else{

		Donneur donneur = new Donneur(txtNom.getText(),txtPrenom.getText(),txtDateNaissance.getText(),txtTel.getText(),txtEmail.getText(),txtAdresse.getText(),Double.parseDouble(txtPoids.getText()),txtGroupage.getText(),(String)cmbSexe.getSelectedItem());
		ctrDonneur.CtrDonneur_Enregistrer(donneur);

				DefaultComboBoxModel<String> modelNum = new DefaultComboBoxModel<>(getListeCBox("id"));
				cmbNom.removeAll();
				cmbNom.setModel(modelNum);

				DefaultTableModel modelTable = remplirTable("","");
				table.setModel(modelTable);
			}	
		}else{
			JOptionPane.showMessageDialog(null,"Remplir les champs !?");
		}
		viderChamps();

}

public void modifierDonneur() {
	if(!txtNom.getText().equals("") & txtNom.getText() != null ){
		String strCle = txtNom.getText();
		int rep = JOptionPane.showConfirmDialog(null, "Voulez-vous enregistrer les modifications portées sur :\n"+ strCle ,"MODIFICATION", JOptionPane.YES_NO_OPTION);
		Donneur donneur = ctrDonneur.CtrDonneur_GetByChamps("NOM", strCle).get(0);

		if(rep==JOptionPane.YES_OPTION){
		
			Donneur donneurNew = new Donneur(donneur.getId(),txtNom.getText(),txtPrenom.getText(),txtDateNaissance.getText(),txtTel.getText(),txtEmail.getText(),txtAdresse.getText(),Double.parseDouble(txtPoids.getText()),txtGroupage.getText(),(String)cmbSexe.getSelectedItem());
	
			ctrDonneur.CtrDonneur_Modifier(donneurNew);
	
			DefaultComboBoxModel<String> modelNum = new DefaultComboBoxModel<>(getListeCBox("id"));
			cmbNom.removeAll();
			cmbNom.setModel(modelNum);
		}	
	}else{
		JOptionPane.showMessageDialog(null,"Choisissez d'abord le nom!?");
	}
	DefaultTableModel modelTable = remplirTable("","");
	table.setModel(modelTable);
	viderChamps();



	}
	public void remplirChamps(String nom) {
		Donneur donneur = ctrDonneur.CtrDonneur_GetByChamps("NOM", nom).get(0);
		txtNom.setText(donneur.getNom());
		txtPrenom.setText(donneur.getPrenom());
		txtDateNaissance.setText(donneur.getDateNaissance());
		txtTel.setText(donneur.getTelphone());
		txtEmail.setText(donneur.getEmail());
		txtAdresse.setText(donneur.getAddresse());
		txtPoids.setText(String.valueOf(donneur.getPoids()));
		txtGroupage.setText(donneur.getGroupage());
		cmbSexe.setSelectedItem(donneur.getSexe());
		

	}
	/*============================================================================================================= */
/*										Ecouetuers																*/
/*============================================================================================================= */

	public void actionBtn(ActionEvent ev){
		if(ev.getSource()== btnLister){
			table.setModel(remplirTable("",""));
			viderChamps();

		}else if(ev.getSource()== btnModifier){
			modifierDonneur();

		}else if(ev.getSource()== btnSuprimer){
			Suprimer();

		}else if(ev.getSource()== btnAjouter){
			//String strCle = JOptionPane.showInputDialog(null, "Entrez le nom du Donneur a ajouter");
			ajouter();

		}
	}

	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()== cmbNom){
			String nom = (String)cmbNom.getSelectedItem();
			nom = nom.split("_")[0];
			DefaultTableModel model = remplirTable("NOM",nom);
			table.setModel(model);
			remplirChamps(nom);
			
		}
	}
	@Override
	public void action() {
		cmbNom.addItemListener(this::itemStateChanged);
		btnLister.addActionListener(this::actionBtn);
		btnAjouter.addActionListener(this::actionBtn);
		btnModifier.addActionListener(this::actionBtn);
		btnSuprimer.addActionListener(this::actionBtn);
		
	}

	public ControleurDonneur getControleur() {
		return ctrDonneur;
		
	}

}