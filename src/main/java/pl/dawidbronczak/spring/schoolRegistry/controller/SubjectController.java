package pl.dawidbronczak.spring.schoolRegistry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.dawidbronczak.spring.schoolRegistry.service.SubjectService;

@Controller
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/subject")
	public String showSubject(Model model, @RequestParam("id") int subjectId) {
		model.addAttribute("subject", subjectService.findSubjectById(subjectId));
		return "subject";
	}
	
}
