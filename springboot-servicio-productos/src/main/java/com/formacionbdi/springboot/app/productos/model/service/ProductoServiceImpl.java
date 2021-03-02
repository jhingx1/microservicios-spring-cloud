package com.formacionbdi.springboot.app.productos.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.springboot.app.productos.model.dao.ProductoDao;
import com.formacionbdi.springboot.app.productos.model.entity.Producto;
//import com.formacionbdi.springboot.app.commons.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> finAll() {		
		return (List<Producto>)productoDao.findAll();//esto ya biene construido
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);//esto ya biene construido
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {		
		return productoDao.save(producto);//esto ya biene construido
	}

	@Override
	@Transactional
	public void deleteById(Long id) {		
		productoDao.deleteById(id);//esto ya biene construido
	}

}
