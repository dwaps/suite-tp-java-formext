import java.util.InputMismatchException;
import java.util.Scanner;

public class HandlerDate {
	final int MONTH_31DAYS = 31;
	final int MONTH_30DAYS = 30;
	
	String datesBuilder[][] = {
		{ "", "janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "octobre", "novembre", "décembre" },
		{ "", "lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche" }
	};
	
	int nbOfDay = 0;
			
	void selectMonth(Scanner scanner) {
		int month = 0;
		
		System.out.print("Choisir un nombre pour obtenir le mois du jour correspondant [1-365] : ");
		
		try {
			nbOfDay = scanner.nextInt();

			if (nbOfDay <= MONTH_31DAYS*1) month = 1;
			else if (nbOfDay <= (MONTH_31DAYS*1 + MONTH_30DAYS*1-1)) month = 2;
			else if (nbOfDay <= (MONTH_31DAYS*2 + MONTH_30DAYS*1-1)) month = 3;
			else if (nbOfDay <= (MONTH_31DAYS*2 + MONTH_30DAYS*2-1)) month = 4;
			else if (nbOfDay <= (MONTH_31DAYS*3 + MONTH_30DAYS*2-1)) month = 5;
			else if (nbOfDay <= (MONTH_31DAYS*3 + MONTH_30DAYS*3-1)) month = 6;
			else if (nbOfDay <= (MONTH_31DAYS*4 + MONTH_30DAYS*3-1)) month = 7;
			else if (nbOfDay <= (MONTH_31DAYS*5 + MONTH_30DAYS*3-1)) month = 8;
			else if (nbOfDay <= (MONTH_31DAYS*5 + MONTH_30DAYS*4-1)) month = 9;
			else if (nbOfDay <= (MONTH_31DAYS*6 + MONTH_30DAYS*4-1)) month = 10;
			else if (nbOfDay <= (MONTH_31DAYS*6 + MONTH_30DAYS*5-1)) month = 11;
			else if (nbOfDay <= (MONTH_31DAYS*7 + MONTH_30DAYS*5-1)) month = 12;
			
			System.out.println(datesBuilder[0][month]);
			
		} catch (InputMismatchException e) {
			System.out.println("La saisie n'a pa pu être récupérée...");
			
		}

	}
}