package com.example.classajunit.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WeekDayServiceImplTest {

	@Test
	public void getDayOfWeek_notAday() {
		WeekDayServiceImpl weekDayService = new WeekDayServiceImpl();
		
		String actualResult = weekDayService.getDayOfWeek(0);
		String expectedResult = "NotAday";
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void getDayOfWeek_monday() {
		WeekDayServiceImpl weekDayService = new WeekDayServiceImpl();
		
		String actualResult = weekDayService.getDayOfWeek(1);
		String expectedResult = "monday";
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void getDayOfWeek_friday() {
		WeekDayServiceImpl weekDayService = new WeekDayServiceImpl();
		String actualResult = weekDayService.getDayOfWeek(5);
		String expectedResult = "Friday";
		assertEquals(expectedResult, actualResult);
	}
	
	

}
