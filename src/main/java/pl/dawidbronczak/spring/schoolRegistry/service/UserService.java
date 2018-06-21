package pl.dawidbronczak.spring.schoolRegistry.service;

import java.util.List;
import java.util.Set;

import pl.dawidbronczak.spring.schoolRegistry.domain.SchoolClass;
import pl.dawidbronczak.spring.schoolRegistry.domain.User;

public interface UserService {
	public boolean isExist(User user);
	public void create(User user);
	public User findByEmail(String email);
	public Iterable<User> findAll();
	public void remove(int userId);
	public User findById(int userId);
	public void save(User user);
	public Set<User> findAllByFunctionIsNull();
	public void assingTeacherFunction(List<User> list);
	public Set<User> findByTeacherFunction();
	public Set<User> findByStudentFunction();
	public void assignStudentFunction(List<User> list);
	public Set<User> findUsersWithoutClass();
	public Set<User> findUserWithClass(SchoolClass schoolClass);

}
