package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
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
    
    //Se agregan validaciones segun la restricción en la clase de entidad
    //El nombre no puede tener el campo vacio se utiliza NoEmpty con Strings por que valida las
    //cadenas vacias mientras que NotNull solo valida que no sea null
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String apellido;
    
    @NotEmpty
    @Email
    private String email;
    
    private String telefono;
}
