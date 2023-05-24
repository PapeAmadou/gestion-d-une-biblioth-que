
public class Lecteur {

	private String nom;
	private String prenom;
	private int numeroLecteur;
	private String tel;
	private int compteurLivresEmpruntes;
	private static int compteur = 0;
	
	public Lecteur(String nom, String prenom, String tel) {
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.compteurLivresEmpruntes = 0;
		compteur++;
		this.numeroLecteur = compteur;
	}
	
	public int getNumero() {
		return numeroLecteur;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getTel() {
		return tel;
	}
	
	public int nombreLivresEmpruntes() {
		return compteurLivresEmpruntes;
	}
	
	public void incrementerCompteurLivres() {
		compteurLivresEmpruntes++;
	}
	
	public void decrementerCompteurLivres() {
		compteurLivresEmpruntes--;
	}

}
