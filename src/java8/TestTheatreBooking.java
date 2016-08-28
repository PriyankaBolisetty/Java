package java8;

import java.time.LocalDate;
import java.util.Scanner;

public class TestTheatreBooking {
	public static void main(String[] args){
		int day;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*****Book a Theatre*******");
		System.out.print("Enter a date: ");
		day = scan.nextInt();
		
		ThreatreBooking bookTheatre = new ThreatreBooking(LocalDate.of(2016, 8, day));
		bookTheatre.getNearestAvailableDate();
	}
}
