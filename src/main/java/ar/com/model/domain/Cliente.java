package ar.com.model.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "DNI_Persona")
public class Cliente extends Persona implements Serializable {
	public Cliente() {
		super();
	}

	public Cliente(String DNI_Persona, String nombre_Persona,
			String apellido_Persona, String telefono_Persona,
			String email_Persona, String fechaDeNac_Persona,
			String domicilio_Persona) {
		super(DNI_Persona, nombre_Persona, apellido_Persona, telefono_Persona,
				email_Persona, fechaDeNac_Persona, domicilio_Persona);
	}

}
