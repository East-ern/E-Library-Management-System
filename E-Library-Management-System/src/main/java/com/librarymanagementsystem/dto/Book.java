package com.librarymanagementsystem.dto;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(generator = RandomGenerator.generatorName)
	@GenericGenerator(name = RandomGenerator.generatorName, strategy = "com.librarymanagementsystem.dto.RandomGenerator")
	private String bookid;
	private String bookname;
	private String bookisbn;
	private double bookprice;

	@ManyToOne
	@JoinColumn(name = "studid")
	private Student bookstudent;
	
	private String issuedate;
	
	private String returndate;
	
	private String returnedby;
	
	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}

	public String getReturnedby() {
		return returnedby;
	}

	public void setReturnedby(String returnedby) {
		this.returnedby = returnedby;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public Student getBookstudent() {
		return bookstudent;
	}

	public void setBookstudent(Student bookstudent) {
		this.bookstudent = bookstudent;
	}

	public Book() {
		super();
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookisbn() {
		return bookisbn;
	}

	public void setBookisbn(String bookisbn) {
		this.bookisbn = bookisbn;
	}

	public double getBookprice() {
		return bookprice;
	}

	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}	
}
