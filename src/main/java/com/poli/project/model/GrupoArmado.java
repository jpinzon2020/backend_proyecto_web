package com.poli.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="Grupos_armados")
public class GrupoArmado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private Date anio_inicio;
	private String ideologia;
	private String descriptcion;
	
	public GrupoArmado() {
		
	}
	
	public GrupoArmado(String nombre, Date anio_inicio, String ideologia, String descriptcion) {
		super();
		this.nombre = nombre;
		this.anio_inicio = anio_inicio;
		this.ideologia = ideologia;
		this.descriptcion = descriptcion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getAnio_inicio() {
		return anio_inicio;
	}
	public void setAnio_inicio(Date anio_inicio) {
		this.anio_inicio = anio_inicio;
	}
	public String getideologia() {
		return ideologia;
	}
	public void setideologia(String ideologia) {
		this.ideologia = ideologia;
	}
	public String getDescriptcion() {
		return descriptcion;
	}
	public void setDescriptcion(String descriptcion) {
		this.descriptcion = descriptcion;
	}
		
}
