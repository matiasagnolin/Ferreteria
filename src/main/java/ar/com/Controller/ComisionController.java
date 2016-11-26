package ar.com.Controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.Request.data.Request;
import ar.com.ServiceLayer.ServiceBussines;
import ar.com.ServiceLayer.ServiceCRUD;
import ar.com.model.domain.Comision;
import ar.com.model.domain.Tipos;
import ar.com.model.domain.Usuario;
import ar.com.model.domain.Vendedor;
import ar.com.model.domain.Venta;
import ar.com.mvc.objects.Cliente_Usuario;
@Controller
@Scope("session")
public class ComisionController implements Serializable{

	@Autowired
	private ServiceCRUD dataService;
	@Autowired
	private ServiceBussines BussinesService;
	@Autowired
	private Request req ;
	private Usuario user;
	
	@RequestMapping(value="/Comisiones")
	public ModelAndView Index(){
		ModelAndView model = new ModelAndView();
		model.addObject("Comision",  (List<Comision>)(Object)dataService.ReadAll(new Request(new Comision())));
		model.addObject("command", new Comision());
		model.setViewName("Comisiones");
		return model;
	}
	@RequestMapping(value="/Calcular",method=RequestMethod.GET)
	public ModelAndView  Calcular(HttpServletRequest request) throws Exception{
		this.user=(Usuario)request.getSession().getAttribute("usuario");
		Venta vt=new Venta();
		Vendedor vendedor2 = new Vendedor();
		Comision com = new Comision();
		
		req.setObject(vt);
		BussinesService.setLsvt((List<Venta>)(Object)dataService.ReadAll(req));
		
		req.setObject(vendedor2);
		List <Vendedor> listvendedor=(List<Vendedor>)(Object)BussinesService.Proxy(user , dataService.ReadAll(req), Vendedor.class.getName());
				//(List<Vendedor>)(Object)dataService.ReadAll(req);
		
		req.setObject(com);
		List<Comision> cm = (List<Comision>)(Object)dataService.ReadAll(req);
		
		BussinesService.setLstcm(cm);
		
		for(Vendedor vd : listvendedor)
		{
			BussinesService.setCantidadDeVentas(vd);
			BussinesService.setComisionPorProductoVendido(vd);
			BussinesService.setComisionPorCantidadVentas(vd);
			BussinesService.setCantidadCampania(vd);
		}
		
		BussinesService.setComisionPrimerVendedor(listvendedor);
		BussinesService.Ordenar(listvendedor);
		
		ModelAndView model = new ModelAndView();
		model.addObject("Vendedores",listvendedor);
		model.addObject("Comision", cm);
		model.setViewName("Calcular_Comisiones");
		
		return model;
	}
	
	
	@RequestMapping(value="/ActualizarComision")
	public ModelAndView Ventas(@ModelAttribute("comision") Comision comision,HttpServletRequest request) throws Exception{
	
		Comision cm = comision;
	
		req.setObject(cm);
		req.setId(cm.getDescripcion());
		dataService.Update(req);
		ModelAndView model = new ModelAndView();
		model.addObject("Comision",  (List<Comision>)(Object)dataService.ReadAll(new Request(new Comision())));
		model.addObject("command", new Comision());
		model.setViewName("Comisiones");		
		return model;
	}
	
	
}
