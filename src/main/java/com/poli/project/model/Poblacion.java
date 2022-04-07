package com.poli.project.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Poblaciones")
public class Poblacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	private String caracteristicas;
	private boolean esNomada;
	
	/*@ManyToMany (mappedBy = "poblaciones")
	@JsonIgnore
	private Set<Departamento> departamentos;
	*/
	
	@OneToMany(mappedBy="poblacion")
	@JsonIgnore
	Set<NumPersona> numPersonas;
	
	public Poblacion() {
		
	}
	
	public Poblacion(String nombre, String caracteristicas, boolean esNomada) {
		super();
		this.nombre = nombre;
		this.caracteristicas = caracteristicas;
		this.esNomada = esNomada;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public boolean isEsNomada() {
		return esNomada;
	}

	public void setEsNomada(boolean esNomada) {
		this.esNomada = esNomada;
	} 
	
	
	
	
}
