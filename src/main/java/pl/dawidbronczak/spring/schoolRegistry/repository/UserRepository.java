package pl.dawidbronczak.spring.schoolRegistry.repository;

import org.springframework.data.repository.CrudRepository;

import pl.dawidbronczak.spring.schoolRegistry.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByEmail(String email);
	
}
