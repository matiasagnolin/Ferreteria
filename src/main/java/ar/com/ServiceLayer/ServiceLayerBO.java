package ar.com.ServiceLayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.Request.data.Request;
import ar.com.model.domain.Venta;
import ar.com.repository.Repository;

public class ServiceLayerBO implements ServiceBussines {
	@Autowired
	private ServiceCRUD data;
	@Override
	public int CantidadDeVentas(Serializable id) throws Exception {
		Venta vt= new Venta();
		List<Venta> lsvt= new ArrayList<Venta>();
		Request req = new Request();
		int cont=0;
		
		req.setObject(vt);

		lsvt=(List<Venta>)(Object)data.ReadAll(req);
		for(Venta vent : lsvt)
			if(vent.getVendedor().getPersona().getDNI_Persona().equals(id))
				cont++;
		return cont;
		}

}
