package pl.dawidbronczak.spring.schoolRegistry.service.implementation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dawidbronczak.spring.schoolRegistry.domain.SchoolClass;
import pl.dawidbronczak.spring.schoolRegistry.domain.Student;
import pl.dawidbronczak.spring.schoolRegistry.repository.SchoolClassRepository;
import pl.dawidbronczak.spring.schoolRegistry.service.SchoolClassService;
import pl.dawidbronczak.spring.schoolRegistry.service.StudentService;

@Service
public class SchoolClassServiceImpl implements SchoolClassService {
	
	@Autowired
	private SchoolClassRepository schoolClassRepository;
	
	@Autowired 
	private StudentService studentService;
	
	@Override
	public SchoolClass findClassById(int id) {
		return schoolClassRepository.findById(id).get();
	}

	@Override
	public Iterable<SchoolClass> findAll() {
		return schoolClassRepository.findAll();
	}

	@Override
	public void remove(int classId) {
		SchoolClass schoolClass = findClassById(classId);
		if(!schoolClass.getStudents().isEmpty()) {
			for(Student student : schoolClass.getStudents()) {
				student.setSchoolClass(null);
			}
		}
		schoolClassRepository.deleteById(classId);		
	}

	@Override
	public void save(SchoolClass schoolClass) {
		schoolClassRepository.save(schoolClass);
		Set<Student> currentStudents = studentService.findBySchoolClass(schoolClass);
		Set<Student> updatedStudents = schoolClass.getStudents();
		
		for(Student currentStudent : currentStudents) {
			if(!updatedStudents.contains(currentStudent)) {
				currentStudent.setSchoolClass(null);
				studentService.save(currentStudent);
			}
		}
		for(Student updatedStudent : updatedStudents) {
			if(!currentStudents.contains(updatedStudent)) {
				updatedStudent.setSchoolClass(schoolClass);
				studentService.save(updatedStudent);
			}
		}
		
	}

}
