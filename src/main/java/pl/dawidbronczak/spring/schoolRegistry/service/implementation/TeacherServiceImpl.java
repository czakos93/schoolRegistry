package pl.dawidbronczak.spring.schoolRegistry.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dawidbronczak.spring.schoolRegistry.domain.Teacher;
import pl.dawidbronczak.spring.schoolRegistry.repository.TeacherRepository;
import pl.dawidbronczak.spring.schoolRegistry.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Override
	public boolean isExist(int userId) {
		return teacherRepository.existsById(userId);
	}

	@Override
	public Teacher findById(int userId) {
		return teacherRepository.findById(userId).get();
	}

}
