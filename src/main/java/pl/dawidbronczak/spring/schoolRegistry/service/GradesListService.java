package pl.dawidbronczak.spring.schoolRegistry.service;

import pl.dawidbronczak.spring.schoolRegistry.domain.GradesList;
import pl.dawidbronczak.spring.schoolRegistry.domain.Student;
import pl.dawidbronczak.spring.schoolRegistry.domain.Subject;

public interface GradesListService {

	GradesList findByStudentAndSubject(Student student, Subject subject);
	GradesList findByStudentAndSubject(int studentId, int subjectId);
	
	void save(GradesList gradesList);
	
}
