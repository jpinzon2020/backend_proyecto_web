package com.poli.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NumPersonaKey implements Serializable {

	@Column(name="departamento_id")
	String departamentoId;
	
	@Column(name="poblacion_id")
	Long poblacionId;

	public NumPersonaKey() {
		
	}
	
	public NumPersonaKey(String departamentoId, Long poblacionId) {
		super();
		this.departamentoId = departamentoId;
		this.poblacionId = poblacionId;
	}

	public String getDepartamentoId() {
		return departamentoId;
	}

	public void setDepartamentoId(String departamentoId) {
		this.departamentoId = departamentoId;
	}

	public Long getPoblacionId() {
		return poblacionId;
	}

	public void setPoblacionId(Long poblacionId) {
		this.poblacionId = poblacionId;
	}
	
	
}
