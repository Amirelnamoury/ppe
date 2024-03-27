package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import controleur.Client;
import controleur.Main;
import controleur.Tableau;

public class VueClients extends JFrame implements ActionListener
{
	private JButton btRetour = new JButton("Retour au Menu") ; 
	/************************** Panel Ajout Client *********/
	private JPanel panelInsert = new JPanel(); 
	private JTextField txtNom = new JTextField(); 
	private JTextField txtPrenom = new JTextField(); 
	private JTextField txtIdentifiants = new JTextField();
	private JTextField txtMdp = new JTextField();
	
	private JTextField txtAdresse= new JTextField(); 
	private JTextField txtVille = new JTextField(); 
	private JTextField txtCp = new JTextField(); 
	private JTextField txtTel = new JTextField(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	/************************** Panel Lister Client *********/
	private JPanel panelLister = new JPanel(); 
	private JTable uneTable ; 
	private JScrollPane uneScroll ;
	private Tableau unTableau ; 
	
	/************************** Panel Filtrer Client *********/
	private JPanel panelFiltrer= new JPanel(); 
	private JLabel lbRecherche = new JLabel("Filtrer les clients par mot clé : "); 
	private JTextField txtMot = new JTextField(); 
	private JButton btFiltrer = new JButton("Filtrer");
	
	public VueClients() {
		this.setTitle("Gestion des clients de SAPESTORE");
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
		this.panelInsert.setLayout(new GridLayout(9,2));
		this.panelInsert.add(new JLabel("Nom : ")); 
		this.panelInsert.add(this.txtNom); 
		this.panelInsert.add(new JLabel("Prénom : ")); 
		this.panelInsert.add(this.txtPrenom);
		this.panelInsert.add(new JLabel("Identifiants : ")); 
		this.panelInsert.add(this.txtIdentifiants);
		this.panelInsert.add(new JLabel(" Mdp : ")); 
		this.panelInsert.add(this.txtMdp);
		this.panelInsert.add(new JLabel("Adresse  : ")); 
		this.panelInsert.add(this.txtAdresse);
		this.panelInsert.add(new JLabel("Ville : ")); 
		this.panelInsert.add(this.txtVille);
		this.panelInsert.add(new JLabel("Cp : ")); 
		this.panelInsert.add(this.txtCp);
		this.panelInsert.add(new JLabel("Téléphone  : ")); 
		this.panelInsert.add(this.txtTel);
		this.panelInsert.add(this.btAnnuler); 
		this.panelInsert.add(this.btEnregistrer); 
		this.add(this.panelInsert); 
		
		/**************** Construction Panel Lister ***************/
		this.panelLister.setBounds(380, 80, 480, 320);
		this.panelLister.setBackground(Color.LIGHT_GRAY);
		this.panelLister.setLayout(null);
		String entetes[] = {" Id Client", "Nom", "Prénom", "Identifiants", "Mdp" , "Adresse" , "Ville", "Code Postal" , "Téléphone"};
		//instanciation de la classe tableau donnees et entetes 
		this.unTableau = new Tableau(this.remplirDonnees(""), entetes);
		//instanciation de la Jtable sur la tableModel unTableau
		this.uneTable = new JTable(unTableau); 
		
		this.uneScroll = new JScrollPane(this.uneTable); 
		this.uneScroll.setBounds(0, 20, 460, 280);
		this.panelLister.add(this.uneScroll); 
		this.add(this.panelLister); 
		
		/**************** Construction Panel Filtrer ***************/
		this.panelFiltrer.setBounds(420, 40, 380, 25);
		this.panelFiltrer.setBackground(Color.LIGHT_GRAY);
		this.panelFiltrer.setLayout(new GridLayout(1, 3));
		this.panelFiltrer.add(this.lbRecherche); 
		this.panelFiltrer.add(this.txtMot); 
		this.panelFiltrer.add(this.btFiltrer); 
		this.add(this.panelFiltrer);
		this.btFiltrer.addActionListener(this);
		
		/*********************** rendre les boutons *****************/
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
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
					int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce client ?", 
							"Suppression Client", JOptionPane.YES_NO_OPTION); 
					if (retour == 0)
					{
						JOptionPane.showMessageDialog(null, "Client supprimé ");
						int indiceLigne = uneTable.getSelectedRow(); 
						int idClient = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
						Main.deleteClient(idClient);
						unTableau.supprimerLigne(indiceLigne);
					}
				}else if (e.getClickCount() == 1)
				{
					int indiceLigne = uneTable.getSelectedRow(); 
					txtNom.setText(unTableau.getValueAt(indiceLigne,1).toString()); 
					txtPrenom.setText(unTableau.getValueAt(indiceLigne,2).toString()); 
					txtIdentifiants.setText(unTableau.getValueAt(indiceLigne,3).toString()); 
					txtMdp.setText(unTableau.getValueAt(indiceLigne,4).toString()); 
					txtAdresse.setText(unTableau.getValueAt(indiceLigne,5).toString()); 
					txtVille.setText(unTableau.getValueAt(indiceLigne,6).toString()); 
					txtCp.setText(unTableau.getValueAt(indiceLigne,7).toString()); 
					txtTel.setText(unTableau.getValueAt(indiceLigne,8).toString()); 
					
					btEnregistrer.setText("Modifier");
				}
				
			}
		});
		
		this.setVisible(true);
	}
	
	public Object [][] remplirDonnees (String mot)
	{
		//cette fonction transforme l'ArrayList des clients en une matride d'objets 
		ArrayList<Client> lesClients = Main.selectAllClient(mot);
		Object [][] matrice = new Object [lesClients.size()][9];
		int i = 0; 
		for (Client unClient : lesClients)
		{
			matrice [i][0] = unClient.getIdclient();
			matrice [i][1] = unClient.getNomc();
			matrice [i][2] = unClient.getPrenomc();
			matrice [i][3] = unClient.getIdentifiants(); 
			matrice [i][4] = unClient.getMdp(); 
			matrice [i][5] = unClient.getAdresse();
			matrice [i][6] = unClient.getVille();
			matrice [i][7] = unClient.getCp();
			matrice [i][8] = unClient.getTelc();
			i++;
		}
		return matrice;
	}
	
	public void viderChamps () {
		this.txtAdresse.setText("");
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtIdentifiants.setText("");
		this.txtMdp.setText("");
		this.txtVille.setText("");
		this.txtCp.setText("");
		this.txtTel.setText("");
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
			//on rÃ©cupÃ¨re les donnÃ©es, on instancie un client, on l'ajoute au bdd 
			String nomc = this.txtNom.getText(); 
			String prenomc = this.txtPrenom.getText(); 
			String identifiants = this.txtIdentifiants.getText();
			String mdp = this.txtMdp.getText();
			String adresse = this.txtAdresse.getText();
			String ville = this.txtVille.getText(); 
			String cp = this.txtCp.getText(); 
			String telc = this.txtTel.getText();
			Client unClient = new Client(nomc, prenomc, identifiants, mdp, adresse, ville, cp, telc);
			Main.insertClient(unClient);
			JOptionPane.showMessageDialog(this, "Insertion réussie du nouveau client !");
			this.viderChamps();
			
			//extraction de l'ID du dernier client insÃ©rÃ©
			unClient = Main.selectWhereClient(identifiants);
			//actualisation de l'affichage 
			Object ligne[] = {unClient.getIdclient(), nomc, prenomc, identifiants, mdp, adresse, ville, cp, telc}; 
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
			int idClient = Integer.parseInt(unTableau.getValueAt(indiceLigne,0).toString());
			//on rÃ©cupÃ¨re les donnÃ©es, on instancie un client, on l'ajoute au bdd 
			String nomc = this.txtNom.getText(); 
			String prenomc  = this.txtPrenom.getText(); 
			String identifiants  = this.txtIdentifiants.getText();
			String mdp = this.txtMdp.getText();
			String adresse = this.txtAdresse.getText(); 
			String ville = this.txtVille.getText(); 
			String cp = this.txtCp.getText(); 
			String telc = this.txtTel.getText();
			Client unClient = new Client(idClient, nomc, prenomc, identifiants, mdp , adresse, ville, cp, telc);
			Main.updateClient(unClient);
			//actualisation de l'affichage 
			Object ligne[] = {idClient, nomc, prenomc, identifiants, mdp , adresse, ville, cp, telc}; 
			this.unTableau.modifierLigne(indiceLigne, ligne);
			JOptionPane.showMessageDialog(this, "Modification réussie du client !");
			this.viderChamps();
		}
	}
	

}
