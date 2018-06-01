package pl.dawidbronczak.spring.schoolRegistry.service;

import pl.dawidbronczak.spring.schoolRegistry.domain.Subject;

public interface SubjectService {
	
	public Subject findSubjectById(int id);
}
