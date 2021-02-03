package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables") // Ruta base del controlador
public class EjemploVariablesRutaController {
	
	@GetMapping("/")
	public String index(Model model) {
		return "variables/index";
	}
	
	//Método GET con mapeo dinamico de variable
	/**
	 * Anotación @PathVariable que indica que un parámetro de método debe estar vinculado a una variable de plantilla de URI. 
	 * Compatible con métodos de controlador anotados RequestMapping.
	 * Esto para recibir parametros de la ruta
	 * @param texto
	 * @param model
	 * @return
	 */
	@GetMapping("/string/{texto}")
	public String variables (@PathVariable String texto, Model model) {
		model.addAttribute("titulo", "Recibir párametros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto);
		return "variables/ver";
	}
	
	@GetMapping("/string/{texto}/{numero}")
	public String variables (@PathVariable String texto, @PathVariable Integer numero, Model model) {
		model.addAttribute("titulo", "Recibir párametros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto
				+ " y el numero enviado en el path es: " + numero);
		return "variables/ver";
	}

}
