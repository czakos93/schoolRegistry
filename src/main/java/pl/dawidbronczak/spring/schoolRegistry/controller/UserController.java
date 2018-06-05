package pl.dawidbronczak.spring.schoolRegistry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.dawidbronczak.spring.schoolRegistry.domain.User;
import pl.dawidbronczak.spring.schoolRegistry.service.UserService;

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
	public String modifyUser(@RequestParam("id") int userId, Model model) {
		model.addAttribute("user", userService.findById(userId));
		return "modifyUser.html";
	}
	
	@PostMapping("admin/user/edit")
	public String modifyUserProcess(@ModelAttribute("user") User user) {
		return "redirect:/admin/users";
	}
	
	
}
