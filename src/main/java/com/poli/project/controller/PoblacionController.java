package com.poli.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poli.project.model.Poblacion;
import com.poli.project.repository.PoblacionRepository;

import io.swagger.annotations.Api;

@Api(tags = {"Class: PoblacionController"})
@RestController
@RequestMapping("/api/v1/")
public class PoblacionController {

	
	@Autowired
	private PoblacionRepository poblacionRepository;
	
	@GetMapping("/poblaciones")
	public List<Poblacion> getAllPoblacion() {
		// The StateRepository is already injected and you can use it
		return poblacionRepository.findAll();
	}
	
	@GetMapping("/poblaciones/{id}")
	public ResponseEntity<Poblacion> getPoblacionById(@PathVariable Long id) {
		
		try {
			Poblacion poblacion = poblacionRepository.findById(id).get();
			return ResponseEntity.status(HttpStatus.OK).body(poblacion);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_ADMIN')")
	@PostMapping("createPoblacion")
	public ResponseEntity<Poblacion> createPoblacion(@RequestBody Poblacion poblacion) {
		
		try {
			poblacionRepository.save(poblacion);
			return ResponseEntity.status(HttpStatus.OK).body(poblacion);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		
	}
	
	
	@PostMapping("/poblacionL")
	public String createPolacionList(@RequestBody List<Poblacion> poblaciones) {

		poblacionRepository.saveAll(poblaciones);
		return "done";
	}
	
	@PutMapping("/updatePoblacion")
	public ResponseEntity<Poblacion> updatePoblacion(@PathVariable Long id, @RequestBody Poblacion poblacionNew) {
		
		try {
			Poblacion currentPoblacion = poblacionRepository.findById(id).get();
			currentPoblacion.setCaracteristicas(poblacionNew.getCaracteristicas());
			currentPoblacion.setEsNomada(poblacionNew.isEsNomada());
			currentPoblacion.setNombre(poblacionNew.getNombre());
			
			poblacionRepository.save(currentPoblacion);
			return ResponseEntity.status(HttpStatus.OK).body(currentPoblacion);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
	}
	
	@DeleteMapping("/deletePoblacion")
	public ResponseEntity<Poblacion> deletePoblacion(@RequestParam("id") Long id) {
		try {
			
			Poblacion poblacionDB = poblacionRepository.findById(id).get();
			poblacionRepository.delete(poblacionDB);
			return ResponseEntity.status(HttpStatus.OK).body(poblacionDB);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
	}
	
} 
