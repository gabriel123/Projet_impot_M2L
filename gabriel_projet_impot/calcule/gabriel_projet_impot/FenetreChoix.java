package gabriel_projet_impot;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FenetreChoix extends JFrame {

	Regime choix = new Regime();
	JButton boutonOui = new JButton("oui");
	JButton boutonNon = new JButton("non");
	JLabel question = new JLabel(
			"Avez-vous g�r� l'association de maniere d�sint�ress�e ?");
	JFrame j = new JFrame();
	FenetreNonLucrative fnonLucrative = new FenetreNonLucrative();
	FenetreLucrative fLucrative = new FenetreLucrative();

	public FenetreChoix() {

		// on d�fini les fonctions de la fenetre nomm�e f
		j.setTitle("Faites un choix !");
		j.setSize(400, 400);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setLayout(null);

		// on d�fini les fonctions du boutonOui
		boutonOui.setBounds(30, 50, 30, 30);
		boutonOui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("bravo");
				choix.setChoix(true);
				fnonLucrative.setVisible(true);
				j.setVisible(false);

			}
		});

		// on d�fini les fonctions du boutonNon

		boutonNon.setText("Non");
		boutonNon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ouai");
				choix.setChoix(false);
				fLucrative.setVisible(true);
				j.setVisible(false);

			}
		});

		// on ajoute les �l�ments au panel (la fenetre)
		j.add(question);
		j.setLayout(new FlowLayout());
		j.add(boutonOui);
		j.add(boutonNon);
		j.setVisible(true);

	}

}