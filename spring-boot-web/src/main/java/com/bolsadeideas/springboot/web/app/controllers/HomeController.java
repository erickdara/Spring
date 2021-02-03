package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	/**
	 * Redirect retorna la palabra clave redirect que reinicia la petición y redirecciona a la ruta absoluta especificada
	 * otra forma es Forward sin reiniciar el request sin recargar la pagina va a realizar un Dispatcher dentro del mismo request
	 * hacia la ruta especificada los parametros de este request no se pierden, no se reinicia y se mantienen 
	 * se usa con rutas propias de los controladores
	 * El forward por debajo lo que hace es ejecutar el método RequestDispatcher.forward
	 * @return
	 */
	@GetMapping("/")
	public String home() {
		return "forward:/app/index";
	}

}
