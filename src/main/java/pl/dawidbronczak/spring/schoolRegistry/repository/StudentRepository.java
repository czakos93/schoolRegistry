package pl.dawidbronczak.spring.schoolRegistry.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import pl.dawidbronczak.spring.schoolRegistry.domain.SchoolClass;
import pl.dawidbronczak.spring.schoolRegistry.domain.Student;
import pl.dawidbronczak.spring.schoolRegistry.domain.User;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	public Set<Student> findBySchoolClassIsNull();
	public Set<Student> findBySchoolClass(SchoolClass schoolClass);
	public Student findByOwner(User loggedUser);
}
