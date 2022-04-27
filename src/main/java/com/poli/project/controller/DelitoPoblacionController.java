package com.poli.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poli.project.model.CantidadDelito;
import com.poli.project.repository.DelitoPoblacionRepository;

@RestController
@RequestMapping("/api/v1/")
public class DelitoPoblacionController {

	@Autowired
	DelitoPoblacionRepository delitoPoblacionRepository;
	
	@GetMapping("/DelitosPoblaciones")
	public List<CantidadDelito> getAllDelitosPoblacion() {
		// The StateRepository is already injected and you can use it
		return delitoPoblacionRepository.findAll();
	}
	
}
