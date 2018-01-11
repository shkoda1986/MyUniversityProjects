import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
/***
 * 
 * @author tatsiana shkoda 
 * ce class est pour construire le menu Fichier
 */

public class FichierMenu extends JMenu implements ActionListener {

	private JMenuItem ouvrirA, ouvrirL, quitter;

	public FichierMenu(String titre) {
		super(titre);
		JMenu ouvrirMenu = new JMenu("Ouvrir");
		ouvrirA = new JMenuItem("Auteurs...");
		ouvrirA.addActionListener(this);
		ouvrirA.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK));
		ouvrirL = new JMenuItem("Livres...");
		ouvrirL.addActionListener(this);
		ouvrirL.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK));
		ouvrirMenu.add(ouvrirA);
		ouvrirMenu.add(ouvrirL);
		quitter = new JMenuItem("Quitter"); 
		quitter.addActionListener(this);
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK));
		add(ouvrirMenu);
		add(new JSeparator());
		add(quitter);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Signatures bdd = Bdd.getBdd();
		Object event = e.getSource();
		if (event == ouvrirA) {
			JFileChooser choisirAuteur = new JFileChooser(new File("."));
			choisirAuteur.setFileFilter(new FileNameExtensionFilter(".txt", "txt"));
			choisirAuteur.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			choisirAuteur.setApproveButtonText("Ajouter");
			choisirAuteur.setDialogTitle("Choisir un fichier de donn�es pour les auteurs");
			choisirAuteur.setAcceptAllFileFilterUsed(false);
			int returnVal = choisirAuteur.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					bdd.lireBddAut(choisirAuteur.getSelectedFile().getName());
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}

		} else if (event == ouvrirL) {

			JFileChooser choisirLivres = new JFileChooser(new File("."));
			choisirLivres.setFileFilter(new FileNameExtensionFilter(".txt", "txt"));
			choisirLivres.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			choisirLivres.setApproveButtonText("Ajouter");
			choisirLivres.setDialogTitle("Choisir un fichier de donn�es pour les livres");
			choisirLivres.setAcceptAllFileFilterUsed(false);
			int returnVal = choisirLivres.showOpenDialog(null);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					bdd.lireBddLivre(choisirLivres.getSelectedFile().getName());
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}

		} else if (event == quitter) {
			JFrame frame = (JFrame) new TP3();
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}

	}

}
