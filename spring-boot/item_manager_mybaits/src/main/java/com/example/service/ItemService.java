package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Category;
import com.example.entity.Item;
import com.example.form.ItemForm;
import com.example.mapper.ItemMapper;

@Service
public class ItemService {
	private ItemMapper itemMapper;

	@Autowired
	public ItemService(ItemMapper itemMapper) {
		this.itemMapper = itemMapper;
	}

	public List<Item> findAll(){
		return this.itemMapper.findAll();
	}

	public Item findById(Integer id) {
		return this.itemMapper.findById(id);
	}

	public void insert(ItemForm itemForm) {
		Category category = new Category();
		Item item = new Item();

		category.setId(itemForm.getCategoryId());
		item.setName(itemForm.getName());
		item.setCategoryId(itemForm.getCategoryId());
		item.setPrice(itemForm.getPrice());
		item.setCategory(category);

		this.itemMapper.insert(item);
	}

	public void update(ItemForm itemForm,Integer id) {
		Item item = this.findById(id);
		item.setName(itemForm.getName());
		item.setPrice(itemForm.getPrice());
		item.setCategoryId(itemForm.getCategoryId());

		this.itemMapper.update(item);
	}

	public void delete(Integer id) {
		this.itemMapper.delete(id);
	}
}
