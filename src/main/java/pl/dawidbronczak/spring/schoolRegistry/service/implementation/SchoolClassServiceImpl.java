package pl.dawidbronczak.spring.schoolRegistry.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dawidbronczak.spring.schoolRegistry.domain.SchoolClass;
import pl.dawidbronczak.spring.schoolRegistry.repository.SchoolClassRepository;
import pl.dawidbronczak.spring.schoolRegistry.service.SchoolClassService;

@Service
public class SchoolClassServiceImpl implements SchoolClassService {
	
	@Autowired
	private SchoolClassRepository schoolClassRepository;
	
	@Override
	public SchoolClass findClassById(int id) {
		Optional<SchoolClass> schoolClass = schoolClassRepository.findById(id);		
		return schoolClass.get();
	}

}
