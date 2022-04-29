package com.poli.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poli.project.model.CantidadDelito;
import com.poli.project.model.CantidadPersonaKey;
import com.poli.project.model.Poblacion;
import com.poli.project.model.Delito;
import com.poli.project.model.GrupoArmado;

import com.poli.project.repository.DelitoPoblacionRepository;
import com.poli.project.repository.DelitoRepository;
import com.poli.project.repository.GrupoArmadoRepository;
import com.poli.project.repository.PoblacionRepository;

@RestController
@RequestMapping("/api/v1/")
public class DelitoPoblacionController {

	@Autowired
	DelitoPoblacionRepository delitoPoblacionRepository;
	@Autowired
	private PoblacionRepository poblacionRepository;
	
	@Autowired
	private DelitoRepository delitoRepository;
	
	@Autowired
	private GrupoArmadoRepository grupoArmadoRepository;
	
	@GetMapping("/DelitosPoblaciones")
	public List<CantidadDelito> getAllDelitosPoblacion() {
		// The StateRepository is already injected and you can use it
		return delitoPoblacionRepository.findAll();
	}
	
	@GetMapping("/DelitosPoblaciones/{id}")
	public ResponseEntity<CantidadDelito> getDelitosPoblacionById(@PathVariable CantidadPersonaKey id) {
		
		try {
			CantidadDelito cantidadDelito = delitoPoblacionRepository.findById(id).get(); 
			return ResponseEntity.status(HttpStatus.OK).body(cantidadDelito);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
	
	/*
	@PutMapping("/DelitosPoblaciones/{idPoblacion}/{idDelito}/{idGrupoArmado}")
	public  ResponseEntity<CantidadDelito> associate(@PathVariable Long idPoblacion, @PathVariable Long idDelito, @PathVariable Long idGrupoArmado) {
		
		Poblacion poblacion = poblacionRepository.findById(idPoblacion).get();
		Delito delito = delitoRepository.findById(idDelito).get();
		GrupoArmado grupoArmado = grupoArmadoRepository.findById(idGrupoArmado).get();
		
	}*/
	
}
