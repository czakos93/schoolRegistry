package pl.dawidbronczak.spring.schoolRegistry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.dawidbronczak.spring.schoolRegistry.domain.Subject;
import pl.dawidbronczak.spring.schoolRegistry.service.SubjectService;
import pl.dawidbronczak.spring.schoolRegistry.service.TeacherService;

@Controller
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/subject")
	public String showSubject(Model model, @RequestParam("id") int subjectId) {
		model.addAttribute("subject", subjectService.findSubjectById(subjectId));
		return "subject";
	}
	
	@GetMapping("/admin/subject/add")
	public String addSubject(Model model) {		
		model.addAttribute("subject", new Subject());
		return "modifySubject.html";
	}
	
	@PostMapping("/admin/subject/add") 
	public String proccesAddingSubject(@ModelAttribute("subject") Subject subject) {
		System.out.println(subject.getName());
		subjectService.create(subject);
		return "redirect:/admin/subjects";
	}
	
	@GetMapping("/admin/subject/edit")
	public String editSubject(@RequestParam("id") int id, Model model) {
		model.addAttribute("subject", subjectService.findSubjectById(id));
		model.addAttribute("teachers", teacherService.findAll());
		return "modifySubject.html";
	}
	
	@PostMapping("/admin/subject/edit")
	public String proccesEditingSubject(@ModelAttribute("subject") Subject subject) {
		subjectService.save(subject);
		return "redirect:/admin/subjects";
	}
	
	@GetMapping("/admin/subject/remove")
	public String removeSubject(@RequestParam("id") int id) {
		subjectService.remove(id);
		return "redirect:/admin/subjects";
	}
	
}
