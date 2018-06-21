package pl.dawidbronczak.spring.schoolRegistry.service;

import pl.dawidbronczak.spring.schoolRegistry.domain.Subject;

public interface SubjectService {
	
	public Subject findSubjectById(int id);

	public void create(Subject subject);

	public void save(Subject subject);

	public Iterable<Subject> findAll();

	public void remove(int id);
}
