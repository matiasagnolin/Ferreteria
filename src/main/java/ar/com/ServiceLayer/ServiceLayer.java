package ar.com.ServiceLayer;

import java.util.List;

import ar.com.DataLayer.data.ReadDataLayer;
import ar.com.DataLayer.data.SaveDataLayer;
import ar.com.DataLayer.data.SaveDataLayerImple;
import ar.com.Request.data.Request;

public class ServiceLayer {

	
	private SaveDataLayer<Object> savedata;
	private ReadDataLayer readData;
	
	public ServiceLayer(){
		savedata=new SaveDataLayerImple<Object>();
	}
	
	public void SaveObject(Request req) throws Exception 
	{
		for(Object obj : req.getList())
			savedata.save(obj);
	}
	public List<Object> ReadObject(Request req) throws Exception 
	{
		return readData.ReadAll(req.getObject());
	}

	

}
