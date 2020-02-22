package com.seguridad.basica;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Passgenerator {

	/**
	 * Para modificar las claves de las password
	 * @param args
	 */
	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        //El String que mandamos al metodo encode es el password que queremos encriptar.
	System.out.println(bCryptPasswordEncoder.encode("ab"));
	}
}
