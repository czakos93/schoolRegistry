package pl.dawidbronczak.spring.schoolRegistry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.dawidbronczak.spring.schoolRegistry.domain.Grade;
import pl.dawidbronczak.spring.schoolRegistry.domain.GradesList;
import pl.dawidbronczak.spring.schoolRegistry.service.GradeService;
import pl.dawidbronczak.spring.schoolRegistry.service.GradesListService;
import pl.dawidbronczak.spring.schoolRegistry.service.SchoolClassService;

@Controller
public class GradeController {

	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private SchoolClassService classService;
	
	@Autowired
	private GradesListService gradesListService;
	
	
	
	@GetMapping("/grade")
	public String shwoGrade(Model model, @RequestParam("id") int id) {
		model.addAttribute("grade", gradeService.findGradeById(id));
		return "grade";
		
	}
	
	@GetMapping("/addGrades")
	public String addGrades(Model model, @RequestParam("subjectID") int subjectID, @RequestParam("classID") int classID ) {
		model.addAttribute("class", classService.findClassById(classID));
		model.addAttribute("grade", new Grade());
		return "addGrades.html";
	}
	
	@PostMapping("/addGradesProcess")
	public String addGradesProcess(@ModelAttribute("grade") Grade grade, @RequestParam("subjectID") int subjectID, @RequestParam("studentID") int studentID) {
		GradesList gradesList = gradesListService.findByStudentAndSubject(studentID, subjectID);		
		grade.setGradesList(gradesList);
		gradeService.save(grade);
		return "redirect:/teacher-desktop";
	}
}
