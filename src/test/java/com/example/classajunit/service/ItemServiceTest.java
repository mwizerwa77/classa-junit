package com.example.classajunit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.example.classajunit.model.Item;
import com.example.classajunit.repository.ItemRepository;

import dto.UpdateItemDto;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {


	@Mock
	private ItemRepository itemRepositoryMock;
	
	@InjectMocks
	private ItemService itemService;
	
	@Test
	public void getAll_withSomeElements() {

		when(itemRepositoryMock.findAll()).thenReturn(Arrays.asList(new Item(1,"Samuel",1,10),
				new Item(2,"Blessing",4,100)));
		assertEquals(10,itemService.getAll().get(0).getValue());
	}
	@Test
	public void updateItem_Success () {
		Item item = new Item(1,"Mangoes",500,3);
		UpdateItemDto updatedItem = new UpdateItemDto("Mangoes",500,6);
		
		when(itemRepositoryMock.findById(1)).thenReturn(Optional.of(item));
		when(itemRepositoryMock.existsByName(updatedItem.getName()))
		.thenReturn(true);

		when(itemRepositoryMock.save(item)).thenReturn(item);
		
		ResponseEntity<?> update = itemService.update(1, updatedItem);
		System.out.println(update.getStatusCodeValue());
		
		assertTrue(update.getStatusCode().is2xxSuccessful());
		
	}
	@Test
	public void updateItem_404 () {
		Item item = new Item(1,"Mangoes",500,3);
		UpdateItemDto updatedItem = new UpdateItemDto("Mangoes",500,6);
		
		when(itemRepositoryMock.findById(1)).thenReturn(Optional.empty());
		
		/*when(itemRepositoryMock.existsByName(updatedItem.getName()))
		.thenReturn(true);*/

		when(itemRepositoryMock.save(item)).thenReturn(item);
		ResponseEntity<?> update = itemService.update(1, updatedItem);
		System.out.println(update.getStatusCodeValue());
		
		assertTrue(update.getStatusCodeValue()==404);
		
	}
	
	@Test
	public void updateItem_nameExists () {
		Item item = new Item(1,"Mangoes",500,3);
		UpdateItemDto updatedItem = new UpdateItemDto("Mangoes",500,6);
		
		when(itemRepositoryMock.findById(1)).thenReturn(Optional.of(item));
		when(itemRepositoryMock.existsByName(updatedItem.getName()))
		.thenReturn(false);

		when(itemRepositoryMock.save(item)).thenReturn(item);
		ResponseEntity<?> update = itemService.update(1, updatedItem);
		System.out.println(update.getStatusCodeValue());
		
		assertTrue(update.getStatusCodeValue()==400);
		
	}
}
