package ar.com.ServiceLayer.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import junit.framework.Assert;
import ar.com.DataLayer.data.DataLayerImple;
import ar.com.Request.data.Request;
import ar.com.ServiceLayer.ServiceBussines;
import ar.com.ServiceLayer.ServiceCRUD;
import ar.com.ServiceLayer.ServiceLayer;


import ar.com.ServiceLayer.ServiceLayerBO;
import ar.com.config.spring.AppConfig;
import ar.com.model.domain.Cliente;
import ar.com.model.domain.Comision;
import ar.com.model.domain.DetalleVenta;
import ar.com.model.domain.Persona;
import ar.com.model.domain.Producto;
import ar.com.model.domain.Usuario;
import ar.com.model.domain.Vendedor;
import ar.com.model.domain.Venta;
import ar.com.repository.Repository;

@RunWith(JUnit4.class)
public class ServiceLayerTest{
	
	private ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
	private ServiceCRUD service=(ServiceCRUD)context.getBean("Service");
	private ServiceBussines serviceBO=(ServiceBussines) context.getBean("ServiceBO");
	
	private List<Object> list;
	private Cliente cliente1;
	private Vendedor vendedor2= new Vendedor();
	private Request req;
	private Usuario usuario1;
	private Usuario usuario2;
	private List<Producto> listpr;
	private Venta vt=new Venta();
	private List <DetalleVenta> Detalle;
	private List <Comision> listcom;
	private List <Venta> listventa;
	private List <Vendedor> listvendedor= new ArrayList<Vendedor>();
	
	
	@Before
	public void before(){
		
		System.out.println("Before()");
		
		req= new Request();
		Detalle =  new ArrayList<DetalleVenta>();
		listpr = new ArrayList<Producto>();
		list= new ArrayList<Object>();
		listcom = new ArrayList<Comision>();
		listventa = new ArrayList<Venta>();
		 
		 	
	} 
	
//	@Test
//	public void SaveProduct() throws Exception{
//		try{
//			Comision cm = new Comision("Comision por producto baja",0.10,"20160605",1);
//			Comision cm1 = new Comision("Comision por producto media",0.20,"20160605",1);
//			Comision cm2 = new Comision("Comision por producto alta",0.30,"20160605",1);
//			Comision cm4 = new Comision("Comision por venta 1 a 5",1,5,200,"20160605",2);
//			Comision cm5 = new Comision("Comision por venta 6 a 10",6,10,400,"20160605",2);
//			Comision cm6 = new Comision("Comision por venta 11 a 15",11,15,700,"20160605",2);
//			Comision cm7= new Comision("Comision por venta mas de 15 ",16,99999,1000,"20160605",2);
//			Comision cm8= new Comision("Comision por camapania ",1000,"20160605","20170807",3);
//			Producto producto= new Producto("tornillo",50,125,cm);
//			 Producto producto1= new Producto("arandela",500,15,cm1);
//			 Producto producto2= new Producto("martillo",510,1,cm2);
//			 Producto producto3= new Producto("sopapa",50,5,cm);
//			 Producto producto4= new Producto("pinza",20,45,cm8);
//			 Producto producto5= new Producto("destornillador",2,55,cm8);
//			 listpr.add(producto);
//			 listpr.add(producto1);
//			 listpr.add(producto2);
//			 listpr.add(producto3);
//			 listpr.add(producto4);
//			 listpr.add(producto5);
//			for(Producto obj : listpr)
//			{req.setObject(obj);
//			service.Save(req);
//			}
//			}
//		catch (Exception e){Assert.fail();}
//	}

//	@Test
//	public void SaveComision() throws Exception{
//		try{
//			Comision cm = new Comision("Comision por producto baja",0.10,"20160605",1);
//			Comision cm1 = new Comision("Comision por producto media",0.20,"20160605",1);
//			Comision cm2 = new Comision("Comision por producto alta",0.30,"20160605",1);
//			Comision cm4 = new Comision("Comision por venta 1 a 5",1,5,200,"20160605",2);
//			Comision cm5 = new Comision("Comision por venta 6 a 10",6,10,400,"20160605",2);
//			Comision cm6 = new Comision("Comision por venta 11 a 15",11,15,700,"20160605",2);
//			Comision cm7= new Comision("Comision por venta mas de 15 ",16,99999,1000,"20160605",2);
//			Comision cm8= new Comision("Comision por camapania ",1000,"20160605","20170807",3);
//			 listcom.add(cm);
//			 listcom.add(cm1);
//			 listcom.add(cm2);
//			 listcom.add(cm4);
//			 listcom.add(cm5);
//			 listcom.add(cm6);
//			 listcom.add(cm7);
//			 listcom.add(cm8);
//			for(Comision obj : listcom)
//			{req.setObject(obj);
//			service.Save(req);
//			}
//			}
//		catch (Exception e){Assert.fail();}
//	}
//	@Test 
//	public void SavePeople() throws Exception{
//		try{
//			cliente1 = new Cliente("38277272","Matias","Agnolin","47448589","matiasagnolin@gmail.com",
//									"18061994","sobremonte 1728"); 
//			vendedor2 = new Vendedor("1111111","pepito","Dummy","11111111","pepito.dummy@gmail.com",
//										"19950902","pepito 1735"); 
//			 usuario1 = new Usuario("usuario1", "123", 0,cliente1);
//			 usuario2 = new Usuario("usuario2", "123", 1,vendedor2);
//			 cliente1.setUsuario(usuario1);
//			 vendedor2.setUsuario(usuario2);
//			 list.add(vendedor2);
//			 list.add(cliente1);
//			for(Object obj : list)
//			{req.setObject(obj);
//			service.Save(req);
//			}
//			}
//		catch (Exception e){Assert.fail();}
//	}
//	@Test
//	public void SaveSale() throws Exception{
//		try{
//			cliente1 = new Cliente("38277272","Matias","Agnolin","47448589","matiasagnolin@gmail.com",
//			"18061994","sobremonte 1728"); 
//			vendedor2 = new Vendedor("1111111","pepito","Dummy","11111111","pepito.dummy@gmail.com",
//			"19950902","pepito 1735"); 
//			usuario1 = new Usuario("usuario1", "123", 0,cliente1);
//			usuario2 = new Usuario("usuario2", "123", 1,vendedor2);
//			cliente1.setUsuario(usuario1);
//			vendedor2.setUsuario(usuario2);
//			Comision cm = new Comision("Comision por producto baja",0.10,"20160605",1);
//			Comision cm1 = new Comision("Comision por producto media",0.20,"20160605",1);
//			Comision cm2 = new Comision("Comision por producto alta",0.30,"20160605",1);
//			Comision cm4 = new Comision("Comision por venta 1 a 5",1,5,200,"20160605",2);
//			Comision cm5 = new Comision("Comision por venta 6 a 10",6,10,400,"20160605",2);
//			Comision cm6 = new Comision("Comision por venta 11 a 15",11,15,700,"20160605",2);
//			Comision cm7= new Comision("Comision por venta mas de 15 ",16,99999,1000,"20160605",2);
//			Comision cm8= new Comision("Comision por camapania ",1000,"20160605","20170807",3);
//			Producto producto= new Producto("tornillo",50,125,cm);
//			 Producto producto1= new Producto("arandela",500,15,cm1);
//			 Producto producto2= new Producto("martillo",510,1,cm2);
//			 Producto producto3= new Producto("sopapa",50,5,cm);
//			 Producto producto4= new Producto("pinza",20,45,cm8);
//			 Producto producto5= new Producto("destornillador",2,55,cm8);
//			vt = new Venta(usuario1,usuario2 ,"20160101");
//			
//			Venta vt1 = new Venta(usuario1,usuario2 ,"20160101");
////			 Detalle.add(new DetalleVenta(vt,producto,5,producto.getPrecio_Unitario_Producto()*5));
////			 Detalle.add(new DetalleVenta(vt,producto1,5,producto1.getPrecio_Unitario_Producto()*5));
////			 vt.setDetalleventa(Detalle);
////			
////			 req.setObject(vt);
////			 service.Save(req);
//			 
//			 Detalle.add(new DetalleVenta(vt1,producto,5,producto.getPrecio_Unitario_Producto()*5));
//			 Detalle.add(new DetalleVenta(vt1,producto3,5,producto1.getPrecio_Unitario_Producto()*5));
//			 vt1.setDetalleventa(Detalle);
//
//			req.setObject(vt1);
//			service.Save(req);
//			}
//		catch (Exception e){Assert.fail();}
//	}
//	
//	@Test
//	public void getCountSales() throws Exception{
//		try{
//			//System.out.println(serviceBO.CantidadDeVentas(vendedor2.getDNI_Persona()));
//			Assert.assertEquals(true,true);
//			}
//		catch (Exception e){Assert.fail();}
//	}

//	@Test
//	public void getCustomer() throws Exception{
//		cliente1 = new Cliente("38277272","Matias","Agnolin","47448589","matiasagnolin@gmail.com",
//				"18061994","sobremonte 1728"); 
//				usuario1 = new Usuario("usuario1", "123", 0,cliente1);
//				cliente1.setUsuario(usuario1);
//		req.setObject(cliente1);
//		Assert.assertTrue(service.ReadAll(req).size() == 1);
//	}
////	
//	
//
//	@Test
//	public void getOneCustomer() throws Exception{
//		cliente1 = new Cliente("38277272","Matias","Agnolin","47448589","matiasagnolin@gmail.com",
//		"18061994","sobremonte 1728"); 
//		usuario1 = new Usuario("usuario1", "123", 0,cliente1);
//		cliente1.setUsuario(usuario1);
//		req.setObject(cliente1);
//		req.setId(cliente1.getDNI_Persona());
//		Persona ps=null;
//		try{ ps = (Persona) service.ReadOne(req);}
//		catch(Exception ex){System.out.println("CATCH");}
//		finally{Assert.assertEquals(ps.getDNI_Persona(),cliente1.getDNI_Persona());}
//	}


//	@Test
//	public void UpdateOneCustomer() throws Exception{
//		req.setObject(cliente1);
//		req.setId(cliente1.getDNI_Persona());
//		try{service.Update(req);}
//		catch(Exception ex){System.out.println("CATCH");}
//	}
	@Test
	public void BussinesLayer() throws Exception{
//		System.out.println(serviceBO.getLsvt().size());
		req.setObject(vt);
		serviceBO.setLsvt((List<Venta>)(Object)service.ReadAll(req));
		req.setObject(vendedor2);
		this.listvendedor=(List<Vendedor>)(Object)service.ReadAll(req);
		for(Vendedor vd : listvendedor)
		{
			serviceBO.setCantidadDeVentas(vd);
			System.out.println(vd.getComision()+" "+vd.getDNI_Persona()+" "+vd.getCantVentas());
			serviceBO.setComisionPorProductoVendido(vd);
			serviceBO.setComisionPorCantidadVentas(vd);
			System.out.println(vd.getComision());
		}

	}
}

