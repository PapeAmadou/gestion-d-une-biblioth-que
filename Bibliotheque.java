import java.util.ArrayList;
import java.util.Date;

public class Bibliotheque implements InterfaceBibliotheque {
	private ArrayList<Livre> livres;
	private ArrayList<Lecteur> lecteurs;
	
	public Bibliotheque() {
		livres = new ArrayList<Livre>();
		lecteurs = new ArrayList<Lecteur>();
	}
	
	public int ajouterLecteur(Lecteur lecteur) {
		lecteurs.add(lecteur);
		return lecteur.getNumero();
	}
	
	public long ajouterLivre(Livre livre) {
		livres.add(livre);
		return livre.getNumero();
	}

	public void retirer(long numeroLivre) {
		Livre livre = this.chercherLivreParNumero(numeroLivre);
		livres.remove(livre);
		System.out.println("Le livre #" + livre.getNumero() + " a été supprimé...");
	}

	public void preter(long numeroLivre, int numeroLecteur) throws PretImpossible {
		Livre livre = this.chercherLivreParNumero(numeroLivre);
		Lecteur lecteur = this.chercherLecteurParNumero(numeroLecteur);
		
		if (lecteur.nombreLivresEmpruntes() < Bibliotheque.nbEmpruntsMax ) {
			lecteur.incrementerCompteurLivres();
			livre.setEmprunteur(lecteur);
			livre.setDateEmprunt(new Date());
			System.out.println("Le livre #" + livre.getNumero() + " a été prêté au lecteur #" + lecteur.getNumero() + "...");
		}
		else {
			throw new PretImpossible();
			//System.out.println("Le lecteur a atteint le quota de livres qu'il peut emprunter...");
		}
	}
	
	public Lecteur chercherLecteurParNumero(long numero) {
		Lecteur l = null;
		for (int i = 0; i < lecteurs.size(); i++) 
			if (lecteurs.get(i).getNumero() == numero)
				l = lecteurs.get(i);
		return l;
	}

	public Livre chercherLivreParNumero(long numero) {
		Livre l = null;
		for (int i = 0; i < livres.size(); i++) 
			if (livres.get(i).getNumero() == numero) {
				l = livres.get(i);
				break; 	// Permet de quitter la boucle for dès que le livre cherché a été trouvé
			}
		return l;
	}
	
	public void retourner(long numeroLivre) {
		Livre l = this.chercherLivreParNumero(numeroLivre);
		if (l != null) {
			l.getEmprunteur().decrementerCompteurLivres();
			l.setEmprunteur(null);
			l.setDateEmprunt(null);
			System.out.println("Livre numero " + numeroLivre + " de nouveau disponible pour le prêt...");
		}
		else {
			System.out.println("Numéro de livre invalide...");
		}
		
	}

	public void editerBilan() {
		Livre l = null;
		for (int i = 0; i < livres.size(); i++) 
			if (livres.get(i).getEmprunteur() != null) {
				Livre livre = livres.get(i);
				System.out.println();
				System.out.println("Le livre " + livre.getTitre() + ", numéro " + livre.getNumero() + " est emprunté par M/Mme " + livre.getEmprunteur().getNom() + " (" + livre.getEmprunteur().getTel() + ") depuis le " + livre.getDateEmprunt());
				System.out.println();
			}
	}
}
