package gabriel_projet_impot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FenetreChoix extends JFrame {

	private BaseDeDonnees base = new BaseDeDonnees();
	private Regime choix = new Regime();
	private JButton boutonOui = new JButton("oui");
	private JButton boutonNon = new JButton("non");
	private JLabel question = new JLabel("Avez-vous géré l'association de maniere désintéressée ?");
	private JFrame j = new JFrame();
	private FenetreNonLucrative fnonLucrative = new FenetreNonLucrative();
	private FenetreLucrative fLucrative = new FenetreLucrative();
	private JComboBox combo = new JComboBox();
	private JButton supprimer = new JButton("supprimer");
	private JPanel panel = new JPanel();

	public FenetreChoix() {
		// on ajoute les éléments au panel
		panel.add(question);
		panel.add(boutonOui);
		panel.add(boutonNon);
		panel.add(combo);
		panel.add(supprimer);
		panel.setLayout(null);
		question.setBounds(30, 10, 350, 30);
		boutonOui.setBounds(210, 60, 80, 30);
		boutonNon.setBounds(90, 60, 80, 30);
		combo.setBounds(15, 150, 350, 30);
		supprimer.setBounds(140, 250, 100, 20);

		// on défini les fonctions du boutonOui
		boutonOui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choix.setChoix(true);
				fnonLucrative.setVisible(true);
				j.setVisible(false);
			}
		});

		// on défini les fonctions du boutonNon
		boutonNon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choix.setChoix(false);
				fLucrative.setVisible(true);
				j.setVisible(false);
			}
		});

		// on défini le combo
		base.afficheBaseDeDonneesCombo(combo);

		// ondéfini le bouton supprimer
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j.dispose();
				try {

					base.supprimeElement(combo);
					int i = combo.getSelectedIndex();
					combo.removeItemAt(i);
					;
					JOptionPane.showMessageDialog(null, "Cette estimation a bien été supprimée !");

				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Il n'y a aucune estimation à supprimer.");
				}
				j.setVisible(true);

			}
		});

		// on défini les fonctions de la fenetre nommée f
		j.setTitle("Faites un choix !");
		j.setSize(400, 400);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setContentPane(panel);
		j.setVisible(true);

	}
}