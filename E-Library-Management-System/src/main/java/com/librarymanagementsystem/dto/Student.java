package com.librarymanagementsystem.dto;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "studentreg")
public class Student {
	@Id
	@GeneratedValue(generator = RandomGenerator.generatorName)
	@GenericGenerator(name = RandomGenerator.generatorName, strategy = "com.librarymanagementsystem.dto.RandomGenerator")
	private String studid;
	private String studname;
	private String studcourse;
	private String studbranch;
	private String studyear;
	private String studsem;
	@OneToMany(mappedBy = "bookstudent")
	private Set<Book> studbooks;
	
	public Set<Book> getStudbooks() {
		return studbooks;
	}

	public void setStudbooks(Set<Book> studbooks) {
		this.studbooks = studbooks;
	}

	public Student() {
		super();
	}

	public String getStudid() {
		return studid;
	}

	public void setStudid(String studid) {
		this.studid = studid;
	}

	public String getStudname() {
		return studname;
	}

	public void setStudname(String studname) {
		this.studname = studname;
	}

	public String getStudcourse() {
		return studcourse;
	}

	public void setStudcourse(String studcourse) {
		this.studcourse = studcourse;
	}

	public String getStudbranch() {
		return studbranch;
	}

	public void setStudbranch(String studbranch) {
		this.studbranch = studbranch;
	}

	public String getStudyear() {
		return studyear;
	}

	public void setStudyear(String studyear) {
		this.studyear = studyear;
	}

	public String getStudsem() {
		return studsem;
	}

	public void setStudsem(String studsem) {
		this.studsem = studsem;
	}	
}
