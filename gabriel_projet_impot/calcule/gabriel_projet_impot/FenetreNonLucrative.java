package gabriel_projet_impot;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FenetreNonLucrative extends JFrame {
	AssociationNonLucrative nonLucrative = new AssociationNonLucrative();
	JLabel questionRevenuMobilier = new JLabel(
			"Quels ont été vos revenus mobiliers ?");
	JTextField caseMobilier = new JTextField(10);
	JLabel questionRevenuPatrimoine = new JLabel(
			"Quels ont été vos revenus patrimoniaux ?");
	JTextField casePatrimoine = new JTextField(10);
	JButton valider = new JButton("valider");

	public FenetreNonLucrative() {
		// on défini les parametres de la fenetre ;
		this.setTitle("Association non-lucrative");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// on défni les parametres de caseMobilier
		caseMobilier.setSize(50, 10);

		// on défni les parametres de casePatrimoine
		casePatrimoine.setSize(50, 20);

		// on défini ce qu'il se passe quand on clique sur le bouton
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// converti en double un string
					double mobilier = Double.parseDouble(caseMobilier.getText());
					nonLucrative.setRevenuMobiliers(mobilier);
					System.out.print(nonLucrative.getRevenuMobiliers());
					// converti en double un string
					double patrimoine = Double.parseDouble(caseMobilier
							.getText());
					nonLucrative.setRevenuPatrimoine(patrimoine);
					System.out.print(" " + nonLucrative.getRevenuPatrimoine());
					JOptionPane.showMessageDialog(null, "Vous devrez "
							+ nonLucrative.getImpot() + " € d'impôt.");

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,
							"Entrez un nombre valide");
				}
			}
		});

		// on rentre les éléments dans la fenetre
		this.getContentPane().setLayout(new FlowLayout());
		this.add(questionRevenuMobilier);
		this.add(caseMobilier);
		this.setLayout(new FlowLayout());
		this.add(questionRevenuPatrimoine);
		this.add(casePatrimoine);
		this.setLayout(new FlowLayout());
		this.add(valider);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
	}

}
