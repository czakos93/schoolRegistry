package pl.dawidbronczak.spring.schoolRegistry.repository;

import org.springframework.data.repository.CrudRepository;

import pl.dawidbronczak.spring.schoolRegistry.domain.GradesList;
import pl.dawidbronczak.spring.schoolRegistry.domain.Student;
import pl.dawidbronczak.spring.schoolRegistry.domain.Subject;

public interface GradesListRepository extends CrudRepository<GradesList, Integer> {
	GradesList findByStudentAndSubject(Student student, Subject subject);
}
