package com.formacionbdi.springboot.app.item.models;

import com.formacionbdi.springboot.app.commons.entity.Producto;

public class Item {
	
	private Producto producto;	
	private Integer cantidad;
	
	public Item() {		
	}
	
	public Item(Producto producto, Integer cantidad) {		
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Double getTotal() {//El formato get[metodo] en el json
		return producto.getPrecio() * cantidad.doubleValue();
	}
	
	public Double getCalculos() {
		return producto.getPrecio() * cantidad.doubleValue();
	}
	
}
