package ar.com.model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
@Entity
public class SalaryReport implements Serializable{
	private float SalarioBasico;
	private Usuario empledo;
	private String DiaGeneracion;
	private int CantVentas;
	private List<Campania> Premios;
	private float adicional;
	
	
	
	public SalaryReport() {
		// TODO Auto-generated constructor stub
	}
	
}
