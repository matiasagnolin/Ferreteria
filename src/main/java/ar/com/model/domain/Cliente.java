package ar.com.model.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Cliente extends Persona {
	
	public Cliente()
	{
		super();
	}
	public Cliente (int DNI,String nombre, String apellido,String fechadenac,String direccion,String email,String telefono){
		super(DNI,nombre, apellido,telefono,email,direccion,fechadenac);		
	}
	public Cliente (int DNI,String nombre, String apellido,String fechadenac,String direccion,String email,String telefono,Usuario usuario){
		super(DNI,nombre, apellido,telefono,email,direccion,fechadenac,usuario);		
	}
	
}
