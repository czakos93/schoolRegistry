package pl.dawidbronczak.spring.schoolRegistry.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.dawidbronczak.spring.schoolRegistry.domain.Student;
import pl.dawidbronczak.spring.schoolRegistry.service.SchoolClassService;
import pl.dawidbronczak.spring.schoolRegistry.service.StudentService;
import pl.dawidbronczak.spring.schoolRegistry.service.UserService;
	


@Controller
public class AdminController {
	
	@Autowired
	private StudentService studentService;
	
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
	
}
