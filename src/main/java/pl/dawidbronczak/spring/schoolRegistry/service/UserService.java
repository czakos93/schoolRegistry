package pl.dawidbronczak.spring.schoolRegistry.service;

import java.util.ArrayList;

import pl.dawidbronczak.spring.schoolRegistry.domain.User;

public interface UserService {
	public boolean isExist(User user);
	public void saveUser(User user);
	public User findByEmail(String email);
}
