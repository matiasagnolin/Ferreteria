package ar.com.ServiceLayer.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import junit.framework.Assert;
import ar.com.DataLayer.data.DataLayerImple;
import ar.com.Request.data.Request;
import ar.com.ServiceLayer.ServiceLayer;


import ar.com.config.spring.AppConfig2;
import ar.com.model.domain.Comision;
import ar.com.model.domain.DetalleVenta;
import ar.com.model.domain.Persona;
import ar.com.model.domain.Producto;
import ar.com.model.domain.Usuario;
import ar.com.model.domain.Venta;
import ar.com.repository.Repository;

@RunWith(JUnit4.class)
public class ServiceLayerTest{
	
	private ServiceLayer service=new ServiceLayer();
	private List<Object> list;
	private Persona cliente1;
	private Persona vendedor2;
	private Request req;
	private Usuario usuario1;
	private Usuario usuario2;
	private List<Producto> listpr;
	private Venta vt;
	private List <DetalleVenta> Detalle;
	
	
	@Before
	public void before(){
		
		System.out.println("Before()");
		
		req= new Request();
		Detalle =  new ArrayList<DetalleVenta>();
		listpr = new ArrayList<Producto>();
		
		cliente1 = new Persona("38277272","Matias","Agnolin","47448589","matiasagnolin@gmail.com",
							"18061994","sobremonte 1735"); 
		vendedor2 = new Persona("1111111","pepito","Dummy","11111111","pepito.dummy@gmail.com",
							"19950902","pepito 1735"); 
		 usuario1 = new Usuario("usuario1", "123", 0,cliente1);
		 usuario2 = new Usuario("usuario2", "123", 1,vendedor2);
		 cliente1.setUsuario(usuario1);
		 vendedor2.setUsuario(usuario2);
		 Producto producto= new Producto("tornillo",50,125,new Comision(0.10, "Comision normal"));
		 Producto producto1= new Producto("arandela",500,15,new Comision(0.10, "Comision normal"));
		 Producto producto2= new Producto("martillo",510,1,new Comision(0.10, "Comision normal"));
		 Producto producto3= new Producto("sopapa",250,25,new Comision(0.20, "Comision superior"));
		 listpr.add(producto);
		 listpr.add(producto1);
		 listpr.add(producto2);
		 listpr.add(producto3);
		 vt = new Venta(usuario1,usuario2 ,"20160101");
		 Detalle.add(new DetalleVenta(vt,producto,5,producto.getPrecio_Unitario_Producto()*producto.getComision().getComision(),producto.getPrecio_Unitario_Producto()*5));
		 vt.setDetalleventa(Detalle);		
	} 


//	@Test
//	public void SaveTest(){
//		list = new ArrayList<Object>();
//		list.add(cliente1);
//		list.add(vendedor2);
//		for(Producto pr : listpr)
//		list.add(pr);
//		list.add(vt);
//		 req.setList(list);
//		try 
//		{
//			service.SaveObject(req);
//		}
//		catch (Exception e) 
//		{
//			Assert.fail(e.getMessage());
//		}
//		
//	}
//	
//	@Test
//	public void ReadTest(){
//		req.setObject(Venta.class);
//		try 
//		{
//			System.out.println("TRY");
//			//for(Object vt : service.ReadObject(req))
//				Assert.assertTrue( service.ReadObject(req).size() >= 0);
//		}
//		catch (Exception e) 
//		{
//			Assert.fail(e.getMessage());
//		}
//		
//	}
	
	@Test
	public void getCustomer() throws Exception{
		req.setObject(cliente1);
		Assert.assertTrue(service.ReadObject(req).size() >= 0);
	}
	

	


	
	
	
	
	
	
}

