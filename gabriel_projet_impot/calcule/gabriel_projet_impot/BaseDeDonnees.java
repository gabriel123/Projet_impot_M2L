package gabriel_projet_impot;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class BaseDeDonnees {

	
	
public BaseDeDonnees(double impot,Date jour) {
	try
		{
  	  	Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/java_impot", user = "root", password = "";
			java.sql.Connection connexion = null;
			connexion = DriverManager.getConnection(url, user, password);
	  		String req = "INSERT INTO tableImpot (ID, jour, estimation) VALUES ('', '"+jour+"','"+impot+"')";
	  		java.sql.Statement s = connexion.createStatement();
	  		s.execute(req);
	  		System.out.print("base de données marche");
		}
catch (ClassNotFoundException | SQLException ee)
	  	{
	  		System.out.print("probleme base de données");
	  		ee.printStackTrace();
	  		
	  	}

}
	
}
