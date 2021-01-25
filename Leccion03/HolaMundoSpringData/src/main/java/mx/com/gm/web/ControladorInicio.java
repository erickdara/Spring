package mx.com.gm.web;

import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.PersonaDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;

//Controlador tipo REST permite enviar informacion al navegador dependiendo el verbo HTTP en este caso Metodo GET
@Controller
//Anotacion para el manejo de logging
@Slf4j
public class ControladorInicio {
    
    //Se inyecta la interfaz dentro del controlador
    //En Spring para poder inyectar cualquier dependencia u objeto que sea administrado por el contenedor se usa @Autowired
    @Autowired
    private PersonaDao personaDao;
    
    //Metodo mapeado a un PATH por el metodo GET y responde a la ruta: 
    //http://localhost:8080
    @GetMapping("/")
    //En el metodo se recibe objeto Model como parametro parar compartir la informacion hacia la vista
    public String inicio(Model model){
        //Se crea la variable personas para recuperar los objetos de tipo persona usando el objeto personaDao
        //Spring crea la implementación () en automatico al lanzar la aplicación
        var personas = personaDao.findAll();
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        return "index";
    }
}
