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

}
