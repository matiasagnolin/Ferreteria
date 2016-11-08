package ar.com.ServiceLayer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import ar.com.DataLayer.data.DataLayerImple;
import ar.com.Request.data.Request;
import ar.com.config.spring.AppConfig;
import ar.com.config.spring.AppConfig2;
import ar.com.repository.Repository;

@Service
public class ServiceLayer implements ServiceBO {

	@Autowired
	private Repository data;

	public ServiceLayer(){
		 
	}
	

	public void setData(Repository data) {
		this.data = data;
	}
	

	@Override
	public List<Object> ReadAll(Request req) {
		List <Object> obj = new ArrayList<Object>();
		obj = data.ReadAll(req.getObject().getClass());
		return obj;
	}

	@Override
	public Object ReadOne(Request req)throws Exception {
		try{return data.ReadOne(req.getObject().getClass(), req.getObject().toString());}
		catch(Exception ex){
			System.out.println("BAD SERVICE");
			ex.printStackTrace();
			
			throw new Exception();}
	}

	@Override
	public void Save(Request req) {
		try{
		data.save(req.getObject());}
		catch(Exception e){e.printStackTrace();}
		
	}

	@Override
	public void Update(Request req) {
		data.update(req.getObject());
		
	}

	@Override
	public void Delete(Request req) {
		// TODO Auto-generated method stub
		
	}

	

}
