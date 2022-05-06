package com.poli.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poli.project.model.Departamento;
import com.poli.project.model.NumPersona;
import com.poli.project.model.Poblacion;
import com.poli.project.repository.DepartamentoPoblacionRepository;
import com.poli.project.repository.DepartamentoRepository;
import com.poli.project.repository.PoblacionRepository;

import java.util.List;


@RestController
@RequestMapping("/api/v1/")
public class DepartamentoPoblacionController {

	@Autowired
	private DepartamentoPoblacionRepository departamentoPoblacionRepository;
	
	@Autowired
	private PoblacionRepository poblacionRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@GetMapping("/DepartamentoPoblacion")
	public List<NumPersona> getAllDepartamentoPoblacion(){
		
		return departamentoPoblacionRepository.findAll();
	}
	
	@PutMapping("/DepartamentoPoblacion/{idDepartamento}/{idPoblacion}/{numPersonas}")
	public ResponseEntity<NumPersona> associate(@PathVariable String idDepartamento, @PathVariable Long idPoblacion, @PathVariable int numPersonas) {
		
		//try {
			Departamento departamento = departamentoRepository.findById(idDepartamento).get();
			Poblacion poblacion = poblacionRepository.findById(idPoblacion).get();
			
			NumPersona numPersona = new NumPersona(departamento, poblacion, numPersonas);
			departamentoPoblacionRepository.save(numPersona);
			
			return ResponseEntity.status(HttpStatus.OK).body(numPersona);
			
		//} catch (Exception e) {
			//return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		//}
		
	}
	
	
	
}
