package pl.dawidbronczak.spring.schoolRegistry.service.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import antlr.collections.List;
import pl.dawidbronczak.spring.schoolRegistry.domain.Role;
import pl.dawidbronczak.spring.schoolRegistry.domain.User;
import pl.dawidbronczak.spring.schoolRegistry.repository.UserRepository;
import pl.dawidbronczak.spring.schoolRegistry.service.RoleService;
import pl.dawidbronczak.spring.schoolRegistry.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public boolean isExist(User user){
		if(userRepository.findByEmail(user.getEmail()) != null) {
			return true;
		}
		return false;
	}	

	@Override
	public void create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role role = roleService.findByRoleName("ROLE_USER");		
		user.getRoles().add(role);
		userRepository.save(user);		
	}

	@Override
	public User findByEmail(String email) {		
		return userRepository.findByEmail(email);
	}

	@Override
	public java.util.List<User> findAll() {
		return (java.util.List<User>) userRepository.findAll();
	}

	@Override
	public void remove(int userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public User findById(int userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
		
	}


}
