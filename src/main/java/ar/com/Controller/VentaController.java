package ar.com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.model.domain.Venta;
import ar.com.repository.Repository;

public class VentaController {
	@Autowired
	private Repository dataService;
	
	@RequestMapping(value="/api/pets", method=RequestMethod.POST)
	public @ResponseBody void add(@RequestBody Venta dto){
		dataService.save(dto); 
	}
}
