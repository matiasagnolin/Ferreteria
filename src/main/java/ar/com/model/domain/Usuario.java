package ar.com.model.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Usuario {
	@Id
	private String Nombre_Usuario;
	private String Password_Usuario;
	private int Rol_Usuario;
	private Persona DNI_Persona;
	
	public Usuario(){}

	public Usuario(String nombre_Usuario, String password_Usuario, int rol_Usuario, Persona DNI) {
		this.Nombre_Usuario = nombre_Usuario;
		this.Password_Usuario = password_Usuario;
		this.Rol_Usuario = rol_Usuario;
		this.DNI_Persona = DNI;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Nombre_Usuario == null) ? 0 : Nombre_Usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (Nombre_Usuario == null) {
			if (other.Nombre_Usuario != null)
				return false;
		} else if (!Nombre_Usuario.equals(other.Nombre_Usuario))
			return false;
		return true;
	}

	public String getNombre_Usuario() {
		return Nombre_Usuario;
	}

	public void setNombre_Usuario(String nombre_Usuario) {
		Nombre_Usuario = nombre_Usuario;
	}

	public String getPassword_Usuario() {
		return Password_Usuario;
	}

	public void setPassword_Usuario(String password_Usuario) {
		Password_Usuario = password_Usuario;
	}

	public int getRol_Usuario() {
		return Rol_Usuario;
	}

	public void setRol_Usuario(int rol_Usuario) {
		Rol_Usuario = rol_Usuario;
	}

	public Persona getDNI_Persona() {
		return DNI_Persona;
	}

	public void setDNI_Persona(Persona dNI_Persona) {
		DNI_Persona = dNI_Persona;
	}
	
}
