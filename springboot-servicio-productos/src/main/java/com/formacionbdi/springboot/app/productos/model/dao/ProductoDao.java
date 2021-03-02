package com.formacionbdi.springboot.app.productos.model.dao;

import org.springframework.data.repository.CrudRepository;
//import com.formacionbdi.springboot.app.productos.model.entity.Producto;
import com.formacionbdi.springboot.app.commons.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{
	
	

}
