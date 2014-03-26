package gabriel_projet_impot;

public class Regime {

	private boolean choix = false;
	private AssociationLucrative lucrative = new AssociationLucrative();
	private AssociationNonLucrative nonLucrative = new AssociationNonLucrative();

	public Regime() {

	}

	public boolean isChoix() {
		return choix;
	}

	public void setChoix(boolean choix) {
		this.choix = choix;
	}

	public double impot(boolean choix) {
		if (choix == false)
			return lucrative.calculSurBenef();
		else
			return nonLucrative.calculImpoAsso();
	}

}