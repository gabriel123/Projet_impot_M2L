package gabriel_projet_impot;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

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

	public FenetreChoix() {

		// on défini les fonctions de la fenetre nommée f
		j.setTitle("Faites un choix !");
		j.setSize(400, 400);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setLayout(null);

		// on défini les fonctions du boutonOui
		boutonOui.setBounds(30, 50, 30, 30);
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
				base.supprimeElement(combo);
			}
		});

		// on ajoute les éléments au panel (la fenetre)
		j.add(question);
		j.setLayout(new FlowLayout());
		j.add(boutonOui);
		j.add(boutonNon);
		j.add(combo);
		j.add(supprimer);
		j.setVisible(true);

	}

}