package pl.dawidbronczak.spring.schoolRegistry.service.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import pl.dawidbronczak.spring.schoolRegistry.domain.Role;
import pl.dawidbronczak.spring.schoolRegistry.domain.SchoolClass;
import pl.dawidbronczak.spring.schoolRegistry.domain.Student;
import pl.dawidbronczak.spring.schoolRegistry.domain.Teacher;
import pl.dawidbronczak.spring.schoolRegistry.domain.User;
import pl.dawidbronczak.spring.schoolRegistry.repository.UserRepository;
import pl.dawidbronczak.spring.schoolRegistry.service.FunctionService;
import pl.dawidbronczak.spring.schoolRegistry.service.RoleService;
import pl.dawidbronczak.spring.schoolRegistry.service.StudentService;
import pl.dawidbronczak.spring.schoolRegistry.service.TeacherService;
import pl.dawidbronczak.spring.schoolRegistry.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private FunctionService functionService;
	
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
	public List<User> findAll() {
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
		User userToUpdate = userRepository.findById(user.getId()).get();
		userToUpdate.setFirstname(user.getFirstname());
		userToUpdate.setLastname(user.getLastname());
		userRepository.save(userToUpdate);
		
	}

	@Override
	public Set<User> findAllByFunctionIsNull() {
		return userRepository.findByFunctionIsNull();
		
	}

	@Override
	public void assingTeacherFunction(List<User> updatedTeachers) {
		Set<User> currentTeachers = userRepository.findByTeacherFunction();
		for (User updatedTeacher : updatedTeachers) {
			if(!currentTeachers.contains(updatedTeacher)){
				Teacher teacher = new Teacher();
				teacherService.save(teacher);
				updatedTeacher.setFunction(teacher);
				userRepository.save(updatedTeacher);
			}
		}
		for(User currentTeacher : currentTeachers) {
			if(!updatedTeachers.contains(currentTeacher)) {
				Teacher teacher = (Teacher) currentTeacher.getFunction();
				currentTeacher.setFunction(null);
				teacherService.delete(teacher);				
				userRepository.save(currentTeacher);
			}
		}
	}

	@Override
	public Set<User> findByTeacherFunction() {
		return userRepository.findByTeacherFunction();
	}

	@Override
	public Set<User> findByStudentFunction() {
		return userRepository.findByStudentFunction();
	}

	@Override
	public void assignStudentFunction(List<User> updatedStudents) {
		Set<User> currentStudents = userRepository.findByStudentFunction();
		for (User updatedStudent : updatedStudents) {
			if(!currentStudents.contains(updatedStudent)){
				Student student = new Student();
				studentService.save(student);
				updatedStudent.setFunction(student);
				userRepository.save(updatedStudent);
			}
		}
		for(User currentStudent : currentStudents) {
			if(!updatedStudents.contains(currentStudent)) {
				Student student = (Student) currentStudent.getFunction();
				currentStudent.setFunction(null);
				studentService.delete(student);				
				userRepository.save(currentStudent);
			}
		}
	}

	@Override
	public Set<User> findUsersWithoutClass() {
		Set<User> users = findByStudentFunction();
		Set<User> usersToReturn = new TreeSet<>();
		for(User user : users) {
			Student student = (Student) user.getFunction();
			if(student.getSchoolClass() == null) {
				usersToReturn.add(user);
			}
		}
		return usersToReturn;
	}

	@Override
	public Set<User> findUserWithClass(SchoolClass schoolClass) {
		Set<User> students = new TreeSet<>();
		
		for(User student : findByStudentFunction()) {
			if(((Student) student.getFunction()).getSchoolClass().equals(schoolClass)) {
				students.add(student);
			}
		}
		return students;
	}
}
