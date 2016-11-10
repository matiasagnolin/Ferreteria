package ar.com.repository;

import java.io.Serializable;
import java.util.List;

public interface Repository{
	
	public List<Object> ReadAll(Class t);
	public Object ReadOne(Class t,Serializable id)throws Exception;
	public void save(Object t);
	public void update(Object t);
	public List<Object> ExecuteQuery(String query);
	public List<Object> GetAllByField(Object t,String field, Serializable id);
}


