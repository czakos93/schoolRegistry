package pl.dawidbronczak.spring.schoolRegistry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.dawidbronczak.spring.schoolRegistry.service.GradeService;

@Controller
public class GradeController {

	@Autowired
	private GradeService gradeService;
	
	@GetMapping("/grade")
	public String shwoGrade(Model model, @RequestParam("id") int id) {
		model.addAttribute("grade", gradeService.findGradeById(id));
		return "grade";
		
	}
}
