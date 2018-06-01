package pl.dawidbronczak.spring.schoolRegistry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import pl.dawidbronczak.spring.schoolRegistry.service.SchoolClassService;

@Controller
public class ClassController {
	
	@Autowired
	private SchoolClassService classService;
	
	@GetMapping("/class")
	public String showClass(@RequestParam("id") int classId, Model model) {
		model.addAttribute("schoolClass", classService.findClassById(classId));
		return "class";
	}
}
