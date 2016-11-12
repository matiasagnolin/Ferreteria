package ar.com.ServiceLayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.Request.data.Request;
import ar.com.model.domain.Calendario;
import ar.com.model.domain.Comision;
import ar.com.model.domain.DetalleVenta;
import ar.com.model.domain.Persona;
import ar.com.model.domain.Vendedor;
import ar.com.model.domain.Venta;
import ar.com.repository.Repository;

public class ServiceLayerBO implements ServiceBussines {

	
	private List<Comision> listcm= new ArrayList<Comision>();
	
	private List<Venta> lsvt = new ArrayList<Venta>();
	
	private List <Vendedor> vnd = new ArrayList<Vendedor>();
	
	@Autowired
	private Calendario calendario;
	
	@SuppressWarnings("unchecked")
	@Override
	public int getCantidadDeVentas(Vendedor vd) throws Exception {
		int cont=0;
		for(Venta vent : lsvt){
			if(vent.getVendedor().getPersona().toString().equals(vd.getDNI_Persona().toString())){
				cont++;
			}
		}
		return cont;
		}
	
	@SuppressWarnings("unchecked")
	@Override
	public Vendedor setCantidadDeVentas(Vendedor vd) throws Exception {
			vd.setCantVentas(this.getCantidadDeVentas(vd));
			return vd;
		}

	@Override
	public Vendedor setComisionPorProductoVendido(Vendedor vd) {
			for(Venta vta : lsvt)
				if(vta.getVendedor().getPersona().getDNI_Persona().toString().equals(vd.getDNI_Persona().toString()))
					for(DetalleVenta dtvta : vta.getDetalleventa())//if la comision e la que tiene porcentaje.
						vd.setComision(dtvta.getProducto().getPrecio_Unitario_Producto()*dtvta.getProducto().getComision().getPorcentaje()*dtvta.getCantidad());
			return vd;
	}

	@Override
	public void setComisionPorCantidadVentas(Vendedor vendedor) 
  {
		for(Comision cm : listcm)
		{
			if(cm.getTipo()==2 && calendario.getDiffFecha(cm.getClose_date())>0){
				if(vendedor.getCantVentas()!=0)
				{
					if(vendedor.getCantVentas()>=cm.getMinimo() ||  vendedor.getCantVentas()<=cm.getMaximo())
					vendedor.setComision(cm.getValor());
				}
		  }
			
	}
  }
	

	

	@Override
	public void setLsvt(List lsvt) {
		this.lsvt = lsvt;
	}

	@Override
	public List getLsvt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setVnd(List vnd) {
		this.vnd=vnd;
		
	}
	
 
}
