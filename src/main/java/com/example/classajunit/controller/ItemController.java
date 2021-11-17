package com.example.classajunit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.classajunit.model.Item;
import com.example.classajunit.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/all-items")
	public List<Item> getAll(){
		
	return itemService.getAll();
	}
	
	@GetMapping("/all-items/{id}")
	public Item getItemById(@PathVariable(name="id") int id) {
		return itemService.getById(id);
	}
}
