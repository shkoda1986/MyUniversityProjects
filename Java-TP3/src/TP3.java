
/* IFT 1176-A-E17
 * Auteur: Shkoda Tatsiana
 * Matricule: 20025283
 * TP3: Bibliographie (partie 3)
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
/***
 * 
 * @author tatsiana shkoda 
 * le class principal pour lancer l'application 
 */
public class TP3 extends JFrame {
	public TP3() {
		setLayout(new BorderLayout());
		setTitle("Bibliographie");
		setSize(650, 450);
		ImageIcon image = new ImageIcon("bibliographie.png");
		JLabel label = new JLabel();
		label.setIcon(image);
		add(label, BorderLayout.CENTER);

		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);

		JMenu fichierMenu = new FichierMenu("Fichier");
		JMenu editionMenu = new EditionMenu("Edition");
		JMenu rapportMenu = new RapportMenu("Rapport");
		JMenu aideMenu = new AideMenu("Aide");

		menu.add(fichierMenu);
		menu.add(editionMenu);
		menu.add(rapportMenu);
		menu.add(aideMenu);

		show();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new TP3();

	}

}
