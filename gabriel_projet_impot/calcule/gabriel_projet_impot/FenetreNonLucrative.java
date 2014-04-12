package gabriel_projet_impot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FenetreNonLucrative extends JFrame {

	private DateConvertion jour = new DateConvertion();
	private AssociationNonLucrative nonLucrative = new AssociationNonLucrative();
	private JLabel questionRevenuMobilier = new JLabel("Quels ont été vos revenus mobiliers ?");
	private JTextField caseMobilier = new JTextField(10);
	private JLabel questionRevenuPatrimoine = new JLabel("Quels ont été vos revenus patrimoniaux ?");
	private JTextField casePatrimoine = new JTextField(10);
	private JButton valider = new JButton("valider");
	private BaseDeDonnees insertion = new BaseDeDonnees();
	private JPanel panel = new JPanel();

	public FenetreNonLucrative() {

		// on rentre les éléments dans le panel
		panel.add(questionRevenuMobilier);
		panel.add(caseMobilier);
		panel.add(questionRevenuPatrimoine);
		panel.add(casePatrimoine);
		panel.add(valider);
		panel.setLayout(null);
		questionRevenuMobilier.setBounds(30, 80, 220, 50);
		caseMobilier.setBounds(270, 93, 80, 25);
		questionRevenuPatrimoine.setBounds(30, 120, 280, 50);
		casePatrimoine.setBounds(270, 130, 80, 25);
		valider.setBounds(140, 180, 100, 30);

		// on défni les parametres de caseMobilier

		// on défni les parametres de casePatrimoine

		// on défini ce qu'il se passe quand on clique sur le bouton
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// converti en double un string
					double mobilier = Double.parseDouble(caseMobilier.getText());
					nonLucrative.setRevenuMobiliers(mobilier);
					System.out.print(nonLucrative.getRevenuMobiliers());
					// converti en double un string
					double patrimoine = Double.parseDouble(caseMobilier.getText());
					nonLucrative.setRevenuPatrimoine(patrimoine);
					System.out.print(" " + nonLucrative.getRevenuPatrimoine());
					JOptionPane.showMessageDialog(null, "Vous devrez " + nonLucrative.getImpot() + " € d'impôt.");
					insertion.ajoutBaseDeDonnees(nonLucrative.getImpot(), jour.getDateConvertion());
					dispose();

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Entrez un nombre valide");
				}
			}
		});

		// on défini les parametres de la fenetre ;
		this.setTitle("Association non-lucrative");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panel);

	}

}
