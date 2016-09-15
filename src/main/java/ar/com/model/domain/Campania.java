package ar.com.model.domain;

import java.io.Serializable;

public class Campania implements Serializable{
	private String FechaInicio;
	private String FechaFin;
	private Producto producto;
	private String nombre;
	
	public Campania(){}
	
	public Campania(String FechaInicio,String FechaFin,Producto producto,String nombre)
	{
		this.FechaInicio=FechaInicio;
		this.FechaFin=FechaFin;
		this.producto=producto;
		this.nombre=nombre;
	}
	
	public String getFechaInicio() {
		return FechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		FechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return FechaFin;
	}
	public void setFechaFin(String fechaFin) {
		FechaFin = fechaFin;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
