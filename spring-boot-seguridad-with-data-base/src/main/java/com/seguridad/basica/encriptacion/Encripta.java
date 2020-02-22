package com.seguridad.basica.encriptacion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Encripta {

	/***
	 *  El numero 4 representa que tan fuerte quieres la encriptacion.
		Se puede en un rango entre 4 y 31.
		Si no pones un numero el programa utilizara uno aleatoriamente cada vez
		que inicies la aplicacion, por lo cual tus contrasenas encriptadas no
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {

		
		// funcionaran bien
		return new BCryptPasswordEncoder(4);
	}

}
