package pl.dawidbronczak.spring.schoolRegistry.repository;

import org.springframework.data.repository.CrudRepository;

import pl.dawidbronczak.spring.schoolRegistry.domain.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	public Student findByEmail(String email);

}
