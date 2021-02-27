package com.formacionbdi.springboot.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Producto;
import com.formacionbdi.springboot.app.item.models.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@RestController
public class ItemController {
	
	@Autowired
	//@Qualifier("serviceFeign") //para espesificar cual implementacion usar.(feing o restTemplate) --> para usar el restTemplate @Qualifier("serviceRestTemplate")
	@Qualifier("serviceRestTemplate")//para balanceo por serviceRestTemplate
	private ItemService itemService;
	
	//Metodos Handler es un objeto que se encarga de una tarea especifica
	
	@GetMapping("/listar")
	public List<Item> listar(){
		return itemService.finAll();
	}
	
	@HystrixCommand(fallbackMethod = "metodoalternativo")
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id,@PathVariable Integer cantidad) {		
		return itemService.findById(id, cantidad);
	}
	
	public Item metodoalternativo(Long id,@PathVariable Integer cantidad) {
		Item item = new Item();
		Producto producto = new Producto();
		
		item.setCantidad(cantidad);
		producto.setId(id);
		producto.setNombre("Camara Sonny");
		producto.setPrecio(500.00);
		item.setProducto(producto);
		return item;
		
	}
	
}
