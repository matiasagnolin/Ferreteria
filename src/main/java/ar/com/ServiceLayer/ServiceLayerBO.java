package ar.com.ServiceLayer;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
					for(DetalleVenta dtvta : vta.getDetalleventa()){
						if(dtvta.getProducto().getComision().getTipo()==1){
						vd.setComision(dtvta.getProducto().getPrecio_Unitario_Producto()*dtvta.getProducto().getComision().getPorcentaje()*dtvta.getCantidad());
						System.out.println(vd.getComision()+"PRODUCTO VENDIDO");
						}}
			return vd;
	}

	@Override
	public void setComisionPorCantidadVentas(Vendedor vendedor){ 
		for(Comision cm : listcm)
		{
			if(cm.getTipo()==2){
				if(vendedor.getCantVentas()!=0)
				{
					if(vendedor.getCantVentas()>=cm.getMinimo() &&  vendedor.getCantVentas()<=cm.getMaximo())
					vendedor.setComision(cm.getValor());
				}
		  }
	}
		System.out.println(vendedor.getComision()+"CANTIDAD DE VENTAS");	
  }
	
//	@Override
@SuppressWarnings("unchecked")
	//	public void setComisionPorCampania(Vendedor vendedor) throws ParseException{
//	SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
//	for(Venta vta : lsvt)
//	{
//		if(vta.getVendedor().getPersona().getDNI_Persona().toString().equals(vendedor.getDNI_Persona().toString()))
//		{
//			for(DetalleVenta dtvta : vta.getDetalleventa())
//			{
//				if(dtvta.getProducto().getComision().getTipo()==3)
//				{
//					Date date1= formatter.parse(dtvta.getProducto().getComision().getClose_date());
//					Date date2=formatter.parse(calendario.getDate());
//					if(date1.compareTo(date2)>0)
//					{
//						vendedor.setComision(dtvta.getProducto().getComision().getValor());
//					}
//					
//				}
//		  }
//	   }
//	}
//  }
	@Override
	public void setComisionPrimerVendedor(List <Vendedor> vnd){ 
		Collections.sort(vnd);
		for(Comision cm : listcm)
		{
			if(cm.getTipo()==4){
		vnd.get(0).setComision(cm.getValor());}
		}
		System.out.println(vnd.get(0).getDNI_Persona()+vnd.get(0).getComision());
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
	public void setLstcm(List<Comision> cm) {
		this.listcm=cm;
	}

	@Override
	public void setCantidadCampania(Vendedor vendedor) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		for(Venta vta : lsvt)
		{
			if(vta.getVendedor().getPersona().getDNI_Persona().toString().equals(vendedor.getDNI_Persona().toString()))
			{
				for(DetalleVenta dtvta : vta.getDetalleventa())
				{
					if(dtvta.getProducto().getComision().getTipo()==4)
					{
						Date date1= formatter.parse(dtvta.getProducto().getComision().getClose_date());
						Date date2=formatter.parse(calendario.getDate());
						if(date1.compareTo(date2)>0)
						{
							vendedor.setCantPremio(vendedor.getCantPremio()+(1*dtvta.getCantidad()));
						}
					}
				}
			}
		}
	}
	
	@Override
	 public void Ordenar(List <Vendedor>vnd)
	 {
		 for (int i = 0; i < vnd.size(); i++) {

			    for (int j = vnd.size() - 1; j > i; j--) {
			        if (vnd.get(i).getCantPremio() > vnd.get(j).getCantPremio()) 
			        {
			            Vendedor tmp = vnd.get(i);
			            vnd.set(i,vnd.get(j));
			            vnd.set(j,tmp);
			        }

			    } 
		 }
		 for(Comision cm : listcm)
			{
				if(cm.getTipo()==4)
				{
					vnd.get(vnd.size()-1).setComision(cm.getValor());
				}	
	 }
		 System.out.println(vnd.get(vnd.size()-1).getComision());
	 }
}