package mx.com.gm.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.service.PersonaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import mx.com.gm.domain.Persona;
import org.springframework.web.bind.annotation.PostMapping;

//Controlador tipo REST permite enviar informacion al navegador dependiendo el verbo HTTP en este caso Metodo GET
@Controller
//Anotacion para el manejo de logging
@Slf4j
public class ControladorInicio {
    
    //Se inyecta el servicio que es la capa logica
    //En Spring para poder inyectar cualquier dependencia u objeto que sea administrado por el contenedor se usa @Autowired
    @Autowired
    private PersonaService personaService;
    
    //Metodo mapeado a un PATH por el metodo GET y responde a la ruta: 
    //http://localhost:8080
    @GetMapping("/")
    //En el metodo se recibe objeto Model como parametro parar compartir la informacion hacia la vista
    public String inicio(Model model){
        //Se crea la variable personas para recuperar los objetos de tipo persona usando el objeto personaDao
        //Spring crea la implementación () en automatico al lanzar la aplicación
        var personas = personaService.listaPersonas();
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        return "index";
    }
    
    @GetMapping("/agregar")
    //Para inyectar un Objeto de tipo persona simplemente se define como un argumento mas del método
    //Spring va a buscar un objeto de tipo persona en la Fábrica de Spring si no lo encuentra va a crear un nuevo objeto
    //Y lo inyecta de manera automatica en este método
    public String agregar(Persona persona){
        return "modificar";
    }
    
    /**
     * Este metodo recibe el objeto del formulario, para recibirlo simplemente lo va a inyectar de spring de manera automatica
     * al definirlo como argumento Spring va a buscar el objeto que se lleno en el formulario lo recupera en memoria 
     * y lo inyecta con los valores llenados desde el formulario
     * 
     * El objeto persona que se recupera del lado del servidor ya va a tener el valor de idPersona establecido desde el formulario
     * y por lo tanto cuando se guarde un objeto de tipo persona en lugar de hacer un INSERT va a hacer un UPDATE
     * @param persona
     * @return 
     */
    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    /**
     * Se especifica el path /editar/con la variable a usar; valor igual al atributo de la clase que se quiere inicializar
     * No es necesario inicializar el objeto ni tampoco hacer set de este parametro recibido
     * @param persona
     * @param model
     * @return 
     */
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
