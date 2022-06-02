package com.poli.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poli.project.model.Departamento;
import com.poli.project.repository.DepartamentoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class DepartamentoController {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@GetMapping("/Departamentos")
	public List<Departamento> getAllDepartamentos() {
		// The StateRepository is already injected and you can use it
		return departamentoRepository.findAll();
	}
	
	@GetMapping("/Departamento/{id}")
	public ResponseEntity<Departamento> getDepartamentoById(@PathVariable String id) {
		
		try {
			Departamento departamento = departamentoRepository.findById(id).get();
			return ResponseEntity.status(HttpStatus.OK).body(departamento);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
	}
	
	@PostMapping("Departamento")
	public ResponseEntity<Departamento> createDepartamento(@RequestBody Departamento departamento) {
		
		try {
			departamentoRepository.save(departamento);
			return ResponseEntity.status(HttpStatus.OK).body(departamento);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		
	}
	
	
	@PostMapping("/DepartamentoL")
	public String createDepartamentoList(@RequestBody List<Departamento> departamento) {

		departamentoRepository.saveAll(departamento);
		return "done";
	}
	
	@PutMapping("/updateDepartamento/{id}")
	public ResponseEntity<Departamento> updateDepartamento(@PathVariable String id, @RequestBody Departamento DepartamentoNew) {
		
		try {
			Departamento currentDepartamento = departamentoRepository.findById(id).get();
			currentDepartamento.setNombreDepartamento(DepartamentoNew.getNombreDepartamento());
			
			departamentoRepository.save(currentDepartamento);
			return ResponseEntity.status(HttpStatus.OK).body(currentDepartamento);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
	}
	
	@DeleteMapping("/deleteDepartamento/{id}")
	public ResponseEntity<Departamento> deleteDepartamento(@RequestParam("id") String id) {
		try {
			
			Departamento DepartamentoDB = departamentoRepository.findById(id).get();
			departamentoRepository.delete(DepartamentoDB);
			return ResponseEntity.status(HttpStatus.OK).body(DepartamentoDB);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
	}
}
