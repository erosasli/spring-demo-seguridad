package com.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// añadir los usuarios que se van autenficar pero usando en memoria volatil
		@SuppressWarnings("deprecation")
		UserBuilder users = User.withDefaultPasswordEncoder();
		// usuario en memoria con autentificacion
		auth.inMemoryAuthentication().withUser(users.username("john").password("test123").roles("EMPLOYEE"))
				.withUser(users.username("mary").password("test123").roles("MANAGER","EMPLOYEE"))
				.withUser(users.username("susan").password("test123").roles("ADMIN","EMPLOYEE"));

	}

	/**
	 * HttpSecurity seguridad http y de es de spring
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		       .antMatchers("/").hasRole("EMPLOYEE")
		       .antMatchers("/leaders/**").hasRole("MANAGER")
		       .antMatchers("/systems/**").hasRole("ADMIN")		       
				// restriccion de solicitud
				.anyRequest()
				// ha esa retriccion de solicitud debe estar autentificado
				.authenticated().
				//Y
				and().
				//el formulario
				formLogin()
				// my pagina de login
				.loginPage("/showMyLoginPage")
				// una vez que cheque el login y password se va ir autehticatTheUser y permitir
				// a todos
				.loginProcessingUrl("/authenticateTheUser").permitAll()
				.and()
				//el logut permite a todo
				.logout().permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
		
		

	}

}
