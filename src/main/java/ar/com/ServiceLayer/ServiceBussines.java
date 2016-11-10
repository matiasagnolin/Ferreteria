package ar.com.ServiceLayer;

import java.io.Serializable;
import java.util.List;

import ar.com.model.domain.Vendedor;

public interface ServiceBussines<T> {
public int CantidadDeVentas(Serializable id) throws Exception;
public  void ObtenerCantidadDeVentas() throws Exception ;
public void ComisionPorVentas();
}
