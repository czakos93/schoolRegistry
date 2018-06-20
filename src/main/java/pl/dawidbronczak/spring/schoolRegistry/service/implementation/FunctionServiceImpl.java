package pl.dawidbronczak.spring.schoolRegistry.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dawidbronczak.spring.schoolRegistry.domain.Function;
import pl.dawidbronczak.spring.schoolRegistry.repository.FunctionRepository;
import pl.dawidbronczak.spring.schoolRegistry.service.FunctionService;

@Service
public class FunctionServiceImpl implements FunctionService {

	@Autowired
	private FunctionRepository functionRepository;
	
	@Override
	public void remove(Function function) {
		functionRepository.delete(function);
	}

}
