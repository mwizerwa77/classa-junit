package com.example.classajunit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.classajunit.model.Item;
import com.example.classajunit.repository.ItemRepository;

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
}
