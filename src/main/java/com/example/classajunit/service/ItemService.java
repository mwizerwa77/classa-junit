package com.example.classajunit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.classajunit.model.Item;
import com.example.classajunit.repository.ItemRepository;

import dto.UpdateItemDto;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> getAll() {	
		List<Item> items = itemRepository.findAll();
		for(Item item:items) {
			item.setValue(item.getPrice()*item.getQuantity());
		}
		return items;
	}

	public Item getById(int id) {
		Optional<Item> itemOption = itemRepository.findById(id);
		if(itemOption.isPresent()) {
			return itemOption.get();
		}
		return null;
	}
	public ResponseEntity<?>  update(int id, UpdateItemDto dto) {
		Optional<Item> itemOptional = itemRepository.findById(id);
		if(itemOptional.isPresent()) {
			if(!(itemRepository.existsByName(dto.getName()) && 
					itemOptional.get().getName().equalsIgnoreCase(dto.getName()))) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name exists");
			}
			Item item = itemOptional.get();
			item.setName(dto.getName());
			item.setPrice(dto.getPrice());
			item.setQuantity(dto.getQuantity());
			item.setValue(item.getPrice()*item.getQuantity());
			itemRepository.save(item);
			return ResponseEntity.status(HttpStatus.CREATED).body(item);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item does not exist");
	}
}
