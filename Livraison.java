package controleur;

public class Livraison {
	private int idlivraison;
	private String datelivrais, desclivrais, statut;
	private int idlivreur;
	
	public Livraison(int idlivraison, String datelivrais, String desclivrais, String statut, int idlivreur) {
		
		this.idlivraison = idlivraison;
		this.datelivrais = datelivrais;
		this.desclivrais = desclivrais;
		this.statut = statut;
		this.idlivreur = idlivreur;
	} 
	
	public Livraison(String datelivrais, String desclivrais, String statut, int idlivreur) {
		
		this.idlivraison = 0;
		this.datelivrais = datelivrais;
		this.desclivrais = desclivrais;
		this.statut = statut;
		this.idlivreur = idlivreur;
	} 
	
	public Livraison ( ) {
		this.idlivraison = 0;
		this.datelivrais = "";
		this.desclivrais = "";
		this.statut = "";
		this.idlivreur = 0;
		
	}

	public int getIdlivraison() {
		return idlivraison;
	}

	public void setIdlivraison(int idlivraison) {
		this.idlivraison = idlivraison;
	}

	public String getDatelivrais() {
		return datelivrais;
	}

	public void setDatelivrais(String datelivrais) {
		this.datelivrais = datelivrais;
	}

	public String getDesclivrais() {
		return desclivrais;
	}

	public void setDesclivrais(String desclivrais) {
		this.desclivrais = desclivrais;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public int getIdlivreur() {
		return idlivreur;
	}

	public void setIdlivreur(int idlivreur) {
		this.idlivreur = idlivreur;
	}
	
	
	
	

}
