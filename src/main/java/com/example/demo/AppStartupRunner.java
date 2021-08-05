package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;


@Component
@Transactional
public class AppStartupRunner implements ApplicationRunner {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		List<Item> items = Arrays.asList(new Item[] { 
				new Item(1L, "Item 1"), new Item(2L, "Item 2"),
				new Item(3L, "Item 3"), new Item(4L, "Item 4") });
		
		itemRepository.saveAll(items);
	}

}
