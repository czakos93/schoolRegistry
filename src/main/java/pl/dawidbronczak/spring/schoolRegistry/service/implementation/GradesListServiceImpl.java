package pl.dawidbronczak.spring.schoolRegistry.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dawidbronczak.spring.schoolRegistry.domain.GradesList;
import pl.dawidbronczak.spring.schoolRegistry.domain.Student;
import pl.dawidbronczak.spring.schoolRegistry.domain.Subject;
import pl.dawidbronczak.spring.schoolRegistry.repository.GradesListRepository;
import pl.dawidbronczak.spring.schoolRegistry.service.GradesListService;
import pl.dawidbronczak.spring.schoolRegistry.service.StudentService;
import pl.dawidbronczak.spring.schoolRegistry.service.SubjectService;

@Service
public class GradesListServiceImpl implements GradesListService {
	
	@Autowired
	GradesListRepository gradesListRepository;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	SubjectService subjectService;
	
	@Override
	public GradesList findByStudentAndSubject(Student student, Subject subject) {
		if(gradesListRepository.findByStudentAndSubject(student, subject) == null) {
			GradesList gradesList = new GradesList();
			gradesList.setStudent(student);
			gradesList.setSubject(subject);
			save(gradesList);
		}
		return gradesListRepository.findByStudentAndSubject(student, subject);
	}

	@Override
	public void save(GradesList gradesList) {
		gradesListRepository.save(gradesList);
		
	}

	@Override
	public GradesList findByStudentAndSubject(int studentId, int subjectId) {
		return findByStudentAndSubject(studentService.findById(studentId), subjectService.findSubjectById(subjectId));
	}


}
