package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

/**
 * Un controlador va a tener metodos de acción o handler que va a manejar una petició HTTP del usuario
 * por ejemplo: Mostrar un formulario, cargar datos, listados de algo, consultas a BD, guardar, insertar, eliminar 
 * Cada Método handler o de acción representa una pagina web que hace algo y que trabaja con los datos de nuestra aplicación
 * y estos datos se van a mostrar y se van a representar en una vista dentro de la respuesta en este caso con thymeleaf
 * Basicamente el controlador se encarga de manejar las peticiones del usuario (Mostrar la pagina la respuesta con los datos que el usuario a solicitado)
 * 
 * Mapeo de controlador con RequestMapping de una ruta base que va a ser común para todos los metodos del controlador (Métodos Handler)
 * permitiendo que esta ruta sea la de primer nivel y la de los demás métodos de segundo nivel en el controlador
 * @author Erick David
 *
 */
@Controller
@RequestMapping("/app")
public class IndexController {
	
	/**
	 * @Value esta anotación es usada para inyectar información de una archivo properties a atributos utilizando esta anotación
	 * se debe indicar el nombre o la llave de donde esta el texto desde el archivo properties
	 * Se pueden desacoplar los textos del controlador en el application properties  
	 * (Inyección de dependencias aplicado a textos)
	 * Existe otra forma de guardar los textos en varios archivos properties si se tienen varios textos por controlador o por modulos o package
	 */
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;

	/**
	 * Retorna un string con el nombre de la vista que tiene que cargar
	 * 
	 * Se tiene que mapear o relacionar este método index a una ruta o URL para que el clente el usuario en la aplicacion
	 * escriba index y automaticamente se invoque este método y carge y muestre la vista index.html con los datos que se implementen
	 * dentro de este metodo (logica de negocio, lo que se necesite)
	 * Se mapea con RequestMapping y se usa el atributo value que es un alias del Path y se inicia con slash y se coloca la url(Alfanumerico, No caracteres Especiales)
	 * Entonces cada vez que se escriba en el navegador http://localhost:8080/index se va a ejecutar este metodo
	 * RequestMapping por defecto es de tipo petición GET
	 * 
	 * Pasar datos desde el controlador a la vista hay diferentes formas en este ejemplo:
	 * Usamos la interaz Model y se pasa argumento en el metodo del controlador
	 * También se puede usar ModelMap
	 * Y Map Map<String, Object> map con su método put
	 * ModelAndView con el método addObject el método en lugar de ser String tiene que ser ModelAndView y que retorne la variable mv(ModelAndView)
	 * para colocar el nombre de la vista que se va a cargar o mostrar con el método mv.setViewName("index") con el nombre de la vista;
	 * @return
	 */
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	
	/**
	 * Método Handler
	 */
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Erick");
		usuario.setApellido("Rangel");
		usuario.setEmail("erick1rg@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
	

		model.addAttribute("titulo", textoListar);
		
		return "listar";
	}
	
	//Anotación ModelAttribute sirve para pasar datos a la vista, se debe asignar el nombre con el cual se recuperará el atributo del modelo a la vista
	//se usan comunmente para poblar Select RadioButton CheckList
	@ModelAttribute("usuarios")
	
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Erick","Rangel","erick1rg@gmail.com"),
				new Usuario("Andrez","Guzman","aguzman@gmail.com"),
				new Usuario("Andrea","Rojas","arojas@gmail.com"),
				new Usuario("Fercho","Redes","fredes@gmail.com"));
		return usuarios;
	}
}
