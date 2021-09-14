package com.everis.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}
	
	@RequestMapping(value="/formulario", method=RequestMethod.POST)
	public String inicio1(Model model,
			@RequestParam(value="nombre") String nombre,
			@RequestParam(value="apellido") String apellido,
			@RequestParam(value="limite") Integer limite,
			@RequestParam(value="codigoPostal") Integer codigoPostal) {
		
		if(apellido.isEmpty()){
			model.addAttribute("error", "Error apellido");
			return "error.jsp";
		}
		
		if(nombre.isEmpty()){
			model.addAttribute("error", "Error nombre");
			return "error.jsp";
		}
			
		if(limite == null) {
			model.addAttribute("error", "Error limite");
			return "error.jsp";
		}
		
		if(codigoPostal == null) {
			model.addAttribute("error", "Error codigo postal");
			return "error.jsp";
		}
		
		if (nombre.length()>10 && nombre.length()<1)
		{
			model.addAttribute("error", "Error nombre");
			return "error.jsp";
		}
		
		if (apellido.length()>10 || apellido.length()<1)
		{
			model.addAttribute("error", "Error apellido");
			return "error.jsp";
		}
		
		if(limite<1 || limite >1000000){
			model.addAttribute("error", "Error limite");
			return "error.jsp";
		}
		
		if((codigoPostal).toString().length()!=8){
			model.addAttribute("error", "Error limite");
			return "error.jsp";
		}
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("apellido", apellido);
		model.addAttribute("limite", limite);
		model.addAttribute("codigoPostal", codigoPostal);
		
		return "respuesta.jsp";
    }

	
	
}