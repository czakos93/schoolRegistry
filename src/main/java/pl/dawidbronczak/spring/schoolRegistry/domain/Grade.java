package pl.dawidbronczak.spring.schoolRegistry.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GRADES")
public class Grade {

	@Id
	@Column(name = "ID", unique = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "GRADE")
	private float grade;
	
	@ManyToOne
	@JoinColumn(name = "STUDENT_ID")
	private Student owner;
	
	@ManyToOne
	@JoinColumn(name = "SUBJECT_ID")
	private Subject subject;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToOne
	private GradesList gradeList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	public Student getOwner() {
		return owner;
	}

	public void setOwner(Student owner) {
		this.owner = owner;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public GradesList getGradeList() {
		return gradeList;
	}

	public void setGradeList(GradesList gradeList) {
		this.gradeList = gradeList;
	}
	
	

	
}
