package controleur;

public class Utilisateur {
	private int iduser;
	private String nom, prenom, email, password, droits;
	private int idClient;
	
	public Utilisateur(int iduser, String nom, String prenom, String email, String password, String droits, int idclient) {
		
		this.iduser = iduser;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.droits = droits;
		this.idClient = idclient;
	}
	
	public Utilisateur(String nom, String prenom, String email, String mdp, String droits, int idclient) {
		
		this.iduser = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.droits = droits;
		this.idClient = idclient;
	}
	
	public Utilisateur ( ) {
		this.iduser = 0;
		this.nom = "";
		this.prenom = "";
		this.email = "";
		this.password = "";
		this.droits = "";
		this.idClient = 0;
		
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDroits() {
		return droits;
	}

	public void setDroits(String droits) {
		this.droits = droits;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	
	
	
	

}
