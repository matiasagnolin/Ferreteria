package ar.com.model.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("E")
public class Empleado extends Persona{
	private String ID_Vendedor;
	public Empleado(){
		super();
	}
					
	public Empleado (String DNI,String nombre, String apellido,String fechadenac,String direccion,String email,String telefono, String ID_Vendedor){
		super(DNI,nombre, apellido,telefono,email,direccion,fechadenac);
		this.ID_Vendedor=ID_Vendedor;
	}
	public Empleado (String nombre, String apellido,String fechadenac,String direccion,String DNI,String email,String telefono, String ID_Vendedor,Usuario usuario){
		super(DNI,nombre, apellido,telefono,email,direccion,fechadenac,usuario);
		this.ID_Vendedor=ID_Vendedor;
	}
	
}
