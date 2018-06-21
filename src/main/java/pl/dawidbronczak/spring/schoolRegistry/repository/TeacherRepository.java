package pl.dawidbronczak.spring.schoolRegistry.repository;

import org.springframework.data.repository.CrudRepository;

import pl.dawidbronczak.spring.schoolRegistry.domain.Teacher;


public interface TeacherRepository extends CrudRepository<Teacher, Integer> {


}
