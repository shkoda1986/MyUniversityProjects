
/* IFT 1176-A-E17
 * Auteur: Shkoda Tatsiana
 * Matricule: 20025283
 * TP3: Bibliographie (partie 3)
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/***
 * 
 * @author shkodata Class qui va gerer la banque do donnees
 *
 */
public class Bdd implements Signatures {

	private Connection conn;
	private Statement stmt;
	private ResultSet result;   
	
	/***
	 * Constructeur qui fait la connection a BDD
	 */
	public Bdd() {
		ConnectionHelper bean = new ConnectionHelper();
    	try{
		bean.setDriver();
    	conn = bean.getConnection();
    	stmt = conn.createStatement();

    	} catch (Exception ex){
    		System.out.println("Incapable de me connecter a MySQL.");
			System.out.println(ex);
			System.exit(0);
    	} 
    	try {
			stmt.executeUpdate("delete from Auteur");
			stmt.executeUpdate("delete from Livre");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	private static Signatures bdd = new Bdd();
	public static Signatures getBdd(){
		return bdd;
	}
	ArrayList<Auteur> listA = new ArrayList<Auteur>();
	ArrayList<Livre> listL = new ArrayList<Livre>();

	/***
	 * Mathode pour lire un fichier
	 * 
	 * @param nomFichier
	 * @return ArrayList<String>list
	 * @throws IOException
	 */
	public ArrayList<String> lireFichier(String nomFichier) throws IOException {
		boolean presence = true;
		FileReader fr = null;
		ArrayList<String> list = new ArrayList<String>();

		try {
			fr = new FileReader(nomFichier);
		} catch (java.io.FileNotFoundException erreur) {
			System.out.println("La difficulte a ouvrir un fichier " + nomFichier);
			presence = false;
		}
		if (presence) {
			BufferedReader br = new BufferedReader(fr);
			boolean finFichier = false;
			while (!finFichier) {
				String ligne = br.readLine();
				if (ligne == null)
					finFichier = true;
				else
					list.add(ligne);
			}
			br.close();
		}
		return list;
	}

	@Override
	/***
	 * Methode pour lire le fichier initial et ajouter les auteurs sur le BDD
	 */
	public void lireBddAut(String nomFichier) throws IOException {
		ArrayList<String> list = lireFichier(nomFichier);
		StringTokenizer token;
		for (int i = 0; i < list.size(); i++) {
			token = new StringTokenizer(list.get(i), "\t");
			int code = Integer.parseInt(token.nextToken());
			String nom = token.nextToken();
			String pays = token.nextToken();
			Auteur a = new Auteur(nom, code, pays);
			addAuteur(a);
		}
	}

	@Override
	/***
	 * Methode pour ajouter un auteur sur le BDD
	 */
	public void addAuteur(Auteur a) {
		boolean existe = false;
		for (int i = 0; i < listA.size(); i++) {
			if (listA.get(i).getCode() == a.getCode()) {
				existe = true;
			}
		}
		if (!existe) {
			listA.add(a);
			try {
				stmt.executeUpdate("insert into Auteur(Nom,Code,Pays) values('" + a.getNom() + "'," + a.getCode() + ",'" + a.getPays() + "');");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

	@Override
	/***
	 * Methode pour lire le fichier initial et ajouter les livres sur le BDD
	 */
	public void lireBddLivre(String nomFichier) throws IOException {
		ArrayList<String> list = lireFichier(nomFichier);
		StringTokenizer token;
		for (int i = 0; i < list.size(); i++) {
			token = new StringTokenizer(list.get(i), "\t");
			int codeLivre = Integer.parseInt(token.nextToken());
			String titre = token.nextToken();
			String categorie = token.nextToken();
			int codeAuteur = Integer.parseInt(token.nextToken());
			double prix = Double.parseDouble(token.nextToken());
			int nbPages = Integer.parseInt(token.nextToken());
			Livre l = new Livre(titre, codeLivre, codeAuteur, categorie, nbPages, prix);
			addLivre(l);
		}
	}

	@Override
	/***
	 * Methode pour ajouter un livre sur le BDD
	 */
	public void addLivre(Livre l) {
		for (int i = 0; i < listA.size(); i++) {
			if (listA.get(i).getCode() == l.getCodeAuteur()) {
				listL.add(l);
				try {
					stmt.executeUpdate("insert into Livre(Nom,codeLivre,codeAuteur,Categorie,nbPages,Prix) values('" + l.getTitre() + "'," + l.getCode() + ","+ l.getCodeAuteur() + ",'" + l.getCategorie() + "',"+ l.getNbPages() + ","+ l.getPrix() + ");");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	/***
	 * returner un Auteur sur BDD par leur nom
	 */
	public Auteur getAuteur(String nom) {
		try {
			result = stmt.executeQuery("select * from Auteur where Nom like '"+ nom + "';" );
			if(result.next())
				return new Auteur(result.getString("Nom"), result.getInt("Code"), result.getString("Pays"));
			else 
				return null;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	/***
	 * returner un auteur sur BDD par leur code
	 */
	public Auteur getAuteur(int codeAuteur) {
		try {
			result = stmt.executeQuery("select * from Auteur where Code like '"+ codeAuteur + "';" );
			if(result.next())
				return new Auteur(result.getString("Nom"), result.getInt("Code"), result.getString("Pays"));
			else 
				return null;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	/***
	 * retourner un livre sur BDD par la titre
	 */
	public Livre getLivre(String titre) {
		try {
			result = stmt.executeQuery("select * from Livre where Nom like '"+ titre + "';" );
			if(result.next()){
				
				return new Livre(result.getString("Nom"), result.getInt("codeLivre"),result.getInt("codeAuteur"), result.getString("Categorie"), result.getInt("nbPages"), result.getDouble("Prix"));
			}
			else 
				return null;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	/***
	 * retourner un livre sur BDD par la code
	 */
	public Livre getLivre(int codeLivre) {
		try {
			result = stmt.executeQuery("select * from Livre where codeLivre like '"+ codeLivre + "';" );
			if(result.next())
				return new Livre(result.getString("Nom"), result.getInt("codeLivre"),result.getInt("codeAuteur"), result.getString("Categorie"), result.getInt("nbPages"), result.getDouble("Prix"));
			else 
				return null;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	/***
	 * retourner une collection des livres par l'auteur
	 */
	public Collection<Livre> getColLivresAut(Auteur unAuteur) {
		ArrayList<Livre> temp = new ArrayList<Livre>();
		try {
			result = stmt.executeQuery("select * from Livre where codeAuteur=" + unAuteur.getCode() + ";");
			while(result.next()){
				temp.add(new Livre(result.getString("Nom"), result.getInt("codeLivre"),result.getInt("codeAuteur"), result.getString("Categorie"), result.getInt("nbPages"), result.getDouble("Prix")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
		
	}

	@Override
	/***
	 * cree un fichier parAuteur.txt contenant la liste des auteurs et de leurs
	 * livres
	 */
	public void rapportParAuteurs() throws IOException {
		Formatter output = new Formatter("parAuteur.txt");
		ResultSet resultL;
		String [] s = new String[listA.size()];
		int index = 0;
		try {
			result = stmt.executeQuery("select * from Auteur order by Nom;" );

			while( result.next() ) {
				s[index] = result.getString("Nom");
				index++;
			}
					
			
			for(int i = 0; i < s.length; i++){
				output.format("\n%s:\n", s[i]);
				resultL = stmt.executeQuery("select Auteur.Nom, Livre.Nom, Categorie, Prix, nbPages from Livre, Auteur where Auteur.Code = codeAuteur and Auteur.nom = '" + s[i]  +"' order by Auteur.Nom, Livre.Nom;");				
	    			while(resultL.next() && resultL.getString("Auteur.Nom").equals(s[i])){
					output.format("\t %-42s \t\t%-10s \t %-5.2f$ \t%d %n", resultL.getString("Livre.Nom"), resultL.getString("Categorie"), resultL.getDouble("Prix"), resultL.getInt("nbPages"));	
	    			}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception in querry!");

		}
		
		output.close();

	}

	@Override
	/***
	 * cree un fichier parLivre.txt contenant la liste des livres et des auteurs
	 */
	public void rapportParLivres() throws IOException {
		Formatter output = new Formatter("parLivre.txt");
		try {
			result = stmt.executeQuery("select Livre.Nom, Categorie, Prix, nbPages, Auteur.Nom from Livre, Auteur where Auteur.Code = codeAuteur order by Livre.Nom;" );
			while( result.next() ) {
	    			output.format("%-42s\t\t%-14s\t %-5.2f$\t%-10d%s %n", result.getString("Nom"), result.getString("Categorie"), result.getDouble("Prix"), result.getInt("nbPages"), result.getString("Auteur.Nom"));		
			}
		} catch (SQLException e) {

		}
		output.close();
	}


	public String lireRapport(String nomFichier){
		StringBuilder rapport = new StringBuilder();
		FileReader fr = null;
		boolean presence = true;
		try {
			fr = new FileReader(nomFichier);
		} catch (java.io.FileNotFoundException erreur) {
			System.out.println("La difficulte a ouvrir un fichier " + nomFichier);
			presence = false;
		}
		if (presence) {
			try{
			BufferedReader br = new BufferedReader(fr);
			boolean finFichier = false;
			while (!finFichier) {
				
				String ligne = br.readLine();
				if (ligne == null)
					finFichier = true;
				else{
					rapport.append(ligne);
					rapport.append("\n");
				}
				}
			
			br.close();}
			catch(IOException e){
				
			}
			
		}
		
		return rapport.toString();
	}

}
