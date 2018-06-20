package pl.dawidbronczak.spring.schoolRegistry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;



import pl.dawidbronczak.spring.schoolRegistry.service.SchoolClassService;

import pl.dawidbronczak.spring.schoolRegistry.service.SubjectService;

import pl.dawidbronczak.spring.schoolRegistry.service.UserService;

	


@Controller
public class AdminController {
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private SchoolClassService classService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/admin")
	public String showAdminPage() {
		return "admin.html";
	}	
	
	@GetMapping("admin/classes")
	public String manageClasses(Model model) {
		model.addAttribute("classes", classService.findAll());
		return "classes.html";
	}
	
	@GetMapping("admin/users")
	public String manageUsers(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users.html";
	}
	
	@GetMapping("admin/subjects")
	public String manageSubjects(Model model) {
		model.addAttribute("subjects", subjectService.findAll());
		return "subjects.html";
	}
	

	
	
	
	
}
