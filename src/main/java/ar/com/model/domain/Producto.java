package ar.com.model.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID_Producto;
	private String Descripcion_Producto;
	private int Stock_Producto;
	private float Precio_Unitario_Producto;
	
	public Producto(){}
	public Producto(int ID_Producto,String Descripcion_Producto ,int Stock_Producto,float Precio_Unitario_Producto)
	{
		this.ID_Producto=ID_Producto;
		this.Descripcion_Producto=Descripcion_Producto;
		this.Stock_Producto=Stock_Producto;
		this.Precio_Unitario_Producto=Precio_Unitario_Producto;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_Producto;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (ID_Producto != other.ID_Producto)
			return false;
		return true;
	}
	
	public int getID_Producto() {
		return ID_Producto;
	}
	public void setID_Producto(int iD_Producto) {
		ID_Producto = iD_Producto;
	}
	public String getDescripcion_Producto() {
		return Descripcion_Producto;
	}
	public void setDescripcion_Producto(String descripcion_Producto) {
		Descripcion_Producto = descripcion_Producto;
	}
	public int getStock_Producto() {
		return Stock_Producto;
	}
	public void setStock_Producto(int stock_Producto) {
		Stock_Producto = stock_Producto;
	}
	public float getPrecio_Unitario_Producto() {
		return Precio_Unitario_Producto;
	}
	public void setPrecio_Unitario_Producto(float precio_Unitario_Producto) {
		Precio_Unitario_Producto = precio_Unitario_Producto;
	}
	
	
	
}
