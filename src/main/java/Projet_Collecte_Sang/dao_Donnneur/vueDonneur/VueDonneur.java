package Projet_Collecte_Sang.dao_Donnneur.vueDonneur;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import Projet_Collecte_Sang.dao_Donnneur.controleurDonneur.ControleurDonneur;
import Projet_Collecte_Sang.dao_Donnneur.modelDonneur.Donneur;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

public class VueDonneur extends JFrame implements actionEvent{

/*============================================================================================================= */
/*										Declaration															*/
/*=============================================================================================================*/
	static JPanel contentPane = new JPanel();
	static JScrollPane scroll =new JScrollPane();
	private JTable table = new JTable();
	private ControleurDonneur ctrDonneur = ControleurDonneur.getControleurDonneur();


	JComboBox<String> cmbId =new JComboBox<>();
	static JButton btnLister = new JButton("Afficher les donneurs");
	static JButton btnModifierChamps = new JButton("Modifier un champs");
	static JButton btnSuprimer = new JButton("Suprimer un donneur");
	static JButton btnAjouter = new JButton("Ajouter un donneur");
	static JButton btnQuitter = new JButton("Quitter");
	static GridBagConstraints gbc_tlBar;
	static 	JTableHeader entete;

/*============================================================================================================= */
/*										Constructeurs															*/
/*============================================================================================================= */
	public VueDonneur() {
		affichage();
		action();
		
	}
	
	public void affichage() {
		//ImageIcon logo = new ImageIcon(getClass().getResource("src\\main\\java\\Projet_livre\\dao\\images\\biblio.png"));
		//setIconImage(logo.getImage());
		contentPane = new JPanel();
		setTitle("Gestion de la bibliotheque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1550, 700);
		contentPane.setBorder(new EmptyBorder(5, 5, 1, 0));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{266, 62, 0};
		gbl_contentPane.rowHeights = new int[]{21, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		table.setModel(imageTable());
		scroll = new JScrollPane(table);
		cmbId =new JComboBox<>(getListeCBox("Id"));
	
	
		btnStyle(btnLister);
		btnStyle(btnAjouter);
		btnStyle(btnSuprimer);
		btnStyle(btnModifierChamps);
		btnStyle(btnQuitter);
		
		JToolBar tlBar = new JToolBar();
		
		tlBar.setToolTipText("Liste des donneurs");
		tlBar.setForeground(Color.BLACK);
		tlBar.setFont(new Font("Serif", Font.PLAIN, 16));
		tlBar.setBackground(Color.WHITE);
		gbc_tlBar = new GridBagConstraints();
		gbc_tlBar.insets = new Insets(0, 5, 10, 5);
		gbc_tlBar.anchor = GridBagConstraints.NORTHWEST;
		gbc_tlBar.gridx = 0;
		gbc_tlBar.gridy = 0;
		contentPane.add(tlBar, gbc_tlBar);
		
		cmbId.setBackground(new Color(123,104,238));
		cmbId.setForeground(Color.yellow);
		cmbId.setFont( new Font("Serif", Font.BOLD, 20));
		cmbId.setOpaque(true);
	

		
		tlBar.add(btnLister);
		tlBar.add(btnModifierChamps);
		tlBar.add(btnAjouter);
		tlBar.add(btnSuprimer);

		tlBar.add(cmbId);
		tlBar.add(btnQuitter);
		
		scroll.setBackground(new Color(128,128,128));
		gbc_tlBar.gridwidth = 2;
		gbc_tlBar.fill = GridBagConstraints.BOTH;
		gbc_tlBar.gridx = 0;
		gbc_tlBar.gridy = 1;
		contentPane.add(scroll, gbc_tlBar);
	}

/*============================================================================================================= */
/*										Ecouetuers																*/
/*============================================================================================================= */

	public void actionBtn(ActionEvent ev){
		if(ev.getSource()== btnLister){
			//DefaultTableModel model = remplirTable("","0");
			table.setModel(remplirTable("",""));
			

		}else if(ev.getSource()== btnModifierChamps){
			modifierLivre();

		}else if(ev.getSource()== btnSuprimer){
			Suprimer();

		}else if(ev.getSource()== btnAjouter){
			ajouter();

		}else if(ev.getSource()== btnQuitter){
		
			System.exit(0);

		}
		styleTable(new Color(12,128,144), Color.white);
	}

	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()== cmbId){
			DefaultTableModel model = remplirTable("ID_DONNEUR",(String)cmbId.getSelectedItem());
			table.setModel(model);
			styleTable(new Color(123,104,238), Color.yellow);
			
		}
	}
	@Override
	public void action() {
		cmbId.addItemListener(this::itemStateChanged);
		btnLister.addActionListener(this::actionBtn);
		btnAjouter.addActionListener(this::actionBtn);
		btnModifierChamps.addActionListener(this::actionBtn);
		btnSuprimer.addActionListener(this::actionBtn);
		btnQuitter.addActionListener(this::actionBtn);
		
	}

/*============================================================================================================= */
/*										S-A-R     															    */
/*=============================================================================================================*/
public void Suprimer() {
	String strCle = JOptionPane.showInputDialog(null, "Entrez le numéro du livre à modifier");
	int cle= Integer.parseInt(strCle);
	//Livre livreSprimer = new Livre();

	if(ctrDonneur.CtrDonneur_GetById(cle)==null){
			JOptionPane.showMessageDialog(null, "le donneur du numero "+ cle +" n' existe pas!!");
			
	}else{
		ctrDonneur.CtrDonneur_Enlever(cle);

		DefaultComboBoxModel<String> modelNum = new DefaultComboBoxModel<>(getListeCBox("id"));
		cmbId.removeAll();
		cmbId.setModel(modelNum);

		//sauvgarder();
		JOptionPane.showMessageDialog(null,"le livre du numero "+ cle + " est suprimer avec succès");
		DefaultTableModel modelTable = remplirTable("","");
		table.setModel(modelTable);

	}
	
}
public void ajouter() {
	String strCle = JOptionPane.showInputDialog(null, "Entrez le numéro du livre a ajouter");
	int cle= Integer.parseInt(strCle);
	if(ctrDonneur.CtrDonneur_GetById(cle) != null){
			JOptionPane.showMessageDialog(null, "le livre du numéro "+ cle +"  existe déjà!!");
			
	}else{
		ArrayList<String> data = new ArrayList<String>(){{add(strCle);add(null);add(null);add(null);add(null);add(null);}};
		String[] retour = paneString(data,new ArrayList<String>(){{add("Nom");
		add("Prenom");
		add("Date Naissance");
		add("Telephone");
		add("Courriel");
		add("Adresse");
		add("Poids");
		add("Groupe sangaine");
		add("Sexe");}},"                         Entrez les informations du votre nouveau donneur");
		if (retour != null){
			Donneur donneur = new Donneur();
			ctrDonneur.CtrDonneur_Enregistrer(donneur);

			DefaultComboBoxModel<String> modelNum = new DefaultComboBoxModel<>(getListeCBox("id"));
			cmbId.removeAll();
			cmbId.setModel(modelNum);

			DefaultTableModel modelTable = remplirTable("ID_DONNEUR",String.valueOf(cle));
			table.setModel(modelTable);
		}	
	}
//	sauvgarder();

}
public void modifierLivre() {
	//ArrayList<Livre> listeLivres = remplirArrayliste();
	String strCle = JOptionPane.showInputDialog(null, "Entrez le numéro du livre a modifier");
	int cle= Integer.parseInt(strCle);
	Donneur donneur = ctrDonneur.CtrDonneur_GetById(cle);
	if(donneur == null){
			JOptionPane.showMessageDialog(null, "le livre du numéro "+ cle +" n' existe pas!!");
			
	}else{
		
		ArrayList<String> data = new ArrayList<String>(){{add(strCle);
			add(donneur.getNom());
			add(donneur.getPrenom());
			add(donneur.getDateNaissance());
			add(donneur.getTelphone());
			add(donneur.getEmail());
			add(donneur.getAddresse());
			add(String.valueOf(donneur.getPoids()));
			add(donneur.getGroupage());
			add(donneur.getSexe());}};

		String[] retour = paneString(data,new ArrayList<String>(){{add("Nom");
		add("Prenom");
		add("Date Naissance");
		add("Telephone");
		add("Courriel");
		add("Adresse");
		add("Poids");
		add("Groupe sangaine");
		add("Sexe");}},"                         Modifiez les informations du votre donneur");
		if (retour != null){
			Donneur livreModifier = new Donneur();
			ctrDonneur.CtrDonneur_Modifier(livreModifier);
		}
		DefaultComboBoxModel<String> modelNum = new DefaultComboBoxModel<>(getListeCBox("id"));
		cmbId.removeAll();
		cmbId.setModel(modelNum);

		DefaultTableModel modelTable = remplirTable("ID_DONNEUR",String.valueOf(cle));
		table.setModel(modelTable);
}
//	sauvgarder();

}
public String[] paneString(ArrayList<String> data,ArrayList<String> listeChamps,String titre) {
	String[] retour = new String[6];
			Dimension d =new Dimension(350,20);
			Color cl = new Color(102,178,255);
			ArrayList<JTextField> listeJtxt = new ArrayList<>();

			JPanel panePrincipal = new JPanel(new GridBagLayout());
			JPanel gPane = new JPanel(new GridLayout(listeChamps.size()+2,1,0,5));
			GridBagConstraints c = new GridBagConstraints();	
			JLabel lblTitre = new JLabel(titre);
			lblTitre.setFont(new Font("Serif", Font.BOLD, 20));
			lblTitre.setForeground(Color.blue);
				gPane.add(lblTitre);
				for(int i=0;i<listeChamps.size();i++){
					JPanel pane = new JPanel();
					JTextField jtxt = new JTextField(data.get(i));
					jtxt.setPreferredSize(d);
					JLabel lbl = new JLabel(listeChamps.get(i));
					lbl.setPreferredSize(new Dimension(50,20));
					lbl.setLabelFor(jtxt);
					listeJtxt.add(jtxt);
					pane.add(lbl);
					pane.add(jtxt);
					gPane.add(pane);
	
				}
				c.weightx = 0.0;
				c.gridx = 0;
				c.gridy = 0;
				c.gridwidth=1;
				panePrincipal.add(gPane,c);
				
	
			int res = JOptionPane.showConfirmDialog(null,panePrincipal,"Modification Livre",JOptionPane.YES_NO_CANCEL_OPTION);
			if(res == JOptionPane.YES_OPTION){
				for(int i=0;i<listeJtxt.size();i++){
					retour[i]= listeJtxt.get(i).getText();
				}
				
			}else{
				retour = null;
			}  
		//}
	
	
	return retour;        

}

/*============================================================================================================= */
/*										Fonctions																*/
/*=============================================================================================================*/
public int calculerTaille() {
	return ctrDonneur.CtrDonneur_GetAll().size();
}

public DefaultTableModel remplirTable(String champs,String valeur) {
	ArrayList<Donneur> listeDonneurs = new ArrayList<>();
	if(champs.equals("")){
		listeDonneurs = (ArrayList<Donneur>) ctrDonneur.CtrDonneur_GetAll(); 	

	}else{
		listeDonneurs = (ArrayList<Donneur>) ctrDonneur.CtrDonneur_GetByChamps(champs, valeur);

	}
	String[] column = {"Id","Nom","Prenom","Date Naissance","Tel","Courrile","Adresse","Poids","Groupe Sang","Sexe"};
	DefaultTableModel model = new DefaultTableModel(column,0);
	
	
	for(Donneur donneur:listeDonneurs){
			model.addRow(new Object[]{donneur.getId(),donneur.getNom(),donneur.getPrenom(),donneur.getDateNaissance(),donneur.getTelphone(),donneur.getEmail(),donneur.getAddresse(),donneur.getPoids(),donneur.getGroupage(),donneur.getSexe()});				
		}
	return model;

}

public  String[] getListeCBox(String choix){

		String[] retour =new String[1];
		ArrayList<String>  listeTmp = new ArrayList<String>();
		for(Donneur donneur:ctrDonneur.CtrDonneur_GetAll()){		
					if(choix.equals("id")) {
						listeTmp.add(String.valueOf(donneur.getId()));
					}
		}
		retour = new String[listeTmp.size()];
		for(int i=0;i<listeTmp.size();i++){
			retour[i+1]=listeTmp.get(i);
		}
		
		return retour;
	
	}

public DefaultTableModel imageTable() {
	entete = table.getTableHeader();
	entete.setFont(new Font("Serif", Font.BOLD, 20));
	entete.setBackground(Color.orange);//new Color(128,128,128));//new Color(105,105,105));
	entete.setForeground(Color.BLACK);

	String[] column = {"Bienvenue à la gestion d'une bibliothéque "};
	table.setRowHeight(558);
	DefaultTableModel model = new DefaultTableModel(column,0)
	{
		
		public Class getColumnClass(int column)
		{
			switch (column)
			{
				case 0: return Icon.class;
				default: return super.getColumnClass(column);
			}
		}
	};

	ImageIcon img =  new ImageIcon("src\\images\\livre2.jpg");
	model.addRow(new Object[]{img});

	return model;	
}
public void btnStyle(JButton btn){
	btn.setSize(new Dimension(200,20));
	btn.setBackground(new Color(12,128,144));		
	btn.setForeground(Color.white);
	btn.setFont( new Font("Serif", Font.BOLD, 18));
	btn.setOpaque(true);

}

public void styleTable(Color bgColor,Color pColor) {
	JTableHeader entete = table.getTableHeader();
	entete.setFont(new Font("Serif", Font.BOLD, 18));
	entete.setBackground(new Color(128,128,128));//new Color(105,105,105));
	entete.setForeground(Color.white);
	TableColumnModel columnModelEntete = entete.getColumnModel();
	columnModelEntete.getColumn(0).setPreferredWidth(5);
	columnModelEntete.getColumn(1).setPreferredWidth(400);
	columnModelEntete.getColumn(2).setPreferredWidth(5);
	columnModelEntete.getColumn(3).setPreferredWidth(5);
	columnModelEntete.getColumn(4).setPreferredWidth(5);
	columnModelEntete.getColumn(5).setPreferredWidth(100);
	TableColumnModel columnModel = table.getColumnModel();
	columnModel.getColumn(0).setPreferredWidth(5);
	columnModel.getColumn(1).setPreferredWidth(400);
	columnModel.getColumn(2).setPreferredWidth(5);
	columnModel.getColumn(3).setPreferredWidth(5);
	columnModel.getColumn(4).setPreferredWidth(5);
	columnModel.getColumn(5).setPreferredWidth(100);
	table.setBackground(bgColor);
	table.setForeground(pColor);
	table.setRowHeight(20);
	table.setFont(new Font("Serif", Font.BOLD, 18));
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
}

}

