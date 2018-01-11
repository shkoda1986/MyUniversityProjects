import java.awt.event.*;
import javax.swing.*;

/***
 * 
 * @author tatsiana shkoda 
 * ce class est pour construire le menu Edition
 */

public class EditionMenu extends JMenu implements ActionListener {
	private JMenuItem ajouterAuteur, ajouterLivre, chercherAuteur, chercherLivre;
	JButton button;
	Signatures bdd = Bdd.getBdd();

	public EditionMenu(String titre) {
		super(titre);
		JMenu ajouterMenu = new JMenu("Ajouter");
		ajouterAuteur = new JMenuItem("Auteur...");
		ajouterAuteur.addActionListener(this);
		ajouterAuteur
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK + InputEvent.SHIFT_MASK));
		ajouterLivre = new JMenuItem("Livre...");
		ajouterLivre.addActionListener(this);
		ajouterLivre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK + InputEvent.SHIFT_MASK));
		ajouterMenu.add(ajouterAuteur);
		ajouterMenu.add(ajouterLivre);
		add(ajouterMenu);
		JMenu chercherMenu = new JMenu("Chercher");
		chercherAuteur = new JMenuItem("Auteur...");
		chercherAuteur.addActionListener(this);
		chercherAuteur.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		chercherLivre = new JMenuItem("Livre...");
		chercherLivre.addActionListener(this);
		chercherLivre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		chercherMenu.add(chercherAuteur);
		chercherMenu.add(chercherLivre);
		add(chercherMenu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object event = e.getSource();
		if (event == ajouterAuteur) {
			new AjouterAuteurDialog("Ajouter d'un auteur");
		} else if (event == ajouterLivre) {
			new AjouterLivreDialog("Ajouter d'un livre");
		} else if (event == chercherAuteur) {
			new RechercheDialog("Recherche d'un auteur", "auteur");
		} else if (event == chercherLivre) {
			new RechercheDialog("Recherche d'un livre", "livre");

		}

	}

}
