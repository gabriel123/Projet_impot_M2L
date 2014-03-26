package gabriel_projet_impot;

public class AssociationNonLucrative {

	private double revenuMobiliers;
	private double revenuPatrimoine;

	public AssociationNonLucrative() {

	}

	public double getRevenuMobiliers() {
		return revenuMobiliers;
	}

	public void setRevenuMobiliers(double rMobiliers) {
		this.revenuMobiliers = rMobiliers;
	}

	public double getRevenuPatrimoine() {
		return revenuPatrimoine;
	}

	public void setRevenuPatrimoine(double rPatrimoine) {
		this.revenuPatrimoine = rPatrimoine;
	}

	public double calculImpoAsso() {
		return revenuMobiliers * 0.1 + revenuPatrimoine * 0.24;
	}

	public double getImpot() {
		return calculImpoAsso();
	}

}
