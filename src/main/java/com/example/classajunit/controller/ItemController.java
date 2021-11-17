package com.example.classajunit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.classajunit.model.Item;
import com.example.classajunit.service.ItemService;
import com.example.classajunit.utils.APIResponse;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/all-items")
	public List<Item> getAll(){
		
	return itemService.getAll();
	}
	
	@GetMapping("/all-items/{id}")
	public ResponseEntity<?> getItemById(@PathVariable(name="id") int id) {
		Item item = itemService.getById(id);
		
		if(item != null) return ResponseEntity.status(HttpStatus.OK).body(item);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse(false, "Item not found"));
	}
}
