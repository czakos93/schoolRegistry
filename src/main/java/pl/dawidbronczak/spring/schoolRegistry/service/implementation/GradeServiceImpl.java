package pl.dawidbronczak.spring.schoolRegistry.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dawidbronczak.spring.schoolRegistry.domain.Grade;
import pl.dawidbronczak.spring.schoolRegistry.repository.GradeRepository;
import pl.dawidbronczak.spring.schoolRegistry.service.GradeService;

@Service
public class GradeServiceImpl implements GradeService {
	
	@Autowired
	private GradeRepository gradeRepository;

	@Override
	public Grade findGradeById(int id) {
		return gradeRepository.findById(id).get();
	}

	@Override
	public void save(Grade grade) {
		gradeRepository.save(grade);
		
	}
	


}
