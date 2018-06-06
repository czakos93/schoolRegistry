package pl.dawidbronczak.spring.schoolRegistry.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.dawidbronczak.spring.schoolRegistry.domain.Student;
import pl.dawidbronczak.spring.schoolRegistry.domain.Teacher;
import pl.dawidbronczak.spring.schoolRegistry.domain.User;
import pl.dawidbronczak.spring.schoolRegistry.service.StudentService;
import pl.dawidbronczak.spring.schoolRegistry.service.TeacherService;
import pl.dawidbronczak.spring.schoolRegistry.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService  userService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TeacherService teacherService;

	@GetMapping("admin/user/remove")
	public String removeUser(@RequestParam("id") int userId) {
		userService.remove(userId);
		return "redirect:/admin/users";
	}
	
	@GetMapping("admin/user/edit")
	public String modifyUser(@RequestParam("id") int userId, Model model, RedirectAttributes redirectAttributes) {		
		
		model.addAttribute("user", userService.findById(userId));
		return "modifyUser.html"; 
	}
	
	@PostMapping("admin/user/edit")
	public String modifyUserProcess(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
		userService.save(user); 
		return "redirect:/admin/users";
	}
	
	
}
