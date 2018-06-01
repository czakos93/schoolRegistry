package pl.dawidbronczak.spring.schoolRegistry.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "STUDENTS")
public class Student extends User {
	
	
	@ManyToOne
	@JoinColumn(name = "SCHOOL_CLASS_ID")
	private SchoolClass schoolClass;
	
	
	@OneToMany(mappedBy = "owner")
	@MapKeyJoinColumn(name = "SUBJECT_ID")
	private Map<Subject, GradesList> gradesMap = new TreeMap<Subject, GradesList>();
	

	public SchoolClass getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}

	public Map<Subject, GradesList> getGradesMap() {
		return gradesMap;
	}

	public void setGradesMap(Map<Subject, GradesList> gradesMap) {
		this.gradesMap = gradesMap;
	}

	
	
	

}
