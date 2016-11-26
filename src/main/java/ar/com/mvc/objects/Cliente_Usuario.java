package ar.com.mvc.objects;

import java.util.List;

import ar.com.model.domain.Persona;
import ar.com.model.domain.Tipos;




public class Cliente_Usuario {
	private String DNI_Persona;
	
	private String Nombre_Persona;
	
	private String Apellido_Persona;
	
	private String Telefono_Persona;
	
	private String Email_Persona;
	
	private String FechaDeNac_Persona;
	
	private String Domicilio_Persona;
	
	private String Nombre_Usuario;
	
	private Persona Persona;
	
	private String Password_Usuario;
	
	private int Role_Usuario;
	
	private List<Tipos> ListaTipos;
	
	
	
	public Cliente_Usuario(List<Object> readAll) {
		this.ListaTipos=(List<Tipos>)(Object)readAll;
	}
	public Cliente_Usuario() {
	
	}
	

	public List<Tipos> getListaTipos() {
		return ListaTipos;
	}

	public void setListaTipos(List<Tipos> listaTipos) {
		ListaTipos = listaTipos;
	}

	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getDNI_Persona() {
		return DNI_Persona;
	}

	public void setDNI_Persona(String dNI_Persona) {
		DNI_Persona = dNI_Persona;
	}

	public String getNombre_Persona() {
		return Nombre_Persona;
	}

	public void setNombre_Persona(String nombre_Persona) {
		Nombre_Persona = nombre_Persona;
	}

	public String getApellido_Persona() {
		return Apellido_Persona;
	}

	public void setApellido_Persona(String apellido_Persona) {
		Apellido_Persona = apellido_Persona;
	}

	public String getTelefono_Persona() {
		return Telefono_Persona;
	}

	public void setTelefono_Persona(String telefono_Persona) {
		Telefono_Persona = telefono_Persona;
	}

	public String getEmail_Persona() {
		return Email_Persona;
	}

	public void setEmail_Persona(String email_Persona) {
		Email_Persona = email_Persona;
	}

	public String getFechaDeNac_Persona() {
		return FechaDeNac_Persona;
	}

	public void setFechaDeNac_Persona(String fechaDeNac_Persona) {
		FechaDeNac_Persona = fechaDeNac_Persona;
	}

	public String getDomicilio_Persona() {
		return Domicilio_Persona;
	}

	public void setDomicilio_Persona(String domicilio_Persona) {
		Domicilio_Persona = domicilio_Persona;
	}

	public String getNombre_Usuario() {
		return Nombre_Usuario;
	}

	public void setNombre_Usuario(String nombre_Usuario) {
		Nombre_Usuario = nombre_Usuario;
	}

	public Persona getPersona() {
		return Persona;
	}

	public void setPersona(Persona persona) {
		Persona = persona;
	}

	public String getPassword_Usuario() {
		return Password_Usuario;
	}

	public void setPassword_Usuario(String password_Usuario) {
		Password_Usuario = password_Usuario;
	}

	public int getRole_Usuario() {
		return Role_Usuario;
	}

	public void setRole_Usuario(int role_Usuario) {
		Role_Usuario = role_Usuario;
	}
	
	
	
	
}
