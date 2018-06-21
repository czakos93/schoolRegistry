package pl.dawidbronczak.spring.schoolRegistry.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;





@Entity
@Table(name = "TEACHERS")
public class Teacher extends Function {
	
	@OneToMany(mappedBy = "leadTeacher")
	private Set<Subject> learnedSubjects = new HashSet<>();
	
	@PreRemove
	public void preRemove(){
		for(Subject subject : learnedSubjects) {
			subject.setLeadTeacher(null);
		}
	}

	public Set<Subject> getLearnedSubjects() {
		return learnedSubjects;
	}

	public void setLearnedSubjects(Set<Subject> learnedSubjects) {
		this.learnedSubjects = learnedSubjects;
	}
}
