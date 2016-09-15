package ar.com.model.domain;

public class Empleado extends Persona{
	private String ID_Vendedor;
	public Empleado(){
		super();
	}
	
	public Empleado (String nombre, String apellido,String fechadenac,String direccion,int DNI,String email,String telefono, String ID_Vendedor){
		super(DNI,nombre, apellido,telefono,email,direccion,fechadenac);
		this.ID_Vendedor=ID_Vendedor;
	}
	public Empleado (String nombre, String apellido,String fechadenac,String direccion,int DNI,String email,String telefono, String ID_Vendedor,Usuario usuario){
		super(DNI,nombre, apellido,telefono,email,direccion,fechadenac,usuario);
		this.ID_Vendedor=ID_Vendedor;
	}
}
