package Projet_Collecte_Sang.Acceuil;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Projet_Collecte_Sang.actionEvent;
import Projet_Collecte_Sang.dao_Donnneur.vueDonneur.VueDonneur;
import Projet_Collecte_Sang.dao_Utilisateur.controleurUtilisateur.ControleurUtilisateur;
import Projet_Collecte_Sang.dao_Utilisateur.modelUtilisateur.Utilisateur;


public class Acceuil extends JFrame implements actionEvent{

	private JPanel contentPane;
	static int niveau=0;
	private JButton btnCollecte = new JButton();
	private JButton btnDon = new JButton();
	private JButton btnDonneur = new JButton();
	private JButton btnLieu = new JButton();
	private JButton btnRDV = new JButton();
	private JButton btnUtilisateur = new JButton();
	private JButton btnConnecte = new JButton();

	private ControleurUtilisateur  ctrUtilisateur = ControleurUtilisateur.getControleurUtilisateur();
	private VueDonneur vueDonneur;
	public Acceuil() {
		action();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1299, 629);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		/*
		JPanel panel = new JPanel();
		panel.setBounds(215, 123, 1033, 355);
		contentPane.add(panel);
		panel.setLayout(null);*/
		
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
/*        btnConnecte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libirerBoutton(connexionForm());
			}
		});*/
		contentPane.add(btnConnecte);

		btnCollecte.setEnabled(false);
		btnDon.setEnabled(false);
		btnDonneur.setEnabled(false);
		btnLieu.setEnabled(false);
		btnRDV.setEnabled(false);
		btnUtilisateur.setEnabled(false);


	}
	public int connexionForm() {
		JPanel contentPane = new JPanel(new GridLayout(3,1));
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setPreferredSize(new Dimension(600,300));

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
		//txtUser.setBounds(256, 113, 300, 30);
		userPane.add(txtUser);
		//txtUser.setColumns(10);
		
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

		contentPane.add(lblPane);
		contentPane.add(userPane);
		contentPane.add(passPane);

		int res = JOptionPane.showConfirmDialog(null,contentPane,"CONNEXION",JOptionPane.YES_NO_OPTION);
		if(res == JOptionPane.YES_OPTION){
			Utilisateur user = ctrUtilisateur.CtrUtilisateur_GetByChamps("USERNAME", txtUser.getText()).get(0);
			String userName = user.getUserName();
			String pass = user.getMotPasse();
			if(txtUser.getText().equals(userName)) {
				if(passwordField.getText().equals(pass)){
				   Utilisateur utilisateur = ctrUtilisateur.CtrUtilisateur_GetByChamps("USERNAME", txtUser.getText()).get(0);
					//setNiveau(utilisateur.getNiveau());
					niveau = utilisateur.getNiveau();
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
	
		}else {
			btnCollecte.setEnabled(true);
			btnDon.setEnabled(true);
			btnDonneur.setEnabled(true);
			btnLieu.setEnabled(true);
			btnRDV.setEnabled(true);
			btnUtilisateur.setEnabled(true);
	
		}
		
	}
/*============================================================================================================= */
/*										Ecouetuers																*/
/*============================================================================================================= */

public void actionBtn(ActionEvent ev){
	if(ev.getSource()== btnCollecte){

	}else if(ev.getSource()== btnDon){

	}else if(ev.getSource()== btnDonneur){
		vueDonneur = new VueDonneur();
		vueDonneur.setVisible(true);

	}else if(ev.getSource()== btnLieu){

	}else if(ev.getSource()== btnUtilisateur){

	}else if(ev.getSource()== btnRDV){

	}else if(ev.getSource()== btnConnecte){
		libirerBoutton(connexionForm());

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
		
	}

}
