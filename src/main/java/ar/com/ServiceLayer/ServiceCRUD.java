package ar.com.ServiceLayer;

import java.util.List;

import ar.com.Request.data.Request;

public interface ServiceCRUD {
public List<Object> ReadAll(Request req);
public Object ReadOne(Request req) throws Exception;
public void Save(Request req);
public void Update(Request req);
public void Delete (Request req);
public List<Object>GetAllByField(Request req, String field);
public int getDiffFecha(String Fecha);
}
