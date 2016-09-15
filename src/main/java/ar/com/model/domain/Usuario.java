package ar.com.model.domain;

public class Usuario {
	private String Nombre_Usuario;
	private String Password_Usuario;
	private int Rol_Usuario;
	private String DNI_Persona;
	
	public Usuario(){}

	public Usuario(String nombre_Usuario, String password_Usuario, int rol_Usuario, String persona) {
		this.Nombre_Usuario = nombre_Usuario;
		this.Password_Usuario = password_Usuario;
		this.Rol_Usuario = rol_Usuario;
		this.DNI_Persona = persona;
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

	public String getDNI_Persona() {
		return DNI_Persona;
	}

	public void setDNI_Persona(String dNI_Persona) {
		DNI_Persona = dNI_Persona;
	}
	
}
