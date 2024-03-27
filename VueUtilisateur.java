package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Client;
import controleur.Main;
import controleur.Tableau;
import controleur.Utilisateur;


public class VueUtilisateur extends JFrame implements ActionListener
{
	private JButton btRetour = new JButton("Retour au Menu") ; 
	/************************** Panel Ajout Produits *********/
	private JPanel panelInsert = new JPanel(); 
	private JTextField txtNom = new JTextField(); 
	private JTextField txtPrenom = new JTextField(); 
	private JTextField txtEmail = new JTextField(); 
	private JTextField txtPassword = new JTextField(); 
	private JComboBox<String> cbxDroits= new JComboBox<String>();  
	private JComboBox<String> cbxClient= new JComboBox<String>();
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	/************************** Panel Lister Produit *********/
	private JPanel panelLister = new JPanel(); 
	private JTable uneTable ; 
	private JScrollPane uneScroll ; // dérouler
	private Tableau unTableau ; 
	
	/************************** Panel Filtrer Client *********/
	private JPanel panelFiltrer= new JPanel(); 
	private JLabel lbRecherche = new JLabel("Filtrer les Utilisateurs :"); 
	private JTextField txtMot = new JTextField(); 
	private JButton btFiltrer = new JButton("Filtrer");
	
	public VueUtilisateur() {
		this.setTitle("Gestion des Utilisateurs de FILELEC");
		this.setBounds(200, 200, 900, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		/******************** Construction BT Retour **********/
		this.btRetour.setBounds(400, 440, 200, 30);
		this.add(this.btRetour); 
		this.btRetour.addActionListener(this);
		
		/**************** Construction Panel Insert ***************/
		this.panelInsert.setBounds(40, 80, 280, 320);
		this.panelInsert.setBackground(Color.LIGHT_GRAY);
		this.panelInsert.setLayout(new GridLayout(7,2)); // lignes - colonnes matriciel
		this.panelInsert.add(new JLabel("Nom de l'utilisateur : ")); 
		this.panelInsert.add(this.txtNom); 
		this.panelInsert.add(new JLabel("Prénom de l'utilisateur : ")); 
		this.panelInsert.add(this.txtPrenom);
		this.panelInsert.add(new JLabel("Email de l'utilisateur : ")); 
		this.panelInsert.add(this.txtEmail);
		this.panelInsert.add(new JLabel("Mot de passe de l'utilisateur : ")); 
		this.panelInsert.add(this.txtPassword);
		
		this.panelInsert.add(new JLabel(" Droits : ")); 
		this.panelInsert.add(this.cbxDroits);
		this.panelInsert.add(new JLabel("Le client : ")); 
		this.panelInsert.add(this.cbxClient);
		this.panelInsert.add(this.btAnnuler); 
		this.panelInsert.add(this.btEnregistrer); 
		this.add(this.panelInsert); 
		
		/**************** Construction Panel Lister ***************/
		this.panelLister.setBounds(380, 80, 480, 320);
		this.panelLister.setBackground(Color.LIGHT_GRAY);
		this.panelLister.setLayout(null);
		String entetes[] = {"ID User","Nom User", "Prenom User", "Email User", "Mdp User", "Droits", "Le Client"};
		//instanciation de la classe tableau donnees et entetes 
		this.unTableau = new Tableau(this.remplirDonnees(""), entetes);
		//instanciation de la Jtable sur la tableModel unTableau
		this.uneTable = new JTable(unTableau);  // definition table
		
		this.uneScroll = new JScrollPane(this.uneTable);  // table dans scroll 
		this.uneScroll.setBounds(0, 20, 460, 280); // scroll definition
		this.panelLister.add(this.uneScroll); // scroll dans panel
		this.add(this.panelLister);  // panel dans fenetre
		
		/*********************** rendre les boutons *****************/
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
		/***************** REMPLIR LES CBX *************************/
		this.remplirCBXDroits (); 
		this.remplirCBXClient ();
		
		/**************** Construction Panel Filtrer ***************/
		this.panelFiltrer.setBounds(420, 40, 380, 25);
		this.panelFiltrer.setBackground(Color.LIGHT_GRAY);
		this.panelFiltrer.setLayout(new GridLayout(1, 3)); // lignes - colonnes matriciel
		this.panelFiltrer.add(this.lbRecherche); 
		this.panelFiltrer.add(this.txtMot); 
		this.panelFiltrer.add(this.btFiltrer); 
		this.add(this.panelFiltrer);
		this.btFiltrer.addActionListener(this);
		
		//gestion de la modification et de la suppression d'un client 
				this.uneTable.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						if (e.getClickCount() >= 2) {
							int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette utilisateur ?", 
									"Suppression Utilisateur", JOptionPane.YES_NO_OPTION); 
							if (retour == 0)
							{
								JOptionPane.showMessageDialog(null, " Utilisateur supprimé ");
								int indiceLigne = uneTable.getSelectedRow(); 
								int iduser = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
								Main.deleteUtilisateur(iduser);
								unTableau.supprimerLigne(indiceLigne);
							}
						}else if (e.getClickCount() == 1)
						{
							int indiceLigne = uneTable.getSelectedRow(); 
							txtNom.setText(unTableau.getValueAt(indiceLigne,1).toString()); 
							txtPrenom.setText(unTableau.getValueAt(indiceLigne,2).toString()); 
							txtEmail.setText(unTableau.getValueAt(indiceLigne,3).toString()); 
							txtPassword.setText(unTableau.getValueAt(indiceLigne,4).toString()); 
						//	txtNbkm.setText(unTableau.getValueAt(indiceLigne,4).toString()); 
							 
							
							btEnregistrer.setText("Modifier");
						}
						
					}
				});
				
				
		this.setVisible(true);
	}
	
	
	public Object [][] remplirDonnees (String mot)
	{
		//cette fonction transforme l'ArrayList des lesProduits en une matrice d'objets 
		ArrayList<Utilisateur> lesUtilisateurs = Main.selectAllUtilisateur(mot);
		Object [][] matrice = new Object [lesUtilisateurs.size()][8];
		int i = 0; 
		for (Utilisateur unUtilisateur : lesUtilisateurs)
		{
			matrice [i][0] = unUtilisateur.getIduser();
			matrice [i][1] = unUtilisateur.getNom();
			matrice [i][2] = unUtilisateur.getPrenom();
			matrice [i][3] = unUtilisateur.getEmail();
			matrice [i][4] = unUtilisateur.getPassword();
			matrice [i][5] = unUtilisateur.getDroits();
			Client unClient = Main.selectWhereClient(unUtilisateur.getIdClient());
			matrice [i][6] = unClient.getNomc();
			i++;
		}
		return matrice;
	}
	
	public void remplirCBXDroits()
	{
		this.cbxDroits.removeAllItems();
		this.cbxDroits.addItem("admin");
		this.cbxDroits.addItem("user");
		
		
	}
	public void remplirCBXClient ()
	{
		this.cbxClient.removeAllItems();
		for (Client unClient : Main.selectAllClient(""))
		{
			this.cbxClient.addItem(unClient.getIdclient() +" - " + unClient.getNomc()
			+ " - " + unClient.getPrenomc());
		}
	}
	public void viderChamps ()
	{
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtEmail.setText("");
		this.txtPassword.setText("");
		
		this.btEnregistrer.setText("Enregistrer");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btRetour)
		{
			this.dispose(); // desinstanciation de la vue Clients
			Main.rendreVisible(true);
			
		}
		else if (e.getSource() == this.btAnnuler)
		{
			this.viderChamps (); 
		}
		else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Enregistrer"))
		{
			//on récupère les données, on instancie un client, on l'ajoute au bdd 
			String nom = this.txtNom.getText(); 
			String prenom = this.txtPrenom.getText(); 
			String email = this.txtEmail.getText(); 
			String password = this.txtPassword.getText(); 
			
			
			String droits = this.cbxDroits.getSelectedItem().toString(); 
			
			String chaine = this.cbxClient.getSelectedItem().toString(); 
			String tab [] = chaine.split(" - "); 
			int idclient = Integer.parseInt(tab[0]); // case contenant l'id
			
			
			Utilisateur unUtilisateur = new Utilisateur(nom, prenom, email, password, droits,  idclient);
			Main.insertUtilisateur(unUtilisateur);
			JOptionPane.showMessageDialog(this, "Insertion réussie du nouvel utilisateur !");
			this.viderChamps();
			
			//extraction de l'ID du dernier Produit inséré
			unUtilisateur = Main.selectWhereUtilisateur(email);
			//actualisation de l'affichage 
			Client unClient = Main.selectWhereClient(idclient);
			Object ligne[] = {unUtilisateur.getIduser(), nom, prenom, email, password, droits, unClient.getNomc()}; 
			this.unTableau.ajouterLigne(ligne);
		}
		else if (e.getSource() == this.btFiltrer)
		{
			String mot = this.txtMot.getText(); 
			this.unTableau.setDonnees(this.remplirDonnees(mot));
		}
		else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Modifier"))
		{
			int indiceLigne = uneTable.getSelectedRow(); 
			int iduser = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
			//on récupère les données, on instancie un véhicule, on l'ajoute au bdd 
			String nom= this.txtNom.getText(); 
			String prenom = this.txtPrenom.getText(); 
			String email = this.txtEmail.getText(); 
			String password = this.txtPassword.getText(); 
			
			String droits = this.cbxDroits.getSelectedItem().toString(); 
			
			String chaine = this.cbxClient.getSelectedItem().toString(); 
			String tab [] = chaine.split(" - "); 
			int idclient = Integer.parseInt(tab[0]);
			
			
			Utilisateur unUtilisateur = new Utilisateur( nom, prenom, email, password, droits, idclient);
			Main.updateUtilisateur(unUtilisateur);
			//actualisation de l'affichage 
			Client unClient = Main.selectWhereClient(idclient);
			Object ligne[] = {iduser, nom, prenom, email, password, droits, unClient.getNomc()}; 
			this.unTableau.modifierLigne(indiceLigne, ligne);
			JOptionPane.showMessageDialog(this, "Modification réussie de l'utilisateur !");
			this.viderChamps();
		}
		
	}

}