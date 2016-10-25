package ar.com.ServiceLayer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ar.com.DataLayer.data.DataLayerImple;
import ar.com.Request.data.Request;
import ar.com.config.spring.AppConfig;
import ar.com.config.spring.AppConfig2;
import ar.com.repository.Repository;

public class ServiceLayer {

	
	private Repository<Object> data;
	private ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
	private List <Object> obj;
	 

	
	public ServiceLayer(){
		data=new DataLayerImple();
	}
	
	public void SaveObject(Request req) throws Exception 
	{
		for(Object obj : req.getList())
			data.save(obj);
	}
	public List<Object> ReadObject(Request req) throws Exception 
	{ 
		data = context.getBean(Repository.class);
		obj = new ArrayList<Object>();
		obj = data.ReadAll(req.getObject().getClass());
		return obj;
	}

	

}
