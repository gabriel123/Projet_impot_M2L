package gabriel_projet_impot;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreChoix extends JFrame {

	Regime choix = new Regime();
	JButton boutonOui = new JButton("oui");
	JButton boutonNon = new JButton("non");
	JLabel question = new JLabel();
	private JPanel f = new JPanel();
	FenetreNonLucrative fnon = new FenetreNonLucrative();
	FenetreLucrative foui = new FenetreLucrative();

	public FenetreChoix() {

		// on défini les fonctions de la fenetre nommée f
		this.setTitle("Faites un choix !");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		// on défini les fonctions du boutonOui
		boutonOui.setBounds(30, 50, 30, 30);

		// boutonOui.setText("Oui");
		boutonOui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("bravo");
				choix.setChoix(true);
				f.setVisible(false);
				fnon.setVisible(true);

			}
		});

		// on défini les fonctions du boutonNon

		boutonNon.setText("Non");
		boutonNon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ouai");
				choix.setChoix(false);
				f.setVisible(false);

			}
		});

		// on défini le label
		question.setText("Avez-vous géré l'association de maniere désintéressée ?");

		// on ajoute les éléments au panel (la fenetre)
		this.add(question);
		this.setLayout(new FlowLayout());
		this.add(boutonOui);
		this.add(boutonNon);
		this.setVisible(true);

	}

}