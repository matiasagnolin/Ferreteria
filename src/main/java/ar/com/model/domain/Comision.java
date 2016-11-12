package ar.com.model.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.metamodel.Type;
@Entity
public class Comision implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Justificacion")
	private String Descripcion;
	private int minimo;
	private int maximo;
	@Column(name="porcentaje")
	private double Porcentaje;
	private double valor;
	private String create_date;
	private String close_date;
	private int tipo;
	
	
	public Comision (){}
	public Comision (String descripcion, int minimo,int maximo,double porcentaje,double valor,String create_date,String close_date,int tipo){
		this.close_date=close_date;
		this.create_date=create_date;
		this.Descripcion=descripcion;
		this.maximo=maximo;
		this.minimo=minimo;
		this.Porcentaje=porcentaje;
		this.tipo=tipo;
		this.valor=valor;
	}
	public Comision (String descripcion,int valor,String create_date,String close_date,int tipo){
		this.close_date=close_date;
		this.create_date=create_date;
		this.Descripcion=descripcion;
		this.tipo=tipo;
		this.valor=valor;
	}
	public Comision (String descripcion, int minimo,int maximo,double valor,String create_date,int tipo){
		this.create_date=create_date;
		this.Descripcion=descripcion;
		this.maximo=maximo;
		this.minimo=minimo;
		
		this.tipo=tipo;
		this.valor=valor;
	}
	
	public Comision (String descripcion,double porcentaje,String create_date,int tipo){
		this.create_date=create_date;
		this.Descripcion=descripcion;
		this.Porcentaje=porcentaje;
		this.tipo=tipo;
	}
	public Comision (String descripcion,double porcentaje,String create_date,String close_date,int tipo){
		this.create_date=create_date;
		this.Descripcion=descripcion;
		this.Porcentaje=porcentaje;
		this.tipo=tipo;
	}
	
	
	public double getPorcentaje() {
		return Porcentaje;
	}


	public void setPorcentaje(double porcentaje) {
		Porcentaje = porcentaje;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public int getMinimo() {
		return minimo;
	}


	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}


	public int getMaximo() {
		return maximo;
	}


	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}


	public String getCreate_date() {
		return create_date;
	}


	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}


	public String getClose_date() {
		return close_date;
	}


	public void setClose_date(String close_date) {
		this.close_date = close_date;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	

}
