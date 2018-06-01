package pl.dawidbronczak.spring.schoolRegistry.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name = "GRADES_LISTS")
public class GradesList {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy = "gradeList")
	private List<Grade> grades = new ArrayList<Grade>();
	
	@ManyToOne
	@JoinColumn(name = "OWNER_ID")
	private Student owner;
	
	@Transient
	private float average;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	
	public float getAverage() {
		float sum = 0;
		for(Grade grade : grades){
			 sum += grade.getGrade();			 
		}
		average = sum/grades.size();
		return average;
	}


	
	
}
