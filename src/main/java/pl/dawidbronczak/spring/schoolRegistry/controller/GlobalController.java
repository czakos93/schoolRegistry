package pl.dawidbronczak.spring.schoolRegistry.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.dawidbronczak.spring.schoolRegistry.domain.Student;
import pl.dawidbronczak.spring.schoolRegistry.service.StudentService;

@ControllerAdvice(assignableTypes={AdminController.class,ClassController.class,DesktopController.class,GradeController.class,SubjectController.class})
public class GlobalController {
	
	@Autowired
	StudentService studentService; 
	
	@ModelAttribute("loggedUser")
	public Student getLoggedUser(Principal principal){
		
			return studentService.findByEmail(principal.getName());
		

			
	}
}
