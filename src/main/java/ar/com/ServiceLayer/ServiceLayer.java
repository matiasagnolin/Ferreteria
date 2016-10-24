package ar.com.ServiceLayer;

import java.util.List;

import ar.com.DataLayer.data.DataLayerImple;
import ar.com.Request.data.Request;

import ar.com.repository.Repository;

public class ServiceLayer {

	
	private Repository<Object> data;

	
	public ServiceLayer(){
		data=new DataLayerImple();
	}
	
	public void SaveObject(Request req) throws Exception 
	{
		for(Object obj : req.getList())
			data.save(obj);
	}
//	public List<Object> ReadObject(Request req) throws Exception 
//	{
//		//return readData.ReadAll(req.getObject());
//	}

	

}
