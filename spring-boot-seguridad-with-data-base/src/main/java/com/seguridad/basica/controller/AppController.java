package com.seguridad.basica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/***
 * Para controlar las entradas y salidas
 * @author erosas
 *
 */
@Controller
public class AppController {

	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@GetMapping("/user")
	public String user() {
		return "user";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}