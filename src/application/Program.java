package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entties.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Enter number room:");
			int numberRoom = sc.nextInt();
			
			sc.nextLine();
			
			System.out.print("CheckIn date: (dd/MM/yyyy)");
			Date checkIn = sdf.parse(sc.nextLine());
			System.out.print("CheckOut date: (dd/MM/yyyy)");
			Date checkOut = sdf.parse(sc.nextLine());
			
			Reservation rv = new Reservation(numberRoom, checkIn, checkOut);
			System.out.println("Reservation: " + rv);
			
			System.out.println();
			System.out.println("Enter data to update reservation: ");
			System.out.print("CheckIn date: (dd/MM/yyyy)");
			checkIn = sdf.parse(sc.next());
			System.out.print("CheckOut date: (dd/MM/yyyy)");
			checkOut = sdf.parse(sc.next());
			
			rv.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + rv);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format.");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		}

		sc.close();

	}

}
