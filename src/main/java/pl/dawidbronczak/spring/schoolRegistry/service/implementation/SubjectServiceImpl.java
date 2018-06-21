package pl.dawidbronczak.spring.schoolRegistry.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dawidbronczak.spring.schoolRegistry.domain.Subject;
import pl.dawidbronczak.spring.schoolRegistry.repository.SubjectRepository;
import pl.dawidbronczak.spring.schoolRegistry.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Override
	public Subject findSubjectById(int id) {
		
		return subjectRepository.findById(id).get();
		
	}

	@Override
	public void create(Subject subject) {

		subjectRepository.save(subject);
		
	}

	@Override
	public void save(Subject subject) {
		subjectRepository.save(subject);		
	}

	@Override
	public Iterable<Subject> findAll() {
		return  subjectRepository.findAll();
	}

	@Override
	public void remove(int id) {
		subjectRepository.deleteById(id);		
	}

}
