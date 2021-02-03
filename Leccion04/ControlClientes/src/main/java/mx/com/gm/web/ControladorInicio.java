package mx.com.gm.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.service.PersonaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

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
}
