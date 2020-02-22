package com.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {


	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());

	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean
	public DataSource securityDataSource() {
		
		//create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		//set the jdbc driver class
		try {
			
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
			securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
			securityDataSource.setUser(env.getProperty("jdbc.user"));
			securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
			securityDataSource.setInitialPoolSize(
					getIntProperty("connection.pool.initialPoolSize"));

			securityDataSource.setMinPoolSize(
					getIntProperty("connection.pool.minPoolSize"));

			securityDataSource.setMaxPoolSize(
					getIntProperty("connection.pool.maxPoolSize"));

			securityDataSource.setMaxIdleTime(
					getIntProperty("connection.pool.maxIdleTime"));
			
	
			
		}catch (PropertyVetoException exec) {
			throw new RuntimeException(exec);
		}
		
		logger.info(">>> jdbc.driver.url "+env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.driver.user "+env.getProperty("jdbc.user"));
		return securityDataSource;
		
		
	}
	
	
	private int getIntProperty(String propName) {
		
		String propVal = env.getProperty(propName);
		int intPropVal = Integer.parseInt(propVal);
		return intPropVal;
		
	}
	
}









