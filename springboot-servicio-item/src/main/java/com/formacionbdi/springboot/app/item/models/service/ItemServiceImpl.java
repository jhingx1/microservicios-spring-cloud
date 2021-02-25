package com.formacionbdi.springboot.app.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Producto;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService{

	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<Item> finAll() {
		List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://servicio-productos:8001/listar", Producto[].class));//http://localhost:8001/listar
		//transformamos un objeto Producto a ITemas y luego lo volvemos a una coleccion
		return productos.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id,Integer cantidad) {
		Map<String,String> pathVariables = new HashMap<String,String>();
		pathVariables.put("id",id.toString());
		Producto producto = clienteRest.getForObject("http://servicio-productos:8001/ver/{id}", Producto.class,pathVariables);//localhost para feing
		return new Item(producto, cantidad);
	}

}
