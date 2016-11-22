package ar.com.Controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
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
import ar.com.model.domain.Cliente_Usuario;
import ar.com.model.domain.Comision;
import ar.com.model.domain.Persona;
import ar.com.model.domain.Usuario;
import ar.com.model.domain.Vendedor;
import ar.com.model.domain.Venta;



@Controller
public class HomeController {
	

	@Autowired
	private ServiceCRUD dataService;
	@Autowired
	private ServiceBussines BussinesService;
	@Autowired
	private Request req ;
	@Autowired
	private HttpServletRequest context;

	
	
	@RequestMapping(value="/")
	public ModelAndView Index(Model model){
		return new ModelAndView("Login", "command", new Usuario());
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String Login(@ModelAttribute("Usuario") Usuario user, ModelMap model) throws Exception{
		req.setObject(user);
		req.setId(user.getNombre_Usuario());
		Usuario user2=(Usuario)dataService.ReadOne(req);
		if(user.equals(user2)){
		return "redirect:/Ventas";}
		else { return "redirect:/";}
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String Register(@ModelAttribute("Cliente_Usuario") Cliente_Usuario cliente_usuario, ModelMap model) throws Exception
	{
		Cliente cliente = new Cliente();
		Usuario user = new Usuario();
		cliente.setDNI_Persona(cliente_usuario.getDNI_Persona());
		cliente.setApellido_Persona(cliente_usuario.getApellido_Persona());
		cliente.setNombre_Persona(cliente_usuario.getNombre_Persona());
		user.setNombre_Usuario(cliente_usuario.getNombre_Usuario());
		user.setPassword_Usuario(cliente_usuario.getPassword_Usuario());
		user.setPersona(cliente);
		cliente.setUsuario(user);

		req.setObject(cliente);
		req.setId(cliente.getDNI_Persona());
		if(dataService.exists(req))
		{
			req.setObject(cliente.getUsuario());
			req.setId(cliente.getUsuario().getNombre_Usuario());
			if(dataService.exists(req))
				return "redirect:/";
			else{ dataService.Save(req); return "redirect:/Ventas";}
		}
		else
		{
			req.setObject(cliente);
			dataService.Save(req);
			req.setObject(user);
			dataService.Save(req);
			return "redirect:/Ventas";
		}
		
	}
	@RequestMapping(value="/Ventas")
	public String Ventas(Model model){
		req.setObject(new Venta());
		List<Venta> ventas = (List<Venta>)(Object)dataService.ReadAll(req);
		model.addAttribute("ventas", ventas);
		return "home";
	}
	@RequestMapping(value="/Ventas/{id}", method=RequestMethod.GET)
	public ModelAndView  DetalleVenta(@PathVariable String id) throws Exception{
		req.setObject(new Venta());
		req.setId(Integer.parseInt(id));
		Venta venta = (Venta)dataService.ReadOne(req);
		return new ModelAndView("DetalleVenta","venta", venta);
	}
	@RequestMapping(value="/Calcular")
	public ModelAndView  Calcular() throws Exception{
		Venta vt=new Venta();
		Vendedor vendedor2 = new Vendedor();
		Comision com = new Comision();
		req.setObject(vt);
		BussinesService.setLsvt((List<Venta>)(Object)dataService.ReadAll(req));
		req.setObject(vendedor2);
		List <Vendedor> listvendedor=(List<Vendedor>)(Object)dataService.ReadAll(req);
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
		model.setViewName("Comisiones");
		return model;
	}
}
