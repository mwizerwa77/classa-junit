package com.example.classajunit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.classajunit.model.Item;
import com.example.classajunit.service.ItemService;
import com.example.classajunit.utils.APIResponse;

import dto.UpdateItemDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
		
	@Test
	public void getAll_success() throws JSONException {
		String response = this.restTemplate.getForObject("/all-items", String.class);
		System.out.println(response);
		//JSONAssert.assertEquals("[]", response, false);
		JSONAssert.assertEquals("[{\"id\":101,\"name\":\"Item1\",\"price\":10,\"quantity\":100,\"value\":1000},{\"id\":102,\"name\":\"Item2\",\"price\":20,\"quantity\":200,\"value\":4000},{\"id\":103,\"name\":\"Item3\",\"price\":30,\"quantity\":300,\"value\":9000},{\"id\":104,\"name\":\"Item4\",\"price\":40,\"quantity\":400,\"value\":16000}]", response, true);
	}
	
	@Test
	public void getById_successEntity() throws JSONException {
		ResponseEntity<Item> response = this.restTemplate.getForEntity("/all-items/101", Item.class);
		
		System.out.println(response);
		assertEquals(200, response.getStatusCodeValue());
		assertEquals(1000, response.getBody().getValue());
		assertEquals("Item1", response.getBody().getName());
		
	}
	
	@Test
	public void getById_404() {
		ResponseEntity<APIResponse> response = this.restTemplate.getForEntity("/all-items/1000", APIResponse.class);
		
		assertEquals(404, response.getStatusCodeValue());
		assertEquals("Item not found", response.getBody().getMessage());
	}
	@Test 
	public void createItem_Success() {
		
		UpdateItemDto item1=new UpdateItemDto("myItem",120,4);
	     
		
		ResponseEntity<Item> response = this.restTemplate.postForEntity("/all-items", item1, Item.class);
		
		assertEquals(201, response.getStatusCodeValue());
		assertEquals("myItem",response.getBody().getName());

	//	assertEquals("", response.getBody().getMessage());
	}
	
	
	

}
