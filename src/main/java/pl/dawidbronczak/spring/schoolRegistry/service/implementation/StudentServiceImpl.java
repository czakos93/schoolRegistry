package pl.dawidbronczak.spring.schoolRegistry.service.implementation;

import java.util.Set;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dawidbronczak.spring.schoolRegistry.domain.SchoolClass;
import pl.dawidbronczak.spring.schoolRegistry.domain.Student;
import pl.dawidbronczak.spring.schoolRegistry.domain.User;
import pl.dawidbronczak.spring.schoolRegistry.repository.StudentRepository;
import pl.dawidbronczak.spring.schoolRegistry.service.RoleService;
import pl.dawidbronczak.spring.schoolRegistry.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	RoleService roleService;
	


	@Override
	public boolean isExist(int studentId) {
		return studentRepository.existsById(studentId);
	}

	@Override
	public void save(@Valid Student student) {
		
		studentRepository.save(student);	
	}

	@Override
	public Set<Student> findBySchoolClassIsNull() {
		return studentRepository.findBySchoolClassIsNull();
	}

	@Override
	public Student findById(int userId) {
		return studentRepository.findById(userId).get();	
	}

	@Override
	public Set<Student> findBySchoolClass(SchoolClass schoolClass) {
		return studentRepository.findBySchoolClass(schoolClass);
	}

	@Override
	public void delete(Student student) {
		studentRepository.delete(student);
	}

	@Override
	public Student findByOwner(User loggedUser) {
		return studentRepository.findByOwner(loggedUser);
	}

}
