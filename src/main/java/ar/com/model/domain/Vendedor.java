package ar.com.model.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;



@Entity
@PrimaryKeyJoinColumn(name="DNI_Persona")
public class Vendedor extends Persona implements Serializable{
	
private int CantVentas=0;

	public Vendedor(){super();}
}
