package pl.dawidbronczak.spring.schoolRegistry.repository;

import org.springframework.data.repository.CrudRepository;

import pl.dawidbronczak.spring.schoolRegistry.domain.Grade;

public interface GradeRepository extends CrudRepository<Grade, Integer> {

}
