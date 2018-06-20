package pl.dawidbronczak.spring.schoolRegistry.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;

import pl.dawidbronczak.spring.schoolRegistry.domain.SchoolClass;
import pl.dawidbronczak.spring.schoolRegistry.domain.Student;
import pl.dawidbronczak.spring.schoolRegistry.domain.User;

public interface StudentService{


	boolean isExist(int studentId);

	void save(@Valid Student student);
	
	Student findById(int userId);

	Set<Student> findBySchoolClassIsNull();

	Set<Student> findBySchoolClass(SchoolClass schoolClass);

	void delete(Student student);
	
}
