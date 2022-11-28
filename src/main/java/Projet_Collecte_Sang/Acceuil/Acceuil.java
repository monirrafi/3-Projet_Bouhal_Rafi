package Projet_Collecte_Sang.Acceuil;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Projet_Collecte_Sang.actionEvent;
import Projet_Collecte_Sang.dao_Collecte.modelCollecte.Collecte;
import Projet_Collecte_Sang.dao_Collecte.vueCollecte.VueCollecte;
import Projet_Collecte_Sang.dao_Donnneur.modelDonneur.Donneur;
import Projet_Collecte_Sang.dao_Donnneur.vueDonneur.VueDonneur;
import Projet_Collecte_Sang.dao_Utilisateur.modelUtilisateur.Utilisateur;
import Projet_Collecte_Sang.dao_Utilisateur.vueUtilisateur.FormulaireUser;


public class Acceuil extends JFrame implements actionEvent{
//	private ControleurUtilisateur  ctrUtilisateur = ControleurUtilisateur.getControleurUtilisateur();
	
	private VueDonneur vueDonneur;
	private FormulaireUser vueUtilisateur= new FormulaireUser();
	private VueCollecte vueCollecte;

	private JPanel contentPane;
	private JPanel paneNiveau2;
	private JTable tableNiveau2; 
	static int niveau=0;
	static String objNiveau2 ="donneur";
	static String champsNiveau2 = "Nom";


	private JComboBox<String> cmbNomNiveau2 = new JComboBox<>();

	private JButton btnCollecte = new JButton();
	private JButton btnDon = new JButton();
	private JButton btnDonneur = new JButton();
	private JButton btnLieu = new JButton();
	private JButton btnRDV = new JButton();
	private JButton btnUtilisateur = new JButton();
	private JButton btnConnecte = new JButton();

	private JButton btnRetour= new JButton();
	private JButton btnCollecteNiveau2 = new JButton();
	private JButton btnDonNiveau2 = new JButton();
	private JButton btnDonneurNiveau2 = new JButton();
	private JButton btnLieuNiveau2 = new JButton();
	private JButton btnRDVNiveau2 = new JButton();
	private JLabel lblTitreNiveau2 = new JLabel();


	JButton btnListerNiveau2 = new JButton();

	public Acceuil() {
		action();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon("src\\main\\java\\Projet_Collecte_Sang\\Acceuil\\logo1.jpg"));
		lblNewLabel_1.setBounds(215, 123, 1100, 300);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Donner du sang sauver des vies");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel.setBounds(215, 31, 1033, 67);
		contentPane.add(lblNewLabel);
		
		btnRDV = new JButton("Rendez-Vous");
		btnRDV.setMargin(new Insets(1, 1, 1, 1));
		btnRDV.setForeground(Color.WHITE);
		btnRDV.setBackground(new Color(128, 0, 0));
		btnRDV.setBounds(45, 186, 145, 32);
		contentPane.add(btnRDV);
		
		btnDon = new JButton("Les dons");
		btnDon.setMargin(new Insets(1, 1, 1, 1));
		btnDon.setForeground(Color.WHITE);
		btnDon.setBackground(new Color(128, 0, 0));
		btnDon.setBounds(45, 233, 145, 32);
		contentPane.add(btnDon);
		
		btnLieu = new JButton("les lieux de collecte");
		btnLieu.setMargin(new Insets(1, 1, 1, 1));
		btnLieu.setForeground(Color.WHITE);
		btnLieu.setBackground(new Color(128, 0, 0));
		btnLieu.setBounds(45, 285, 145, 32);
		contentPane.add(btnLieu);
		
		btnCollecte = new JButton("Les collectes");
		btnCollecte.setMargin(new Insets(1, 1, 1, 1));
		btnCollecte.setForeground(Color.WHITE);
		btnCollecte.setBackground(new Color(128, 0, 0));
		btnCollecte.setBounds(45, 327, 145, 32);
		contentPane.add(btnCollecte);
		
		
		btnUtilisateur = new JButton("Utilisateurs");
		btnUtilisateur.setMargin(new Insets(1, 1, 1, 1));
		btnUtilisateur.setForeground(Color.WHITE);
		btnUtilisateur.setBackground(new Color(128, 0, 0));
		btnUtilisateur.setBounds(45, 369, 145, 32);
		contentPane.add(btnUtilisateur);
		
		btnDonneur = new JButton("Donneurs");
		btnDonneur.setMargin(new Insets(1, 1, 1, 1));
		btnDonneur.setForeground(Color.WHITE);
		btnDonneur.setBackground(new Color(128, 0, 0));
		btnDonneur.setBounds(45, 123, 145, 32);
		contentPane.add(btnDonneur);
	
		
		btnConnecte = new JButton("Connexion");
		btnConnecte.setMargin(new Insets(1, 1, 1, 1));
		btnConnecte.setForeground(Color.WHITE);
		btnConnecte.setBackground(new Color(128, 0, 0));
		btnConnecte.setBounds(45, 503, 145, 32);
		contentPane.add(btnConnecte);

		btnCollecte.setEnabled(false);
		btnDon.setEnabled(false);
		btnDonneur.setEnabled(false);
		btnLieu.setEnabled(false);
		btnRDV.setEnabled(false);
		btnUtilisateur.setEnabled(false);


	}
	public int connexionForm() {
		JPanel connexioPane = new JPanel(new GridLayout(3,1));
		connexioPane.setBackground(new Color(0, 128, 0));
		connexioPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		connexioPane.setPreferredSize(new Dimension(600,300));

		JPanel lblPane = new JPanel();
		lblPane.setBackground(new Color(0, 128, 0));
		JLabel lblConnexion = new JLabel("Connexion");
		lblConnexion.setForeground(new Color(255, 255, 255));
		lblConnexion.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));

		lblPane.add(lblConnexion);
		JPanel userPane = new JPanel();
		userPane.setBackground(new Color(0, 128, 0));
		JLabel lblUser = new JLabel("User Name");
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setBackground(new Color(240, 240, 240));
		lblUser.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblUser.setPreferredSize(new Dimension(300,30));
		userPane.add(lblUser);
		JTextField txtUser = new JTextField();
		txtUser.setPreferredSize(new Dimension(300,30));
		userPane.add(txtUser);
		
		JPanel passPane = new JPanel();
		passPane.setBackground(new Color(0, 128, 0));
		JLabel lblMotPasse = new JLabel("Mot de Passe");
		lblMotPasse.setForeground(Color.WHITE);
		lblMotPasse.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblMotPasse.setBackground(SystemColor.menu);
		lblMotPasse.setPreferredSize(new Dimension(300,30));
		passPane.add(lblMotPasse);
		
		JPasswordField passwordField = new JPasswordField();
		//passwordField.setBounds(256, 169, 300, 30);
		passwordField.setPreferredSize(new Dimension(300,30));
		passPane.add(passwordField);

		connexioPane.add(lblPane);
		connexioPane.add(userPane);
		connexioPane.add(passPane);

		int res = JOptionPane.showConfirmDialog(null,connexioPane,"CONNEXION",JOptionPane.YES_NO_CANCEL_OPTION);
		if(res == JOptionPane.YES_OPTION){
			ArrayList<Utilisateur> liste = (ArrayList<Utilisateur>)vueUtilisateur.getControleur().CtrUtilisateur_GetByChamps("USERNAME", txtUser.getText());
			if(liste.size() != 0){
				Utilisateur user = liste.get(0);
				String userName = user.getUserName();
				String pass = user.getMotPasse();
				if(txtUser.getText().equals(userName)) {
					if(passwordField.getText().equals(pass)){
					Utilisateur utilisateur = vueUtilisateur.getControleur().CtrUtilisateur_GetByChamps("USERNAME", txtUser.getText()).get(0);
						niveau = utilisateur.getNiveau();
					}else{
						JOptionPane.showMessageDialog(null, "Le mot de passe de " + userName + " est incorrect ou vide!\n Essayez une autre fois");
						
					}
				}else{
					JOptionPane.showMessageDialog(null, "Le user name est incorrect ou vide!\n Essayez une autre fois");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Le user name est incorrect!\n Essayez une autre fois");

			}                  

		}  

		return niveau;
	}
	public void libirerBoutton(int entree) {
		if(entree == 3){
			btnDonneur.setEnabled(true);
			btnRDV.setEnabled(true);

		}else if(entree==1){
			btnCollecte.setEnabled(true);
			btnDon.setEnabled(true);
			btnDonneur.setEnabled(true);
			btnLieu.setEnabled(true);
			btnRDV.setEnabled(true);
			btnUtilisateur.setEnabled(true);
			
		}else if(entree==2){
			paneNiveau2 = getPaneNiveau2();
			setContentPane(paneNiveau2);
			action();
            revalidate();
 
		}else{
			setContentPane(contentPane);
			action();
            revalidate();

		}
		
	}
	public JPanel getPaneNiveau2() {
		JPanel pane = new JPanel();
		pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		pane.setLayout(null);
		
		lblTitreNiveau2 = new JLabel("Les informations des donneurs");
		lblTitreNiveau2.setBounds(168, 10, 865, 62);
		lblTitreNiveau2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		pane.add(lblTitreNiveau2);
		
		JLabel lblChercher = new JLabel("Choisir");
		lblChercher.setBounds(850, 40, 159, 21);
		lblChercher.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		pane.add(lblChercher);

		cmbNomNiveau2 = new JComboBox<>(getListeCBox("donneur"));
		cmbNomNiveau2.setBounds(900, 40, 159, 21);
		pane.add(cmbNomNiveau2);

		btnListerNiveau2 = new JButton("Afficher tout");
		btnListerNiveau2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnListerNiveau2.setBackground(new Color(255, 128, 64));
		btnListerNiveau2.setBounds(1090, 31, 158, 35);
		pane.add(btnListerNiveau2);

		JPanel paneBoutonNiveau2 = new JPanel();
		paneBoutonNiveau2.setBounds(10, 571, 1243, 32);
		pane.add(paneBoutonNiveau2);
		
		btnDonneurNiveau2 = new JButton("les donneurs");
		paneBoutonNiveau2.add(btnDonneurNiveau2);
		
		btnDonNiveau2 = new JButton("Les dons");
		paneBoutonNiveau2.add(btnDonNiveau2);
		
		btnCollecteNiveau2 = new JButton("Les collectes");
		paneBoutonNiveau2.add(btnCollecteNiveau2);
		
		btnLieuNiveau2 = new JButton("Les lieux des collectes");
		paneBoutonNiveau2.add(btnLieuNiveau2);
		
		btnRDVNiveau2 = new JButton("Les rendez-vous");
		paneBoutonNiveau2.add(btnRDVNiveau2);
		
		btnRetour = new JButton("Retour au menu");
		paneBoutonNiveau2.add(btnRetour);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 1245, 488);
		pane.add(scrollPane);
		
		tableNiveau2 = new JTable();
		scrollPane.setViewportView(tableNiveau2);
		tableNiveau2.setForeground(new Color(0, 0, 0));
		tableNiveau2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Nom", "Prenom", "Date Naissance", "Telephone", "courriel", "Adresse", "Poids", "Groupe Sanguin", "Sexe"
			}
		));



		return pane;
		
	}
/*============================================================================================================= */
/*										Fonctions																*/
/*=============================================================================================================*/

public DefaultTableModel remplirTable(String champs,String valeur,String obj) {
	DefaultTableModel model = new DefaultTableModel();
	if(obj.equals("donneur")){
		ArrayList<Donneur> listeDonneurs = new ArrayList<>();
		if(champs.equals("")){
			listeDonneurs = (ArrayList<Donneur>) vueDonneur.getControleur().CtrDonneur_GetAll(); 	
		}else{
			listeDonneurs = (ArrayList<Donneur>) vueDonneur.getControleur().CtrDonneur_GetByChamps(champs, valeur);
		}
		String[] column = {"Nom", "Prenom", "Date Naissance", "Telephone", "courriel", "Adresse", "Poids", "Groupe Sanguin", "Sexe"};
		model = new DefaultTableModel(column,0);
		for(Donneur donneur:listeDonneurs){
				model.addRow(new Object[]{donneur.getNom(),donneur.getPrenom(),donneur.getDateNaissance(),donneur.getTelphone(),donneur.getEmail(),donneur.getAddresse(),donneur.getPoids(),donneur.getGroupage(),donneur.getSexe()});				
			}
	}else if(obj.equals("collecte")){
		ArrayList<Collecte> listeCollectes = new ArrayList<>();
		if(champs.equals("")){
			listeCollectes = (ArrayList<Collecte>) vueCollecte.getControleur().CtrCollecte_GetAll(); 	
		}else{
			listeCollectes = (ArrayList<Collecte>) vueCollecte.getControleur().CtrCollecte_GetByChamps(champs, valeur);
		}
		String[] column = {"Lieu", "TYPE COLLECTE", "Date COLLECTE", "ORGANISATEUR"};
		model = new DefaultTableModel(column,0);
		for(Collecte collecte:listeCollectes){
				model.addRow(new Object[]{collecte.getLieu(),collecte.getTypeCollecte(),collecte.getDateCollecte(),collecte.getOrganisateur()});				
			}
		}
	return model;

}

public  String[] getListeCBox(String obj){

		String[] retour =new String[1];
		ArrayList<String>  listeTmp = new ArrayList<String>();

		if(obj.equals("donneur")) {
			for(Donneur donneur:vueDonneur.getControleur().CtrDonneur_GetAll()){		
							listeTmp.add(String.valueOf(donneur.getNom()));
			}
				
		}else if(obj.equals("collecte")) {
			for(Collecte collecte:vueCollecte.getControleur().CtrCollecte_GetAll()){		
							listeTmp.add(String.valueOf(collecte.getLieu()));
			}
				
		}		
		retour = new String[listeTmp.size()];
		for(int i=0;i<listeTmp.size();i++){
			retour[i]=listeTmp.get(i);
		}
		
		return retour;
	
	}

/*============================================================================================================= */
/*										Ecouetuers																*/
/*============================================================================================================= */

public void actionBtn(ActionEvent ev){
	if(ev.getSource()== btnCollecte){
		vueCollecte = new VueCollecte();
		vueCollecte.action();
		vueCollecte.setVisible(true);

	}else if(ev.getSource()== btnDon){

	}else if(ev.getSource()== btnDonneur){
		vueDonneur = new VueDonneur();
		vueDonneur.action();
		vueDonneur.setVisible(true);

	}else if(ev.getSource()== btnLieu){

	}else if(ev.getSource()== btnUtilisateur){
		vueUtilisateur = new FormulaireUser();
		vueUtilisateur.action();
		vueUtilisateur.setVisible(true);

	}else if(ev.getSource()== btnRDV){

	}else if(ev.getSource()== btnConnecte){
		if(niveau == 0){
			niveau = connexionForm();
		}
		libirerBoutton(niveau);

	}else if(ev.getSource()== btnRetour){
		//System.exit(0);
		setContentPane(contentPane);
		revalidate();
/*=========================================Niveau 2=================================================== */		

	}if(ev.getSource()== btnCollecteNiveau2){
		objNiveau2="collecte";
		champsNiveau2="ID_LIEU";
		lblTitreNiveau2.setText("les informations des collectes");
		tableNiveau2.setModel(remplirTable("","", objNiveau2));
		DefaultComboBoxModel<String> modelCmb = new DefaultComboBoxModel<>(getListeCBox("collecte"));
		cmbNomNiveau2.removeAll();
		cmbNomNiveau2.setModel(modelCmb);


	}else if(ev.getSource()== btnDonNiveau2){
		System.exit(0);

	}else if(ev.getSource()== btnDonneurNiveau2){
		objNiveau2="donneur";
		champsNiveau2="Nom";
		lblTitreNiveau2.setText("les informations des donneurs");
		tableNiveau2.setModel(remplirTable("","", objNiveau2));
		DefaultComboBoxModel<String> modelCmb = new DefaultComboBoxModel<>(getListeCBox("donneur"));
		cmbNomNiveau2.removeAll();
		cmbNomNiveau2.setModel(modelCmb);

	}else if(ev.getSource()== btnLieuNiveau2){
		System.exit(0);

	}else if(ev.getSource()== btnRDVNiveau2){
		System.exit(0);

	}
	
	if(ev.getSource()== btnListerNiveau2){
		tableNiveau2.setModel(remplirTable("","",objNiveau2));

	}
}
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()== cmbNomNiveau2){
			String nom = (String)cmbNomNiveau2.getSelectedItem();
			//nom = nom.split("_")[0];
			DefaultTableModel model = remplirTable(champsNiveau2,nom,objNiveau2);
			tableNiveau2.setModel(model);
			
		}

	}

@Override
	public void action() {
		btnCollecte.addActionListener(this::actionBtn);
		btnDon.addActionListener(this::actionBtn);
		btnDonneur.addActionListener(this::actionBtn);
		btnLieu.addActionListener(this::actionBtn);
		btnRDV.addActionListener(this::actionBtn);
		btnUtilisateur.addActionListener(this::actionBtn);
		btnConnecte.addActionListener(this::actionBtn);

		btnRetour.addActionListener(this::actionBtn);
		btnCollecteNiveau2.addActionListener(this::actionBtn);
		btnDonNiveau2.addActionListener(this::actionBtn);
		btnDonneurNiveau2.addActionListener(this::actionBtn);
		btnLieuNiveau2.addActionListener(this::actionBtn);
		btnRDVNiveau2.addActionListener(this::actionBtn);
		btnListerNiveau2.addActionListener(this::actionBtn);
		cmbNomNiveau2.addItemListener(this::itemStateChanged);

		
	}

}
