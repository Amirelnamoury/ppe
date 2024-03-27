package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;
import controleur.Departement;
import controleur.Livraison;
import controleur.Produit;
import controleur.Livreur;
import controleur.Utilisateur;


public class Modele {
	
	private static BDD uneBdd = new BDD("localhost", "sapestore", "root", ""); //pour superv user
	//private static BDD uneBdd = new BDD("localhost", "garage_JV", "root", ""); //pour PC
	//private static BDD uneBdd = new BDD("localhost:8889", "garage_JV", "root", "root"); //pour MAC
	//private static BDD uneBdd = new BDD("172.20.111.147", "filelec", "lahcen", "lahcen"); //pour serveur 
	
	public static void executerRequete (String requete)
	{
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
	}

	/************************************************ Modele Client *************************************/

	public static void insertClient (Client unClient)
	{
		String requete ="insert into client values (null, '"+unClient.getNomc()+"','"+unClient.getPrenomc()+"','"+unClient.getIdentifiants()+"','"+unClient.getMdp()+"','"+unClient.getAdresse()+"','"+unClient.getVille()+"','"+unClient.getCp()+"', '"+unClient.getTelc()+"');" ; 
		executerRequete(requete);
	}
	
	public static void deleteClient (int idClient)
	{
		String requete ="delete from client where idclient =  " + idClient +";"; 
		executerRequete(requete);
	}
	
	public static void updateClient (Client unClient)
	{
		String requete ="update client set nomc = '"+unClient.getNomc()+"',prenomc ='"+unClient.getPrenomc()+"', identifiants = '"+unClient.getIdentifiants()+"', mdp ='"+unClient.getMdp()+"', adresse ='"+unClient.getAdresse()+"', ville ='"+unClient.getVille()+"', cp ='"+unClient.getCp()+"', telc ='"+unClient.getTelc()+"'"+ " where idclient =  " + unClient.getIdclient() +" ; "; 
		executerRequete(requete);
	}
	
	public static Client selectWhereClient (int idClient)
	{
		Client unClient = null; 
		String requete ="select * from client where idclient =  " + idClient +";"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unClient = new Client (
							unRes.getInt("idclient"), unRes.getString("nomc"), unRes.getString("prenomc"), unRes.getString("identifiants"), unRes.getString("mdp"),
							unRes.getString("adresse"), unRes.getString("ville") , unRes.getString("cp") , unRes.getString("telc")
							);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unClient; 
	}
	
	public static Client selectWhereClient (String identifiants)
	{
		Client unClient = null; 
		String requete ="select * from client where identifiants =  '" + identifiants +"' ;"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unClient = new Client (
						unRes.getInt("idclient"), unRes.getString("nomc"), unRes.getString("prenomc"), unRes.getString("identifiants"), unRes.getString("mdp"),
						unRes.getString("adresse"), unRes.getString("ville") , unRes.getString("cp") , unRes.getString("telc")
							);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unClient; 
	}
	public static ArrayList<Client> selectAllClient (String mot)
	{
		ArrayList<Client> lesClients = new ArrayList<Client>();  
		String requete =""; 
		if (mot.equals("")) {
			requete = "select * from client ;"; 
		}else {
			 requete ="select * from client where nomc like '%"+mot+"%'  or prenomc like '%"+mot+"%'"
			 		+ " or adresse like '%"+mot+"%' ;";
		}
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
					//instanciation du produit resultat 
				Client unClient = new Client (
						desRes.getInt("idclient"), desRes.getString("nomc"), desRes.getString("prenomc"), desRes.getString("identifiants"), desRes.getString("mdp"), 
						desRes.getString("adresse"), desRes.getString("ville"), desRes.getString("cp"), desRes.getString("telc")
							); 
				//Ajout du client dans la liste des clients 
				lesClients.add(unClient);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return lesClients; 
	}
	
	/************************************************ Modele Produit *************************************/
	public static void insertProduit (Produit unProduit)
	{
		String requete ="insert into produit values (null, '"+unProduit.getNomp()+"','"+unProduit.getPrix()+"', '"+unProduit.getDescp()+"','"+unProduit.getStock()+"', '"+unProduit.getDescp()+"', '"+unProduit.getProvenance()+"');" ; 
		executerRequete(requete);
	}

	public static void deleteProduit (int idProduit)
	{
		String requete ="delete from produit where idproduit =  " + idProduit +";"; 
		executerRequete(requete);
	}
	
	public static void updateProduit (Produit unProduit)
	{
		String requete ="update produit set nomp = '"+unProduit.getNomp()+"',prix ='"+unProduit.getPrix()+"', stock = '"+unProduit.getStock()+"', descp ='"+unProduit.getDescp()+"',provenance ='"+unProduit.getProvenance()+"'"+ " where idproduit =  " + unProduit.getIdproduit() +" ; "; 
		executerRequete(requete);
	}
	
	public static Produit selectWhereProduit (int idProduit)
	{
		Produit unProduit = null; 
		String requete ="select * from produit where idproduit =  " + idProduit +";"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unProduit = new Produit (
							unRes.getInt("idproduit"), unRes.getString("nomp"), unRes.getString("descp"), unRes.getInt("stock"), 
							unRes.getInt("prix"),unRes.getString("provenance")
 
							);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unProduit; 
	}
	
	public static Produit selectWhereProduit (String nomp)
	{
		Produit unProduit = null; 
		String requete ="select * from produit where nomp =  '" + nomp +"' ;"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unProduit = new Produit (
						unRes.getInt("idproduit"), unRes.getString("nomp"), unRes.getString("descp"),
						unRes.getInt("stock") , unRes.getInt("prix"),unRes.getString("provenance")
						);
		}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unProduit; 
	}
	public static ArrayList<Produit> selectAllProduit (String mot)
	{
		ArrayList<Produit> lesProduits = new ArrayList<Produit>();  
		String requete =""; 
		if (mot.equals("")) {
			requete = "select * from produit ;"; 
		}else {
			 requete ="select * from produit where nomp like '%"+mot+"%' or descp like '%"+mot+"%';";
		}
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
					//instanciation du produit resultat 
				Produit unProduit = new Produit (
						desRes.getInt("idproduit"), desRes.getString("nomp"), desRes.getString("descp"),
						desRes.getInt("stock") , desRes.getInt("prix"),desRes.getString("provenance")
							); 
				//Ajout du produits dans la liste des produits 
				lesProduits.add(unProduit);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return lesProduits; 
	}
	
	/************************************************ Modele Livreur *************************************/
	public static Livreur selectWhereLivreur (String email, String mdp)
	{
		Livreur unLivreur = null; 
		String requete ="select * from Livreur where email =  '" + email +"' and mdp ='"+mdp+"' ;"; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unLivreur = new Livreur (
							unRes.getInt("idlivreur"), unRes.getString("nom"), unRes.getString("prenom"), 
							unRes.getString("email") , unRes.getString("mdp"), unRes.getString("dateembauche"), unRes.getString("fin_contrat"), 
							unRes.getString("tel"), unRes.getInt("couthoraire"),unRes.getInt("nblivraison"),
							unRes.getInt("iddepartement")
							
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unLivreur; 
	}
	
	public static Livreur selectWhereLivreur (int idlivreur)
	{
		Livreur unLivreur = null; 
		String requete ="select * from Livreur where idlivreur=  " + idlivreur +";"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unLivreur= new Livreur (
						unRes.getInt("idlivreur"), unRes.getString("nom"), unRes.getString("prenom"), 
						unRes.getString("email") , unRes.getString("mdp"), unRes.getString("dateembauche"), unRes.getString("fin_contrat"), 
						unRes.getString("tel"), unRes.getInt("couthoraire"),unRes.getInt("nblivraison"),
						unRes.getInt("iddepartement")
					
					);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unLivreur; 
	}
	
	public static ArrayList<Livreur> selectAllLivreur (String mot)
	{
		ArrayList<Livreur> lesLivreurs = new ArrayList<Livreur>();  
		String requete =""; 
		if (mot.equals("")) {
			requete = "select * from Livreur ;"; 
		}else {
			 requete ="select * from Livreur where nom like '%"+mot+"%' or prenom like '%"+mot+"%' or email like '%"+mot+"%';";
		}
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
					//instanciation du produit resultat 
				Livreur unLivreur = new Livreur (
						desRes.getInt("idlivreur"), desRes.getString("nom"), desRes.getString("prenom"), 
						desRes.getString("email") , desRes.getString("mdp"), desRes.getString("dateembauche"), desRes.getString("fin_contrat"), 
						desRes.getString("tel"), desRes.getInt("couthoraire"),desRes.getInt("nblivraison"),
						desRes.getInt("iddepartement")
							); 
				//Ajout du produits dans la liste des produits 
				lesLivreurs.add(unLivreur);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return lesLivreurs; 
	}
	
	public static void insertLivreur (Livreur unLivreur)
	{
		String requete ="insert into Livreur values (null, '"+unLivreur.getNom()+"','"+unLivreur.getPrenom()+"', '"+unLivreur.getEmail()+"', '"+unLivreur.getMdp()+"', '"+unLivreur.getNblivraison()+"', '"+unLivreur.getDateembauche()+"', '"+unLivreur.getFin_contrat()+"', '"+unLivreur.getCouthoraire()+"' , '"+unLivreur.getTel()+"' , '"+unLivreur.getIddepartement()
						+"');" ; 
		executerRequete(requete);
	}
	
	public static void deleteLivreur(int idlivreur)
	{
		String requete ="delete from Livreur where idlivreur =  " + idlivreur +";"; 
		executerRequete(requete);
	}
	
	public static void updateLivreur (Livreur unLivreur)
	{
		String requete ="update Livreur set nom = '"+unLivreur.getNom()+"',prenom ='"+unLivreur.getPrenom()+"', email = '"+unLivreur.getEmail()+"', mdp = '"+unLivreur.getMdp()+"',  nblivraison = '"+unLivreur.getNblivraison()+"' , dateembauche = '"+unLivreur.getDateembauche()+"' , fin_contrat = '"+unLivreur.getFin_contrat()+"' , couthoraire = '"+unLivreur.getCouthoraire()+"' , tel = '"+unLivreur.getTel()+"', iddepartement='"+unLivreur.getIddepartement()+"' "
						+ "  where idlivreur =  " + unLivreur.getIdlivreur() +" ;  "; 
		executerRequete(requete);
	}
	
	
	
	/************************************************ Modele Livraison *************************************/

	public static void insertLivraison (Livraison unLivraison)
	{
		String requete ="insert into Livraison values (null, '"+unLivraison.getDatelivrais()+"','"+unLivraison.getDesclivrais()+"','"+unLivraison.getStatut()
						+"','"+unLivraison.getIdlivreur()+"');" ; 
		executerRequete(requete);
	}
	
	public static void deleteLivraison(int idlivraison)
	{
		String requete ="delete from Livraison where idlivraison =  " + idlivraison +";"; 
		executerRequete(requete);
	}
	
	public static void updateLivraison (Livraison unLivraison)
	{
		String requete ="update Livraison set datelivrais = '"+unLivraison.getDatelivrais()+"',desclivrais ='"+unLivraison.getDesclivrais()+"',"
				+ "statut = '"+unLivraison.getStatut()+"',idlivreur='"+unLivraison.getIdlivreur()+"' "
						+ "  where idlivraison =  " + unLivraison.getIdlivraison() +" ;  "; 
		executerRequete(requete);
	}
	
	public static Livraison selectWhereLivraison (int idlivraison)
	{
		Livraison unLivraison = null; 
		String requete ="select * from Livraison where idlivraison=  " + idlivraison +";"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unLivraison= new Livraison (
							unRes.getInt("idlivraison"), unRes.getString("datelivrais"), unRes.getString("desclivrais"), 
							unRes.getString("statut"), unRes.getInt("idlivreur")
							);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unLivraison; 
	}
	
	public static Livraison selectWhereLivraison(String desclivrais)
	{
		Livraison unLivraison = null; 
		String requete ="select * from Livraison where desclivrais =  '" + desclivrais +"' ;"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unLivraison = new Livraison (
						unRes.getInt("idlivraison"), unRes.getString("datelivrais"), unRes.getString("desclivrais"), 
						unRes.getString("statut"), unRes.getInt("idlivreur")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unLivraison; 
	}
	public static ArrayList<Livraison> selectAllLivraison (String mot)
	{
		ArrayList<Livraison> lesLivraisons = new ArrayList<Livraison>();  
		String requete =""; 
		if (mot.equals("")) {
			requete = "select * from Livraison ;"; 
		}else {
			 requete ="select * from Livraison where desclivrais like '%"+mot+"%' "
					+ " or statut like '%"+mot+"%' ; ";
		}
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
					//instanciation du produit resultat 
				Livraison unLivraison= new Livraison (
						desRes.getInt("idlivraison"), desRes.getString("datelivrais"), desRes.getString("desclivrais"), 
						desRes.getString("statut"), desRes.getInt("idlivreur")
							); 
				//Ajout du client dans la liste des clients 
				lesLivraisons.add(unLivraison);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return lesLivraisons; 
	}
	
	/************************************************ Modele Utilisateur *************************************/
	
	
	public static void insertUtilisateur (Utilisateur unUtilisateur)
	{
		String requete ="insert into user values (null, '"+unUtilisateur.getNom()+"','"+unUtilisateur.getPrenom()+"','"+unUtilisateur.getEmail()
						+"','"+unUtilisateur.getPassword()+"','"+unUtilisateur.getDroits()+"','"+unUtilisateur.getIdClient()+"');" ; 
		executerRequete(requete);
	}
	
	public static void deleteUtilisateur (int iduser)
	{
		String requete ="delete from user where iduser =  " + iduser +";"; 
		executerRequete(requete);
	}
	
	public static void updateUtilisateur (Utilisateur unUtilisateur)
	{
		String requete ="update user set nom = '"+unUtilisateur.getNom()+"',prenom ='"+unUtilisateur.getPrenom()+"',"
				+ "email = '"+unUtilisateur.getEmail() +"',password = '"+unUtilisateur.getPassword()+"',droits= '"+unUtilisateur.getDroits()+"',idclient='"+unUtilisateur.getIdClient()+"'"
						+ " where iduser =  " + unUtilisateur.getIduser() +" ; "; 
		executerRequete(requete);
	}
	
	public static Utilisateur selectWhereUtilisateur (int iduser)
	{
		Utilisateur unUtilisateur = null; 
		String requete ="select * from user where iduser =  " + iduser +";"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unUtilisateur = new Utilisateur (
							unRes.getInt("iduser"), unRes.getString("nom"), unRes.getString("prenom"), 
							unRes.getString("email"), unRes.getString("password") , unRes.getString("droits") , unRes.getInt("idclient")
							);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unUtilisateur; 
	}
	
	public static Utilisateur selectWhereUtilisateur (String email)
	{
		Utilisateur unUtilisateur = null; 
		String requete ="select * from user where email =  '" + email +"' ;"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unUtilisateur = new Utilisateur (
						unRes.getInt("iduser"), unRes.getString("nom"), unRes.getString("prenom"), 
						unRes.getString("email"), unRes.getString("password") , unRes.getString("droits") , unRes.getInt("idclient")
							);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unUtilisateur; 
	}
	public static ArrayList<Utilisateur> selectAllUtilisateur(String mot)
	{
		ArrayList<Utilisateur> lesUtilisateurs = new ArrayList<Utilisateur>();  
		String requete =""; 
		if (mot.equals("")) {
			requete = "select * from user ;"; 
		}else {
			 requete ="select * from user where nom like '%"+mot+"%'  or prenom like '%"+mot+"%' "
					+ " or email like '%"+mot+"%' ; ";
		}
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
					//instanciation du produit resultat 
				Utilisateur unUtilisateur = new Utilisateur (
						desRes.getInt("iduser"), desRes.getString("nom"), desRes.getString("prenom"), 
						desRes.getString("email"), desRes.getString("password") , desRes.getString("droits") , desRes.getInt("idclient")
							); 
				//Ajout du client dans la liste des clients 
				lesUtilisateurs.add(unUtilisateur);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return lesUtilisateurs; 
	}
	
	/************************************************ Modele Departement *************************************/
	public static Departement selectWhereDepartement (String nomd)
	{
		Departement unDepartement = null; 
		String requete ="select * from departement where nomd = '"+nomd+"' ;"; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unDepartement = new Departement (
						unRes.getInt("iddepartement"), unRes.getString("coded"), unRes.getString("nomd"), 
						unRes.getString("uppercase") , unRes.getString("slug"), 
						unRes.getString("soundex")
							
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unDepartement; 
	}
	
	public static Departement selectWhereDepartement (int iddepartement)
	{
		Departement unDepartement = null; 
		String requete ="select * from departement where iddepartement=  " + iddepartement +";"; 
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
					//instanciation du produit resultat 
				unDepartement= new Departement (
						unRes.getInt("iddepartement"), unRes.getString("coded"), unRes.getString("nomd"), 
						unRes.getString("uppercase") , unRes.getString("slug"), 
						unRes.getString("soundex")
					
					);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return unDepartement; 
	}
	
	public static ArrayList<Departement> selectAllDepartement(String mot)
	{
		ArrayList<Departement> lesDepartements = new ArrayList<Departement>();  
		String requete =""; 
		if (mot.equals("")) {
			requete = "select * from departement ;"; 
		}else {
			 requete ="select * from departement where coded like '%"+mot+"%'  or nomd like '%"+mot+"%' "
					+ " or uppercase like '%"+mot+"%' ; ";
		}
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaconnexion().createStatement(); 
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
					//instanciation du produit resultat 
				Departement unDepartement = new Departement (
						desRes.getInt("iddepartement"), desRes.getString("coded"), desRes.getString("nomd"), 
						desRes.getString("uppercase") , desRes.getString("slug"), 
						desRes.getString("soundex")
							); 
				//Ajout du client dans la liste des clients 
				lesDepartements.add(unDepartement);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible d'exécuter la requete : " + requete);
		}
		return lesDepartements; 
	}
	
	

	
	
	
	
	
} // la derniere

	
	


