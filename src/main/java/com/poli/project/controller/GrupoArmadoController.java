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

import com.poli.project.model.GrupoArmado;
import com.poli.project.repository.GrupoArmadoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class GrupoArmadoController {

	@Autowired
	private GrupoArmadoRepository grupoArmadoRepository;
	
	@GetMapping("/GrupoArmados")
	public List<GrupoArmado> getAllGrupoArmados() {
		// The StateRepository is already injected and you can use it
		return grupoArmadoRepository.findAll();
	}
	
	@GetMapping("/GrupoArmado/{id}")
	public ResponseEntity<GrupoArmado> getGrupoArmadoById(@PathVariable Long id) {
		
		try {
			GrupoArmado GrupoArmado = grupoArmadoRepository.findById(id).get();
			return ResponseEntity.status(HttpStatus.OK).body(GrupoArmado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
	}
	
	@PostMapping("GrupoArmado")
	public ResponseEntity<GrupoArmado> createGrupoArmado(@RequestBody GrupoArmado GrupoArmado) {
		
		try {
			grupoArmadoRepository.save(GrupoArmado);
			return ResponseEntity.status(HttpStatus.OK).body(GrupoArmado);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		
	}
	
	
	@PostMapping("/GrupoArmadoL")
	public String createPolacionList(@RequestBody List<GrupoArmado> GrupoArmado) {

		grupoArmadoRepository.saveAll(GrupoArmado);
		return "done";
	}
	
	@PutMapping("/updateGrupoArmado/{id}")
	public ResponseEntity<GrupoArmado> updateGrupoArmado(@PathVariable Long id, @RequestBody GrupoArmado GrupoArmadoNew) {
		
		try {
			
			GrupoArmado currentGrupoArmado = grupoArmadoRepository.findById(id).get();
			currentGrupoArmado.setNombre(GrupoArmadoNew.getNombre());
			currentGrupoArmado.setAnio_inicio(GrupoArmadoNew.getAnio_inicio());
			currentGrupoArmado.setDescriptcion(GrupoArmadoNew.getDescriptcion());
			currentGrupoArmado.setideologia(GrupoArmadoNew.getideologia());
			
			grupoArmadoRepository.save(currentGrupoArmado);
			return ResponseEntity.status(HttpStatus.OK).body(currentGrupoArmado);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
	}
	
	@DeleteMapping("/deleteGrupoArmado/{id}")
	public ResponseEntity<GrupoArmado> deleteGrupoArmado(@RequestParam("id") Long id) {
		
		try {
			
			GrupoArmado GrupoArmadoDB = grupoArmadoRepository.findById(id).get();
			grupoArmadoRepository.delete(GrupoArmadoDB);
			return ResponseEntity.status(HttpStatus.OK).body(GrupoArmadoDB);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
	}
}
