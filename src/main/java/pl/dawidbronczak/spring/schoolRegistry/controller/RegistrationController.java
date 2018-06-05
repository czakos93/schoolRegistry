package pl.dawidbronczak.spring.schoolRegistry.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.dawidbronczak.spring.schoolRegistry.domain.User;
import pl.dawidbronczak.spring.schoolRegistry.dto.UserDTO;
import pl.dawidbronczak.spring.schoolRegistry.service.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping("/register")
	public String showRegisterPage(Model model){	
		model.addAttribute("userDTO", new UserDTO());
		return "register";
	}
	
	@PostMapping("/register")
	public String processRegistration(@Valid @ModelAttribute("userDTO") UserDTO userDto, BindingResult result){
		User user = modelMapper.map(userDto, User.class);
		if (userService.isExist(user)) {
			result.rejectValue("email", "error.user", "Użytkownik o podanym emailu istnieje");
		}
		if (result.hasErrors()) {
			return "/register";
		}
		userService.saveUser(user);		
		return "redirect:/login";
	}
}
