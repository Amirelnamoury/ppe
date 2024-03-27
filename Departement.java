package controleur;

public class Departement 
{
	private int iddepartement;
	private String coded, nomd, uppercase, slug, soundex;
	
	
	public Departement(int iddepartement, String coded, String nomd, String uppercase, String slug, String soundex) {
		
		this.iddepartement = iddepartement;
		this.coded = coded;
		this.nomd = nomd;
		this.uppercase = uppercase;
		this.slug = slug;
		this.soundex = soundex;
	}
	
public Departement( String coded, String nomd, String uppercase, String slug, String soundex) {
		
		this.iddepartement = 0;
		this.coded = coded;
		this.nomd = nomd;
		this.uppercase = uppercase;
		this.slug = slug;
		this.soundex = soundex;
	}

	public Departement ( ) {
		this.iddepartement = 0;
		this.coded = "";
		this.nomd = "";
		this.uppercase = "";
		this.slug = "";
		this.soundex = "";
	
}

	public int getIddepartement() {
		return iddepartement;
	}

	public void setIddepartement(int iddepartement) {
		this.iddepartement = iddepartement;
	}

	public String getCoded() {
		return coded;
	}

	public void setCoded(String coded) {
		this.coded = coded;
	}

	public String getNomd() {
		return nomd;
	}

	public void setNomd(String nomd) {
		this.nomd = nomd;
	}

	public String getUppercase() {
		return uppercase;
	}

	public void setUppercase(String uppercase) {
		this.uppercase = uppercase;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getSoundex() {
		return soundex;
	}

	public void setSoundex(String soundex) {
		this.soundex = soundex;
	}
	
	
	
	
	
	
	
	
	

} // la derniere

