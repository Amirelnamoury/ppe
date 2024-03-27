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

import controleur.Livraison;
import controleur.Main;
import controleur.Tableau;
import controleur.Livreur;


public class VueLivraison extends JFrame implements ActionListener
{
	private JButton btRetour = new JButton("Retour au Menu") ; 
	/************************** Panel Ajout Livraison *********/
	private JPanel panelInsert = new JPanel(); 
	private JTextField txtdatelivrais = new JTextField(); 
	private JTextField txtdesclivrais= new JTextField(); 
	private JComboBox<String> cbxStatut= new JComboBox<String>();  
	private JComboBox<String> cbxTech= new JComboBox<String>();
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	/************************** Panel Lister Livraison *********/
	private JPanel panelLister = new JPanel(); 
	private JTable uneTable ; 
	private JScrollPane uneScroll ; // dérouler
	private Tableau unTableau ; 
	
	/************************** Panel Filtrer Client *********/
	private JPanel panelFiltrer= new JPanel(); 
	private JLabel lbRecherche = new JLabel("Filtrer les Livraisons :"); 
	private JTextField txtMot = new JTextField(); 
	private JButton btFiltrer = new JButton("Filtrer");
	
	public VueLivraison() {
		this.setTitle("Gestion des Livraisons de SAPESTORE");
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
		this.panelInsert.add(new JLabel("Date Livraison : ")); 
		this.panelInsert.add(this.txtdatelivrais); 
		this.panelInsert.add(new JLabel("Desc Livraison: ")); 
		this.panelInsert.add(this.txtdesclivrais);
		this.panelInsert.add(new JLabel(" Statut : ")); 
		this.panelInsert.add(this.cbxStatut);
		this.panelInsert.add(new JLabel("Le Livreur : ")); 
		this.panelInsert.add(this.cbxTech);
		this.panelInsert.add(this.btAnnuler); 
		this.panelInsert.add(this.btEnregistrer); 
		this.add(this.panelInsert); 
		
		/**************** Construction Panel Lister ***************/
		this.panelLister.setBounds(380, 80, 480, 320);
		this.panelLister.setBackground(Color.LIGHT_GRAY);
		this.panelLister.setLayout(null);
		String entetes[] = {"ID Livraison","Date Livrais", "Desc Livrais", "Statut", "Le Livreur"};
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
		this.remplirCBXStatut (); 
		this.remplirCBXCTech ();
		
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
							int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette Livraison ?", 
									"Suppression Livraison", JOptionPane.YES_NO_OPTION); 
							
							if (retour == 0)
							{
								JOptionPane.showMessageDialog(null, " Livraison supprimé ");
								int indiceLigne = uneTable.getSelectedRow(); 
								int idinter = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
								Main.deleteLivraison(idinter);
								unTableau.supprimerLigne(indiceLigne);
								
							}
						}else if (e.getClickCount() == 1)
						{
							int indiceLigne = uneTable.getSelectedRow(); 
							txtdatelivrais.setText(unTableau.getValueAt(indiceLigne,1).toString()); 
							txtdesclivrais.setText(unTableau.getValueAt(indiceLigne,2).toString()); 
							
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
		ArrayList<Livraison> lesLivraisons = Main.selectAllLivraison(mot);
		Object [][] matrice = new Object [lesLivraisons.size()][5];
		int i = 0; 
		for (Livraison unLivraison : lesLivraisons)
		{
			matrice [i][0] = unLivraison.getIdlivraison();
			matrice [i][1] = unLivraison.getDatelivrais();
			matrice [i][2] = unLivraison.getDesclivrais();
			matrice [i][3] = unLivraison.getStatut();
		//	matrice [i][4] = unLivraison.getNbkm();
			Livreur unLivreur = Main.selectWhereLivreur(unLivraison.getIdlivreur());
			matrice [i][4] = unLivreur.getNom();
			i++;
		}
		return matrice;
	}
	
	public void remplirCBXStatut()
	{
		this.cbxStatut.removeAllItems();
		this.cbxStatut.addItem("programée");
		this.cbxStatut.addItem("réalisé");
		this.cbxStatut.addItem("en cours");
		this.cbxStatut.addItem("annulée");
		
	}
	public void remplirCBXCTech ()
	{
		this.cbxTech.removeAllItems();
		for (Livreur unLivreur : Main.selectAllLivreur(""))
		{
			this.cbxTech.addItem(unLivreur.getIdlivreur() +" - " + unLivreur.getNom()
			+ " - " + unLivreur.getPrenom());
		}
	}
	public void viderChamps ()
	{
		this.txtdatelivrais.setText("");
		this.txtdesclivrais.setText("");
		
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
			String datelivrais = this.txtdatelivrais.getText();
		
			String desclivrais = this.txtdesclivrais.getText(); 
			String Statut = this.cbxStatut.getSelectedItem().toString(); 
			
			String chaine = this.cbxTech.getSelectedItem().toString(); 
			String tab [] = chaine.split(" - "); 
			int idlivreur = Integer.parseInt(tab[0]); // case contenant l'id
			
			
			Livraison unLivraison = new Livraison(datelivrais, desclivrais, Statut,  idlivreur);
			Main.insertLivraison(unLivraison);
			JOptionPane.showMessageDialog(this, "Insertion réussie de la nouvelle Livraison !");
			this.viderChamps();
			
			//extraction de l'ID du dernier vehicule inséré
			unLivraison = Main.selectWhereLivraison(desclivrais);
			//actualisation de l'affichage 
			Livreur unLivreur = Main.selectWhereLivreur(idlivreur);
			Object ligne[] = {unLivraison.getIdlivraison(), datelivrais, desclivrais, Statut, unLivreur.getNom()}; 
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
			int idinter = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
			//on récupère les données, on instancie un véhicule, on l'ajoute au bdd 
			String datelivrais = this.txtdatelivrais.getText(); 
			String desclivrais = this.txtdesclivrais.getText(); 
			
			String statut = this.cbxStatut.getSelectedItem().toString(); 
			
			String chaine = this.cbxTech.getSelectedItem().toString(); 
			String tab [] = chaine.split(" - "); 
			int idlivreur = Integer.parseInt(tab[0]);
			
			
			Livraison unLivraison = new Livraison( datelivrais, desclivrais, statut, idlivreur);
			Main.updateLivraison(unLivraison);
			//actualisation de l'affichage 
			Livreur unLivreur = Main.selectWhereLivreur(idlivreur);
			Object ligne[] = {idinter, datelivrais, desclivrais, statut, unLivreur.getNom()}; 
			this.unTableau.modifierLigne(indiceLigne, ligne);
			JOptionPane.showMessageDialog(this, "Modification réussie de l'Livraison !");
			this.viderChamps();
		}
		
	}

}