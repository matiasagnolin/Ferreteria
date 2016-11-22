package ar.com.model.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String DNI_Persona;
	@Column(name="Nombre_Persona")
	private String Nombre_Persona;
	@Column(name="Apellido_Persona")
	private String Apellido_Persona;
	@Column(name="Telefono_Persona")
	private String Telefono_Persona;
	@Column(name="Email_Persona")
	private String Email_Persona;
	@Column(name="FechaDeNac_Persona")
	private String FechaDeNac_Persona;
	@Column(name="Domicilio_Persona")
	private String Domicilio_Persona;
	
	@OneToOne(cascade= CascadeType.ALL)
	//@JoinColumn(name="Nombre_Usuario")
	private Usuario usuario;
	
	public Persona(){}
	
	public Persona(String DNI_Persona, String nombre_Persona, String apellido_Persona, String telefono_Persona,
			String email_Persona, String fechaDeNac_Persona, String domicilio_Persona)  {
		
			this.DNI_Persona = DNI_Persona;
			this.Nombre_Persona = nombre_Persona;
			this.Apellido_Persona = apellido_Persona;
			this.Telefono_Persona = telefono_Persona;
			this.Email_Persona = email_Persona;
			this.FechaDeNac_Persona = fechaDeNac_Persona;
			this.Domicilio_Persona = domicilio_Persona;		
	}
	public Persona(String DNI_Persona, String nombre_Persona, String apellido_Persona, String telefono_Persona,
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
	public Persona(String DNI_Persona)  {
		
			this.DNI_Persona = DNI_Persona;	
	}
	public Persona(String DNI_Persona, String nombre_Persona, String apellido_Persona)  {
		
		this.DNI_Persona = DNI_Persona;
		this.Nombre_Persona = nombre_Persona;
		this.Apellido_Persona = apellido_Persona;
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



	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return  DNI_Persona;
	}


	
}
