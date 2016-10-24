package ar.com.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Venta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID_Venta;
	
	@ManyToOne
	private Usuario cliente;
	
	@ManyToOne
	private Usuario vendedor;
	@OneToMany(cascade= CascadeType.ALL)
	private List<DetalleVenta> detalleventa;
	
	@Column(name="Fecha_Venta")
	private String Fecha;

	
	public Usuario getVendedor() {
		return vendedor;
	}
	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}
	public List<DetalleVenta> getDetalleventa() {
		return detalleventa;
	}
	public void setDetalleventa(List<DetalleVenta> detalleventa) {
		this.detalleventa = detalleventa;
	}
	public Venta(){}
	public Venta (Usuario cliente,Usuario vendedor,String Fecha)
	{
		this.cliente=cliente;
		this.vendedor=vendedor;
		this.Fecha=Fecha;
	}
	
	public Venta (Usuario cliente,Usuario vendedor,String Fecha,ArrayList<DetalleVenta> detalle)
	{
		
		this.cliente=cliente;
		this.vendedor=vendedor;
		this.Fecha=Fecha;
		this.detalleventa=detalle;
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
	
	
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	@Override
	public String toString() {
		return "Venta [ID_Venta=" + ID_Venta + ", cliente=" + cliente
				+ ", vendedor=" + vendedor ;
		
	}
}
