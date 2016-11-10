package ar.com.model.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.metamodel.Type;
@Entity
public class Comision implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Justificacion")
	private String Descripcion;
	@Column(name="porcentaje")
	private double Comision;
	
	
	
	
	public Comision( Double comision, String descripcion) {
		super();
		Comision = comision;
		Descripcion = descripcion;
	}

	public Double getComision() {
		return Comision;
	}
	public void setComision(float comision) {
		Comision = comision;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	

}
