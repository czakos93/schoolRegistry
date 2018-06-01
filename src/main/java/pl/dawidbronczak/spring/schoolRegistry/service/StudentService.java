package pl.dawidbronczak.spring.schoolRegistry.service;

import org.springframework.data.repository.CrudRepository;

import pl.dawidbronczak.spring.schoolRegistry.domain.Student;

public interface StudentService{

	Student findByEmail(String email);
	
}
