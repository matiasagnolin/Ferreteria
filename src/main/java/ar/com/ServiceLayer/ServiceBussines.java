package ar.com.ServiceLayer;

import java.io.Serializable;

public interface ServiceBussines<T> {
public double ComisionPorVentas(Serializable id,String field) throws Exception;
}
