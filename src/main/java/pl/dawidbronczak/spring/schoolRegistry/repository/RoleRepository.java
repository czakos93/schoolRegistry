package pl.dawidbronczak.spring.schoolRegistry.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pl.dawidbronczak.spring.schoolRegistry.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
	
	public Role findByRoleName(String roleName);
	
	
	
}
