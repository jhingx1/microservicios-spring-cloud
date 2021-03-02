package com.formacionbdi.springboot.app.commons.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "productos")
public class Producto implements Serializable{ 
	/*
	
	NOTA: para compilar con mvn se debe de verificar que version de java usas con el comnado java -version = con la que sale
	se debe de configurar el proyecto si java 8 el proy debe de ser java 8 para compilar
	 
	modificar las variables de entorno java : 
	JAVA_HOME
	Variable de usuario: C:\Program Files\Java\jdk1.8.0_161    o   C:\Program Files\Java\jdk-11.0.5
	Path
	C:\Program Files\Java\jdk-11.0.5\bin
	Path
	variables del sistemas :  C:\Program Files\Java\jdk-11.0.5\bin
	
	Crear con maven
	D:\repo_ms_spring_boot_spring_cloud_udemy\repo\springboot-servicio-commons>mvnw.cmd install
	
	El target - se genera el compilado
	
	D:\repo_ms_spring_boot_spring_cloud_udemy\repo\springboot-servicio-commons\target>dir
	02/03/2021  07:59             4,768 springboot-servicio-commons-0.0.1-SNAPSHOT.jar
	
	*/	
	private static final long serialVersionUID = -3989349104399708041L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Double precio;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@Transient
	private Integer port;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}	

}
