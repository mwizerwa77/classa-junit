package com.example.classajunit.service;

public class WeekDayServiceImpl {

	public String getDayOfWeek(int guessNumber) {
		String dayOfWeek="";
		
		
		switch(guessNumber) {
		case 1:
			dayOfWeek="monday";
			break;
		case 2:
			dayOfWeek="Tuesday";
			break;
			
		case 3:
			dayOfWeek="Wednsday";
			break;
			
		case 4:
			dayOfWeek="thursday";
			break;
		case 5:
			dayOfWeek="Friday";
			break;
			
		case 6:
			dayOfWeek="Saturday";
			break;
		case 7:
			dayOfWeek="Sunday";
			break;
			
			default:
				dayOfWeek=	"NotAday";
				break;
		}
		
		return dayOfWeek;
	}
}
