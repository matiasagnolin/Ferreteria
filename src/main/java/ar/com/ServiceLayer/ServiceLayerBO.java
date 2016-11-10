package ar.com.ServiceLayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.Request.data.Request;
import ar.com.model.domain.DetalleVenta;
import ar.com.model.domain.Persona;
import ar.com.model.domain.Vendedor;
import ar.com.model.domain.Venta;
import ar.com.repository.Repository;

public class ServiceLayerBO implements ServiceBussines {
	@Autowired
	private ServiceCRUD data;
	
	private Request req = new Request();
	private List<Venta> lsvt;
	private List <Vendedor> vnd;
	
	@SuppressWarnings("unchecked")
	@Override
	public int CantidadDeVentas(Serializable id) throws Exception {
		Venta vt= new Venta();
		lsvt= new ArrayList<Venta>();
		int cont=0;
		
		req.setObject(vt);
		
		lsvt=(List<Venta>)(Object)data.ReadAll(req);
		for(Venta vent : lsvt)
			if(vent.getVendedor().getPersona().getDNI_Persona().equals(id))
				cont++;
		return cont;
		}
	
	@SuppressWarnings("unchecked")
	@Override
	public void ObtenerCantidadDeVentas() throws Exception {
		Persona vn = new Vendedor();
		 vnd= new ArrayList<Vendedor>();
		req.setObject(vn);
		vnd=(List<Vendedor>)(Object)data.ReadAll(req);
		for(Vendedor vdd : vnd)
			vdd.setCantVentas(this.CantidadDeVentas(vdd.getDNI_Persona()));
		}

	@Override
	public void ComisionPorVentas() {
		for(Vendedor vend : vnd)
			for(Venta vta : lsvt)
				if(vta.getVendedor().getPersona().getDNI_Persona().equals(vend.getDNI_Persona()))
					for(DetalleVenta dtvta : vta.getDetalleventa())
						vend.setComision(dtvta.getProducto().getPrecio_Unitario_Producto()*dtvta.getProducto().getComision().getComision()*dtvta.getCantidad());
	}
 
}
