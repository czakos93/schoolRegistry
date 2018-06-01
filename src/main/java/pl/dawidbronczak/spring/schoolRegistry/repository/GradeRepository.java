package pl.dawidbronczak.spring.schoolRegistry.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import pl.dawidbronczak.spring.schoolRegistry.domain.Grade;
import pl.dawidbronczak.spring.schoolRegistry.domain.Student;

public interface GradeRepository extends CrudRepository<Grade, Integer> {
	public ArrayList<Grade> findAllByOwner(Student owner);
}
