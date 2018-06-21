package pl.dawidbronczak.spring.schoolRegistry.service;

import pl.dawidbronczak.spring.schoolRegistry.domain.Teacher;


public interface TeacherService {

	boolean isExist(int userId);

	Teacher findById(int userId);

	Iterable<Teacher> findAll();

	void save(Teacher teacher);

	void delete(Teacher teacher);

}
