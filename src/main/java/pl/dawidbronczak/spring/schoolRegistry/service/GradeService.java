package pl.dawidbronczak.spring.schoolRegistry.service;

import java.util.ArrayList;
import java.util.HashMap;

import pl.dawidbronczak.spring.schoolRegistry.domain.Grade;
import pl.dawidbronczak.spring.schoolRegistry.domain.Student;
import pl.dawidbronczak.spring.schoolRegistry.domain.Subject;

public interface GradeService {
	public Grade findGradeById(int id);
}
