package com.formacionbdi.springboot.app.productos.model.service;

import java.util.List;

import com.formacionbdi.springboot.app.productos.model.entity.Producto;

public interface IProductoService {
	
	public List<Producto> finAll();
	public Producto findById(Long id);	
	//agregar	
	public Producto save(Producto producto);
	//eliminar
	public void deleteById(Long id);

}
