package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Category;
import com.example.mapper.CategoryMapper;

@Service
public class CategoryService {
	private CategoryMapper categoryMapper;

	public CategoryService(CategoryMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
	}

	public List<Category> findAll(){
		return this.categoryMapper.findAll();
	}
}
