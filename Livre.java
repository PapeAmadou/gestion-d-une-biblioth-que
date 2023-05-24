import java.util.ArrayList;
import java.util.Date;

public class Livre {

	private String titre;
	private ArrayList<String> auteurs;
	private long numero;
	private Lecteur emprunteur;
	private Date dateEmprunt;
	private static long compteur = 0;
	
	public Livre(String tit, ArrayList<String> auteurs) {
		titre = tit;
		this.auteurs = auteurs;
		this.compteur++;
		this.numero = compteur;
	}
	
	public long getNumero() {
		return numero;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public Date getDateEmprunt() {
		return dateEmprunt;
	}
	
	public Lecteur getEmprunteur() {
		return emprunteur;
	}
	
	public void setEmprunteur(Lecteur lecteur) {
		emprunteur = lecteur;
	}
	
	public void setDateEmprunt(Date date) {
		dateEmprunt = date;
	}
	
	public void emprunter(Lecteur lecteur) {
		this.emprunteur = lecteur;
		dateEmprunt = new Date();
		System.out.println(dateEmprunt);
		
		
	}
}
