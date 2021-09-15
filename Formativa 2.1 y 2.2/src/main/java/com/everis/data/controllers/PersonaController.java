package com.everis.data.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Persona;
import com.everis.data.services.PersonaService;

@Controller
@RequestMapping("/persona")
	public class PersonaController {
		//dependencia servicio
		private final PersonaService ps; 
		
		public PersonaController(PersonaService personaService) {
			this.ps = personaService;
		}
		
		@RequestMapping("")
		public String index(@ModelAttribute("persona") Persona persona, Model model) {
			System.out.println("index");
			List<Persona> lista_personas =  ps.findAll();
			model.addAttribute("lista_personas", lista_personas);
			//System.out.println("personas: "+lista_personas.get(0).getNombre());
			System.out.println("listas");
			return "persona.jsp";
		}
		
		@RequestMapping(value="/crear", method=RequestMethod.POST)
		public String crear(@Valid @ModelAttribute("persona") Persona persona, Model model) {
			System.out.println("crear"+persona);
			if(validacionEmptyI(persona.getRut())) {
				//VALIDACIONES NULL
				//persona.addAttribute("error", "Error, datos vacios");
				System.out.println("Rut vacio");
				model.addAttribute("error", "Rut vacio");
				return "error.jsp";
			} else if(validacionEmptyS(persona.getDv())) {//VALIDACIONES
				//persona.addAttribute("error", "Error, datos vacios");
				System.out.println("DV vacio");
				model.addAttribute("error", "Digito verficador vacio");
				return "error.jsp";
			} else if(validacionEmptyS(persona.getNombre())) {//VALIDACIONES
				//persona.addAttribute("error", "Error, datos vacios");
				System.out.println("Nombre vacio");
				model.addAttribute("error", "Nombre vacio");
				return "error.jsp";
			} else if(validacionEmptyS(persona.getApellido())) {//VALIDACIONES
				//persona.addAttribute("error", "Error, datos vacios");
				System.out.println("Apellido vacio");
				model.addAttribute("error", "Apellido vacio");
				return "error.jsp";
			} else  if(validacionEmptyS(persona.getEmail())) {//VALIDACIONES
				//persona.addAttribute("error", "Error, datos vacios");
				System.out.println("error Email vacio");
				model.addAttribute("error", "Email vacio");
				return "error.jsp";
			} 
			//VALIDACIONES LONGITUD
			else if(validacionRut(persona.getRut(), persona.getDv())) {
				//persona.addAttribute("error", "Error, datos vacios");
				System.out.println("error Rut largo o DV");
				model.addAttribute("error", "Rut o digito verificadorde largo incorrecto");
				return "error.jsp";
			} else if(validaLargoNomApellido(persona.getNombre())) {
				System.out.println("error Persona largo");
				model.addAttribute("error", "Nombre persona largo incorrecto");
				return "error.jsp";
			} else if(validaLargoNomApellido(persona.getApellido())){
				System.out.println("error Apellido largo");
				model.addAttribute("error", "Apellido persona largo incorrecto");
				return "error.jsp";
			} else if(validacionEmail(persona.getEmail())){
				System.out.println("error Correo corto");
				model.addAttribute("error", "Correo de la persona largo incorrecto");
				return "error.jsp";
			}
			
			ps.crearPersona(persona);
			return "redirect:/persona";
		}
		
	
		private boolean validacionRut(Integer rut, String dv)		{
			//rut es numerico y flag es 0 si el digito verificador entre 0 y 9 o K.
			if ((rut.toString().length()==8 || rut.toString().length()==7) && dv.toString().length()==1) 
			{
				return false;
			}
			return true;
		}
		
		
		private boolean validacionEmptyS(String validado){
			//si es vacio, devuelve true para que retorne el error
			if (validado.isEmpty()){
				return true;
			}
			return false;				
		}
		
		private boolean validacionEmptyI(Integer validado){
			//si es vacio, devuelve true para que retorne el error
			if (validado == null){
				return true;
			}
			return false;				
		}
		private boolean validaLargoNomApellido(String nombre){
			//si no cumple, devuelve falso para que retorne el error
			if(nombre.length()<=0 || nombre.length()>20){
				System.out.println("largo nombre: "+nombre);
				return true;
			}
			else{
				return false;
			}
		}
		
		private boolean validacionEmail(String email) {
			if (email.length()<10){
				System.out.println("Largo correo corto: "+email.length());
			return true;
			}
			return false;
			}
		

		//METODO ACTUALIZAR
		@RequestMapping(value="/actualizar/{id}", method=RequestMethod.GET)
		public String actualizar(@PathVariable("id") Long id, Model model){
			/* if()
			
			*/
			System.out.println("Actualizar id: "+id);
			Persona persona = ps.buscarPersona(id);
			model.addAttribute("persona", persona);
			
			return "editar_persona.jsp";
			
		}
		@RequestMapping(value="/modificar", method=RequestMethod.PUT)
		public String modificar(@Valid @ModelAttribute("persona") Persona persona){
			System.out.println("Modificar la persona de id: "+ persona.getId());
			/*
			if(validacionEmptyI(persona.getRut())) {
				//VALIDACIONES NULL
				//persona.addAttribute("error", "Error, datos vacios");
				System.out.println("Rut vacio");
				model.addAttribute("error", "Rut vacio");
				return "error.jsp";
			} else if(validacionEmptyS(persona.getDv())) {//VALIDACIONES
				//persona.addAttribute("error", "Error, datos vacios");
				System.out.println("DV vacio");
				model.addAttribute("error", "Digito verficador vacio");
				return "error.jsp";
			} else if(validacionEmptyS(persona.getNombre())) {//VALIDACIONES
				//persona.addAttribute("error", "Error, datos vacios");
				System.out.println("Nombre vacio");
				model.addAttribute("error", "Nombre vacio");
				return "error.jsp";
			} else if(validacionEmptyS(persona.getApellido())) {//VALIDACIONES
				//persona.addAttribute("error", "Error, datos vacios");
				System.out.println("Apellido vacio");
				model.addAttribute("error", "Apellido vacio");
				return "error.jsp";
			} else  if(validacionEmptyS(persona.getEmail())) {//VALIDACIONES
				//persona.addAttribute("error", "Error, datos vacios");
				System.out.println("error Email vacio");
				model.addAttribute("error", "Email vacio");
				return "error.jsp";
			} 
			//VALIDACIONES LONGITUD
			else if(validacionRut(persona.getRut(), persona.getDv())) {//VALIDACIONES
				//persona.addAttribute("error", "Error, datos vacios");
				System.out.println("error Rut largo o DV");
				model.addAttribute("error", "Rut o digito verificadorde largo incorrecto");
				return "error.jsp";
			} else if(validaLargoNomApellido(persona.getNombre())) {
				System.out.println("error Persona largo");
				model.addAttribute("error", "Nombre persona largo incorrecto");
				return "error.jsp";
			} else if(validaLargoNomApellido(persona.getApellido())){
				System.out.println("error Apelido largo");
				model.addAttribute("error", "Apellido persona larggo incorrecto");
				return "error.jsp";

			}
			*/
			ps.modificarPersona(persona);
			return "redirect:/persona";
			
		}
		
		//METODO ELIMINAR
		@RequestMapping(value="/eliminar", method=RequestMethod.POST)
		public String eliminar(@RequestParam("id") Long id) {
			System.out.println("Eliminar id: "+id);
			ps.eliminarPersona(id);
			return "redirect:/persona";
		}
			
		
}
