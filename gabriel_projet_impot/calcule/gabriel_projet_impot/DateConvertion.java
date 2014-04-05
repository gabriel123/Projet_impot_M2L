package gabriel_projet_impot;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvertion {

	private String dateFormatee;

	public DateConvertion() {
		Date maintenant = new Date();
		SimpleDateFormat formatDateJour = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
		dateFormatee = formatDateJour.format(maintenant);
	}

	public String getDateConvertion() {
		return dateFormatee;
	}
}
