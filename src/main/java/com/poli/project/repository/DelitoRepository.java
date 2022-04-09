package com.poli.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.project.model.Delito;

public interface DelitoRepository extends JpaRepository<Delito, Long> {

}
