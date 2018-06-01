package pl.dawidbronczak.spring.schoolRegistry.service;

import pl.dawidbronczak.spring.schoolRegistry.domain.SchoolClass;

public interface SchoolClassService {
	public SchoolClass findClassById(int id);
}
