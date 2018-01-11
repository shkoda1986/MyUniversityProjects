/* IFT 1176-A-E17
 * Auteur: Shkoda Tatsiana
 * Matricule: 20025283
 * TP3: Bibliographie (partie 3)
 */

public class Livre implements Comparable<Livre> {
	/***
	 * Class Livre pour conserver et traiter les atributs d'un livre
	 */
	private String titre;
	private int codeLivre;
	private int codeAuteur;
	private String categorie;
	private int nbPages;
	private double prix;

	/***
	 * 
	 * @param titre:
	 *            une titre du livre
	 * @param codeLivre:
	 *            code du livre
	 * @param codeAuteur:
	 *            code du auteur
	 * @param categorie:
	 *            categorie du livre
	 * @param nbPages:
	 *            numero des pages du livre
	 * @param prix:
	 *            prix du livre
	 */
	public Livre(String titre, int codeLivre, int codeAuteur, String categorie, int nbPages, double prix) {
		this.titre = titre;
		this.codeLivre = codeLivre;
		this.codeAuteur = codeAuteur;
		this.categorie = categorie;
		this.nbPages = nbPages;
		this.prix = prix;
	}

	public int getCodeAuteur() {

		return this.codeAuteur;
	}

	public String getTitre() {
		return this.titre;
	}

	public int getCode() {
		return this.codeLivre;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public int getNbPages() {
		return this.nbPages;
	}

	public double getPrix() {
		return this.prix;
	}

	@Override
	public int compareTo(Livre autre) {

		return titre.compareTo(autre.titre);
	}

	/***
	 * methode toString pour afficher une titre du livre
	 */
	public String toString() {

		return this.titre;

	}

}
