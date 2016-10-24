package ar.com.repository;

import java.io.Serializable;
import java.util.List;

public interface Repository<T> {
	public void save(T t);
	public List<Object> ReadAll(Class clazz);
	public void ReadOne(Class clazz,Serializable id);
}


