package pl.dawidbronczak.spring.schoolRegistry.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;

import pl.dawidbronczak.spring.schoolRegistry.domain.SchoolClass;
import pl.dawidbronczak.spring.schoolRegistry.domain.Student;
import pl.dawidbronczak.spring.schoolRegistry.domain.User;

public interface StudentService{

	Student findByEmail(String email);

	boolean isExist(int studentId);

	void save(@Valid Student student);
	
	List<Student> findBySchoolClassIsNullOrSchoolClass(SchoolClass schoolClass);

	Student findById(int userId);
	
}
