package pl.dawidbronczak.spring.schoolRegistry.service.implementation;

import java.util.List;
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
		return schoolClassRepository.findById(id).get();
	}

	@Override
	public List<SchoolClass> findAll() {
		return (List<SchoolClass>) schoolClassRepository.findAll();
	}

	@Override
	public void remove(int classId) {
		schoolClassRepository.deleteById(classId);
		
	}

	@Override
	public void save(SchoolClass schoolClass) {
		schoolClassRepository.save(schoolClass);
		
	}

}
