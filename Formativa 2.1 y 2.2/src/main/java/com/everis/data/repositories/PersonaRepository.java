package com.everis.data.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona,Long>{
	List<Persona> findAll();
}

