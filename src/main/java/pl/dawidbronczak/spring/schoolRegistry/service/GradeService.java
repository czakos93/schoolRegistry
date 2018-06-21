package pl.dawidbronczak.spring.schoolRegistry.service;

import pl.dawidbronczak.spring.schoolRegistry.domain.Grade;

public interface GradeService {
	public Grade findGradeById(int id);
}
