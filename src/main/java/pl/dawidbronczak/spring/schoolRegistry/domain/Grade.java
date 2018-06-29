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
@Table(name = "GRADES")
public class Grade {

	@Id
	@Column(name = "ID", unique = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "GRADE")
	private float gradeValue;
	
	@Column(name = "DESCRIPTION")
	private String description;

	
	@ManyToOne
	@JoinColumn(name = "GRADES_LIST_ID")
	private GradesList gradesList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getGradeValue() {
		return gradeValue;
	}

	public void setGradeValue(float gradeValue) {
		this.gradeValue = gradeValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public GradesList getGradesList() {
		return gradesList;
	}

	public void setGradesList(GradesList gradesList) {
		this.gradesList = gradesList;
	}


	
	

	
}
