package com.formacionbdi.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.item.clientes.ProductoClienteRest;
import com.formacionbdi.springboot.app.item.models.Item;

@Service("serviceFeign")
@Primary //para que sea por defecto en el controlador
public class ItemServiceFeign implements ItemService{
	@Autowired
	private ProductoClienteRest clienteFeign;

	@Override
	public List<Item> finAll() {		
		return clienteFeign.listar().stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {		
		return new Item(clienteFeign.detalle(id), cantidad);
	}
}
