package com.example.classajunit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class ClassACalculatorServiceImplTest {

	@Test
	public void sumNumber_basic() {
		ClassACalculatorServiceImpl calcServiceImpl =  new ClassACalculatorServiceImpl();
		
		int actualResult = calcServiceImpl.sumOfNumbers(new int[] {1,2,3});
		int expectedResult =6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void sumNumber_empty() {
		ClassACalculatorServiceImpl calcServiceImpl =  new ClassACalculatorServiceImpl();
		
		int actualResult = calcServiceImpl.sumOfNumbers(new int[] {});
		int expectedResult =0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void sumNumber_oneELement() {
		ClassACalculatorServiceImpl calcServiceImpl =  new ClassACalculatorServiceImpl();
		
		int actualResult = calcServiceImpl.sumOfNumbers(new int[] {5});
		int expectedResult =5;
		assertEquals(expectedResult, actualResult);
	}
	
}
