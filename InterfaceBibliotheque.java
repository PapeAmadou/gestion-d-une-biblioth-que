public interface InterfaceBibliotheque {
	
	public static final int nbEmpruntsMax = 5;
	
	public int ajouterLecteur(Lecteur lecteur);
	
	public long ajouterLivre(Livre livre);
	
	public void retirer(long numeroLivre);
	
	public void preter(long numeroLivre, int numeroLecteur) throws PretImpossible;
	
	public void retourner(long numeroLivre);
	
	public void editerBilan();

}
