import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
/***
 * 
 * @author tatsiana shkoda 
 * ce class est pour construire le menu Rapport
 */
public class RapportMenu extends JMenu implements ActionListener {
	private JMenuItem rapportA, rapportL;

	public RapportMenu(String titre) {
		super(titre);
		rapportA = new JMenuItem("par Auteur");
		rapportA.addActionListener(this);
		rapportL = new JMenuItem("par Livre");
		rapportL.addActionListener(this);
		add(rapportA);
		add(rapportL);
	}
/***
 * 
 * @param rapport - le type de rapport(par uteur ou par Livre)
 * @param titre - le titre de dialog
 */
	public void afficherRapport(String rapport, String titre) {
		JDialog dialog = new JDialog();
		dialog.setTitle(titre);

		JTextArea text = new JTextArea(70, 70);

		text.setText(rapport);
		text.setEnabled(false);
		text.setDisabledTextColor(Color.BLUE);
		text.setFont(new Font("Arial", Font.BOLD, 10));
		text.setCaretPosition(0);
		JScrollPane scroll = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		dialog.add(scroll);
		dialog.pack();
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);

	}

	public void afficherError(String titre) {
		JOptionPane.showMessageDialog(null,
				"Vouz ne pouvez pas creer le '" + titre
						+ "' avant d'ajouter le fichier approprié! \n\n Appuyez sur 'F1' pour consulter l'aide en ligne",
				"Attention", JOptionPane.WARNING_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Bdd bdd = (Bdd) Bdd.getBdd();
		Object event = e.getSource();
		if (event == rapportA) {
			try {
				if (bdd.listA.isEmpty())
					afficherError("Rapport par Auteur");
				else {
					bdd.rapportParAuteurs();
					String rapport = bdd.lireRapport("parAuteur.txt");
					afficherRapport(rapport, "Rapport par Auteur");
				}
			} catch (IOException exception) {

			}
		} else if (event == rapportL) {
			try {
				if (bdd.listL.isEmpty())
					afficherError("Rapport par Livre");
				else {
					bdd.rapportParLivres();
					String rapport = bdd.lireRapport("parLivre.txt");
					afficherRapport(rapport, "Rapport par Livre");

				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

	}

}
