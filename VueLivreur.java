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
import controleur.Departement;
import controleur.Main;
import controleur.Tableau;
import controleur.Livreur;
import controleur.Utilisateur;


public class VueLivreur extends JFrame implements ActionListener
{
	private JButton btRetour = new JButton("Retour au Menu") ; 
	/************************** Panel Ajout Livreur *********/
	private JPanel panelInsert = new JPanel(); 
	private JTextField txtNom = new JTextField(); 
	private JTextField txtPrenom = new JTextField(); 
	private JTextField txtEmail = new JTextField(); 
	private JTextField txtMdp = new JTextField(); 
	private JTextField txtnblivraison = new JTextField();
	private JTextField txtDatee = new JTextField(); 
	private JTextField txtDatef = new JTextField(); 
	private JTextField txtCout = new JTextField(); 
	private JTextField txtTel = new JTextField();
	
	
	  
	private JComboBox<String> cbxDepartement= new JComboBox<String>();
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	/************************** Panel Lister Livreur *********/
	private JPanel panelLister = new JPanel(); 
	private JTable uneTable ; 
	private JScrollPane uneScroll ; // dérouler
	private Tableau unTableau ; 
	
	/************************** Panel Filtrer Client *********/
	private JPanel panelFiltrer= new JPanel(); 
	private JLabel lbRecherche = new JLabel("Filtrer les Livreurs :"); 
	private JTextField txtMot = new JTextField(); 
	private JButton btFiltrer = new JButton("Filtrer");
	
	public VueLivreur() {
		this.setTitle("Gestion des Livreurs de SapeStore");
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
		this.panelInsert.setLayout(new GridLayout(11,2)); // lignes - colonnes matriciel
		this.panelInsert.add(new JLabel("Nom du Livreur : ")); 
		this.panelInsert.add(this.txtNom); 
		this.panelInsert.add(new JLabel("Prénom du Livreur : ")); 
		this.panelInsert.add(this.txtPrenom);
		this.panelInsert.add(new JLabel("Email du Livreur : ")); 
		this.panelInsert.add(this.txtEmail);
		this.panelInsert.add(new JLabel("Mot de passe du Livreur : ")); 
		this.panelInsert.add(this.txtMdp);
		
		this.panelInsert.add(new JLabel("Date d'embauche du Livreur : ")); 
		this.panelInsert.add(this.txtDatee);
		this.panelInsert.add(new JLabel("Date fin de contrat du Livreur : ")); 
		this.panelInsert.add(this.txtDatef);
		this.panelInsert.add(new JLabel("Cout horaire en euros :")); 
		this.panelInsert.add(this.txtCout);
		this.panelInsert.add(new JLabel("Nb de livraison du livreur : ")); 
		this.panelInsert.add(this.txtnblivraison);
		this.panelInsert.add(new JLabel("Tel du livreur: ")); 
		this.panelInsert.add(this.txtTel);
		
		
		
		
		
	
		this.panelInsert.add(new JLabel("Le Departement : ")); 
		this.panelInsert.add(this.cbxDepartement);
		this.panelInsert.add(this.btAnnuler); 
		this.panelInsert.add(this.btEnregistrer); 
		this.add(this.panelInsert); 
		
		/**************** Construction Panel Lister ***************/
		this.panelLister.setBounds(380, 80, 480, 320);
		this.panelLister.setBackground(Color.LIGHT_GRAY);
		this.panelLister.setLayout(null);
		String entetes[] = {"ID Livreur","Nom Livreur", "Prenom Livreur", "Email Livreur", "Mdp Livreur", "Nb inter du Livreur", "Date embauche du Livreur", "Date fin du Livreur",  "Cout horaire du Livreur", "Tel du Livreur",  "Departement du Livreur"};
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
		//this.remplirCBXDroits (); 
		this.remplirCBXDepartement ();
		
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
							int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce Livreur ?", 
									"Suppression Livreur", JOptionPane.YES_NO_OPTION); 
							if (retour == 0)
							{
								JOptionPane.showMessageDialog(null, " Livreur supprimé ");
								int indiceLigne = uneTable.getSelectedRow(); 
								int idLivreur = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
								Main.deleteLivreur(idLivreur);
								unTableau.supprimerLigne(indiceLigne);
							}
						}else if (e.getClickCount() == 1)
						{
							int indiceLigne = uneTable.getSelectedRow(); 
							txtNom.setText(unTableau.getValueAt(indiceLigne,1).toString()); 
							txtPrenom.setText(unTableau.getValueAt(indiceLigne,2).toString()); 
							txtEmail.setText(unTableau.getValueAt(indiceLigne,3).toString()); 
							txtMdp.setText(unTableau.getValueAt(indiceLigne,4).toString()); 
							txtnblivraison.setText(unTableau.getValueAt(indiceLigne,5).toString()); 
							txtDatee.setText(unTableau.getValueAt(indiceLigne,6).toString()); 
							txtDatef.setText(unTableau.getValueAt(indiceLigne,7).toString());
							txtCout.setText(unTableau.getValueAt(indiceLigne,8).toString());
							txtTel.setText(unTableau.getValueAt(indiceLigne,9).toString());
							
						
							 
						//	txtNbkm.setText(unTableau.getValueAt(indiceLigne,4).toString()); 
							 
							
							btEnregistrer.setText("Modifier");
						}
						
					}
				});
				
				
		this.setVisible(true);
	}
	
	
	public Object [][] remplirDonnees (String mot)
	{
		//cette fonction transforme l'ArrayList des lesVehicules en une matrice d'objets 
		ArrayList<Livreur> lesLivreurs = Main.selectAllLivreur(mot);
		Object [][] matrice = new Object [lesLivreurs.size()][12];
		int i = 0; 
		for (Livreur unLivreur : lesLivreurs)
		{
			matrice [i][0] = unLivreur.getIdlivreur();
			matrice [i][1] = unLivreur.getNom();
			matrice [i][2] = unLivreur.getPrenom();
			matrice [i][3] = unLivreur.getEmail();
			matrice [i][4] = unLivreur.getMdp();
			matrice [i][5] = unLivreur.getNblivraison();
			matrice [i][6] = unLivreur.getDateembauche();
			matrice [i][7] = unLivreur.getFin_contrat();
			matrice [i][8] = unLivreur.getCouthoraire();
			matrice [i][9] = unLivreur.getTel();
			
			
			
			
			Departement unDepartement = Main.selectWhereDepartement(unLivreur.getIddepartement());
			if(unDepartement != null) {
			matrice [i][10] = unDepartement.getNomd();
			i++;
			}else {
				System.out.println("erreur");
			}
		}
		return matrice;
	}
	
	
	public void remplirCBXDepartement ()
	{
		this.cbxDepartement.removeAllItems();
		for (Departement unDepartement : Main.selectAllDepartement(""))
		{
			this.cbxDepartement.addItem(unDepartement.getIddepartement() +" - " + unDepartement.getCoded()
			+ " - " + unDepartement.getNomd());
		}
	}
	public void viderChamps ()
	{
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtEmail.setText("");
		this.txtMdp.setText("");
		this.txtnblivraison.setText("");
		this.txtDatee.setText("");
		this.txtDatef.setText("");
		this.txtCout.setText("");
		this.txtTel.setText("");
		
		
	
		
		
		
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
			String mdp = this.txtMdp.getText();
			int nblivraison=0; 
			try {
				nblivraison= Integer.parseInt(this.txtnblivraison.getText());
			}
			catch (NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie pour le nombre de livraison ");
				this.txtnblivraison.setBackground(Color.red);
			}
			
			String dateembauche = this.txtDatee.getText(); 
			String fin_contrat  = this.txtDatef.getText(); 
			
			int couthoraire=0;
			try {
				couthoraire= Integer.parseInt(this.txtCout.getText());
			}
			catch (NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie du cout horaire");
				this.txtCout.setBackground(Color.red);
			}
			
			
		    if(nblivraison==0 || couthoraire==0)
			{
				JOptionPane.showMessageDialog(this, "Vérifiez les données saisies" );
				this.txtnblivraison.setBackground(Color.white);
				this.txtCout.setBackground(Color.white);
			}
			
		
		
			String tel = this.txtTel.getText(); 
			
			
			String chaine = this.cbxDepartement.getSelectedItem().toString(); 
			String tab [] = chaine.split(" - "); 
			int iddepartement = Integer.parseInt(tab[0]); // case contenant l'id
			
			
				
			
			
			
			Livreur unLivreur = new Livreur( nom, prenom, email, mdp, dateembauche, fin_contrat , tel, couthoraire, nblivraison, iddepartement);
			Main.insertLivreur(unLivreur);
			JOptionPane.showMessageDialog(this, "Insertion réussie du nouveau Livreur !");
			this.viderChamps();
			
			//extraction de l'ID du dernier vehicule inséré
			unLivreur = Main.selectWhereLivreur(email, mdp);
			//actualisation de l'affichage 
			Departement unDepartement = Main.selectWhereDepartement(iddepartement);
			Object ligne[] = {unLivreur.getIdlivreur(), nom, prenom, email, mdp, dateembauche, fin_contrat , tel, couthoraire, tel, unDepartement.getNomd()}; 
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
			int idLivreur = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
			//on récupère les données, on instancie un véhicule, on l'ajoute au bdd 
			String nom = this.txtNom.getText(); 
			String prenom = this.txtPrenom.getText(); 
			String email = this.txtEmail.getText(); 
			String mdp = this.txtMdp.getText();
			int nblivraison=0; 
			try {
				nblivraison= Integer.parseInt(this.txtnblivraison.getText());
			}
			catch (NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie pour le nombre de livraison ");
				this.txtnblivraison.setBackground(Color.red);
			}
			
			String dateembauche = this.txtDatee.getText(); 
			String fin_contrat  = this.txtDatef.getText(); 
		
			String tel = this.txtTel.getText();  
			
			int couthoraire=0;
			try {
				couthoraire= Integer.parseInt(this.txtCout.getText());
			}
			catch (NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie du cout horaire");
				this.txtCout.setBackground(Color.red);
			}
			
			
		    if(nblivraison==0 || couthoraire==0)
			{
				JOptionPane.showMessageDialog(this, "Vérifiez les données saisies" );
				this.txtnblivraison.setBackground(Color.white);
				this.txtCout.setBackground(Color.white);
			}
			
			
			
			String chaine = this.cbxDepartement.getSelectedItem().toString(); 
			String tab [] = chaine.split(" - "); 
			int iddepartement = Integer.parseInt(tab[0]);
			
			
			Livreur unLivreur = new Livreur(nom, prenom, email, mdp, dateembauche, fin_contrat , tel, couthoraire, nblivraison, iddepartement);
			Main.updateLivreur(unLivreur);
			//actualisation de l'affichage 
			Livreur unDepartement = Main.selectWhereLivreur(iddepartement);
			Object ligne[] = {idLivreur, nom, prenom, email, mdp, nblivraison, dateembauche, fin_contrat , couthoraire, tel, unDepartement.getNom()}; 
			this.unTableau.modifierLigne(indiceLigne, ligne);
			JOptionPane.showMessageDialog(this, "Modification réussie du nouveau Livreur !");
			this.viderChamps();
		}
		
	}

}