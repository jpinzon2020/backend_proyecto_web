package com.poli.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.project.model.CantidadDelito;
import com.poli.project.model.CantidadPersonaKey;

public interface DelitoPoblacionRepository extends JpaRepository<CantidadDelito, CantidadPersonaKey> {

}
