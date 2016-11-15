package ar.com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.com.model.domain.Venta;
import ar.com.repository.Repository;

@Controller
public class HomeController {
	
	@Autowired
	private Repository dataService;
	
	@RequestMapping(value="/")
	public String home(Model model){
		System.out.println("CONTROLLER");
		List<Venta> ventas = (List<Venta>)(Object)dataService.ReadAll(Venta.class);
		model.addAttribute("ventas", ventas);
		return "home";
	}
	
	@RequestMapping(value="/about")
	public String about(){
		return "about";
	}
}
