package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.everis.data.models.Persona;
import com.everis.data.repositories.PersonaRepository;

@Service
public class PersonaService {
private final PersonaRepository pr; 
	
	public PersonaService(PersonaRepository personaRepository) {
		this.pr = personaRepository;
	}
	
	public Persona crearPersona(@Valid Persona persona) {
		//System.out.println("crearPersona: "+persona.getNombre());
		return pr.save(persona); 
	}
	
	public List<Persona> findAll() {
		// retorna una lista de personas
		return pr.findAll();
		
	}
	
	public void eliminarPersona(Long id) {
		pr.deleteById(id);;
	}

	public Persona buscarPersona(Long id) {
		// TODO Auto-generated method stub
		Optional<Persona> oPersona = pr.findById(id);
		
		if(oPersona.isPresent()) {
			return oPersona.get();
		}
		return null;
	}

	public void modificarPersona(@Valid Persona persona) {
		pr.save(persona);
		
	}
	

}
