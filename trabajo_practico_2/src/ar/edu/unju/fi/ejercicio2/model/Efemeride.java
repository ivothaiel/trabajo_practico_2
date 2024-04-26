package ar.edu.unju.fi.ejercicio2.model;
import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;


public class Efemeride {
	public String codigo;
	public Mes mes;
	public LocalDate dia;
	public String detalle;
	
	
	
	public Efemeride() {
		super();
		
	}



	public Efemeride(String codigo, Mes mes, LocalDate dia, String detalle) {
		super();
		this.codigo = codigo;
		this.mes = mes;
		this.dia = dia;
		this.detalle = detalle;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public Mes getMes() {
		return mes;
	}



	public void setMes(Mes mes) {
		this.mes = mes;
	}



	public LocalDate getDia() {
		return dia;
	}



	public void setDia(LocalDate nuevoDia) {
		this.dia = nuevoDia;
	}



	public String getDetalle() {
		return detalle;
	}



	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	
	
	

}
