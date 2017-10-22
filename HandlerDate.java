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
		int cpt31Days = 1, cpt30Days = 0;
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
		
		stop : for (int i = 0; i < is30DaysMonth.length; i++) {
			switch (i) {
				case 0:
					// Si l'utilisateur a saisi 1..31, le jour appartient au mois de janvier
					if (nbOfDay <= MONTH_31DAYS) { // Simplification de la condition : l'incrémentation de cpt31Days --> 1 à l'initialisation
						month = 1;
						break stop;
					}
					break;
				default:
					if (nbOfDay <= (MONTH_31DAYS*(is30DaysMonth[i] ? cpt31Days : ++cpt31Days) + MONTH_30DAYS*(is30DaysMonth[i] ? ++cpt30Days : cpt30Days)-1)) {
						month = i+1;
						break stop;
					}
			}
		}
	}
}