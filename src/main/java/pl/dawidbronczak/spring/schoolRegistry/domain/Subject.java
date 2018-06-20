package pl.dawidbronczak.spring.schoolRegistry.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECTS")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, updatable = false)
	private int id;
	
	@Column(name = "NAME")
	private String name;		
	
	@ManyToOne
	@JoinColumn(name = "TEACHER_ID")
	private Teacher leadTeacher;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getLeadTeacher() {
		return leadTeacher;
	}

	public void setLeadTeacher(Teacher leadTeacher) {
		this.leadTeacher = leadTeacher;
	}
	
	
	
}
