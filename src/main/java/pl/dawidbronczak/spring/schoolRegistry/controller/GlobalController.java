package pl.dawidbronczak.spring.schoolRegistry.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.dawidbronczak.spring.schoolRegistry.domain.User;
import pl.dawidbronczak.spring.schoolRegistry.service.UserService;

@ControllerAdvice(assignableTypes={AdminController.class,ClassController.class,DesktopController.class,GradeController.class,SubjectController.class})
public class GlobalController {
	
	@Autowired
	UserService userService; 
	
	@ModelAttribute("loggedUser")
	public User getLoggedUser(Principal principal){
		
			return userService.findByEmail(principal.getName());
		

			
	}
}
