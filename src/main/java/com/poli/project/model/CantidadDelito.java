package com.poli.project.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="delito_x_poblacion")
public class CantidadDelito {

	@EmbeddedId
	CantidadPersonaKey id;
	
	@ManyToOne
	@MapsId("grupoArmadoId")
	@JoinColumn(name="grupo_armado_id")
	GrupoArmado grupoArmado;
	
	@ManyToOne
	@MapsId("delitoId")
	@JoinColumn(name="delito_id")
	Delito delito;
	
	@ManyToOne
	@MapsId("poblacionId")
	@JoinColumn(name="poblacion_id")
	Poblacion poblacion;
	
	int cantidadDelitos;
	
	public CantidadDelito() {
		
	}
		
	public CantidadDelito(Poblacion poblacion, Delito delito, GrupoArmado grupoArmado, int cantidadDelitos) {
		super();
		this.grupoArmado = grupoArmado;
		this.delito = delito;
		this.poblacion = poblacion;
		this.cantidadDelitos = cantidadDelitos;
	}
	
	

	public Poblacion getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(Poblacion poblacion) {
		this.poblacion = poblacion;
	}

	public int getCantidadDelitos() {
		return cantidadDelitos;
	}

	public void setCantidadDelitos(int cantidadDelitos) {
		this.cantidadDelitos = cantidadDelitos;
	}

	public GrupoArmado getGrupoArmado() {
		return grupoArmado;
	}

	public void setGrupoArmado(GrupoArmado grupoArmado) {
		this.grupoArmado = grupoArmado;
	}

	public Delito getDelito() {
		return delito;
	}

	public void setDelito(Delito delito) {
		this.delito = delito;
	}
	
}
