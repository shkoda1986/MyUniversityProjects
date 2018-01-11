import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/***
 * 
 * @author tatsiana shkoda 
 * ce class est pour construire le dialog pour ajouter
 *         les auteurs
 */
public class AjouterAuteurDialog extends JDialog implements ActionListener {
	private JTextField nomText, codeText, paysText;
	private JLabel nomLabel, codeLabel, paysLabel;
	JDialog dialog;
	JButton button;
	Auteur auteur;

	/***
	 * 
	 * @param titre
	 *            - le titre du dialog
	 */
	public AjouterAuteurDialog(String titre) {
		JDialog dialog = new JDialog();
		dialog.setTitle(titre);
		dialog.setLayout(new BorderLayout());
		dialog.setPreferredSize(new Dimension(650, 150));
		dialog.setResizable(false);
		JPanel panel = new JPanel(new BorderLayout());
		JPanel labelPanel = new JPanel(new GridLayout(3, 3));
		panel.setBorder(new TitledBorder(
				"Veuillez remplir toutes les champs pour ajouter un nouveau auteur sur le base de donn�es\n"));
		nomLabel = new JLabel("Nom de l'auteur");
		nomText = new JTextField(25);
		codeLabel = new JLabel("Code de l'auteur");
		codeText = new JTextField(25);
		paysLabel = new JLabel("Pays de l'auteur");
		paysText = new JTextField(25);
		labelPanel.add(nomLabel);
		labelPanel.add(nomText);
		labelPanel.add(codeLabel);
		labelPanel.add(codeText);
		labelPanel.add(paysLabel);
		labelPanel.add(paysText);
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
		String nom = "", pays = "";
		int code = 0;
		if (event == button) {
			try {
				code = Integer.parseInt(codeText.getText());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Le valeur 'Code de l'auteur' doit etre le numero!", "Attention",
						JOptionPane.WARNING_MESSAGE);
				codeText.setText("");
			}
			if (nomText.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Veuillez remplir le champ 'Nom de l'auteur'", "Attention",
						JOptionPane.WARNING_MESSAGE);
			} else
				nom = nomText.getText();
			if (paysText.getText().length() == 0)
				JOptionPane.showMessageDialog(null, "Veuillez remplir le champ 'Pays de l'auteur'", "Attention",
						JOptionPane.WARNING_MESSAGE);
			else
				pays = paysText.getText();
			int mapSize = bdd.listA.size();
			if (code != 0 && !nom.equals("") && !pays.equals(""))
				bdd.addAuteur(new Auteur(nom, code, pays));
			int newMapSize = bdd.listA.size();
			if (newMapSize > mapSize) {
				JOptionPane.showMessageDialog(null, "L'auteur a �t� ajouter sur le base de donn�es", "Succ�s",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "L'auteur est d�j� sur le base de donn�es", "Attention",
						JOptionPane.WARNING_MESSAGE);
			}
			codeText.setText("");
			nomText.setText("");
			paysText.setText("");
		}

	}

}