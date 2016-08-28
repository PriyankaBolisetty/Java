package java8;

import java.time.*;

public class ThreatreBooking {
	private LocalDate[] bookingDates = new LocalDate[10];
	private LocalDate interestDate;
	
	
	public ThreatreBooking(LocalDate interestDate){
		this.interestDate = interestDate;
		initialize();
	}
	
	public void initialize(){
		LocalDate date1 = LocalDate.of(2016, 8, 20);
		LocalDate date2 = LocalDate.of(2016, 8, 22);
		LocalDate date3 = LocalDate.of(2016, 8, 25);
		LocalDate date4 = LocalDate.of(2016, 8, 27);
		LocalDate date5 = LocalDate.of(2016, 8, 30);
		LocalDate date6 = LocalDate.of(2016, 8, 31);
		
		bookingDates[0] = date1;
		bookingDates[1] = date2;
		bookingDates[2] = date3;
		bookingDates[3] = date4;
		bookingDates[4] = date5;
		bookingDates[5] = date6;
	}
	
	public LocalDate getNearestAvailableDate(){
		int minDiff = 0;
		LocalDate date = null;
		
		for(int  i = 0; i < bookingDates.length; i++){
			date = bookingDates[i];
			
			minDiff = getMinDifferenceInDates(interestDate, date);
			if(minDiff >= 0){
				if(interestDate.equals(date)){
					System.out.println("Nearest Available date: " + interestDate);
					return date;
				}
				minDiff = getMinDifferenceInDates(interestDate, date);
				System.out.println("Nearest Available date: " + date);
				return date;
			}
		}
		return date;
	}
	
	public int getMinDifferenceInDates(LocalDate interestDate, LocalDate otherDate) {
		Period period = Period.between(interestDate, otherDate);
		return period.getDays();
	}
}
