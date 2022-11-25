package Projet_Collecte_Sang.Acceuil;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Acceuil extends JFrame {

	private JPanel contentPane;

	public Acceuil() {
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
		
		JButton btnRDV = new JButton("Rendez-Vous");
		btnRDV.setMargin(new Insets(1, 1, 1, 1));
		btnRDV.setForeground(Color.WHITE);
		btnRDV.setBackground(new Color(128, 0, 0));
		btnRDV.setBounds(45, 186, 145, 32);
		contentPane.add(btnRDV);
		
		JButton btnDon = new JButton("Les dons");
		btnDon.setMargin(new Insets(1, 1, 1, 1));
		btnDon.setForeground(Color.WHITE);
		btnDon.setBackground(new Color(128, 0, 0));
		btnDon.setBounds(45, 233, 145, 32);
		contentPane.add(btnDon);
		
		JButton btnLieu = new JButton("les lieux de collecte");
		btnLieu.setMargin(new Insets(1, 1, 1, 1));
		btnLieu.setForeground(Color.WHITE);
		btnLieu.setBackground(new Color(128, 0, 0));
		btnLieu.setBounds(45, 285, 145, 32);
		contentPane.add(btnLieu);
		
		JButton btnCollecte = new JButton("Les collectes");
		btnCollecte.setMargin(new Insets(1, 1, 1, 1));
		btnCollecte.setForeground(Color.WHITE);
		btnCollecte.setBackground(new Color(128, 0, 0));
		btnCollecte.setBounds(45, 327, 145, 32);
		contentPane.add(btnCollecte);
		
		JButton btnConnecte = new JButton("Connexion");
		btnConnecte.setMargin(new Insets(1, 1, 1, 1));
		btnConnecte.setForeground(Color.WHITE);
		btnConnecte.setBackground(new Color(128, 0, 0));
		btnConnecte.setBounds(45, 503, 145, 32);
        btnConnecte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                ConnexionForm frm = new ConnexionForm();
                frm.setVisible(true);
			}
		});
		contentPane.add(btnConnecte);
		
		JButton btnUtilisateur = new JButton("Utilisateurs");
		btnUtilisateur.setMargin(new Insets(1, 1, 1, 1));
		btnUtilisateur.setForeground(Color.WHITE);
		btnUtilisateur.setBackground(new Color(128, 0, 0));
		btnUtilisateur.setBounds(45, 369, 145, 32);
		contentPane.add(btnUtilisateur);
		
		JButton btnDonneurs = new JButton("Donneurs");
		btnDonneurs.setMargin(new Insets(1, 1, 1, 1));
		btnDonneurs.setForeground(Color.WHITE);
		btnDonneurs.setBackground(new Color(128, 0, 0));
		btnDonneurs.setBounds(45, 123, 145, 32);
		contentPane.add(btnDonneurs);

        btnCollecte.setEnabled(false);
        btnDon.setEnabled(false);
        btnDonneurs.setEnabled(false);
        btnUtilisateur.setEnabled(false);
        btnLieu.setEnabled(false);
        btnRDV.setEnabled(false);


	}


}
