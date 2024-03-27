package controleur;

import java.util.ArrayList;

import modele.Modele;
import vue.VueClients;
import vue.VueConnexion;
import vue.VueLivraison;
import vue.VueProduit;
import vue.VueLivreur;
import vue.VueUtilisateur;




public class Main 
{
	public static VueConnexion uneVueConnexion ;
	public static VueClients uneVueClients ;
	public static VueProduit uneVueProduit ;
	public static VueLivreur uneVueLivreur ;
	public static VueLivraison uneVueLivraison ; 
	public static VueUtilisateur uneVueUtilisateur ; 
	
	public static void main (String args[]) 
	
	{
		uneVueConnexion = new VueConnexion(); 
	}
	
	public static void rendreVisible (boolean action)
	{
		Main.uneVueConnexion.setVisible(action);
	}
	
	public static void instancierVueClients ()
	{
		Main.uneVueClients = new VueClients ();
	}
	
	public static void instancierVueLivreur ()
	{
		Main.uneVueLivreur = new VueLivreur ();
	}
	
	public static void instancierVueProduit ()
	{
		Main.uneVueProduit = new VueProduit ();
	}
	
	public static void instancierVueLivraison () 
	{
		Main.uneVueLivraison = new VueLivraison (); 
	}
	
	public static void instancierVueUtilisateur ()
	{
		Main.uneVueUtilisateur = new VueUtilisateur ();
	}
	
	/***********************************************Controleur Client **********************************************************/
	public static void insertClient (Client unClient)
	{
		//on controle les donnees avant insertion
		Modele.insertClient(unClient);
	}
	
	public static void deleteClient (int idClient)
	{
		Modele.deleteClient(idClient);
	}
	
	public static void updateClient (Client unClient)
	{
		Modele.updateClient(unClient);
	}
	
	public static Client selectWhereClient (int idClient)
	{
		return Modele.selectWhereClient(idClient);
	}
	
	public static Client selectWhereClient (String identifiants)
	{
		return Modele.selectWhereClient(identifiants);
	}
	
	public static ArrayList<Client> selectAllClient (String mot)
	{
		return Modele.selectAllClient(mot);
	}
	
	/***********************************************Controleur Produit **********************************************************/
	public static void insertProduit (Produit unProduit)
	{
		//on controle les donnees avant insertion
		Modele.insertProduit(unProduit);
	}
	
	public static void deleteProduit (int idProduit)
	{
		Modele.deleteProduit(idProduit);
	}
	
	public static void updateProduit (Produit unProduit)
	{
		Modele.updateProduit(unProduit);
	}
	
	public static Produit selectWhereProduit (int idProduit)
	{
		return Modele.selectWhereProduit(idProduit);
	}
	
	public static Produit selectWhereProduit (String nomp)
	{
		return Modele.selectWhereProduit(nomp);
	}
	
	public static ArrayList<Produit> selectAllProduit (String mot)
	{
		return Modele.selectAllProduit(mot);
	}
	
	
	/***********************************************Controleur Livreur **********************************************************/
	public static Livreur selectWhereLivreur(String email, String mdp)
	{
		return Modele.selectWhereLivreur(email, mdp);
	}
	
	public static Livreur selectWhereLivreur (int idtech)
	{
		return Modele.selectWhereLivreur(idtech);
	}
	
	public static ArrayList<Livreur> selectAllLivreur(String mot)
	{
		return Modele.selectAllLivreur(mot);
	}
	
	public static void insertLivreur (Livreur unLivreur)
	{
		Modele.insertLivreur(unLivreur);
	}
	public static void deleteLivreur(int idlivreur)
	{
		Modele.deleteLivreur(idlivreur);
	}
	
	public static void updateLivreur(Livreur unLivreur)
	{
		Modele.updateLivreur(unLivreur);
	}
	
	/***********************************************Controleur Produit **********************************************************/
	public static void insertLivraison (Livraison unLivraison)
	{
		//on controle les donnees avant insertion
		Modele.insertLivraison(unLivraison);
	}
	
	public static void deleteLivraison(int idlivraison)
	{
		Modele.deleteLivraison(idlivraison);
	}
	
	public static void updateLivraison (Livraison unLivraison)
	{
		Modele.updateLivraison(unLivraison);
	}
	
	public static Livraison selectWhereLivraison (int idlivraison)
	{
		return Modele.selectWhereLivraison(idlivraison);
	}
	
	public static Livraison selectWhereLivraison (String desclivrais)
	{
		return Modele.selectWhereLivraison(desclivrais);
	}
	
	public static ArrayList<Livraison> selectAllLivraison(String mot)
	{
		return Modele.selectAllLivraison(mot);
	}

	/***********************************************Controleur Utilisateur **********************************************************/
	
	public static void insertUtilisateur (Utilisateur unUtilisateur)
	{
		//on controle les donnees avant insertion
		Modele.insertUtilisateur(unUtilisateur);
	}
	
	public static void deleteUtilisateur(int iduser)
	{
		Modele.deleteUtilisateur(iduser);
	}
	
	public static void updateUtilisateur (Utilisateur unUtilisateur)
	{
		Modele.updateUtilisateur(unUtilisateur);
	}
	
	public static Utilisateur selectWhereUtilisateur (int iduser)
	{
		return Modele.selectWhereUtilisateur(iduser);
	}
	
	public static Utilisateur selectWhereUtilisateur (String email)
	{
		return Modele.selectWhereUtilisateur(email);
	}
	
	public static ArrayList<Utilisateur> selectAllUtilisateur(String mot)
	{
		return Modele.selectAllUtilisateur(mot);
	}
	
	/***********************************************Controleur Departement **********************************************************/

	
	public static Departement selectWhereDepartement (int iddepartement)
	{
		return Modele.selectWhereDepartement(iddepartement);
	}
	
	public static Departement selectWhereDepartement (String nomd)
	{
		return Modele.selectWhereDepartement(nomd);
	}
	
	public static ArrayList<Departement> selectAllDepartement(String mot)
	{
		return Modele.selectAllDepartement(mot);
	}
	
	

}
