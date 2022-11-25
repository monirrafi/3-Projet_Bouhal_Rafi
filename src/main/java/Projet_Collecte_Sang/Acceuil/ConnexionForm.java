package Projet_Collecte_Sang.Acceuil;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Projet_Collecte_Sang.dao_Utilisateur.controleurUtilisateur.ControleurUtilisateur;
import Projet_Collecte_Sang.dao_Utilisateur.modelUtilisateur.DaoUtilisateur;
import Projet_Collecte_Sang.dao_Utilisateur.modelUtilisateur.Utilisateur;

public class ConnexionForm extends JFrame {

        private JPanel contentPane;
        private JTextField txtUser;
        private JPasswordField passwordField;
        private ControleurUtilisateur  ctrUtilisateur = ControleurUtilisateur.getControleurUtilisateur();
    
        public ConnexionForm() {
            setBackground(new Color(0, 128, 0));
            //setIconImage(Toolkit.getDefaultToolkit().getImage(ConnexionForm.class.getResource("src/main/java/Projet_Collecte_Sang/Acceuil/logo1.jpg")));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 681, 426);
            contentPane = new JPanel();
            contentPane.setBackground(new Color(0, 128, 0));
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    
            setContentPane(contentPane);
            contentPane.setLayout(null);
            
            JLabel lblConnexion = new JLabel("Connexion");
            lblConnexion.setForeground(new Color(255, 255, 255));
            lblConnexion.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
            lblConnexion.setBounds(194, 10, 199, 71);
            contentPane.add(lblConnexion);
            
            txtUser = new JTextField();
            txtUser.setBounds(256, 113, 300, 30);
            contentPane.add(txtUser);
            txtUser.setColumns(10);
            
            JLabel lblUser = new JLabel("User Name");
            lblUser.setForeground(new Color(255, 255, 255));
            lblUser.setBackground(new Color(240, 240, 240));
            lblUser.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
            lblUser.setBounds(133, 112, 113, 30);
            contentPane.add(lblUser);
            
            JLabel lblMotPasse = new JLabel("Mot de Passe");
            lblMotPasse.setForeground(Color.WHITE);
            lblMotPasse.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
            lblMotPasse.setBackground(SystemColor.menu);
            lblMotPasse.setBounds(133, 167, 113, 30);
            contentPane.add(lblMotPasse);
            
            passwordField = new JPasswordField();
            passwordField.setBounds(256, 169, 300, 30);
            contentPane.add(passwordField);

            JButton btn = new JButton("Connecte");
            //btn.setMargin(new Insets(1,1,1,1));
            btn.setBounds(256, 230, 150, 30);
            //btn.setBackground(new Color(0, 128, 0));
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Utilisateur user = ctrUtilisateur.CtrUtilisateur_GetByChamps("USERNAME", txtUser.getText()).get(0);
                    String userName = user.getNom();
                    String pass = user.getMotPasse();
                    if(txtUser.getText().equals(userName)) {
                        if(passwordField.getText().equals(pass)){
                            
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Le user name est incorrect!\n Essayez une autre fois");
                    }                  
                }
            });
    
            contentPane.add(btn);

        }
    
    }
        

