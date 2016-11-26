package ar.com.Controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.Request.data.Request;
import ar.com.ServiceLayer.ServiceBussines;
import ar.com.ServiceLayer.ServiceCRUD;
import ar.com.model.domain.Cliente;
import ar.com.model.domain.Comision;
import ar.com.model.domain.Persona;
import ar.com.model.domain.Usuario;
import ar.com.model.domain.Vendedor;
import ar.com.model.domain.Venta;
import ar.com.mvc.objects.Cliente_Usuario;



@SuppressWarnings({ "unchecked", "unchecked" })
@Controller
@Scope("session")
public class HomeController  {
	

	@Autowired
	private ServiceCRUD dataService;
	@Autowired
	private ServiceBussines BussinesService;
	@Autowired
	private Request req ;
	
	
//	@Autowired
	private Usuario user;

	
	
		
	@RequestMapping(value="/Home",method=RequestMethod.GET)
	public ModelAndView Ventas(HttpServletRequest request) throws Exception{
		
		this.user=(Usuario)request.getSession().getAttribute("usuario");
		
		req.setObject(new Venta());
		
		List<Object> objects = dataService.ReadAll(req);
		
		List<Venta> ventas=(List<Venta>)(Object)BussinesService.Proxy(user,objects,Venta.class.getTypeName());
		
		return new ModelAndView("home","ventas", ventas);
	}
	
	@RequestMapping(value="Ventas/{id}", method=RequestMethod.GET)
	public ModelAndView  DetalleVenta(@PathVariable String id) throws Exception
	{
		req.setObject(new Venta());
		req.setId(Integer.parseInt(id));
		Venta venta = (Venta)dataService.ReadOne(req);
		return new ModelAndView("DetalleVenta","venta", venta);
	}
	
	
}
