package gabriel_projet_impot;

public class AssociationLucrative {

	private double chiffreAffaires;
	private double benefices;

	public AssociationLucrative() {

	}

	public double getChiffreAffaires() {
		return chiffreAffaires;
	}

	public void setChiffreAffaires(double chiffreAffaires) {
		this.chiffreAffaires = chiffreAffaires;
	}

	public double getBenefices() {
		return benefices;
	}

	public void setBenefices(double benefices) {
		this.benefices = benefices;
	}

	public double calculSurBenef() {
		if (chiffreAffaires > 7630000)
			return benefices * 33.33 / 100;
		else if (chiffreAffaires < 38120)
			return benefices * 15 / 100;
		else
			return 38120 * 15 / 100 + (benefices - 38120) * 33.33 / 100;

	}

	private static double arrondiNDecimales(double x, int n) {
		double pow = Math.pow(10, n);
		return (Math.floor(x * pow)) / pow;
	}

	public double getImpot() {
		return arrondiNDecimales(calculSurBenef(), 2);
	}

}
