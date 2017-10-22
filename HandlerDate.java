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
		int cpt31Days = 0, cpt30Days = 0;
		final boolean[] is30DaysMonth = {
			false, // Janvier
			true, // Février (30-1 !!!)
			false, // Mars
			true, // Avril
			false, // Mai
			true, // Juin
			false, // Juillet
			false, // Août
			true, // Septembre
			false, // Octobre
			true, // Novembre
			false // Décembre
		};

		// SIMULATION DES TOURS DE BOUCLES
		// 1er tour de boucle : test sur 31 jours seulement
		if (nbOfDay <= MONTH_31DAYS*(is30DaysMonth[0] ? cpt31Days : ++cpt31Days)) month = 1;
		// A partir de 3ème tour de boucle : test avec irrégularité du mois de février pris en compte
		else if (nbOfDay <= (MONTH_31DAYS*(is30DaysMonth[1] ? cpt31Days : ++cpt31Days) + 	MONTH_30DAYS*(is30DaysMonth[1] ? ++cpt30Days : cpt30Days)-1)) month = 2;
		else if (nbOfDay <= (MONTH_31DAYS*(is30DaysMonth[2] ? cpt31Days : ++cpt31Days) + 	MONTH_30DAYS*(is30DaysMonth[2] ? ++cpt30Days : cpt30Days)-1)) month = 3;
		else if (nbOfDay <= (MONTH_31DAYS*(is30DaysMonth[3] ? cpt31Days : ++cpt31Days) + 	MONTH_30DAYS*(is30DaysMonth[3] ? ++cpt30Days : cpt30Days)-1)) month = 4;
		else if (nbOfDay <= (MONTH_31DAYS*(is30DaysMonth[4] ? cpt31Days : ++cpt31Days) + 	MONTH_30DAYS*(is30DaysMonth[4] ? ++cpt30Days : cpt30Days)-1)) month = 5;
		else if (nbOfDay <= (MONTH_31DAYS*(is30DaysMonth[5] ? cpt31Days : ++cpt31Days) + 	MONTH_30DAYS*(is30DaysMonth[5] ? ++cpt30Days : cpt30Days)-1)) month = 6;
		else if (nbOfDay <= (MONTH_31DAYS*(is30DaysMonth[6] ? cpt31Days : ++cpt31Days) + 	MONTH_30DAYS*(is30DaysMonth[6] ? ++cpt30Days : cpt30Days)-1)) month = 7;
		else if (nbOfDay <= (MONTH_31DAYS*(is30DaysMonth[7] ? cpt31Days : ++cpt31Days) + 	MONTH_30DAYS*(is30DaysMonth[7] ? ++cpt30Days : cpt30Days)-1)) month = 8;
		else if (nbOfDay <= (MONTH_31DAYS*(is30DaysMonth[8] ? cpt31Days : ++cpt31Days) + 	MONTH_30DAYS*(is30DaysMonth[8] ? ++cpt30Days : cpt30Days)-1)) month = 9;
		else if (nbOfDay <= (MONTH_31DAYS*(is30DaysMonth[9] ? cpt31Days : ++cpt31Days) + 	MONTH_30DAYS*(is30DaysMonth[9] ? ++cpt30Days : cpt30Days)-1)) month = 10;
		else if (nbOfDay <= (MONTH_31DAYS*(is30DaysMonth[10] ? cpt31Days : ++cpt31Days) + 	MONTH_30DAYS*(is30DaysMonth[10] ? ++cpt30Days : cpt30Days)-1)) month = 11;
		else if (nbOfDay <= (MONTH_31DAYS*(is30DaysMonth[11] ? cpt31Days : ++cpt31Days) + 	MONTH_30DAYS*(is30DaysMonth[11] ? ++cpt30Days : cpt30Days)-1)) month = 12;
	}
}