package pl.dawidbronczak.spring.schoolRegistry.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.dawidbronczak.spring.schoolRegistry.service.GradeService;
import pl.dawidbronczak.spring.schoolRegistry.service.StudentService;
import pl.dawidbronczak.spring.schoolRegistry.service.UserService;

@Controller
public class DesktopController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	GradeService gradeService;
	
	@GetMapping(value={"/","/desktop"})
	public String showDesktop(Model model, Principal principal){

		return "desktop";
	}
	
	@GetMapping("/user-desktop")
	public String showUserDesktop(){
		return "userDesktop.html";
	}
	

	@GetMapping("/teacher-desktop")
	public String showTeacherPage(){
		return "teacherDesktop.html";
	}
}