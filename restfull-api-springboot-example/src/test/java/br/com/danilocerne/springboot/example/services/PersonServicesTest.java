package br.com.danilocerne.springboot.example.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.danilocerne.springboot.example.converter.mocks.MockPerson;
import br.com.danilocerne.springboot.example.data.vo.v1.PersonVO;
import br.com.danilocerne.springboot.example.data.vo.v2.PersonVOV2;
import br.com.danilocerne.springboot.example.mapper.custom.MockPersonMapper;
import br.com.danilocerne.springboot.example.mapper.custom.PersonMapper;
import br.com.danilocerne.springboot.example.models.Person;
import br.com.danilocerne.springboot.example.repositories.PersonRepository;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServicesTest {
	
	MockPerson mockPerson;
	
	MockPersonMapper mockPersonMapper;
	
	@InjectMocks
	private PersonServices service;
	
	@Mock
	PersonRepository repository;
	
	@Mock
	PersonMapper mapper;
	
	@BeforeEach
	void setUpMocks() throws Exception {
		mockPerson = new MockPerson();
		mockPersonMapper = new MockPersonMapper();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAll() {
		List<Person> list = mockPerson.mockEntityList(); 
		
		when(repository.findAll()).thenReturn(list);
		
		var people = service.findAll();
		
		assertNotNull(people);
		assertEquals(14, people.size());
		
		var personOne = people.get(1);
		
		assertNotNull(personOne);
		assertNotNull(personOne.getKey());
		assertNotNull(personOne.getLinks());
		
//		System.out.println(personOne.toString());
		
		assertTrue(personOne.toString().contains("links: [</person/1>;rel=\"self\"]"));
		assertEquals("Address Test1", personOne.getAddress());
		assertEquals("First Name Test1", personOne.getFirstName());
		assertEquals("Last Name Test1", personOne.getLastName());
		assertEquals("Female", personOne.getGender());
		
		var personFour = people.get(4);
		
		assertNotNull(personFour);
		assertNotNull(personFour.getKey());
		assertNotNull(personFour.getLinks());
		
//		System.out.println(personFour.toString());
		
		assertTrue(personFour.toString().contains("links: [</person/4>;rel=\"self\"]"));
		assertEquals("Address Test4", personFour.getAddress());
		assertEquals("First Name Test4", personFour.getFirstName());
		assertEquals("Last Name Test4", personFour.getLastName());
		assertEquals("Male", personFour.getGender());
		
		var personSeven = people.get(7);
		
		assertNotNull(personSeven);
		assertNotNull(personSeven.getKey());
		assertNotNull(personSeven.getLinks());
		
//		System.out.println(personSeven.toString());
		
		assertTrue(personSeven.toString().contains("links: [</person/7>;rel=\"self\"]"));
		assertEquals("Address Test7", personSeven.getAddress());
		assertEquals("First Name Test7", personSeven.getFirstName());
		assertEquals("Last Name Test7", personSeven.getLastName());
		assertEquals("Female", personSeven.getGender());
	}

	@Test
	void testFindById() {
		Person entity = mockPerson.mockEntity();
		entity.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		
		var result = service.findById(1L);
		
//		System.out.println(result.toString());
//		System.out.println(result.getAddress().toString());
//		System.out.println(result.getFirstName().toString());
//		System.out.println(result.getLastName().toString());
//		System.out.println(result.getGender().toString());
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		
		assertTrue(result.toString().contains("links: [</person/1>;rel=\"self\"]"));
		
		assertEquals("Address Test1", result.getAddress());
		assertEquals("First Name Test1", result.getFirstName());
		assertEquals("Last Name Test1", result.getLastName());
		assertEquals("Female", result.getGender());
	}

	@Test
	void testCreate() {
		Person entity = mockPerson.mockEntity();
		
		Person persisted = entity;
		persisted.setId(1L);
		
		PersonVO vo = mockPerson.mockVO(1);
		vo.setKey(1L);
		
		when(repository.save(entity)).thenReturn(persisted);
		
		var result = service.create(vo);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		
		assertTrue(result.toString().contains("links: [</person/1>;rel=\"self\"]"));
		assertEquals("Address Test1", result.getAddress());
		assertEquals("First Name Test1", result.getFirstName());
		assertEquals("Last Name Test1", result.getLastName());
		assertEquals("Female", result.getGender());
	}

	@Test
	void testCreateV2() {
		
		Person entity = mockPerson.mockEntity();
		PersonVOV2 voV2 = mockPerson.mockVOV2(1);
		when(mapper.convertEntityToVO(entity)).thenReturn(voV2);
		when(mapper.convertVOToEntity(voV2)).thenReturn(entity);
		
		Person persistedEntity = entity;
		persistedEntity.setId(1L);
		when(repository.save(entity)).thenReturn(persistedEntity);
		
		var result = service.createV2(voV2);
		
		assertNotNull(result);
		assertNotNull(result.getId());
		
		assertEquals("Address Test1", result.getAddress());
		assertEquals("First Name Test1", result.getFirstName());
		assertEquals("Last Name Test1", result.getLastName());
		assertEquals("Female", result.getGender());
	}

	@Test
	void testUpdate() {
		Person entity = mockPerson.mockEntity();
		entity.setId(1L);
		
		Person persisted = entity;
		persisted.setId(1L);
		
		PersonVO vo = mockPerson.mockVO(1);
		vo.setKey(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		when(repository.save(entity)).thenReturn(persisted);
		
		var result = service.update(vo);
		
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		
		assertTrue(result.toString().contains("links: [</person/1>;rel=\"self\"]"));
		assertEquals("Address Test1", result.getAddress());
		assertEquals("First Name Test1", result.getFirstName());
		assertEquals("Last Name Test1", result.getLastName());
		assertEquals("Female", result.getGender());
	}

	@Test
	void testDelete() {
		Person entity = mockPerson.mockEntity();
		entity.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		
		service.delete(1L);
	}

}
