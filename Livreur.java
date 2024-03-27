package controleur;

public class Livreur {
	private int idlivreur;
	private String nom, prenom, email, mdp, dateembauche, fin_contrat, tel;
	private int nblivraison ; 
	private int couthoraire; 
	private int iddepartement;
	
public Livreur(int idlivreur, String nom, String prenom, String email, String mdp, String dateembauche,
			String fin_contrat, String tel, int nblivraison , int couthoraire, int iddepartement) {
		
		this.idlivreur = idlivreur;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.dateembauche = dateembauche;
		this.fin_contrat = fin_contrat;
		this.tel = tel;
		this.nblivraison  = nblivraison ;
		this.couthoraire = couthoraire;
		this.iddepartement = iddepartement;
	} 

public Livreur(String nom, String prenom, String email, String mdp, String dateembauche,
		String fin_contrat, String tel, int nblivraison , int couthoraire, int iddepartement) {
	
	this.idlivreur = 0;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.mdp = mdp;
	this.dateembauche = dateembauche;
	this.fin_contrat = fin_contrat;
	this.tel = tel;
	this.nblivraison  = nblivraison ;
	this.couthoraire = couthoraire;
	this.iddepartement = iddepartement;
} 

public Livreur ( ) {
	this.idlivreur = 0;
	this.nom = "";
	this.prenom = "";
	this.email = "";
	this.mdp = "";
	this.dateembauche = "";
	this.fin_contrat = "";
	this.tel = "";
	this.nblivraison  = 0;
	this.couthoraire = 0;
	this.iddepartement = 0;
}

public int getIdlivreur() {
	return idlivreur;
}

public void setIdlivreur(int idlivreur) {
	this.idlivreur = idlivreur;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getMdp() {
	return mdp;
}

public void setMdp(String mdp) {
	this.mdp = mdp;
}

public String getDateembauche() {
	return dateembauche;
}

public void setDateembauche(String dateembauche) {
	this.dateembauche = dateembauche;
}

public String getFin_contrat() {
	return fin_contrat;
}

public void setFin_contrat(String fin_contrat) {
	this.fin_contrat = fin_contrat;
}

public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}

public int getNblivraison () {
	return nblivraison ;
}

public void setNblivraison (int nblivraison ) {
	this.nblivraison  = nblivraison ;
}

public int getCouthoraire() {
	return couthoraire;
}

public void setCouthoraire(int couthoraire) {
	this.couthoraire = couthoraire;
}

public int getIddepartement() {
	return iddepartement;
}

public void setIddepartement(int iddepartement) {
	this.iddepartement = iddepartement;
}




	
	

	
	
	

}
