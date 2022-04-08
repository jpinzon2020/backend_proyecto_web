package com.poli.project.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Departamentos")
public class Departamento {
	
	@Id
	private String codigoDepartamento;
	
	private String nombreDepartamento;
	
	/*@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Departamento_Poblacion", 
				joinColumns = { @JoinColumn(name = "departamento_id")  }, 
				inverseJoinColumns = {@JoinColumn (name = "poblacion_id") })
				
	private Set<Poblacion> poblaciones;
	*/
	
	@OneToMany(mappedBy="departamento")
	@JsonIgnore
	Set<NumPersona> numPersonas;
	
	public Departamento() {
		
	}
	
	public Departamento(String codigoDepartamento, String nombreDepartamento) {
		super();
		this.codigoDepartamento = codigoDepartamento;
		this.nombreDepartamento = nombreDepartamento;
	}

	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	
}
