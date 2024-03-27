package controleur;

public class Produit {
	private int idproduit;
	private String nomp, descp; 
	private int prix, stock;
	private String provenance;
	
	public Produit(int idproduit, String nomp, String descp, int prix, int stock,String provenance) {
		
		this.idproduit = idproduit;
		this.nomp = nomp;
		this.descp = descp;
		this.prix = prix;
		this.stock = stock;
		this.provenance = provenance;
	}
	
	public Produit( String nomp, String descp, int prix, int stock,String provenance) {
		this.idproduit = 0;
		this.nomp = nomp;
		this.descp = descp;
		this.prix = prix;
		this.stock = stock;
		this.provenance = provenance;
		
	}
	
	public Produit() {
		this.idproduit = 0;
		this.nomp ="";
		this.descp = "";
		this.prix = 0;
		this.stock = 0; 
		this.provenance ="";
	}

	public int getIdproduit() {
		return idproduit;
	}

	public void setIdproduit(int idproduit) {
		this.idproduit = idproduit;
	}

	public String getNomp() {
		return nomp;
	}

	public void setNomp(String nomp) {
		this.nomp = nomp;
	}

	public String getDescp() {
		return descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getProvenance() {
		return provenance;
	}

	public void setProvenance(String provenance) {
		this.provenance = provenance;
	}
	
	

}
