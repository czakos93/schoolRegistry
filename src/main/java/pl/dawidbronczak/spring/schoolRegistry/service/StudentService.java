package pl.dawidbronczak.spring.schoolRegistry.service;

import java.util.Set;

import javax.validation.Valid;

import pl.dawidbronczak.spring.schoolRegistry.domain.SchoolClass;
import pl.dawidbronczak.spring.schoolRegistry.domain.Student;

public interface StudentService{


	boolean isExist(int studentId);

	void save(@Valid Student student);
	
	Student findById(int userId);

	Set<Student> findBySchoolClassIsNull();

	Set<Student> findBySchoolClass(SchoolClass schoolClass);

	void delete(Student student);
	
}
