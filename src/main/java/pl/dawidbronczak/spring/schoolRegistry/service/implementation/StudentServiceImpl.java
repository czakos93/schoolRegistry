package pl.dawidbronczak.spring.schoolRegistry.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dawidbronczak.spring.schoolRegistry.domain.Student;
import pl.dawidbronczak.spring.schoolRegistry.repository.StudentRepository;
import pl.dawidbronczak.spring.schoolRegistry.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Student findByEmail(String email) {
		return studentRepository.findByEmail(email);
	}

}
