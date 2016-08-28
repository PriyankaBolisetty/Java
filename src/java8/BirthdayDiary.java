/** A Diary class to keep track of birthdays **/

package java8;

import java.time.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BirthdayDiary {
	private Map<String, LocalDate> birthdays;
	
	public BirthdayDiary(){
		birthdays = new HashMap<>();
	}
	
	public void addBirthday(String name, int day, int month, int year){
		LocalDate birthday = LocalDate.of(year, month, day);
		birthdays.put(name, birthday);
	}
	
	public LocalDate getBirthdayForName(String name){
		return birthdays.get(name);
	}
	
	public int getAgeInYear(String name, int year){
		Period period = Period.between(birthdays.get(name), birthdays.get(name).withYear(year));
		
		return period.getYears();
	}
	
	public Set<String> getFriendsOfAge(int age, int year){
		return birthdays.keySet().stream()
				.filter(p -> getAgeInYear(p, year) == age)
				.collect(Collectors.toSet());
	}
	
	public int getDaysUntilBirthday(String name){
		System.out.println(LocalDate.now());
		Period period = Period.between(LocalDate.now(),
				birthdays.get(name));
		
		return period.getDays();
	}
	
	public Set<String> getBirthdaysIn(Month month){
		return birthdays.entrySet().stream()
				.filter(p -> p.getValue().getMonth() == month)
				.map(p -> p.getKey())
				.collect(Collectors.toSet());
	}
	
	public Set<String> getBirthdaysInNextMonth(){
		return getBirthdaysIn(LocalDate.now().getMonth().plus(1));
	}
	
	public int getTotalAgeInYears(){
		return birthdays.keySet().stream()
				.mapToInt(p -> getAgeInYear(p, LocalDate.now().getYear()))
				.sum();
	}
}
