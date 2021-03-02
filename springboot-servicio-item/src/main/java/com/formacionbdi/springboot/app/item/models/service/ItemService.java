package com.formacionbdi.springboot.app.item.models.service;

import java.util.List;

import com.formacionbdi.springboot.app.item.models.Item;
//import com.formacionbdi.springboot.app.item.models.Producto;
import com.formacionbdi.springboot.app.commons.entity.Producto;

public interface ItemService {
	public List<Item> finAll();
	public Item findById(Long id,Integer cantidad);
	
	//agregar 3 metodos - consumir del ms-productos
	public Producto save(Producto producto);
	public Producto update(Producto producto,Long id);
	public void delete(Long id);
}
