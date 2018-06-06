package pl.dawidbronczak.spring.schoolRegistry.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dawidbronczak.spring.schoolRegistry.domain.Role;
import pl.dawidbronczak.spring.schoolRegistry.domain.SchoolClass;
import pl.dawidbronczak.spring.schoolRegistry.domain.Student;
import pl.dawidbronczak.spring.schoolRegistry.domain.User;
import pl.dawidbronczak.spring.schoolRegistry.repository.StudentRepository;
import pl.dawidbronczak.spring.schoolRegistry.service.RoleService;
import pl.dawidbronczak.spring.schoolRegistry.service.StudentService;
import pl.dawidbronczak.spring.schoolRegistry.service.UserService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	RoleService roleService;
	
	@Override
	public Student findByEmail(String email) {
		return studentRepository.findByEmail(email);
	}

	@Override
	public boolean isExist(int studentId) {
		return studentRepository.existsById(studentId);
	}

	@Override
	public void save(@Valid Student student) {
		Role role = roleService.findByRoleName("ROLE_STUDENT");
		Set<Role> roles = student.getRoles();
		roles.add(role);
		student.setRoles(roles);
		studentRepository.save(student);	
	}

	@Override
	public List<Student> findBySchoolClassIsNullOrSchoolClass(SchoolClass schoolClass) {
		return studentRepository.findBySchoolClassIsNullOrSchoolClass(schoolClass);
	}

	@Override
	public Student findById(int userId) {
		return studentRepository.findById(userId).get();	
	}

}
