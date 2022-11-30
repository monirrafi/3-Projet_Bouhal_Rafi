package Projet_Collecte_Sang.dao_Collecte.vueCollecte;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Projet_Collecte_Sang.actionEvent;
import Projet_Collecte_Sang.dao_Collecte.controleurCollecte.ControleurCollecte;
import Projet_Collecte_Sang.dao_Collecte.modelCollecte.Collecte;
import Projet_Collecte_Sang.dao_LieuCollecte.controleurLieuCollecte.ControleurLieuCollecte;
import Projet_Collecte_Sang.dao_LieuCollecte.modelLieuCollecte.LieuCollecte;

import java.util.*;

public class VueCollecte extends JFrame implements actionEvent{
	private ControleurCollecte ctrCollecte = ControleurCollecte.getControleurCollecte();
	private ControleurLieuCollecte controleurLieuCollecte = ControleurLieuCollecte.getControleurLieuCollecte();
	private JPanel contentPane;
	private JTextField txtType;
	private JTextField txtDateCollecte;
	private JTextField txtOrganisateur;
	private JTable table;

	JButton btnAjouter = new JButton();
	JButton btnModifier = new JButton();
	JButton btnSuprimer = new JButton();
	JButton btnLister = new JButton();
	JComboBox<String> cmbNom = new JComboBox<>();
	JComboBox<String> cmbLieu = new JComboBox<>();	
	public VueCollecte() {
		action();
		setBackground(new Color(240, 240, 240));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 431);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitre = new JLabel("Mise à jour des Collectes");
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
		
		JLabel lblLieu = new JLabel("Lieu");
		lblLieu.setBounds(20, 7, 117, 19);
		lblLieu.setFont(new Font("Times New Roman", Font.BOLD, 12));
		paneChamps.add(lblLieu);

		ArrayList<LieuCollecte> listelieux = (ArrayList<LieuCollecte>) controleurLieuCollecte.CtrLieuCollecte_GetAll();
		String[] lieuxString = new String[listelieux.size()];
		for(int i=0;i<listelieux.size();i++){
			lieuxString[i]=String.valueOf(listelieux.get(i).getNom());
		}
		
		cmbLieu = new JComboBox<>(lieuxString);
		cmbLieu.setBounds(142, 5, 198, 19);
		lblLieu.setLabelFor(cmbLieu);
		paneChamps.add(cmbLieu);
		//cmbLieu.setColumns(10);
		
/*	
		txtLieu = new JTextField();
		txtLieu.setBounds(142, 5, 198, 19);
		lblLieu.setLabelFor(txtLieu);
		paneChamps.add(txtLieu);
		txtLieu.setColumns(10);
*/		
		JLabel lblType = new JLabel("Type Collecte");
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblType.setBounds(20, 35, 117, 19);
		paneChamps.add(lblType);
		
		txtType = new JTextField();
		lblType.setLabelFor(txtType);
		txtType.setColumns(10);
		txtType.setBounds(142, 35, 198, 19);
		paneChamps.add(txtType);
		
		JLabel lblDateCollecte = new JLabel("Date Collecte");
		lblDateCollecte.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDateCollecte.setBounds(20, 65, 117, 19);
		paneChamps.add(lblDateCollecte);
		
		txtDateCollecte = new JTextField();
		lblDateCollecte.setLabelFor(txtDateCollecte);
		txtDateCollecte.setColumns(10);
		txtDateCollecte.setBounds(142, 65, 198, 19);
		paneChamps.add(txtDateCollecte);
		
		JLabel lblOrganisateur = new JLabel("Organisateur");
		lblOrganisateur.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblOrganisateur.setBounds(20, 95, 117, 19);
		paneChamps.add(lblOrganisateur);
		
		txtOrganisateur = new JTextField();
		lblOrganisateur.setLabelFor(txtOrganisateur);
		txtOrganisateur.setColumns(10);
		txtOrganisateur.setBounds(142, 95, 198, 19);
		paneChamps.add(txtOrganisateur);
		
		
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
				"Lieu", "TYPE COLLECTE", "Date COLLECTE", "ORGANISATEUR"
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
		
		JLabel lblCollecte = new JLabel("Chercher un Collecte");
		lblCollecte.setBackground(new Color(0, 128, 255));
		lblCollecte.setForeground(new Color(255, 255, 0));
		lblCollecte.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCollecte.setBounds(382, 25, 196, 28);
		contentPane.add(lblCollecte);
		
		cmbNom = new JComboBox<>(getListeCBox());
		cmbNom.setBounds(588, 31, 159, 21);
		contentPane.add(cmbNom);
	}

	
/*============================================================================================================= */
/*										Fonctions																*/
/*=============================================================================================================*/
public void viderChamps() {
	//cmbLieu.    setText("");
	txtType.setText("");
	txtDateCollecte.setText("");
	txtOrganisateur.setText("");
}
public DefaultTableModel remplirTable(String champs,String valeur) {
	ArrayList<Collecte> listeCollectes = new ArrayList<>();
	
	if(champs.equals("")){
		listeCollectes = (ArrayList<Collecte>) ctrCollecte.CtrCollecte_GetAll(); 	

	}else{
		
		listeCollectes = (ArrayList<Collecte>) ctrCollecte.CtrCollecte_GetByChamps(champs, valeur);

	}
	String[] column = {"Lieu", "TYPE COLLECTE", "Date COLLECTE", "ORGANISATEUR"};
	DefaultTableModel model = new DefaultTableModel(column,0);
	
	
	for(Collecte collecte:listeCollectes){
			model.addRow(new Object[]{collecte.getLieu(),collecte.getTypeCollecte(),collecte.getDateCollecte(),collecte.getOrganisateur()});				
		}
	return model;

}

public  String[] getListeCBox(){
	//String choix
		String[] retour =new String[1];
		ArrayList<String>  listeTmp = new ArrayList<String>();
		for(Collecte collecte:ctrCollecte.CtrCollecte_GetAll()){		
					//if(choix.equals("id")) {
						listeTmp.add(String.valueOf(collecte.getOrganisateur()));
					//}
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
	if(!txtOrganisateur.getText().equals("") & txtOrganisateur.getText() != null ){
		String strCle = (String)cmbLieu.getSelectedItem();
		int rep = JOptionPane.showConfirmDialog(null, "Voulez-vous suprimer:\n"+ strCle ,"SOUPRESSION", JOptionPane.YES_NO_OPTION);
		if(rep==0){
		int cle = ctrCollecte.CtrCollecte_GetByChamps("ID_LIEU", strCle).get(0).getId();
		ctrCollecte.CtrCollecte_Enlever(cle);

		DefaultComboBoxModel<String> modelNum = new DefaultComboBoxModel<>(getListeCBox());
		cmbNom.removeAll();
		cmbNom.setModel(modelNum);
		}	
	}else{
		JOptionPane.showMessageDialog(null,"Choisissez d'abord le Lieu!?");
	}
	DefaultTableModel modelTable = remplirTable("","");
	table.setModel(modelTable);
	viderChamps();
}
public void ajouter() {
	if(!txtOrganisateur.getText().equals("") & txtOrganisateur.getText() != null ){
		String strCle = (String)cmbLieu.getSelectedItem();
		if(ctrCollecte.CtrCollecte_GetByChamps("ID_LIEU", strCle).size() != 0){
				int rep = JOptionPane.showConfirmDialog(null, "le Collecte "+ strCle +"  existe déjà!!\n Voulez-vous le modifier?","AJOUT", JOptionPane.YES_NO_OPTION);
				if(rep==0){
					modifierCollecte();
				}			
		}else{

		Collecte collecte = new Collecte(Integer.parseInt(strCle),txtType.getText(),txtDateCollecte.getText(),txtOrganisateur.getText());
		ctrCollecte.CtrCollecte_Enregistrer(collecte);

				DefaultComboBoxModel<String> modelNum = new DefaultComboBoxModel<>(getListeCBox());
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

public void modifierCollecte() {
	if(!txtOrganisateur.getText().equals("") & txtOrganisateur.getText() != null ){
		String strCle = (String)cmbLieu.getSelectedItem();
		int rep = JOptionPane.showConfirmDialog(null, "Voulez-vous enregistrer les modifications portées sur :\n"+ strCle ,"MODIFICATION", JOptionPane.YES_NO_OPTION);
		Collecte collecte = ctrCollecte.CtrCollecte_GetByChamps("ID_LIEU", strCle).get(0);

		if(rep==JOptionPane.YES_OPTION){
		
			Collecte collecteNew = new Collecte(collecte.getId(),Integer.parseInt(strCle),txtType.getText(),txtDateCollecte.getText(),txtOrganisateur.getText());
	
			ctrCollecte.CtrCollecte_Modifier(collecteNew);
	
			DefaultComboBoxModel<String> modelNum = new DefaultComboBoxModel<>(getListeCBox());
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
		Collecte collecte = ctrCollecte.CtrCollecte_GetByChamps("ID_COLLECTE", nom).get(0);
		cmbLieu.setSelectedItem(String.valueOf(collecte.getLieu()));
		txtType.setText(collecte.getTypeCollecte());
		txtDateCollecte.setText(collecte.getDateCollecte());
		txtOrganisateur.setText(collecte.getOrganisateur());
	}
/*============================================================================================================= */
/*										Ecouetuers																*/
/*============================================================================================================= */

	public void actionBtn(ActionEvent ev){
		if(ev.getSource()== btnLister){
			table.setModel(remplirTable("",""));
			viderChamps();

		}else if(ev.getSource()== btnModifier){
			modifierCollecte();

		}else if(ev.getSource()== btnSuprimer){
			Suprimer();

		}else if(ev.getSource()== btnAjouter){
			ajouter();

		}
	}

	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()== cmbNom){
			String nom = (String)cmbNom.getSelectedItem();
			DefaultTableModel model = remplirTable("ORGANISATEUR",nom);
			table.setModel(model);
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					String lieuChoisi =  model.getValueAt( table.getSelectedRow(),table.getSelectedColumn()).toString();
					remplirChamps(lieuChoisi);
					//System.out.println(lieuChoisi);
					
				}
			  });
			//remplirChamps(nom);
			viderChamps();
			
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
	public ControleurCollecte getControleur(){
		return ctrCollecte;
	}


}