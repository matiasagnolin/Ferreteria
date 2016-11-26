package ar.com.model.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tipos implements Serializable{
@Id
private int tipo;
private String descripcion;


public Tipos() {

}
public Tipos(int tipo, String descripcion) {
	super();
	this.tipo = tipo;
	this.descripcion = descripcion;
}
public int getTipo() {
	return tipo;
}
public void setTipo(int tipo) {
	this.tipo = tipo;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}


}
