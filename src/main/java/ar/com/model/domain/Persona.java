package ar.com.model.domain;

import java.io.Serializable;



public class Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	private int DNI_Persona;
	private String Nombre_Persona;
	private String Apellido_Persona;
	private String Telefono_Persona;
	private String Email_Persona;
	private String FechaDeNac_Persona;
	private String Domicilio_Persona;
	private Usuario usuario;
	public Persona(){}
	
	public Persona(int DNI_Persona, String nombre_Persona, String apellido_Persona, String telefono_Persona,
			String email_Persona, String fechaDeNac_Persona, String domicilio_Persona)  {
		
			this.DNI_Persona = DNI_Persona;
			this.Nombre_Persona = nombre_Persona;
			this.Apellido_Persona = apellido_Persona;
			this.Telefono_Persona = telefono_Persona;
			this.Email_Persona = email_Persona;
			this.FechaDeNac_Persona = fechaDeNac_Persona;
			this.Domicilio_Persona = domicilio_Persona;		
	}
	public Persona(int DNI_Persona, String nombre_Persona, String apellido_Persona, String telefono_Persona,
			String email_Persona, String fechaDeNac_Persona, String domicilio_Persona,Usuario usuario)  {
		
			this.DNI_Persona = DNI_Persona;
			this.Nombre_Persona = nombre_Persona;
			this.Apellido_Persona = apellido_Persona;
			this.Telefono_Persona = telefono_Persona;
			this.Email_Persona = email_Persona;
			this.FechaDeNac_Persona = fechaDeNac_Persona;
			this.Domicilio_Persona = domicilio_Persona;		
			this.usuario=usuario;
	}
	
	
	
}
