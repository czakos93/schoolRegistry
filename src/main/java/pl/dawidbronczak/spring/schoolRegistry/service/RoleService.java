package pl.dawidbronczak.spring.schoolRegistry.service;

import org.springframework.data.repository.CrudRepository;

import pl.dawidbronczak.spring.schoolRegistry.domain.Role;

public interface RoleService{
	public Role findByRoleName(String name);
}
