package ar.com.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Venta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID_Venta;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Usuario cliente;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Empleado vendedor;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Producto> Productos = new ArrayList <Producto>();
	private String Fecha;

	
	public Venta(){}
	public Venta (int ID_Venta,Usuario cliente,Empleado vendedor,Producto Productos,String Fecha)
	{
		this.ID_Venta=ID_Venta;
		this.cliente=cliente;
		this.vendedor=vendedor;
		this.Productos=(List<Producto>) Productos;
		this.Fecha=Fecha;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_Venta;
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
		Venta other = (Venta) obj;
		if (ID_Venta != other.ID_Venta)
			return false;
		return true;
	}
	public int getID_Venta() {
		return ID_Venta;
	}
	public void setID_Venta(int iD_Venta) {
		ID_Venta = iD_Venta;
	}
	public Usuario getCliente() {
		return cliente;
	}
	public void setCliente(Usuario cliente) {
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
