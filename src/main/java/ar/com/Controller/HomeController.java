package ar.com.Controller;

import java.io.Serializable;
import java.util.List;

import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.Request.data.Request;
import ar.com.ServiceLayer.ServiceBussines;
import ar.com.ServiceLayer.ServiceCRUD;
import ar.com.model.domain.Comision;
import ar.com.model.domain.Vendedor;
import ar.com.model.domain.Venta;


@Controller
public class HomeController {
	

@Autowired
	private ServiceCRUD dataService;
@Autowired
private ServiceBussines BussinesService;

	private Request req = new Request();
	
	@RequestMapping(value="/")
	public String home(Model model){
		req.setObject(new Venta());
		List<Venta> ventas = (List<Venta>)(Object)dataService.ReadAll(req);
		model.addAttribute("ventas", ventas);
		return "home";
	}
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
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
		for(Vendedor vd : listvendedor)
		{
			BussinesService.setCantidadDeVentas(vd);
			BussinesService.setComisionPorProductoVendido(vd);
			BussinesService.setComisionPorCantidadVentas(vd);
			BussinesService.setCantidadCampania(vd);
		}
		BussinesService.setComisionPrimerVendedor(listvendedor);
		BussinesService.Ordenar(listvendedor);
		return new ModelAndView("Comisiones","Vendedores",listvendedor);
	}
}
