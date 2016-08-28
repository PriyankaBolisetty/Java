package java8;

import java.time.LocalDate;

public class TestTheatreBooking {
	public static void main(String[] args){
		ThreatreBooking bookTheatre = new ThreatreBooking(LocalDate.of(2016, 8, 27));
		bookTheatre.getNearestAvailableDate();
	}
}
