package pl.dawidbronczak.spring.schoolRegistry.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import pl.dawidbronczak.spring.schoolRegistry.domain.SchoolClass;
import pl.dawidbronczak.spring.schoolRegistry.domain.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	public Student findByEmail(String email);
	
	public Set<Student> findBySchoolClassIsNull();

	public Set<Student> findBySchoolClass(SchoolClass schoolClass);
}
