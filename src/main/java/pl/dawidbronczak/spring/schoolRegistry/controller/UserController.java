package pl.dawidbronczak.spring.schoolRegistry.controller;

import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.dawidbronczak.spring.schoolRegistry.domain.User;

import pl.dawidbronczak.spring.schoolRegistry.service.UserService;
import pl.dawidbronczak.spring.schoolRegistry.utils.wrapper.ListWrapper;

@Controller
public class UserController {
	
	@Autowired
	private UserService  userService;
	
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
	
	@GetMapping("admin/users/assign-teachers")
	public String assignTeacher(Model model) {
		Set<User> possibleTeachers = userService.findAllByFunctionIsNull();
		ListWrapper allTeachersWrapper = new ListWrapper();
		allTeachersWrapper.getList().addAll(userService.findByTeacherFunction());
		model.addAttribute("allTeachersWrapper", allTeachersWrapper);
		model.addAttribute("possibleTeachers", possibleTeachers);
		return "assign-teachers.html";
	}	

	@PostMapping("admin/users/assign-teachers")
	public String assignTeacherProcess(@ModelAttribute("allTeachersWrapper") ListWrapper allTeachersWrapper) {
		userService.assingTeacherFunction(allTeachersWrapper.getList());
		return "redirect:/admin/users/assign-teachers";
	}
	
	@GetMapping("admin/users/assign-students")
	public String assignStudents(Model model) {
		Set<User> possibleStudents = userService.findAllByFunctionIsNull();
		ListWrapper allStudentsWrapper = new ListWrapper();
		allStudentsWrapper.getList().addAll(userService.findByStudentFunction());
		model.addAttribute("allStudentsWrapper", allStudentsWrapper);
		model.addAttribute("possibleStudents", possibleStudents);
		return "assign-students.html";
	}
	
	@PostMapping("admin/users/assign-students")
	public String assignStudentsProcess(@ModelAttribute("allStudentsWrapper") ListWrapper allStudentsWrapper) {
		userService.assignStudentFunction(allStudentsWrapper.getList());
		return "redirect:/admin/users/assign-students";
	}
}
