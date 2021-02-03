/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.dao;

import org.springframework.data.repository.CrudRepository;
import mx.com.gm.domain.Persona;

/**
 *
 * @author Erick David
 */

//La interface va a extender de manera directa de otra Interface llamada CrudRepository
//La ventaja es que cualquier tipo de clase Dao vamos a poder crearla utilizando este mismo Repositorio
//Así que ya no es necesario estar agregando los clasicos métodos insertar,listar, actualizar, eliminar, etc... a cada una de nuestras clases
//Debido a que va a ser un tipo generico que se va a poder utilizar en cualquiera de las clases de tipo DAO
//Se debe especificar cual es el tipo de entidad que va a manejar: <Persona, Long> se indica que va a manejar objetos de tipo Persona Y posteriormente se debe indicar el tipo de llave que se esta utilizando
//Una de las ventajas de utilizar esta nueva practica es que ya no es necesario crear una implementacion (Anteriormente se implementaba la clase)
//En este caso SpringBoot ya va a crear una implementación por Default
public interface PersonaDao extends CrudRepository<Persona, Long>{
    
}
