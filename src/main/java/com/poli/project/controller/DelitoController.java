package com.poli.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poli.project.model.Delito;
import com.poli.project.repository.DelitoRepository;


@RestController
@RequestMapping("/api/v1/")
public class DelitoController {


	@Autowired
	private DelitoRepository delitoRepository;
	
	@GetMapping("/Delitos")
	public List<Delito> getAllDelitos() {
		// The StateRepository is already injected and you can use it
		return delitoRepository.findAll();
	}
	
	@GetMapping("/delito/{id}")
	public ResponseEntity<Delito> getDelitoById(@PathVariable Long id) {
		
		try {
			Delito delito = delitoRepository.findById(id).get();
			return ResponseEntity.status(HttpStatus.OK).body(delito);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
	}
	
	@PostMapping("delito")
	public ResponseEntity<Delito> createDelito(@RequestBody Delito delito) {
		
		try {
			delitoRepository.save(delito);
			return ResponseEntity.status(HttpStatus.OK).body(delito);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		
	}
	
	
	@PostMapping("/delitoL")
	public String createPolacionList(@RequestBody List<Delito> delito) {

		delitoRepository.saveAll(delito);
		return "done";
	}
	
	@PutMapping("/updateDelito/{id}")
	public ResponseEntity<Delito> updateDelito(@PathVariable Long id, @RequestBody Delito delitoNew) {
		
		try {
			Delito currentDelito = delitoRepository.findById(id).get();
			currentDelito.setNombre(delitoNew.getNombre());
			
			delitoRepository.save(currentDelito);
			return ResponseEntity.status(HttpStatus.OK).body(currentDelito);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
	}
	
	@DeleteMapping("/delito/{id}")
	public ResponseEntity<Delito> deleteDelito(@RequestParam("id") Long id) {
		try {
			
			Delito DelitoDB = delitoRepository.findById(id).get();
			delitoRepository.delete(DelitoDB);
			return ResponseEntity.status(HttpStatus.OK).body(DelitoDB);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
	}
	
}
