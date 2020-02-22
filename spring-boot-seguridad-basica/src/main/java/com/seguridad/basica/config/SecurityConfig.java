package com.seguridad.basica.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Autenficacion
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("sa").password("{noop}sa").roles("USER");
	}

	/***
	 * Autorizacion
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().antMatcher("/**")
		        .authorizeRequests()
		        .anyRequest()
		        .hasRole("USER")
		        .and().
	    formLogin().
		        loginPage("/login.jsp")
		        .failureUrl("/login.jsp?error=1")
		        .loginProcessingUrl("/login")
		        .defaultSuccessUrl("/listEmployees.html")
				.permitAll(true)
			    .and().
		 logout()
		        .logoutSuccessUrl("/listEmployees.html")
		        .logoutSuccessHandler((new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK)))
		        .deleteCookies().invalidateHttpSession(true).logoutSuccessUrl("/").permitAll();
				
		
		/*http.csrf().disable().antMatcher("/**")
				.authorizeRequests()
				.anyRequest().hasRole("USER")
				.and()
		.formLogin()
				.loginPage("/login.jsp")
				.failureUrl("/login.jsp?error=1")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/listEmployees.html")
				.permitAll(true)
				.and()
		.logout()
		        .logoutSuccessUrl("/login?listEmployees.html")
		        //.logoutSuccessUrl("/listEmployees.html")
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessHandler((new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK)))
				.deleteCookies().invalidateHttpSession(true).logoutSuccessUrl("/").permitAll();*/
			
		        
				
		

	}

}
