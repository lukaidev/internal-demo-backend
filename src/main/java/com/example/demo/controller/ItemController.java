package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

	private final ItemRepository itemRepository;

	public ItemController(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@GetMapping
	public List<Item> getItems() {
		return itemRepository.findAll();
	}

	@GetMapping("/{itemId}")
	public Item getItem(@PathVariable(value = "itemId", required = true) Long itemId) {
		return itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("not found"));
	}
	
	@PostMapping
	public Item saveItem(@RequestBody Item item) {
		return itemRepository.save(item);
	}

}
