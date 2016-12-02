package ar.com.Controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.Request.data.Request;
import ar.com.ServiceLayer.ServiceBussines;
import ar.com.ServiceLayer.ServiceCRUD;
import ar.com.model.domain.Cliente;
import ar.com.model.domain.Persona;
import ar.com.model.domain.RRHH;
import ar.com.model.domain.Tipos;
import ar.com.model.domain.Usuario;
import ar.com.model.domain.Vendedor;
import ar.com.mvc.objects.Cliente_Usuario;

@Controller
@Scope("session")
public class LoginController implements Serializable{
	

	@Autowired
	private ServiceCRUD dataService;
	@Autowired
	private ServiceBussines BussinesService;
	@Autowired
	private Request req ;
	@Autowired
	private HttpServletRequest context;
	@Autowired
	private Usuario user;
	
	
	
	@RequestMapping(value="/")
	public ModelAndView Index(Model model){

		return new ModelAndView("Login", "command", new Cliente_Usuario(dataService.ReadAll(new Request(new Tipos()))));
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView Login(@ModelAttribute("Usuario") Cliente_Usuario cliente_usuario, HttpServletRequest requ) throws Exception
	{
		
		Usuario user2 = new Usuario();
		user2.setNombre_Usuario(cliente_usuario.getNombre_Usuario());
		user2.setPassword_Usuario(cliente_usuario.getPassword_Usuario());
		
		req.setObject(user2);
		req.setId(user2.getNombre_Usuario());
		try{
		this.user=(Usuario)dataService.ReadOne(req);
		
		if(user.equals(user2)){
			requ.getSession().setAttribute("usuario", this.user);
			return new ModelAndView("redirect:/Home");
		}
		else 
		{
			cliente_usuario.setError("ERROR: USUARIO O CONTRASENA INCORRECTO"); 
			cliente_usuario.setListaTipos((List<Tipos>)(Object)dataService.ReadAll(new Request(new Tipos())));
			return new ModelAndView("Login", "command", cliente_usuario);
			}
		}catch(Exception e){
			cliente_usuario.setError("ERROR: USUARIO O CONTRASENA INCORRECTO");
			cliente_usuario.setListaTipos((List<Tipos>)(Object)dataService.ReadAll(new Request(new Tipos())));
			return new ModelAndView("Login", "command", cliente_usuario);
			}
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView Register(@ModelAttribute("Cliente_Usuario") Cliente_Usuario cliente_usuario, ModelMap model,HttpServletRequest requ) throws Exception
	{
		Persona cliente;
		if(cliente_usuario.getRole_Usuario()==0)
			{cliente = new Cliente();}
		else 
			if(cliente_usuario.getRole_Usuario()==1)
				{ cliente = new Vendedor();}
					else{cliente = new RRHH();}
		
		Usuario user2 = new Usuario();
		
		cliente.setDNI_Persona(cliente_usuario.getDNI_Persona());
		cliente.setApellido_Persona(cliente_usuario.getApellido_Persona());
		cliente.setNombre_Persona(cliente_usuario.getNombre_Persona());
		
		user2.setNombre_Usuario(cliente_usuario.getNombre_Usuario());
		user2.setPassword_Usuario(cliente_usuario.getPassword_Usuario());
		
		req.setObject(new Tipos());
		req.setId(cliente_usuario.getRole_Usuario());
		
		user2.setRole_Usuario((Tipos)dataService.ReadOne(req));
		
		user2.setPersona(cliente);
		cliente.setUsuario(user2);
		
		req.setObject(cliente);
		req.setId(cliente.getDNI_Persona());
		
		if(dataService.exists(req))
		{
			req.setObject(cliente.getUsuario());
			req.setId(cliente.getUsuario().getNombre_Usuario());
			
			if(dataService.exists(req))
			{
				cliente_usuario.setError("ERROR: USUARIO YA EXISTENTE");
				cliente_usuario.setListaTipos((List<Tipos>)(Object)dataService.ReadAll(new Request(new Tipos())));
				return new ModelAndView("Login", "command",  cliente_usuario);
			}
			else
			{
				dataService.Save(req); 
				return new ModelAndView("redirect:/Home");//EN CASO DE QUE EXISTA REGISTRO EN PERSONA Y NO EN USUARIO (NO VA A PASAR NUNCA)
			}
		}
		else
		{
			
			req.setId(cliente.getDNI_Persona());
			req.setObject(cliente);
			
			dataService.Save(req);
			
			
			req.setObject(user2);
			req.setId(user2.getNombre_Usuario());
			
			//dataService.Save(req);
			
			this.user=(Usuario)dataService.ReadOne(req);
			requ.getSession().setAttribute("usuario", this.user);
			return  new ModelAndView("redirect:/Home");
		}
	}

}
