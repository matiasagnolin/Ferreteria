package ar.com.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Venta implements Serializable{
	private int ID_Venta;
	private Cliente cliente;
	private Empleado vendedor;
	private List<Producto> Productos = new ArrayList <Producto>();
	private String Fecha;

	
	public Venta(){}
	public Venta (int ID_Venta,Cliente cliente,Empleado vendedor,Producto Productos,String Fecha)
	{
		this.ID_Venta=ID_Venta;
		this.cliente=cliente;
		this.vendedor=vendedor;
		this.Productos=(List<Producto>) Productos;
		this.Fecha=Fecha;
	}
	public int getID_Venta() {
		return ID_Venta;
	}
	public void setID_Venta(int iD_Venta) {
		ID_Venta = iD_Venta;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getVendedor() {
		return vendedor;
	}
	public void setVendedor(Empleado vendedor) {
		this.vendedor = vendedor;
	}
	public List<Producto> getProductos() {
		return Productos;
	}
	public void setProductos(List<Producto> productos) {
		Productos = productos;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	
}
