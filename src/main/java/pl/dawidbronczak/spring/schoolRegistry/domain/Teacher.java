package pl.dawidbronczak.spring.schoolRegistry.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEACHERS")
public class Teacher extends User {

	
	@OneToMany(mappedBy = "leadTeacher")
	private List<Subject> learnedSubjects;

	
	public List<Subject> getLearnedSubjects() {
		return learnedSubjects;
	}

	public void setLearnedSubjects(List<Subject> learnedSubjects) {
		this.learnedSubjects = learnedSubjects;
	}
}
