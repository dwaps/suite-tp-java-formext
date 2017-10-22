import java.util.InputMismatchException;
import java.util.Scanner;

public class HandlerDate {
	final int MONTH_31DAYS = 31;
	final int MONTH_30DAYS = 30;
	
	String datesBuilder[][] = {
		{ "", "janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "octobre", "novembre", "décembre" },
		{ "", "lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche" }
	};
	
	int nbOfDay = 0, month = 0;
			
	void selectMonth(Scanner scanner) {
		System.out.print("Choisir un nombre pour obtenir le mois du jour correspondant [1-365] : ");
		
		try {
			nbOfDay = scanner.nextInt();
			
			if (nbOfDay >= 1 && nbOfDay <= 366) {
				
				searchMonth();
				
				System.out.println(datesBuilder[0][month]);
			} else {
				System.out.println("La valeur saisie n'est pas correcte...");
			}
			
			nbOfDay = 0;
			month = 0;
			
		} catch (InputMismatchException e) {
			System.out.println("La saisie n'a pa pu être récupérée...");
		}
	}
	
	private void searchMonth() {
		int cpt31Days = 1, cpt30Days = 1;
		
		if (nbOfDay <= MONTH_31DAYS) month = 1;
		
		// Incrémentation ?
		// cpt31Days => NON OUI NON OUI NON OUI OUI NON OUI NON OUI
		// cpt30Days => NON NON OUI NON OUI NON NON OUI NON OUI NON
		else if (nbOfDay <= (MONTH_31DAYS*cpt31Days + 		MONTH_30DAYS*cpt30Days-1)) month = 2;
		else if (nbOfDay <= (MONTH_31DAYS*(++cpt31Days) + 	MONTH_30DAYS*cpt30Days-1)) month = 3;
		else if (nbOfDay <= (MONTH_31DAYS*cpt31Days + 		MONTH_30DAYS*(++cpt30Days)-1)) month = 4;
		else if (nbOfDay <= (MONTH_31DAYS*(++cpt31Days) + 	MONTH_30DAYS*cpt30Days-1)) month = 5;
		else if (nbOfDay <= (MONTH_31DAYS*cpt31Days + 		MONTH_30DAYS*(++cpt30Days)-1)) month = 6;
		else if (nbOfDay <= (MONTH_31DAYS*(++cpt31Days) + 	MONTH_30DAYS*cpt30Days-1)) month = 7;
		else if (nbOfDay <= (MONTH_31DAYS*(++cpt31Days) + 	MONTH_30DAYS*cpt30Days-1)) month = 8;
		else if (nbOfDay <= (MONTH_31DAYS*cpt31Days + 		MONTH_30DAYS*(++cpt30Days)-1)) month = 9;
		else if (nbOfDay <= (MONTH_31DAYS*(++cpt31Days) + 	MONTH_30DAYS*cpt30Days-1)) month = 10;
		else if (nbOfDay <= (MONTH_31DAYS*cpt31Days + 		MONTH_30DAYS*(++cpt30Days)-1)) month = 11;
		else if (nbOfDay <= (MONTH_31DAYS*(++cpt31Days) + 	MONTH_30DAYS*cpt30Days-1)) month = 12;
	}
}