package gabriel_projet_impot;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FenetreLucrative extends JFrame {

	AssociationLucrative lucrative = new AssociationLucrative();
	JLabel questionChiffreAffaire = new JLabel(
			"Quel a été votre chiffre d'affaire ?");
	JLabel questionBenefice = new JLabel("Quel a été votre bénéfice ?");
	JTextField chiffreAffaire = new JTextField(10);
	JTextField benefice = new JTextField(10);
	JButton valider = new JButton("valider");
	Date jour = new Date();

	public FenetreLucrative() {
		this.setTitle("Association lucrative");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// on défini les cases
		chiffreAffaire.setSize(5, 10);
		benefice.setSize(5, 10);

		// on défini ce qu'il se passe quand on clique sur le bouton
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// converti en double un string
					double chiffreA = Double.parseDouble(chiffreAffaire
							.getText());
					lucrative.setChiffreAffaires(chiffreA);
					System.out.print(lucrative.getChiffreAffaires());
					// converti en double un string
					double benf = Double.parseDouble(benefice.getText());
					lucrative.setBenefices(benf);
					System.out.print(" " + lucrative.getBenefices());
					JOptionPane.showMessageDialog(null, "Vous devrez "
							+ lucrative.getImpot() + " € d'impôt.");
					BaseDeDonnees insertion = new BaseDeDonnees(lucrative
							.getImpot(), jour);

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,
							"Entrez un nombre valide");

				}
			}
		});

		this.getContentPane().setLayout(new FlowLayout());
		this.add(questionChiffreAffaire);
		this.add(chiffreAffaire);
		this.add(questionBenefice);
		this.add(benefice);
		this.setLayout(new FlowLayout());
		this.add(valider);

	}

}
