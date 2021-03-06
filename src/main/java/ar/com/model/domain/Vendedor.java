package ar.com.model.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;



@Entity
@PrimaryKeyJoinColumn(name="DNI_Persona")
public class Vendedor extends Persona implements Serializable,Comparable{
	@Transient
	private int CantVentas=0;
	@Transient
	private double Comision=0;
	@Transient
	private int CantPremio=0;

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
		Comision = this.Comision+comision;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		if (this.getDNI_Persona() != other.getDNI_Persona())
			return false;
		return true;
	}
	@Override
	public int compareTo(Object o) {
		  int compareCant=((Vendedor)o).getCantVentas();
	        return compareCant-this.CantVentas;
	}

	public int getCantPremio() {
		return CantPremio;
	}
	public void setCantPremio(int cantPremio) {
		CantPremio = cantPremio;
	}
	
	
	
}
