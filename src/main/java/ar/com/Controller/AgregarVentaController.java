package ar.com.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.Request.data.Request;
import ar.com.ServiceLayer.ServiceCRUD;
import ar.com.model.domain.Producto;
import ar.com.model.domain.Usuario;
import ar.com.model.domain.Venta;

@Controller
@Scope("session")
public class AgregarVentaController {
	@Autowired
	private ServiceCRUD dataService;
	@Autowired
	private Request req ;
	
	private Usuario user;
	
	@RequestMapping(value="/AgegarVenta",method=RequestMethod.GET)
	public ModelAndView Ventas(HttpServletRequest request) throws Exception{
		
		this.user=(Usuario)request.getSession().getAttribute("usuario");
		
		req.setObject(new Producto());
		List<Producto> productos = (List<Producto>)(Object)dataService.ReadAll(req);
		req.setObject(new Usuario());
		List<Usuario> usuarios = (List<Usuario>)(Object)dataService.ReadAll(req);
		
		ModelAndView model = new ModelAndView();
		
		model.addObject("usuarios", usuarios);
		model.addObject("productos", productos);
		model.setViewName("AgregarVenta");
		
		return  model;
	}
	@RequestMapping(value="/GuardarVenta",method=RequestMethod.GET)
	public ModelAndView guardarVenta(HttpServletRequest request) throws Exception{
		
		
		
		ModelAndView model = new ModelAndView();
		
		
		
		return  model;
	}
	
	
}
