package pl.dawidbronczak.spring.schoolRegistry.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;

import pl.dawidbronczak.spring.schoolRegistry.domain.SchoolClass;
import pl.dawidbronczak.spring.schoolRegistry.domain.Student;

public interface StudentService{

	Student findByEmail(String email);

	boolean isExist(@Valid Student student);

	void save(@Valid Student student);
	
	List<Student> findBySchoolClassIsNullOrSchoolClass(SchoolClass schoolClass);
	
}
