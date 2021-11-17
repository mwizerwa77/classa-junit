package com.example.classajunit.service;

public class ClassACalculatorServiceImpl {

	CalculatorService calcService;
	
	public void setCalcService(CalculatorService calcService) {
		this.calcService = calcService;
	}

	public int sumOfNumbers(int[] data) {
		int sum =0;
		
		for(int value:data) {
			sum +=value;
		}
		return sum;
	}
	
	public int sumOfNumbersFromService() {
		int sum =0;
		for(int value:calcService.getAll()) {
			sum +=value;
		}
		return sum;
	}
	
	
}
