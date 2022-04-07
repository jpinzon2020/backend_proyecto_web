package com.poli.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<Poblacion> getStateById(@PathVariable Long id) {
		
		try {
			Poblacion poblacion = poblacionRepository.findById(id).get();
			return ResponseEntity.status(HttpStatus.OK).body(poblacion);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
	}
	
	@PostMapping("poblacion")
	public ResponseEntity<Poblacion> createPoblacion(@RequestBody Poblacion poblacion) {
		
		try {
			poblacionRepository.save(poblacion);
			return ResponseEntity.status(HttpStatus.OK).body(poblacion);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		
	}
	
	
	@PostMapping("/statesL")
	public String createStateList(@RequestBody List<Poblacion> poblaciones) {

		poblacionRepository.saveAll(poblaciones);
		return "done";
	}
	
	
} 
