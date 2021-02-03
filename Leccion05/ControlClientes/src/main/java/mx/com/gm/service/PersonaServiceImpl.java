/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.service;

import java.util.List;
import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Para que Spring reconozca la clase como servicio se debe agregar la anotación @Service
//Esto es muy importante ya que posteriormente si no se agrega esta anotación entonces no se va a poder inyectar 
//esta clase como una implementación de la interfaz de Persona Service dentro del controlador de Spring
@Service
public class PersonaServiceImpl implements PersonaService{
    
    @Autowired
    private PersonaDao personaDao;

    @Override
    //Debido a que se esta trabajando en la capa de servicio se debe agregar cuando se esta en la capa DAO se maneja el concepto 
    //de transacciones; Esto quiere decir que cualquier operación en la base de datos en dado caso de error se va a hacer un RollBack 
    //O en caso de todo sea exitoso se hace un COMMIT
    //Cuando se esta trabajando con las clase de servicio se podrian estar utilizando varios objetos de tipo DAO desde una misma clase de servicio
    //Por lo tanto se podría estar realizando varias operaciones sobre distintas tablas de la base de datos 
    //Por lo cual estos métodos deben ser marcados como transaccionales ya que en dado caso de error se tiene que hacer Rollback y no guardar ninguna información en niguna de las tablas afectadas
    //Y en dado caso que todo sea exitoso entonces hacer un COMMIT de toda la transacción en todas las tablas afectadas.
    //Dependiendo del tipo de método es el tipo de transacción que se va a realizar
    @Transactional(readOnly=true)
    public List<Persona> listaPersonas() {
       return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
         personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly=true)
    public Persona encontrarPersona(Persona persona) {
       return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
    
}
