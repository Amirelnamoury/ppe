package controleur;

public class Client {
	private int idclient; 
	private String nomc, prenomc, identifiants, mdp, adresse, ville, cp, telc;

	
	public Client(int idclient, String nomc, String prenomc, String identifiants, String mdp, String adresse,
			String ville, String cp, String telc) {
		
		this.idclient = idclient;
		this.nomc = nomc;
		this.prenomc = prenomc;
		this.identifiants = identifiants;
		this.mdp = mdp;
		this.adresse = adresse;
		this.ville = ville;
		this.cp = cp;
		this.telc = telc;
	}
	
	public Client(String nomc, String prenomc, String identifiants, String mdp, String adresse,
			String ville, String cp, String telc) {
		
		this.idclient = 0;
		this.nomc = nomc;
		this.prenomc = prenomc;
		this.identifiants = identifiants;
		this.mdp = mdp;
		this.adresse = adresse;
		this.ville = ville;
		this.cp = cp;
		this.telc = telc;
	}
	
	public Client ( ) {
		this.idclient = 0;
		this.nomc = "";
		this.prenomc = "";
		this.identifiants = "";
		this.mdp = "";
		this.adresse = "";
		this.ville = "";
		this.cp = "";
		this.telc = "";
		
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public String getNomc() {
		return nomc;
	}

	public void setNomc(String nomc) {
		this.nomc = nomc;
	}

	public String getPrenomc() {
		return prenomc;
	}

	public void setPrenomc(String prenomc) {
		this.prenomc = prenomc;
	}

	public String getIdentifiants() {
		return identifiants;
	}

	public void setIdentifiants(String identifiants) {
		this.identifiants = identifiants;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getTelc() {
		return telc;
	}

	public void setTelc(String telc) {
		this.telc = telc;
	}

	
	
	
	
	


	
	

}
