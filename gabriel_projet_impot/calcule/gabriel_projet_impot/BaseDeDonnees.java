package gabriel_projet_impot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

public class BaseDeDonnees {

	public void BaseDeDonnes() {

	}

	public void ajoutBaseDeDonnees(double impot, String jour) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/java_impot", user = "root", password = "";
			Connection connexion = null;
			connexion = DriverManager.getConnection(url, user, password);
			String req = "INSERT INTO tableImpot (jour, estimation) VALUES ('" + jour + "','" + impot + "')";
			Statement s = connexion.createStatement();
			s.execute(req);
			System.out.print("base de données marche");
		}

		catch (ClassNotFoundException | SQLException ee) {
			System.out.print("probleme base de données");
			ee.printStackTrace();

		}
	}

	public void afficheBaseDeDonneesCombo(JComboBox combo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/java_impot", user = "root", password = "";
			Connection connexion = null;
			connexion = DriverManager.getConnection(url, user, password);
			String requete = "SELECT jour, estimation FROM tableimpot";
			Statement s = connexion.createStatement();
			ResultSet resultat = s.executeQuery(requete);

			while (resultat.next()) {
				combo.addItem(resultat.getObject(1) + " estimation de : " + resultat.getObject(2) + "€");
			}
		} catch (ClassNotFoundException | SQLException ee) {
			System.out.print("probleme base de données avec le combo");
			ee.printStackTrace();
		}
	}

	public void supprimeElement(JComboBox combo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/java_impot", user = "root", password = "";
			Connection connexion = null;
			connexion = DriverManager.getConnection(url, user, password);
			String req = "DELETE FROM tableimpot WHERE jour AND estimation = '" + combo.getSelectedItem() + "' ";
			Statement s = connexion.createStatement();
			s.execute(req);
			System.out.print("base de données marche");
		} catch (ClassNotFoundException | SQLException ee) {
			System.out.print("probleme base de données");
			ee.printStackTrace();
		}

	}

}
