package ar.com.ServiceLayer;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.List;

import ar.com.model.domain.Comision;
import ar.com.model.domain.Usuario;
import ar.com.model.domain.Vendedor;
import ar.com.model.domain.Venta;

public interface ServiceBussines {
	public int getCantidadDeVentas(Vendedor vd) throws Exception;

	public Vendedor setCantidadDeVentas(Vendedor vd) throws Exception;

	public Vendedor setComisionPorProductoVendido(Vendedor vd);

	public void setComisionPorCantidadVentas(Vendedor vd);

	public List<Venta> getLsvt();

	public void setLsvt(List<Venta> lsvt);

	public List<Object>  VentasPorVendedor(List<Object> ventas,String user,String type);

	public void setLstcm(List<Comision> vnd);

	public void setCantidadCampania(Vendedor vendedor) throws ParseException;

	public void setComisionPrimerVendedor(List<Vendedor> vnd);

	public void Ordenar(List<Vendedor> vnd);
	
	public List<Object> Proxy(Usuario user, List<Object> obj, String t);
}
