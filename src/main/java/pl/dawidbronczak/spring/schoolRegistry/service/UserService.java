package pl.dawidbronczak.spring.schoolRegistry.service;

import java.util.ArrayList;
import java.util.List;

import pl.dawidbronczak.spring.schoolRegistry.domain.User;

public interface UserService {
	public boolean isExist(User user);
	public void create(User user);
	public User findByEmail(String email);
	public List<User> findAll();
	public void remove(int userId);
	public User findById(int userId);
	public void save(User user);

}
