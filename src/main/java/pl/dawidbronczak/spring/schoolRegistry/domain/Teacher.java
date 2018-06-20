package pl.dawidbronczak.spring.schoolRegistry.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;



@Entity
@Table(name = "TEACHERS")
public class Teacher extends Function {

	
	@OneToMany(mappedBy = "leadTeacher")
	private Set<Subject> learnedSubjects = new HashSet<>();

	


	public Set<Subject> getLearnedSubjects() {
		return learnedSubjects;
	}

	public void setLearnedSubjects(Set<Subject> learnedSubjects) {
		this.learnedSubjects = learnedSubjects;
	}
}
