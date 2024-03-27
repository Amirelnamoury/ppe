package controleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel 
{
		private String entetes [];
		private Object donnees [][];
		public Tableau (Object donnees [][], String entetes []) {
			this.donnees = donnees;
			this.entetes = entetes;
		}
	
	
	@Override
	public int getRowCount() {
		return this.donnees.length;
	}
	
	@Override
	public int getColumnCount() {
		return this.entetes.length;
	}
	
	@Override
	public Object getValueAt(int indiceLigne, int indiceColonne) {
		return this.donnees[indiceLigne][indiceColonne];
	}
	
	
	@Override
	public String getColumnName(int indiceColonne) {
		return this.entetes[indiceColonne];
	}
	
	public void ajouterLigne (Object [] ligne)
	{
		Object matrice [] [] = new Object[this.donnees.length +1] [this.entetes.length];
		int i=0;
		for ( i = 0; i <this.donnees.length; i++)
		{
			matrice [i] = this.donnees[i]; // recopie ligne par ligne 
		}
		matrice[this.donnees.length] = ligne; 
		// actualisation des donnees 
		
		this.donnees = matrice; 
		this.fireTableDataChanged(); // reprendre la donnee et changer 
		
	}
	
	public void supprimerLigne (int indiceLigne) 
	{
		Object matrice [] [] = new Object[this.donnees.length -1] [this.entetes.length];
		int i=0, j = 0; 
		for ( i = 0; i <this.donnees.length; i++)
		{
			if (i != indiceLigne)
			{
				matrice [j] = this.donnees[i]; // recopie ligne par ligne 
				j++; // nombre de ligne de la nouvelle matrice i c'est l'ancienne
			}
			
		}
		// actualisation des donnees
		this.donnees = matrice; 
		this.fireTableDataChanged(); // reprendre la donnee et changer 
		
		
	}
	
	public void modifierLigne (int indiceLigne, Object [] ligne)
	{
		Object matrice [] [] = new Object[this.donnees.length ] [this.entetes.length];
		int i=0, j = 0; 
		for ( i = 0; i <this.donnees.length; i++)
		{
			if (i != indiceLigne)
			{
				matrice [j] = this.donnees[i]; // recopie ligne par ligne 
				j++; // nombre de ligne de la nouvelle matrice i c'est l'ancienne
			}else {
				matrice [j] = ligne;
				j++; 
			}
			
		}
		this.donnees = matrice; 
		this.fireTableDataChanged(); // reprendre la donnee et changer
	}
	
	public void setDonnees (Object matrice [] [] )
	{
		this.donnees = matrice; 
		this.fireTableDataChanged(); // reprendre la donnee et changer
		// ACTUALISATION DE LA MATRICE
	}
	
}