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
	@MapsId("departamentoId")
	@JoinColumn(name="departamento_id")
	Departamento departamento;
	
	@ManyToOne
	@MapsId("poblacionId")
	@JoinColumn(name="poblacion_id")
	Poblacion poblacion;
	
	int numPersonas;

	public NumPersona() {
		
	}
	
	
	public NumPersona(int numPersonas) {
		super();
		this.numPersonas = numPersonas;
	}


	public int getNumPersonas() {
		return numPersonas;
	}


	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}


}
