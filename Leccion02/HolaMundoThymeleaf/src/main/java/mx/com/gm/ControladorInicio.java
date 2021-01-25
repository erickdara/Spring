package mx.com.gm;

import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import mx.com.gm.domain.Persona;

//Controlador tipo REST permite enviar informacion al navegador dependiendo el verbo HTTP en este caso Metodo GET
@Controller
//Anotacion para el manejo de logging
@Slf4j
public class ControladorInicio {
    
    //Anotacion para acceder a la información del archivo de propiedades 
    //Dentro de la anotación se accede a la llave similar Expression Language ${index.saludo} para que inyecte el valor desde properties
    //Spring aplica el concepto de inyección de dependencias debido a que la información de el archivo de properties ya esta disponible para el contenedor de Spring
    //Lo que hace Spring de manera automatica esta llave utilizando esta sintaxis y va a tomar el valor relacionado a esta llave
    //y lo va a inyectar como el valor de la variable saludo 
    @Value("${index.saludo}")
    //variable para almacenar el valor declarado en el archivo de propiedades
    private String saludo;
    //Metodo mapeado a un PATH por el metodo GET y responde a la ruta: 
    //http://localhost:8080
    @GetMapping("/")
    //En el metodo se recibe objeto Model como parametro parar compartir la informacion hacia la vista
    public String inicio(Model model){
        var mensaje = "Mensaje con Thymeleaf";
        
        var persona = new Persona();
        persona.setNombre("Erick");
        persona.setApellido("Rangel");
        persona.setEmail("erick1rg@gmail.com");
        persona.setTelefono("3102415108");
        
        var persona2 = new Persona();
        persona2.setNombre("Camila");
        persona2.setApellido("Amaya");
        persona2.setEmail("Mcami93@gmail.com");
        persona2.setTelefono("3012749629");
        
        //Asi se puede crear la lista
//        var personas = new ArrayList();
//        personas.add(personas);
//        personas.add(personas);

        var personas = Arrays.asList(persona, persona2);
        
        //Lista Vacia
        //var personas = new ArrayList();
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("mensaje", mensaje);
        //Se comparte esta infomacion utilizando la clase de modelo usando el metodo addAttribute mandando una llave y un valor
        model.addAttribute("saludo", saludo);
        //model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        return "index";
    }
}
