package gabriel_projet_impot;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Regime orientation = new Regime();

		System.out.println(orientation.impot(orientation.isChoix()));
		FenetreChoix f = new FenetreChoix();
		FenetreNonLucrative g = new FenetreNonLucrative();

	}

}
