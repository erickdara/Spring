package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    //Se crea el campo de la llave primaria 
    @Id
    //Se indica la forma de generar esta llave primaria y la estrategia a utilizar para 
    //generarla
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
            
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
