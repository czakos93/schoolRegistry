package pl.dawidbronczak.spring.schoolRegistry.repository;

import org.springframework.data.repository.CrudRepository;

import pl.dawidbronczak.spring.schoolRegistry.domain.SchoolClass;

public interface SchoolClassRepository extends CrudRepository<SchoolClass, Integer> {

}
