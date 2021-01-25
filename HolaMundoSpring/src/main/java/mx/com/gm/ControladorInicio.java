package mx.com.gm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//Controlador tipo REST permite enviar informacion al navegador dependiendo el verbo HTTP en este caso Metodo GET
@RestController
//Anotacion para el manejo de logging
@Slf4j
public class ControladorInicio {
    
    //Metodo mapeado a un PATH por el metodo GET y responde a la ruta: 
    //http://localhost:8080
    @GetMapping("/")
    public String inicio(){
        log.info("Ejecutando el controlador REST");
        log.debug("Mas detalle del controlador");
        return "Hola Mundo con Spring Boot";
    }
}
