import java.awt.event.*;
import javax.swing.*;

/***
 * 
 * @author tatsiana shkoda ce class est pour construire le menu Aide
 */

public class AideMenu extends JMenu implements ActionListener {
	private JMenuItem aide, aPropos;

	/***
	 * 
	 * @param titre
	 *            - le titre du menu Aide
	 */
	public AideMenu(String titre) {
		super(titre);
		aide = new JMenuItem("Aide");
		aide.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		aide.addActionListener(this);
		aPropos = new JMenuItem("� propos de Bibliographie");
		aPropos.addActionListener(this);
		add(aide);
		add(aPropos);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		if (event == aPropos) {
			JOptionPane.showMessageDialog(this,
					"Application Bibliographie\n\n" + "Version 1.3 beta\n"
							+ "Par: Tatsiana Shkoda  (Matricule: 20025283)\n" + "Pour le cours IFT1176-A-E17 - TP2\n"
							+ "(c) Copyright Tatsiana Shkoda",
					"� propos de Bibliographie", JOptionPane.PLAIN_MESSAGE, new ImageIcon("livre.jpg"));
		} else if (event == aide) {
			JOptionPane.showMessageDialog(this,

					"Bienvenue dans Bibliographie!\n" + "\n" + "UTILISATION DE BASE:\n"
							+ "Ce programme vous permettra de maintenir une base de donn�es liant des auteurs et \n"
							+ "des livres. Vous pouvez ins�rer des donn�es une par une au moyen du menu d'�dition\n"
							+ "ou lire les fichier de donn�es pour les auteurs et les livres � l'aide du menu Fichier.\n\n"
							+

							"MENU FICHIER:\n" + "Lire fichier des auteurs:    \n"
							+ "Fichier>Ouvrir>Auteurs...  ou appuez sur ctrl+shift+a \n"
							+ "Lire fichier des livres:    \n"
							+ "Fichier>Ouvrir>Livres...  ou appuez sur ctrl+shift+l \n" + "Quitter l'application:    \n"
							+ "Fichier>Quitter  ou appuez sur ctrl+shift+q \n\n" + "MENU EDITION:\n"
							+ "Ici vous pouvez ins�rer les livres ou les auteurs sur le base de donn�es et faire la \n"
							+ "recherche par la base des donn�es \n" + "Inserer des auteurs:    \n"
							+ "Edition>Ajouter>Auteur...  ou appuez sur alt+shift+a \n" + "Inserer des livres:    \n"
							+ "Edition>Ajouter>Livre...  ou appuez sur alt+shift+l \n" + "Chercher des auteurs:    \n"
							+ "Edition>Chercher>Auteur...  ou appuez sur ctrl+a \n" + "Chercher des livres:    \n"
							+ "Edition>Chercher>Livre...  ou appuez sur ctrl+l \n\n" + "MENU RAPPORT:\n"
							+ "Ici vous pouvez generer les rapports par les auteurs ou par les livres\n"
							+ "Generer le rapport par les auteurs:    \n" + "Rapport>par Auteur\n"
							+ "Generer le rapport par les livres:    \n" + "Rapport>par Livre\n" + "   \n" + "   \n",
					"Bibliographie - Aide", JOptionPane.PLAIN_MESSAGE);
		}

	}

}
