/* IFT 1176-A-E17
 * Auteur: Shkoda Tatsiana
 * Matricule: 20025283
 * TP3: Bibliographie (partie 3)
 */

//Class Auteur pour conserver et traiter les attributes d'un auteur
public class Auteur implements Comparable<Auteur> {
	public String nom;
	private int code;
	private String pays;

	/***
	 * 
	 * @param nom:
	 *            nom d'un auteur
	 * @param code:
	 *            code d'un auteur
	 * @param pays:
	 *            pays d'un auteur
	 */
	public Auteur(String nom, int code, String pays) {
		this.nom = nom;
		this.code = code;
		this.pays = pays;
	}

	public String getNom() {

		return this.nom;
	}

	public int getCode() {
		return this.code;
	}

	public String getPays() {
		return this.pays;
	}

	@Override
	/***
	 * pour trier la liste des auteurs
	 */
	public int compareTo(Auteur autre) {

		return this.nom.compareTo(autre.nom);
	}

	public String toString() {
		return this.nom;
	}

}
