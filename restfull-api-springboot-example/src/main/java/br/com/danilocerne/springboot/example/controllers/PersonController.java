package br.com.danilocerne.springboot.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danilocerne.springboot.example.data.vo.v1.PersonVO;
import br.com.danilocerne.springboot.example.data.vo.v2.PersonVOV2;
import br.com.danilocerne.springboot.example.services.PersonServices;
import br.com.danilocerne.springboot.example.util.MediaType;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	@GetMapping(value = "/v1",
			    produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	public List<PersonVO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/v1/{id}",
				produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	public PersonVO findById(@PathVariable(value = "id") Long id) {

		return service.findById(id);
	}
	
	@PostMapping(value = "/v1",
		    	 consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML },
				 produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	public PersonVO create(@RequestBody PersonVO person) {
		
		return service.create(person);
	}
	
	@PostMapping(value = "/v2",
				 consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML },
				 produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
		
		return service.createV2(person);
	}
	
	@PutMapping(value = "/v1",
				consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML },
				produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	public PersonVO update(@RequestBody PersonVO person) {
		
		return service.update(person);
	}
	
	@DeleteMapping(value = "/v1/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
