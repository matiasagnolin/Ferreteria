package ar.com.Service.dto;

import java.util.ArrayList;
import java.util.List;


import ar.com.model.domain.DetalleVenta;
import ar.com.model.domain.Usuario;
import ar.com.model.domain.Venta;

public class VentaDTO {
	private int ID_Venta;
	
	private Usuario cliente;
	
	
	private Usuario vendedor;
	
	private List<DetalleVenta> detalleventa;
	
	
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
	public VentaDTO(){}
	public VentaDTO (Usuario cliente,Usuario vendedor,String Fecha)
	{
		this.cliente=cliente;
		this.vendedor=vendedor;
		this.Fecha=Fecha;
	}
	
	public VentaDTO (Usuario cliente,Usuario vendedor,String Fecha,ArrayList<DetalleVenta> detalle)
	{
		
		this.cliente=cliente;
		this.vendedor=vendedor;
		this.Fecha=Fecha;
		this.detalleventa=detalle;
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
