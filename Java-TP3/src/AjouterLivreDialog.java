import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/***
 * 
 * @author tatsiana shkoda ce class est pour construire le dialog pour ajouter
 *         les livres
 */
public class AjouterLivreDialog extends JDialog implements ActionListener {
	private JTextField titreText, codeLivreText, codeAuteurText, categorieText, nbPagesText, prixText;
	private JLabel titreLabel, codeLivreLabel, codeAuteurLabel, categorieLabel, nbPagesLabel, prixLabel;
	JDialog dialog;
	JButton button;
	Auteur auteur;
/***
 * 
 * @param titre - le titre du dialog
 */
	public AjouterLivreDialog(String titre) {
		JDialog dialog = new JDialog();
		dialog.setTitle(titre);
		dialog.setLayout(new BorderLayout());
		dialog.setPreferredSize(new Dimension(650, 250));
		dialog.setResizable(false);
		JPanel panel = new JPanel(new BorderLayout());
		JPanel labelPanel = new JPanel(new GridLayout(6, 6));
		panel.setBorder(new TitledBorder(
				"Veuillez remplir toutes les champs pour ajouter un nouveau livre sur le base de donn�es\n"));
		titreLabel = new JLabel("Titre: ");
		titreText = new JTextField(25);
		codeLivreLabel = new JLabel("Code du livre: ");
		codeLivreText = new JTextField(25);
		codeAuteurLabel = new JLabel("Code de l'auteur: ");
		codeAuteurText = new JTextField(25);
		categorieLabel = new JLabel("Cat�gorie: ");
		categorieText = new JTextField(25);
		nbPagesLabel = new JLabel("Nombre de pages: ");
		nbPagesText = new JTextField(25);
		prixLabel = new JLabel("Le Prix: ");
		prixText = new JTextField(25);
		labelPanel.add(titreLabel);
		labelPanel.add(titreText);
		labelPanel.add(codeLivreLabel);
		labelPanel.add(codeLivreText);
		labelPanel.add(codeAuteurLabel);
		labelPanel.add(codeAuteurText);
		labelPanel.add(categorieLabel);
		labelPanel.add(categorieText);
		labelPanel.add(nbPagesLabel);
		labelPanel.add(nbPagesText);
		labelPanel.add(prixLabel);
		labelPanel.add(prixText);
		panel.add(labelPanel);
		dialog.add(panel, BorderLayout.NORTH);
		JPanel buttonPane = new JPanel();
		button = new JButton("Ajouter");
		button.setPreferredSize(new Dimension(100, 20));
		button.addActionListener(this);
		buttonPane.add(button);
		dialog.add(buttonPane, BorderLayout.SOUTH);
		dialog.pack();
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		Object event = action.getSource();
		Bdd bdd = (Bdd) Bdd.getBdd();
		String titre = null;
		int codeLivre = 0;
		int codeAuteur = 0;
		String categorie = null;
		int nbPages = 0;
		double prix = 0;
		if (event == button) {
			try {
				codeAuteur = Integer.parseInt(codeAuteurText.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Le valeur 'Code de l'auteur' doit etre le numero!", "Attention",
						JOptionPane.WARNING_MESSAGE);
			}
			try {
				codeLivre = Integer.parseInt(codeLivreText.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Le valeur 'Code du livre' doit etre le numero!", "Attention",
						JOptionPane.WARNING_MESSAGE);
			}
			try {
				nbPages = Integer.parseInt(nbPagesText.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Le valeur 'Numero de pages' doit etre le numero!", "Attention",
						JOptionPane.WARNING_MESSAGE);
			}
			try {
				prix = Double.parseDouble(prixText.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Le valeur 'Prix' doit etre le numero!", "Attention",
						JOptionPane.WARNING_MESSAGE);
			}
			if (titreText.getText().length() == 0)
				JOptionPane.showMessageDialog(null, "Veuillez remplir le champ 'Titre'", "Attention",
						JOptionPane.WARNING_MESSAGE);
			else
				titre = titreText.getText();
			if (categorieText.getText().length() == 0)
				JOptionPane.showMessageDialog(null, "Veuillez remplir le champ 'Cat�gorie'", "Attention",
						JOptionPane.WARNING_MESSAGE);
			else
				categorie = categorieText.getText();
			int mapSize = bdd.listL.size();
			if (codeAuteur != 0 && codeLivre != 0 && nbPages != 0 && prix != 0.0 && !titre.equals("")
					&& !categorie.equals(""))
				bdd.addLivre(new Livre(titre, codeLivre, codeAuteur, categorie, nbPages, prix));
			int newMapSize = bdd.listL.size();
			if (newMapSize > mapSize) {
				JOptionPane.showMessageDialog(null, "Le livre a �t� ajouter sur le base de donn�es", "Succ�s",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "L'auteur inexistant. Le livre n'a pas �t� ajouter!", "Attention",
						JOptionPane.WARNING_MESSAGE);
			}
			titreText.setText("");
			codeLivreText.setText("");
			codeAuteurText.setText("");
			categorieText.setText("");
			nbPagesText.setText("");
			prixText.setText("");
		}

	}

}
