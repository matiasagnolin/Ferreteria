package ar.com.DataLayer.data;

import java.io.Serializable;
import java.util.List;

public interface ReadDataLayer {
	public List<Object> ReadAll(Class clazz);
	public void ReadOne(Class clazz,Serializable id);
}
