package pl.dawidbronczak.spring.schoolRegistry.repository;


import java.util.Set;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pl.dawidbronczak.spring.schoolRegistry.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByEmail(String email);

	public Set<User> findByFunctionIsNull();
	
	@Query("select u from User u where u.function in(select t from Teacher t)")
	public Set<User> findByTeacherFunction();

	@Query("select u from User u where u.function in(select s from Student s)")
	public Set<User> findByStudentFunction();
	

}
