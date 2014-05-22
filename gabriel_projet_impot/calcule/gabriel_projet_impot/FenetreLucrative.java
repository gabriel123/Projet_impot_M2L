package gabriel_projet_impot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FenetreLucrative extends JFrame {

	private DateConvertion jour = new DateConvertion();
	private AssociationLucrative lucrative = new AssociationLucrative();
	private JLabel questionChiffreAffaire = new JLabel("Quel a été votre chiffre d'affaire en euros ?");
	private JLabel questionBenefice = new JLabel("Quel a été votre bénéfice en euros ?");
	private JTextField chiffreAffaire = new JTextField(10);
	private JTextField benefice = new JTextField(10);
	private JButton valider = new JButton("valider");
	private BaseDeDonnees insertion = new BaseDeDonnees();
	private JPanel panel = new JPanel();

	public FenetreLucrative() {

		panel.add(questionChiffreAffaire);
		panel.add(chiffreAffaire);
		panel.add(questionBenefice);
		panel.add(benefice);
		panel.add(valider);
		panel.setLayout(null);
		questionChiffreAffaire.setBounds(25, 80, 250, 50);
		chiffreAffaire.setBounds(275, 95, 80, 25);
		questionBenefice.setBounds(25, 120, 280, 50);
		benefice.setBounds(275, 133, 80, 25);
		valider.setBounds(140, 180, 100, 30);

		// on défini ce qu'il se passe quand on clique sur le bouton
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// convertit en double un string
					double chiffreA = Double.parseDouble(chiffreAffaire.getText());
					lucrative.setChiffreAffaires(chiffreA);
					System.out.print(lucrative.getChiffreAffaires());
					// convertit en double un string
					double benf = Double.parseDouble(benefice.getText());
					lucrative.setBenefices(benf);
					System.out.print(" " + lucrative.getBenefices());
					JOptionPane.showMessageDialog(null, "Vous devrez " + lucrative.getImpot() + " € d'impôt.");
					insertion.ajoutBaseDeDonnees(lucrative.getImpot(), jour.getDateConvertion());
					dispose();

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Entrez un nombre valide");

				}

			}

		});

		// on définit la fenetre
		this.setTitle("Association lucrative");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panel);

	}
}
