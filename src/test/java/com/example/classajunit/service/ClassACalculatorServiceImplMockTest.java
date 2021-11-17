package com.example.classajunit.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClassACalculatorServiceImplMockTest {

	@InjectMocks
	private ClassACalculatorServiceImpl calcServiceImpl;

	@Mock
	private CalculatorService calculatorServiceMock;

	@Test
	public void sumNumber_basic() {
		when(calculatorServiceMock.getAll()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, calcServiceImpl.sumOfNumbersFromService());
	}

	@Test
	public void sumNumber_empty() {

		when(calculatorServiceMock.getAll()).thenReturn(new int[] {});
		assertEquals(0, calcServiceImpl.sumOfNumbersFromService());
	}

	@Test
	public void sumNumber_oneELement() {

		when(calculatorServiceMock.getAll()).thenReturn(new int[] { 5 });
		assertEquals(5, calcServiceImpl.sumOfNumbersFromService());
	}

}
