package br.com.danilocerne.springboot.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.danilocerne.springboot.example.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}
