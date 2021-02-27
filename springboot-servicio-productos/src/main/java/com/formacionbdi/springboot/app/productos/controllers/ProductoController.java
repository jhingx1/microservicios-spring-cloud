package com.formacionbdi.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.model.entity.Producto;
import com.formacionbdi.springboot.app.productos.model.service.IProductoService;

@RestController //dubuelve el json
public class ProductoController { //para levantear por instancias : -Dserver.port=9001
	
	@Autowired
	private Environment env;//para  feign
	
	@Value("${server.port}")//para inyectar valores que estan en el properties
	private Integer port;
	
	@Autowired
	private IProductoService productoService;
	
	//metodos hadler
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoService.finAll().stream().map(producto -> {
			//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));//tenemos que convertir
			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id)  {//throws Exception
		Producto producto = productoService.findById(id);
		//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		producto.setPort(port);
		
//		boolean ok = false;
//		if(ok==false) {
//			throw new Exception("No se puede cargar el producto");
//		}
		
//		try {
//			Thread.sleep(2000L);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return producto;
	}

}
