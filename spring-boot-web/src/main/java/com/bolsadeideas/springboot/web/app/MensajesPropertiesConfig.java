package com.bolsadeideas.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Se crea clase de configuración de Spring con la anotación @Configuration
 * Además se anota con @PropertySources un arreglo con las llaves y se pueden indicar varios archivos properties
 * con la anotación @PropertySource en singular y en las comillas se indica el nonmbre  y la ubicación
 * los recursos son el classpath y se debe configurar @PropertySource("classpath:mensajes.properties")
 * para varios archivos se separa por coma
 * @author Erick David
 *
 */
@Configuration
@PropertySources ({
	 @PropertySource("classpath:mensajes.properties")
})
public class MensajesPropertiesConfig {

}
