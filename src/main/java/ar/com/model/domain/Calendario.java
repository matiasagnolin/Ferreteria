package ar.com.model.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

@Entity
public class Calendario  implements Serializable{
	@javax.persistence.Id
	private int id;
	private String nombre_mes;
	private String primer_dia;
	private String ultimo_dia;
	DateFormat dateFormat; 
	public Calendario(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_mes() {
		return nombre_mes;
	}

	public void setNombre_mes(String nombre_mes) {
		this.nombre_mes = nombre_mes;
	}

	public String getPrimer_dia() {
		return primer_dia;
	}

	public void setPrimer_dia(String primer_dia) {
		this.primer_dia = primer_dia;
	}

	public String getUltimo_dia() {
		return ultimo_dia;
	}

	public void setUltimo_dia(String ultimo_dia) {
		this.ultimo_dia = ultimo_dia;
	}
	
	
	public int getDiffFecha(String Fecha){
        String fechaInicio = Fecha;
        
        Date date = new Date();
        String fechaActual = date.getDate()+"/"+date.getMonth()+"/"+date.getYear();
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        fechaActual = df.format(date);
        String[] aFechaIng = fechaInicio.split("/");
        Integer diaInicio = Integer.parseInt(aFechaIng[0]);
        Integer mesInicio = Integer.parseInt(aFechaIng[1]);
        Integer anioInicio = Integer.parseInt(aFechaIng[2]);

        String[] aFecha = fechaActual.split("/");
        Integer diaActual = Integer.parseInt(aFecha[0]);
        Integer mesActual = Integer.parseInt(aFecha[1]);
        Integer anioActual = Integer.parseInt(aFecha[2]);

        System.out.println(diaActual);
        System.out.println(mesActual);
        System.out.println(anioActual);
        int b = 0;
        int dias = 0;
        int mes = 0;
        int anios = 0;
        int meses = 0;
        mes = mesInicio - 1;
        if (mes == 2) {
            if ((anioActual % 4 == 0) && ((anioActual % 100 != 0) || (anioActual % 400 == 0))) {
                b = 29;
            } else {
                b = 28;
            }
        } else if (mes <= 7) {
            if (mes == 0) {
                b = 31;
            } else if (mes % 2 == 0) {
                b = 30;
            } else {
                b = 31;
            }
        } else if (mes > 7) {
            if (mes % 2 == 0) {
                b = 31;
            } else {
                b = 30;
            }
        }
        if ((anioInicio > anioActual) || (anioInicio == anioActual && mesInicio > mesActual)
                || (anioInicio == anioActual && mesInicio == mesActual && diaInicio > diaActual)) {
            System.out.println("La fecha de inicio debe ser anterior a la fecha Actual");
        } else {
            if (mesInicio <= mesActual) {
                anios = anioActual - anioInicio;
                if (diaInicio <= diaActual) {
                    meses = mesActual - mesInicio;
                    dias = b - (diaInicio - diaActual);
                } else {
                    if (mesActual == mesInicio) {
                        anios = anios - 1;
                    }
                    meses = (mesActual - mesInicio - 1 + 12) % 12;
                    dias = b - (diaInicio - diaActual);
                }
            } else {
                anios = anioActual - anioInicio - 1;
                System.out.println(anios);
                if (diaInicio > diaActual) {
                    meses = mesActual - mesInicio - 1 + 12;
                    dias = b - (diaInicio - diaActual);
                } else {
                    meses = mesActual - mesInicio + 12;
                    dias = diaActual - diaInicio;
                }
            }
        }

        System.out.println("Años: " + anios);
        System.out.println("Meses: " + meses);
        System.out.println("Días: " + dias);
        return dias;
	    }
	
	public String getDate()
	{
		dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		   return dateFormat.format(cal.getTime());
	}
	
	
	
}
