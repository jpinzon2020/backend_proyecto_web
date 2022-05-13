package com.poli.project.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="departamento_poblacion")
public class NumPersona {

	@EmbeddedId
	NumPersonaKey id;
	
	@ManyToOne
	@MapsId("departamento_id")
	@JoinColumn(name="departamento_id")
	Departamento departamento;
	
	@ManyToOne
	@MapsId("poblacion_id")
	@JoinColumn(name="poblacion_id")
	Poblacion poblacion;
	
	int numPersonas;

	public NumPersona() {
		
	}
	
	
	public NumPersona(NumPersonaKey key, Departamento departamento, Poblacion poblacion, int numPersonas) {
		
		super();
		this.id = key;	
		this.numPersonas = numPersonas;
		this.departamento = departamento;
		this.poblacion = poblacion; 
	}

	
	/*public NumPersonaKey getId() {
		return id;
	}


	public void setId(NumPersonaKey id) {
		this.id = id;
	}*/


	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	public Poblacion getPoblacion() {
		return poblacion;
	}


	public void setPoblacion(Poblacion poblacion) {
		this.poblacion = poblacion;
	}


	public int getNumPersonas() {
		return numPersonas;
	}


	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}


}
