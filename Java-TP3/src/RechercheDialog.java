import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;

import javax.swing.*;
/***
 * 
 * @author tatsiana shkoda 
 * ce class est pour construire le dialog pour faire le recherche par Auteur ou par Livre
 * sur le base de donnees
 */
public class RechercheDialog extends JDialog implements ActionListener {
	private JTextField text;
	private String param;
	private NumberFormat nf = new DecimalFormat("#0.00");
	JButton button;
	Auteur auteur;
	Livre livre;
	Signatures bdd = Bdd.getBdd();
/***
 * 
 * @param titre - titre du dialog
 * @param param - indication sur le type de recherche
 */
	public RechercheDialog(String titre, String param) {
		this.param = param;
		JDialog dialog = new JDialog();
		dialog.setTitle(titre);
		dialog.setSize(650, 150);
		JPanel panel = new JPanel();
		text = new JTextField(25);
		button = new JButton("Chercher");
		button.addActionListener(this);
		if (param.equals("auteur")) {
			text.setToolTipText("Veillez entrer le nom ou le code de l'auteur");
		} else {
			text.setToolTipText("Veillez entrer le nom ou le code du livre");
		}
		panel.add(text);
		panel.add(button);
		dialog.add(panel);
		dialog.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		Object event = action.getSource();
		Collection oeuvres = null;
		if (event == button && param.equals("auteur")) {
			try {
				auteur = bdd.getAuteur(Integer.valueOf(text.getText()));
				if (auteur == null) {
					JOptionPane.showMessageDialog(null, "L'auteur avec code " + text.getText() + " n'existe pas!",
							"Attention", JOptionPane.WARNING_MESSAGE);
				} else
					oeuvres = bdd.getColLivresAut(auteur);

			} catch (Exception e) {
				auteur = bdd.getAuteur(text.getText());
				if (auteur == null)
					JOptionPane.showMessageDialog(null, "L'auteur " + text.getText() + " n'existe pas!", "Attention",
							JOptionPane.WARNING_MESSAGE);
				else
					oeuvres = bdd.getColLivresAut(auteur);

			}
			if (auteur != null) {
				String s = "Les oeuvres de " + auteur.getNom() + ":\n";
				if (oeuvres.isEmpty())
					s += "Aucun livre trouv�";
				else {
					for (Object l : oeuvres) {
						s += l;
						s += "\n";
					}
				}
				JOptionPane.showMessageDialog(null, s, "Les oeuvres de l'auteur", JOptionPane.INFORMATION_MESSAGE);
			}
			text.setText("");
		} else if (event == button && param.equals("livre")) {
			try {
				livre = bdd.getLivre(Integer.valueOf(text.getText()));
				if (livre == null) {
					JOptionPane.showMessageDialog(null, "Le livre avec code " + text.getText() + " n'existe pas!",
							"Attention", JOptionPane.WARNING_MESSAGE);
				}

			} catch (Exception e) {
				livre = bdd.getLivre(text.getText());
				if (livre == null)
					JOptionPane.showMessageDialog(null, "Le livre " + text.getText() + " n'existe pas!", "Attention",
							JOptionPane.WARNING_MESSAGE);

			}
			if (livre != null) {
				int codeNum = livre.getCodeAuteur();
				String nom = bdd.getAuteur(codeNum).getNom();
				String s = "Le livre " + livre.getTitre() + " de " + nom + ":\n";
				s += "Code du livre: " + livre.getCode() + ",\n";
				s += "Cat�gorie du livre: " + livre.getCategorie() + ",\n";
				s += "Prix du livre: " + nf.format(livre.getPrix()) + "$,\n";
				s += "Nombre de pages: " + livre.getNbPages();

				JOptionPane.showMessageDialog(null, s, "Information sur le livre recherch�",
						JOptionPane.INFORMATION_MESSAGE);
			}
			text.setText("");

		}

	}

}
