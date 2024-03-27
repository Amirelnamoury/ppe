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
import controleur.Produit;
import controleur.Tableau;

public class VueProduit extends JFrame implements ActionListener 
{
	private JButton btRetour = new JButton("Retour au Menu") ;
	/************************** Panel Ajout Vehicule *********/
	private JPanel panelInsert = new JPanel(); 
	private JTextField txtDescp = new JTextField(); 
	private JTextField txtNomp= new JTextField(); 
	private JTextField txtPrix = new JTextField();
	private JTextField txtStock = new JTextField(); 
	private JTextField txtProv = new JTextField(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	/************************** Panel Lister Vehicule *********/
	private JPanel panelLister = new JPanel(); 
	private JTable uneTable ; 
	private JScrollPane uneScroll ; // dérouler
	private Tableau unTableau ; 
	
	/************************** Panel Filtrer Client *********/
	private JPanel panelFiltrer= new JPanel(); 
	private JLabel lbRecherche = new JLabel("Filtrer les Produits :"); 
	private JTextField txtMot = new JTextField(); 
	private JButton btFiltrer = new JButton("Filtrer");
	
	public VueProduit() {
		this.setTitle("Gestion des Produits");
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
		this.panelInsert.setLayout(new GridLayout(6,2)); // lignes - colonnes matriciel
		this.panelInsert.add(new JLabel("Nom produit : ")); 
		this.panelInsert.add(this.txtNomp); 
		this.panelInsert.add(new JLabel("Description du produit ")); 
		this.panelInsert.add(this.txtDescp);
		this.panelInsert.add(new JLabel("Prix en euros  : ")); 
		this.panelInsert.add(this.txtPrix);
		this.panelInsert.add(new JLabel("Nb Stock : ")); 
		this.panelInsert.add(this.txtStock);
		this.panelInsert.add(new JLabel("Provenance : ")); 
		this.panelInsert.add(this.txtProv);
		
		
		
		this.panelInsert.add(this.btAnnuler); 
		this.panelInsert.add(this.btEnregistrer); 
		this.add(this.panelInsert); 
		
		/**************** Construction Panel Lister ***************/
		this.panelLister.setBounds(380, 80, 480, 320);
		this.panelLister.setBackground(Color.LIGHT_GRAY);
		this.panelLister.setLayout(null);
		String entetes[] = {"ID Produit","Nom Produit", "Desc Produit",  "Prix", "Stock","Provenance" };
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
					int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce produit ?", 
							"Suppression du Produit", JOptionPane.YES_NO_OPTION); 
					if (retour == 0)
					{
						JOptionPane.showMessageDialog(null, "Produit supprimé ");
						int indiceLigne = uneTable.getSelectedRow(); 
						int idProduit = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
						Main.deleteProduit(idProduit);
						unTableau.supprimerLigne(indiceLigne);
					}
				}else if (e.getClickCount() == 1)
				{
					int indiceLigne = uneTable.getSelectedRow(); 
					txtNomp.setText(unTableau.getValueAt(indiceLigne,1).toString()); 
					txtDescp.setText(unTableau.getValueAt(indiceLigne,2).toString()); 
					
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
	ArrayList<Produit> lesProduits = Main.selectAllProduit(mot);
	Object [][] matrice = new Object [lesProduits.size()][6];
	int i = 0; 
	for (Produit unProduit : lesProduits)
	{
		matrice [i][0] = unProduit.getIdproduit();
		matrice [i][1] = unProduit.getNomp();
		matrice [i][2] = unProduit.getDescp();
		matrice [i][3] = unProduit.getPrix();
		matrice [i][4] = unProduit.getStock();
		matrice [i][5] = unProduit.getProvenance();
		
	//	Client unClient = Main.selectWhereClient(unVehicule.getIdClient());
	//	matrice [i][5] = unClient.getNom();
		i++;
	}
	return matrice;
	}
	
	/*public void remplirCBXEnergie ()
	{
	this.cbxEnergie.removeAllItems();
	this.cbxEnergie.addItem("gazol");
	this.cbxEnergie.addItem("essence");
	this.cbxEnergie.addItem("électrique");
	this.cbxEnergie.addItem("hybride");
	this.cbxEnergie.addItem("autre");
	}
	public void remplirCBXClient ()
	{
	this.cbxClient.removeAllItems();
	for (Client unClient : Main.selectAllClient(""))
	{
		this.cbxClient.addItem(unClient.getIdclient() +" - " + unClient.getNom()
		+ " - " + unClient.getPrenom());
	}
	} */
	public void viderChamps ()
	{
	
	this.txtNomp.setText("");
	this.txtDescp.setText("");
	this.txtPrix.setText("");
	this.txtStock.setText("");
	this.txtProv.setText("");
	this.btEnregistrer.setText("Enregistrer");
	}
		
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btRetour)
		{
			this.dispose(); //on tue la vue Clients 
			Main.rendreVisible(true);
			
		}
		else if (e.getSource() == this.btAnnuler)
		{
			this.viderChamps (); 
		}
		else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Enregistrer"))
		{
			//on récupère les données, on instancie un client, on l'ajoute au bdd 
			String nomp = this.txtNomp.getText(); 
			String descp = this.txtDescp.getText();
			String provenance = this.txtProv.getText(); 
			int prix=0; 
			try {
				prix= Integer.parseInt(this.txtPrix.getText());
			}
			catch (NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie pour le prix ");
				this.txtPrix.setBackground(Color.red);
				
			}
			int stock=0;
			try {
				stock= Integer.parseInt(this.txtStock.getText());
			}
			catch (NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie du stock");
				this.txtStock.setBackground(Color.red);
				
			}
			
			
		    if(prix==0 || stock==0)
			{
				JOptionPane.showMessageDialog(this, "Vérifiez les données saisies" );
				this.txtPrix.setBackground(Color.white);
				this.txtStock.setBackground(Color.white);
				
				this.viderChamps();
			}
		    
		    
			
		  
			
			else {
				
			Produit unProduit = new Produit(nomp, descp, prix, stock,provenance);
			Main.insertProduit(unProduit);
			JOptionPane.showMessageDialog(this, "Insertion réussie du nouveau produit !");
			
			
			
			//extraction de l'ID du dernier client inséré
			unProduit = Main.selectWhereProduit(nomp);
			//actualisation de l'affichage 
			if (unProduit != null) {
			    // Actualise l'affichage avec les détails du produit
			    Object ligne[] = {unProduit.getIdproduit(), nomp, descp, prix, stock, provenance}; 
			    this.unTableau.ajouterLigne(ligne);
			} else {
			    // Gère le cas où aucun produit n'a été récupéré avec le nom spécifié
			    JOptionPane.showMessageDialog(this, "Erreur lors de la récupération du produit !");
			}}
		    
		    
		}
		else if (e.getSource() == this.btFiltrer)
		{
			String mot = this.txtMot.getText(); 
			this.unTableau.setDonnees(this.remplirDonnees(mot));
		}
		else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Modifier"))
		{
			int indiceLigne = uneTable.getSelectedRow(); 
			int idProduit = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
			//on récupère les données, on instancie un client, on l'ajoute au bdd 
			String nomp = this.txtNomp.getText(); 
			String descp = this.txtDescp.getText(); 
			String provenance = this.txtProv.getText();
			int prix=0; 
			try {
				prix= Integer.parseInt(this.txtPrix.getText());
			}
			catch (NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie pour le prix ");
				this.txtPrix.setBackground(Color.red);
				
			}
			int stock=0;
			try {
				stock= Integer.parseInt(this.txtStock.getText());
			}
			catch (NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie du stock");
				this.txtStock.setBackground(Color.red);
			
				
			}
			
			if(prix==0 || stock==0)
			{
				JOptionPane.showMessageDialog(this, "Vérifiez les données saisies" );
				this.txtPrix.setBackground(Color.white);
				this.txtStock.setBackground(Color.white);
				
				this.viderChamps();
			}
			
			else {
				
			Produit unProduit = new Produit(idProduit, nomp,descp, prix, stock, provenance);
			Main.updateProduit(unProduit);
			//actualisation de l'affichage 
			Object ligne[] = {idProduit, nomp, descp, prix, stock,provenance}; 
			this.unTableau.modifierLigne(indiceLigne, ligne);
			this.txtPrix.setBackground(Color.GREEN);
			this.txtStock.setBackground(Color.GREEN);
			JOptionPane.showMessageDialog(this, "Modification réussie du produit !");
			this.txtPrix.setBackground(Color.white);
			this.txtStock.setBackground(Color.white);
			
			this.viderChamps();
			
			}
		}
		
		
	}

}
