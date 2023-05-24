import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	private Bibliotheque bibliotheque;
	private Scanner sc;

	public Test() {
		bibliotheque = new Bibliotheque();
		sc = new Scanner(System.in);
		this.afficherMenu();
		sc.close();
	}
	
	public Lecteur saisirLecteur() {
		System.out.println("Saisir le nom du lecteur : ");
		String nom = sc.nextLine();
		System.out.println("Saisir le prénom du lecteur : ");
		String prenom = sc.nextLine();
		System.out.println("Saisir le numéro de téléphone du lecteur : ");
		String tel = sc.nextLine();
		Lecteur lecteur = new Lecteur(nom, prenom, tel);  
		return lecteur;		
	}
	
	public Livre saisirLivre() {
		ArrayList<String> auteurs = new ArrayList<String>();
		System.out.println("Saisir le titre du livre : ");
		String titre = sc.nextLine();
		System.out.println("Saisir le nombre d'auteurs du livre : ");
		int nb = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i<nb; i++) {
			System.out.println("Saisir le nom de l'auteur #" + i + " : ");
			String s = sc.nextLine();
			auteurs.add(s);
		}
		Livre livre = new Livre(titre, auteurs);
		return livre;
	}
	
	public int saisirNumeroLecteur() {
		int numero;
		System.out.println("Saisir le numéro du lecteur : ");
		numero = sc.nextInt();
		sc.nextLine();
		return numero;
	}
	
	public long saisirNumeroLivre() {
		long numero;
		System.out.println("Saisir le numéro du livre : ");
		numero = sc.nextLong();
		return numero;
	}
	
	public static void clearScreen() {    
		for (int i=0; i<2; i++)
			System.out.println();
	}
	
	public void afficherMenu() {
		int choix;
		do {
			clearScreen();
			System.out.println();
			System.out.println("****** GESTION DE LA BIBLIOTHEQUE ******");
			System.out.println();
			System.out.println("1 - Enregistrer un nouveau lecteur");
			System.out.println("2 - Enregistrer un nouveau livre");
			System.out.println("3 - Supprimer un livre");
			System.out.println("4 - Enregistrer le prêt d'un livre");
			System.out.println("5 - Enregistrer le retour d'un livre");
			System.out.println("6 - Editer un bilan des livres prêtés");
			System.out.println("0 - Quitter");
			System.out.println();		
			System.out.print("Entrer votre choix : ");
			choix = sc.nextInt();
			sc.nextLine();
			System.out.println();

			switch (choix) {
			case 1 : 	
				Lecteur lecteur = this.saisirLecteur() ;
				bibliotheque.ajouterLecteur(lecteur);
				System.out.print("Voici votre numéro de lecteur : " + lecteur.getNumero());
				break;
			case 2 :
				Livre livre = this.saisirLivre();
				bibliotheque.ajouterLivre(livre);
				System.out.print("Le numéro : " + livre.getNumero() + " a été attribué au livre " + livre.getTitre());
				break;
			case 3 :
				bibliotheque.retirer(this.saisirNumeroLivre());
				break;
			case 4 :
				try {
					bibliotheque.preter(this.saisirNumeroLivre(), this.saisirNumeroLecteur());					
				}
				catch (PretImpossible e) {
					System.out.println("RENDS LES LIVRES !!!");
				}
				break;
			case 5 :
				bibliotheque.retourner(this.saisirNumeroLivre());
				break;
			case 6 :
				bibliotheque.editerBilan();
				break;
			}

		}
		while (choix != 0);	
	}
	
	public static void main(String[] args) {
		new Test();
		
		


	}

}
