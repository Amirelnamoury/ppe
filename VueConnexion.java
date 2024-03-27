package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.Main;

import controleur.Livreur;

public class VueConnexion extends JFrame implements ActionListener, KeyListener 
{
	/************************************Instanciation Panel Connexion****************************************/
	
	private JPanel panelConnexion = new JPanel(); 
	private JButton btAnnuler = new JButton ("Annuler"); 
	private JButton btSeConnecter = new JButton ("Se Connecter");
	private JTextField txtEmail = new JTextField(); 
	private JPasswordField txtMdp = new JPasswordField(); 
	
	/************************************Instanciation Panel Connexion****************************************/
	private JPanel panelMenu = new JPanel(); 
	private JPanel panelMenu2 = new JPanel(); 
	private JButton btClients = new JButton ("Gestion Clients");
	private JButton btLivreurs = new JButton ("Gestion des Livreurs");
	private JButton btProduits= new JButton ("Gestion des Produits");
	private JButton btProduits2= new JButton ("Gestion des Produits");
	private JButton btLivraisons = new JButton ("Gestion des Livraisons");
	private JButton btStats = new JButton ("Gestion des Utilisateurs");
	private JButton btQuitter = new JButton ("Quitter l'application");
	private JButton btQuitter2 = new JButton ("Quitter l'application");
	
	public VueConnexion() {
		this.setTitle("Gestion SAPESTORE");
		this.setBounds(200, 200, 700, 350);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.white);
		
		
		
		ImageIcon uneImage = new ImageIcon("src/image/Sape.png");
		JLabel monLogo = new JLabel (uneImage);
		monLogo.setBounds(20,60, 270, 200);
		this.add(monLogo);
		
	/**********************Construction Panel Connexion******************/
		this.panelConnexion.setBounds(320, 60, 340, 200);
		this.panelConnexion.setBackground(Color.LIGHT_GRAY);
		this.panelConnexion.setLayout(new GridLayout (3,2));
		this.panelConnexion.add(new JLabel("Email : " ));
		this.panelConnexion.add(this.txtEmail);
		this.panelConnexion.add(new JLabel("MDP : "));
		this.panelConnexion.add(this.txtMdp);
		this.panelConnexion.add(this.btAnnuler);
		this.btAnnuler.setBackground(Color.DARK_GRAY);
		this.btAnnuler.setForeground(Color.white);
		
		
		this.panelConnexion.add(this.btSeConnecter);
		this.btSeConnecter.setBackground(Color.DARK_GRAY);
		this.btSeConnecter.setForeground(Color.white);
		
		this.add(this.panelConnexion);
		
	/**********************Construction Panel MENU******************/
		this.panelMenu.setBounds(320, 60, 300, 200);
		this.panelMenu.setBackground(Color.DARK_GRAY);
		this.panelMenu.setLayout(new GridLayout (3,2));
		this.panelMenu.add(this.btClients);
		this.btClients.setBackground(Color.DARK_GRAY);
		this.btClients.setForeground(Color.white);
		
		this.panelMenu.add(this.btLivreurs);
		this.btLivreurs.setBackground(Color.DARK_GRAY);
		this.btLivreurs.setForeground(Color.white);
		
		this.panelMenu.add(this.btProduits);
		this.btProduits.setBackground(Color.DARK_GRAY);
		this.btProduits.setForeground(Color.white);
	
		this.panelMenu.add(this.btLivraisons);
		this.btLivraisons.setBackground(Color.DARK_GRAY);
		this.btLivraisons.setForeground(Color.white);
		
		this.panelMenu.add(this.btQuitter);
		this.btQuitter.setBackground(Color.DARK_GRAY);
		this.btQuitter.setForeground(Color.white);
		
		this.panelMenu.add(this.btStats);
		this.btStats.setBackground(Color.DARK_GRAY);
		this.btStats.setForeground(Color.white);
		
		this.add(this.panelMenu);
		this.panelMenu.setVisible(false); // cacher le menu
		
		

		this.panelMenu2.setBounds(320, 60, 300, 200);
		this.panelMenu2.setBackground(Color.DARK_GRAY);
		this.panelMenu2.setLayout(new GridLayout (3,2));
		this.panelMenu2.add(this.btProduits2);
		this.btProduits2.setBackground(Color.DARK_GRAY);
		this.btProduits2.setForeground(Color.white);
		this.panelMenu2.add(this.btQuitter2);
		this.btQuitter2.setBackground(Color.DARK_GRAY);
		this.btQuitter2.setForeground(Color.white);
		this.add(this.panelMenu2);
		this.panelMenu2.setVisible(false); 
		
	/********************** Rendre les boutons ecoutables *****************/
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		this.btClients.addActionListener(this);
		this.btLivraisons.addActionListener(this);
		this.btProduits.addActionListener(this);
		this.btProduits2.addActionListener(this);
		this.btStats.addActionListener(this);
		this.btQuitter.addActionListener(this);
		this.btQuitter2.addActionListener(this);
		this.btLivreurs.addActionListener(this);
		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.btAnnuler == e.getSource())
		{
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		}
		else if (e.getSource() == this.btSeConnecter)
		{
			this.traitement() ; 
		}
		else if (e.getSource() == this.btQuitter)
		{
			int retour = JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'application", 
					"Quitter l'application", JOptionPane.YES_NO_OPTION);
			if (retour == 0) {
				this.panelConnexion.setVisible(true);
				this.panelMenu.setVisible(false);
			}
		}
		else if (e.getSource() == this.btQuitter2)
		{
			int retour = JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'application", 
					"Quitter l'application", JOptionPane.YES_NO_OPTION);
			if (retour == 0) {
				this.panelConnexion.setVisible(true);
				this.panelMenu2.setVisible(false);
			}
		}
		else if (e.getSource() == this.btClients)
		{
			Main.rendreVisible(false);
			Main.instancierVueClients(); // instanciation setVisible true
		}
		
		else if (e.getSource() == this.btProduits)
		{
			Main.rendreVisible(false);
			Main.instancierVueProduit(); // instanciation setVisible true
		}
		else if (e.getSource() == this.btProduits2)
		{
			Main.rendreVisible(false);
			Main.instancierVueProduit(); // instanciation setVisible true
		}
		else if (e.getSource() == this.btLivraisons)
		{
			Main.rendreVisible(false);
			Main.instancierVueLivraison(); // instanciantion setVisible true
		}
		
		else if (e.getSource() == this.btStats)
		{
			Main.rendreVisible(false);
			Main.instancierVueUtilisateur(); // instanciantion setVisible true
		}
		else if (e.getSource() == this.btLivreurs)
		{
			Main.rendreVisible(false);
			Main.instancierVueLivreur(); // instanciantion setVisible true
		}
			
	}
		
	public void traitement() {
	    String email = this.txtEmail.getText();
	    String mdp = new String(this.txtMdp.getPassword());
	    
	    // On demande au contrôleur de nous donner le Livreur
	    Livreur unLivreur = Main.selectWhereLivreur(email, mdp);
	    
	    if (unLivreur == null) {
	        JOptionPane.showMessageDialog(this, "Veuillez vérifier vos identifiants");
	    } else {
	        JOptionPane.showMessageDialog(this, "Bienvenue à " + unLivreur.getNom() + " " + unLivreur.getPrenom());
	        
	        // On ouvre le logiciel d'administration et on coupe la connexion
	        this.panelConnexion.setVisible(false);
	        this.panelMenu2.setVisible(false);
	        this.panelMenu.setVisible(true);
	    }
	    
	    this.txtEmail.setText("");
	    this.txtMdp.setText("");
	}

		
		
		
		
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// sur frappe de touche entrée 
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			this.traitement(); 
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
