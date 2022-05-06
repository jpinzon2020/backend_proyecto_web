package com.poli.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.project.model.NumPersona;
import com.poli.project.model.NumPersonaKey;

public interface DepartamentoPoblacionRepository extends JpaRepository<NumPersona, NumPersonaKey>{

}
