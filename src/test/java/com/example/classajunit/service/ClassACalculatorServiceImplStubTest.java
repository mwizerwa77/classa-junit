package com.example.classajunit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

class CalculatorServiceImplSomeData implements CalculatorService{

	@Override
	public int[] getAll() {
		
		return new int[] {1,2,3};
	}
	
}

class CalculatorServiceImplEMpty implements CalculatorService{

	@Override
	public int[] getAll() {
		
		return new int[] {};
	}
	
}

class CalculatorServiceImplOneElement implements CalculatorService{

	@Override
	public int[] getAll() {
		
		return new int[] {5};
	}
	
}

public class ClassACalculatorServiceImplStubTest {

	@Test
	public void sumNumber_basic() {
		ClassACalculatorServiceImpl calcServiceImpl =  new ClassACalculatorServiceImpl();
		
		calcServiceImpl.setCalcService( new CalculatorServiceImplSomeData() );
		
		int actualResult = calcServiceImpl.sumOfNumbersFromService();
		int expectedResult =6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void sumNumber_empty() {
		ClassACalculatorServiceImpl calcServiceImpl =  new ClassACalculatorServiceImpl();
	
		calcServiceImpl.setCalcService( new CalculatorServiceImplEMpty() );
		
		int actualResult = calcServiceImpl.sumOfNumbersFromService();
		int expectedResult =0;
		assertEquals(expectedResult, actualResult);
	}
	
	
	@Test
	public void sumNumber_oneELement() {
		ClassACalculatorServiceImpl calcServiceImpl =  new ClassACalculatorServiceImpl();
		
		calcServiceImpl.setCalcService( new CalculatorServiceImplOneElement() );
		
		int actualResult = calcServiceImpl.sumOfNumbersFromService();
		int expectedResult =5;
		assertEquals(expectedResult, actualResult);
	}
	
}
