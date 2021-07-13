package chapter05;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class EnumWeekExample {
	public static void main(String[] args) {
//		예전에는 Calender를 사용했으나 
//		Calender와 Date 객체는 보안상 사용을 안하는것이 좋음

		DayOfWeek week = LocalDate.now().getDayOfWeek();
		System.out.println("오늘 요일: "+ week);
		
		int ordinal = week.ordinal();
		System.out.println(ordinal);
		Week today = null;
		switch(week) {
		case SUNDAY:
			today = Week.SUNDAY;break;
		case MONDAY:
			today = Week.MONDAY;break;
		case TUESDAY:
			today = Week.TUESDAY;break;
		case WEDNESDAY:
			today = Week.WEDNESDAY;break;
		case THURSDAY:
			today = Week.THURSDAY;break;
		case FRIDAY:
			today = Week.FRIDAY;break;
		case SATURDAY:
			today = Week.SATURDAY;break;
		
		}
		System.out.println("오늘 요일: "+ today.getKorOfWeek() + "요일");
	}
}
