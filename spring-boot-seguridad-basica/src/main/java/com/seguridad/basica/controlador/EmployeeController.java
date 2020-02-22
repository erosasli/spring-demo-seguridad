package com.seguridad.basica.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmployeeController {

	@RequestMapping(value = "/listEmployees.html", method = RequestMethod.GET)
	public ModelAndView employees() {
		//List<Employee> allEmployees = employeeData.findAll();
		return new ModelAndView("allEmployees", "employees",null);

	}
	
	
	

	

}
