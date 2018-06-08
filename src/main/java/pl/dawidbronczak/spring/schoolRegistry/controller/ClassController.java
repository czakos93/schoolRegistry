package pl.dawidbronczak.spring.schoolRegistry.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.dawidbronczak.spring.schoolRegistry.domain.SchoolClass;
import pl.dawidbronczak.spring.schoolRegistry.domain.Student;
import pl.dawidbronczak.spring.schoolRegistry.service.SchoolClassService;
import pl.dawidbronczak.spring.schoolRegistry.service.StudentService;

@Controller
public class ClassController {
	
	@Autowired
	private SchoolClassService classService;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/class")
	public String showClass(@RequestParam("id") int classId, Model model) {
		model.addAttribute("schoolClass", classService.findClassById(classId));
		return "class";
	}
	
	@GetMapping("admin/class/remove") 
	public String removeClass(@RequestParam("id") int classId) {
		classService.remove(classId);
		return "redirect:/admin/classes";
	}
	
	@GetMapping("admin/class/edit")
	public String editClass(@RequestParam("id") int classId, Model model) {
		
		SchoolClass schoolClass = classService.findClassById(classId);
		List<Student> students = new ArrayList<>();
		students.addAll(schoolClass.getStudents());
		students.addAll(studentService.findBySchoolClassIsNull());
		model.addAttribute("schoolClass", schoolClass);
		model.addAttribute("students", students);
		
		return "modifyClass.html";
	}
	
	@PostMapping("admin/class/edit")
	public String editClassProcces(@ModelAttribute("schoolClass") SchoolClass schoolClass) {

		classService.save(schoolClass);
		return "redirect:/admin/classes";
	}
	
	@GetMapping("admin/class/add")
	public String newClass(Model model) {
		model.addAttribute("schoolClass", new SchoolClass());
		return "modifyClass.html";
	}
}
