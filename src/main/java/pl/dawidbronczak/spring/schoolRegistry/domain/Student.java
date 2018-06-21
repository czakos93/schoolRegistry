package pl.dawidbronczak.spring.schoolRegistry.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS")
public class Student extends Function {
		
	@ManyToOne
	@JoinColumn(name = "SCHOOL_CLASS_ID")
	private SchoolClass schoolClass;
	
	
	@OneToMany(mappedBy = "student")
	private Set<GradesList> gradesLists = new HashSet<>();

	

	
	public SchoolClass getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}

	public Set<GradesList> getGradesLists() {
		return gradesLists;
	}

	public void setGradesLists(Set<GradesList> gradesLists) {
		this.gradesLists = gradesLists;
	}


}
