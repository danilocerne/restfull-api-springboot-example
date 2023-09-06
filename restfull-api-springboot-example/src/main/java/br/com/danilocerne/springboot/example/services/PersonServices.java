package br.com.danilocerne.springboot.example.services;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.danilocerne.springboot.example.models.Person;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public Person findById(String id) {
		
		logger.info("Finding one person!");
		
		//Simple Mock
		Person person = new Person();
		person.setId(Long.parseLong(id));
		person.setFirstName("Danilo");
		person.setLastName("Cerne");
		person.setAddress("Ribeirão Preto - São Paulo - Brasil");
		person.setGender("Masculino");
		return person;
	}
}