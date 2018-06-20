package pl.dawidbronczak.spring.schoolRegistry.repository;

import org.springframework.data.repository.CrudRepository;

import pl.dawidbronczak.spring.schoolRegistry.domain.Function;

public interface FunctionRepository extends CrudRepository<Function, Integer> {
	
}
