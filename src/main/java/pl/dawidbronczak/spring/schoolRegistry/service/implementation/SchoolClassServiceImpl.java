package pl.dawidbronczak.spring.schoolRegistry.service.implementation;

import java.util.List;
import java.util.Optional;
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
	public List<SchoolClass> findAll() {
		return (List<SchoolClass>) schoolClassRepository.findAll();
	}

	@Override
	public void remove(int classId) {
		schoolClassRepository.deleteById(classId);
		
	}

	@Override
	public void save(SchoolClass schoolClass) {
		Set<Student> currentStudents = studentService.findBySchoolClass(schoolClass);
		List<Student> updatedStudents = schoolClass.getStudents();
		for(Student currentStudent : currentStudents) {
			if(!updatedStudents.contains(currentStudent)) {
				currentStudent.setSchoolClass(null);
			}
		}
		for(Student updatedStudent : updatedStudents) {
			if(!currentStudents.contains(updatedStudent)) {
				updatedStudent.setSchoolClass(schoolClass);
			}
		}
		schoolClassRepository.save(schoolClass);
		
	}

}
