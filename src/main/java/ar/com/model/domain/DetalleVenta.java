package ar.com.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class DetalleVenta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	//@EmbeddedId
	@ManyToOne(cascade= CascadeType.ALL)
	private Venta venta;
	@OneToOne(cascade=CascadeType.ALL)
	private Producto producto;
	@Column(name="Cantidad")
	private int cantidad;
//	@Column(name="Comision")
//	private double comision;
	@Column(name="TotalParcial")
	private double totalParcial;
	public DetalleVenta(){}
	
	
	
	public DetalleVenta(Venta venta, Producto producto, int cantidad,
			 double totalParcial) {
		super();
		this.venta = venta;
		this.producto = producto;
		this.cantidad = cantidad;
//		this.comision = comision;
		this.totalParcial = totalParcial;
	}
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
//	public double getComision() {
//		return comision;
//	}
//	public void setComision(double comision) {
//		this.comision = comision;
//	}
	public double getTotalParcial() {
		return totalParcial;
	}
	public void setTotalParcial(double totalParcial) {
		this.totalParcial = totalParcial;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((producto == null) ? 0 : producto.hashCode());
		result = prime * result + ((venta == null) ? 0 : venta.hashCode());
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
		DetalleVenta other = (DetalleVenta) obj;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		if (venta == null) {
			if (other.venta != null)
				return false;
		} else if (!venta.equals(other.venta))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DetalleVenta [venta=" + venta + ", producto=" + producto
				//+ ", cantidad=" + cantidad + ", comision=" + comision
				+ ", totalParcial=" + totalParcial + "]";
	}
	
	
	
	
}
