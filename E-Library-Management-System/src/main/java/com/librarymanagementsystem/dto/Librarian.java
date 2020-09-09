package com.librarymanagementsystem.dto;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="librarian")
public class Librarian {
	@Id
//	@GeneratedValue(generator = UUIDGenerator.generatorName)
//	@GenericGenerator(name = UUIDGenerator.generatorName, strategy = "com.librarymanagementsystem.dto.UUIDGenerator")
	private String username;
	
	private String name;
	
	private String password;
	
	private String securityQuestion;
	
	private String securityAnswer;
	
	public Librarian() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
}
