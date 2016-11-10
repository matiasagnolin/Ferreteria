package ar.com.model.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="DNI_Persona")
public class Cliente extends Persona implements Serializable{
	public Cliente(){super();}

}
