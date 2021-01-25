package es.pildoras.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoEmpleados {

	public static void main(String[] args) {

		/**
		 * Codigo de Inyección de Dependencias sin usar Spring
		//Creo objetos de tipo Empleado desde la interfaz Empleados
		Empleados empleado1= new DirectorEmpleado();
		
		
		//Uso de los objetos creados 
	    System.out.println(empleado1.getTareas());
	    */
		
		/**********************************************************
		 * Cuatro Pasos a seguir para usar el contenedor de Spring*
		 * ********************************************************/
		 
		// Paso 1: Crear un contexto (Creando un Objeto o instacia persteneciente a la clase 
		// ClassPathXmlApplicationContext) En los argumentos de este constructor
		// se debe indicar el nombre del archivo xml de configuración a cargar
		
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Paso 2: Pedir al archivo xml el Bean (Objeto)
		// El metodo getBean va a pedir 2 argumentos: El primero el alias que se le ha dado al motor o generador de Beans
		// El segundo argumento va a pedir el nombre de la clase Intefaz
		 
		DirectorEmpleado Juan = contexto.getBean("miEmpleado", DirectorEmpleado.class);
		
		//Paso 3: Utilizar el Bean		 
		System.out.println(Juan.getTareas());
		
		System.out.println(Juan.getInforme()); 
		
		System.out.println(Juan.getEmail());
		
		System.out.println(Juan.getNombreEmpresa());
		
		/*SecretarioEmpleado Maria = contexto.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
		
		System.out.println(Maria.getTareas());
		
		System.out.println(Maria.getInforme());
		
		System.out.println("Email :" + Maria.getEmail());
		
		System.out.println(Maria.getNombreEmpresa());   */
		
		//Paso 4: Cerrar el Contexto (Archivo XML);
		contexto.close();
		 
	}

}
