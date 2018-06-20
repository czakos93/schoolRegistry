package pl.dawidbronczak.spring.schoolRegistry.service;

import java.util.List;
import java.util.Set;

import pl.dawidbronczak.spring.schoolRegistry.domain.Function;
import pl.dawidbronczak.spring.schoolRegistry.domain.Teacher;
import pl.dawidbronczak.spring.schoolRegistry.domain.User;


public interface TeacherService {

	boolean isExist(int userId);

	Teacher findById(int userId);

	List<Teacher> findAll();

	void save(Teacher teacher);

	void delete(Teacher teacher);

}
