package ar.com.model.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;



@Entity
@PrimaryKeyJoinColumn(name="DNI_Persona")
public class Vendedor extends Persona implements Serializable{
	
	private int CantVentas=0;
	private double Comision=0;

	public Vendedor(){super();}
	public Vendedor(String DNI_Persona, String nombre_Persona, String apellido_Persona, String telefono_Persona,
			String email_Persona, String fechaDeNac_Persona, String domicilio_Persona){
		super( DNI_Persona,  nombre_Persona,  apellido_Persona,  telefono_Persona,
				 email_Persona,  fechaDeNac_Persona,  domicilio_Persona);
		}
	public int getCantVentas() {
		return CantVentas;
	}
	public void setCantVentas(int cantVentas) {
		CantVentas = cantVentas;
	}

public double getComision() {
		return Comision;
	}
	public void setComision(double comision) {
		Comision = comision;
	}
	
}
