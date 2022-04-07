package com.poli.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CantidadPersonaKey implements Serializable {

	@Column(name="grupo_armado_id")
	Long grupoArmadoId;
	
	@Column(name="delito_id")
	Long delitoId;
	
	@Column(name="poblacion_id")
	Long poblacionId;
	
	public CantidadPersonaKey() {
		
	}

	public CantidadPersonaKey(Long grupoArmadooId, Long delitoId, Long poblacionId) {
		super();
		this.grupoArmadoId = grupoArmadooId;
		this.delitoId = delitoId;
		this.poblacionId = poblacionId;
	}

	public Long getGrupoArmadooId() {
		return grupoArmadoId;
	}

	public void setGrupoArmadooId(Long grupoArmadooId) {
		this.grupoArmadoId = grupoArmadooId;
	}

	public Long getDelitoId() {
		return delitoId;
	}

	public void setDelitoId(Long delitoId) {
		this.delitoId = delitoId;
	}

	public Long getPoblacionId() {
		return poblacionId;
	}

	public void setPoblacionId(Long poblacionId) {
		this.poblacionId = poblacionId;
	}
	
}
