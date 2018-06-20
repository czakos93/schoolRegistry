package pl.dawidbronczak.spring.schoolRegistry.service.implementation;

import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dawidbronczak.spring.schoolRegistry.domain.Function;
import pl.dawidbronczak.spring.schoolRegistry.domain.Subject;
import pl.dawidbronczak.spring.schoolRegistry.domain.Teacher;
import pl.dawidbronczak.spring.schoolRegistry.domain.User;
import pl.dawidbronczak.spring.schoolRegistry.repository.TeacherRepository;
import pl.dawidbronczak.spring.schoolRegistry.service.RoleService;
import pl.dawidbronczak.spring.schoolRegistry.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public boolean isExist(int userId) {
		return teacherRepository.existsById(userId);
	}

	@Override
	public Teacher findById(int userId) {
		return teacherRepository.findById(userId).get();
	}

	@Override
	public List<Teacher> findAll() {
		return (List<Teacher>) teacherRepository.findAll();
	}

	

	@Override
	public void save(Teacher teacher) {
		teacherRepository.save(teacher);		
	}

	@Override
	public void delete(Teacher teacher) {
		for(Subject subject : teacher.getLearnedSubjects()) {
			subject.setLeadTeacher(null);
		}
		teacherRepository.delete(teacher);		
	}

}
