package br.com.danilocerne.springboot.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danilocerne.springboot.example.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{}
