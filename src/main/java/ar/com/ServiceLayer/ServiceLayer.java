package ar.com.ServiceLayer;

import ar.com.DataLayer.data.SaveDataLayer;
import ar.com.DataLayer.data.SaveDataLayerImple;
import ar.com.Request.data.Request;

public class ServiceLayer {

	
	private SaveDataLayer<Object> data;
	
	public ServiceLayer(){
		data=new SaveDataLayerImple<Object>();
	}
	
	public void SaveObject(Request req) throws Exception 
	{
		for(Object obj : req.getList())
		data.save(obj);
	}

	

}
