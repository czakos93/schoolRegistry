package pl.dawidbronczak.spring.schoolRegistry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pl.dawidbronczak.spring.schoolRegistry.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);
	
	@Query(value = "DELETE FROM users_roles WHERE user_id = ?1", nativeQuery = true)
	public void removeUserfromUsers_Roles(int userId);
	

}
