package com.formacionbdi.springboot.app.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.model.entity.Producto;
import com.formacionbdi.springboot.app.productos.model.service.IProductoService;

@RestController //dubuelve el json
public class ProductoController { //para levantear por instancias : -Dserver.port=9001
	
	@Autowired
	private IProductoService productoService;
	
	//metodos hadler
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoService.finAll();
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoService.findById(id);				
		return producto;
	}

}
