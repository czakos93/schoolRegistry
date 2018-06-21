package pl.dawidbronczak.spring.schoolRegistry.service;

import pl.dawidbronczak.spring.schoolRegistry.domain.Role;

public interface RoleService{
	public Role findByRoleName(String name);
}
