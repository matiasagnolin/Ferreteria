package ar.com.model.domain;

import java.io.Serializable;
import ar.com.model.domain.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Producto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int ID_Producto;
	@Id
	private String Descripcion_Producto;
	@Column(name="Stock_Producto")
	private int Stock_Producto;
	@Column(name="Precio_Unitario_Producto")
	private float Precio_Unitario_Producto;
	@OneToOne(cascade= CascadeType.ALL)
	private Comision comision;
	
	public Comision getComision() {
		return comision;
	}
	public void setComision(Comision comision) {
		this.comision = comision;
	}
	@Override
	public String toString() {
		return 
				 ", Descripcion_Producto=" + Descripcion_Producto
				+ ", Stock_Producto=" + Stock_Producto
				+ ", Precio_Unitario_Producto=" + Precio_Unitario_Producto
				+ "]";
	}
	public Producto(){}
	public Producto(String Descripcion_Producto ,int Stock_Producto,float Precio_Unitario_Producto)
	{
		this.Descripcion_Producto=Descripcion_Producto;
		this.Stock_Producto=Stock_Producto;
		this.Precio_Unitario_Producto=Precio_Unitario_Producto;
	}
	public Producto(String Descripcion_Producto ,int Stock_Producto,float Precio_Unitario_Producto,Comision comision)
	{
		this.Descripcion_Producto=Descripcion_Producto;
		this.Stock_Producto=Stock_Producto;
		this.Precio_Unitario_Producto=Precio_Unitario_Producto;
		this.comision=comision;
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
