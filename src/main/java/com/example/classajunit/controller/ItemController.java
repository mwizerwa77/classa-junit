package com.example.classajunit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.classajunit.model.Item;
import com.example.classajunit.service.ItemService;
import com.example.classajunit.utils.APIResponse;

import dto.UpdateItemDto;

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
	
	@PutMapping("/all-items/104")
	public  ResponseEntity<?> postItem(@PathVariable(name="id") int id, @Valid @RequestBody UpdateItemDto item1){
		
		return itemService.save(item1);
		
		
	}
	@PostMapping("/all-items")
	public  ResponseEntity<?> save( @Valid @RequestBody UpdateItemDto item1){
		
		return itemService.save(item1);
		
		
	}
}
