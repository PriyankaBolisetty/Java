package java8;

import java.time.Month;

public class TestBirthdayDiary {
	public static void main(String[] args){
		BirthdayDiary bdayDiary = new BirthdayDiary();
		
		bdayDiary.addBirthday("Latha", 2, 10, 1987);
		bdayDiary.addBirthday("Priyanka", 20, 1, 1990);
		bdayDiary.addBirthday("Vamshi", 19, 3, 1991);
		bdayDiary.addBirthday("Nageswar Rao", 2, 6, 1962);
		bdayDiary.addBirthday("Dhana", 17, 9, 1987);
		bdayDiary.addBirthday("Aadvik", 17, 8, 2016);
		
		System.out.println("Priyanka: " + bdayDiary.getBirthdayForName("Priyanka"));
		System.out.println("Birthdays in this month: " + bdayDiary.getBirthdaysIn(Month.AUGUST));
		System.out.println("Birthdays in next month: " + bdayDiary.getBirthdaysInNextMonth());
		
		System.out.println("No. of days till Dhana's bday: " + bdayDiary.getDaysUntilBirthday("Dhana"));
		System.out.println("Total age in years: " + bdayDiary.getTotalAgeInYears());
		
		System.out.println("Friends in age: " + bdayDiary.getFriendsOfAge(28, 1987));		
	}
}
