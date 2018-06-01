package pl.dawidbronczak.spring.schoolRegistry.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dawidbronczak.spring.schoolRegistry.domain.Role;
import pl.dawidbronczak.spring.schoolRegistry.repository.RoleRepository;
import pl.dawidbronczak.spring.schoolRegistry.service.RoleService;

@Service
public class RoleServieImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role findByRoleName(String name) {
		return roleRepository.findByRoleName(name);
	}

}
