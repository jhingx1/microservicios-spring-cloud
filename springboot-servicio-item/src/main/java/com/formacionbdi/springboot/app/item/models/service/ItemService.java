package com.formacionbdi.springboot.app.item.models.service;

import java.util.List;

import com.formacionbdi.springboot.app.item.models.Item;

public interface ItemService {
	public List<Item> finAll();
	public Item findById(Long id,Integer cantidad);
}
