package ar.com.ServiceLayer;

import java.util.List;

import ar.com.Request.data.Request;

public interface ServiceBO {
public List<Object> ReadAll(Request req);
public Object ReadOne(Request req) throws Exception;
public void Save(Request req);
public void Update(Request req);
public void Delete (Request req);
}
