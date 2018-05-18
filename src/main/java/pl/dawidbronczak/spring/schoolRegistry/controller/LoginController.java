package pl.dawidbronczak.spring.schoolRegistry.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.dawidbronczak.spring.schoolRegistry.dto.UserDTO;

@Controller
public class LoginController {
	
	@GetMapping("/register")
	public String showRegisterPage(Model model){	
		model.addAttribute("user", new UserDTO());
		return "register";
	}
	
	@PostMapping("/register")
	public String processRegistration(@Valid @ModelAttribute("user") UserDTO user, BindingResult result){
		if(result.hasErrors()){
			return "/register";
		}
		return "redirect:/desktop";
	}
}
