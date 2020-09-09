package com.librarymanagementsystem.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.librarymanagementsystem.dao.LoginDAO;
import com.librarymanagementsystem.dto.Book;
import com.librarymanagementsystem.dto.Librarian;
import com.librarymanagementsystem.dto.Student;

@Controller
public class LoginController {
	@RequestMapping(value = "/checklibrarian" , method = RequestMethod.POST)
	public String checkLibrarian(Librarian ref, HttpSession s) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		LoginDAO ld = (LoginDAO) context.getBean("ldao");
		
		if(ld.checkLibrarian(ref)) { 
			s.setAttribute("username", ref.getUsername());
			return "home";
		}
		else return "error";
	}
	
	@RequestMapping(value ="/registerlibrarian" , method = RequestMethod.POST)
	public String registerLibrarian() {
		return "register";
	}
	
	@RequestMapping(value="/forgotpassword", method=RequestMethod.POST)
	public String forgotpassword() {
		return "forgotpassword";
	}
	
	@RequestMapping(value = "/savelibrarian", method = RequestMethod.POST)
	public String saveLibrarian(Librarian ref) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		LoginDAO ld = (LoginDAO) context.getBean("ldao");
		
		if(ld.saveLibrarian(ref)) { 
			return "register_success";
		}
		else return "register_error";
	}
	
	@RequestMapping(value="/securityquestion", method = RequestMethod.POST)
	public String securityQuestion(@RequestParam("username") String username, HttpSession s) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		LoginDAO ld = (LoginDAO) context.getBean("ldao");
		
		Librarian l = ld.getLibrarianDetails(username);
		
		s.setAttribute("USERNAME",username);
		s.setAttribute("NAME",l.getName());
		s.setAttribute("SECURITY_QUESTION",l.getSecurityQuestion());
		
		if(l!=null) return "securityanswer";
		else return "error";
	}
	
	@RequestMapping(value="/passworddisplay", method = RequestMethod.POST)
	public String passwordDisplay(@RequestParam("username") String username,@RequestParam("securityAnswer") String answer, HttpSession s) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		LoginDAO ld = (LoginDAO) context.getBean("ldao");
		
		Librarian l = ld.getLibrarianDetails(username);
		if(ld.checkAnswer(username, answer)) {
			s.setAttribute("PASSWORD",l.getPassword());
			return "passworddisplay";
		}
		else return "error";
	}
	
	@RequestMapping(value ="/gotoaddbook" , method = RequestMethod.POST)
	public String goToAddBook() {
		return "addbook";
	}
	
	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public String addBook(Book ref) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		LoginDAO ld = (LoginDAO) context.getBean("ldao");
		
		if(ld.addBook(ref)) { 
			return "bookadded";
		}
		else return "error";
	}
	
	@RequestMapping(value ="/gotoaddstudent" , method = RequestMethod.POST)
	public String goToAddStudent() {
		return "addstudent";
	}
	
	@RequestMapping(value = "/addstudent", method = RequestMethod.POST)
	public String addStudent(Student ref) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		LoginDAO ld = (LoginDAO) context.getBean("ldao");
		
		if(ld.addStudent(ref)) { 
			return "studentadded";
		}
		else return "error";
	}
	
	@RequestMapping(value ="/backtohome" , method = RequestMethod.POST)
	public String backToHome() {
		return "home";
	}
	
	@RequestMapping(value ="/gotodisplaybooks" , method = RequestMethod.POST)
	public String displayBook(HttpSession s) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		LoginDAO ld = (LoginDAO) context.getBean("ldao");
		
		List<Book> l = ld.getAllBook();
		
		s.setAttribute("bookList", l);
		
		return "displaybook";
	}
	
	@RequestMapping(value ="/gotodisplaystudents" , method = RequestMethod.POST)
	public String displayStudent(HttpSession s) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		LoginDAO ld = (LoginDAO) context.getBean("ldao");
		
		List<Student> l = ld.getAllStudent();
		
		s.setAttribute("studentList", l);
		
		return "displaystudent";
	}
	
	@RequestMapping(value ="/gotobookcheck" , method = RequestMethod.POST)
	public String goToIssueBook() {
		return "bookcheck";
	}
	
	@RequestMapping(value = "/issuebooktostudent" , method = RequestMethod.POST)
	public String issueBookToStudent(@RequestParam("bookid") String bookid, HttpSession s) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		LoginDAO ld = (LoginDAO) context.getBean("ldao");
		
		Book b = ld.getBook(bookid);
		
		if(b!=null) { 
			s.setAttribute("bookid", b.getBookid());
			s.setAttribute("bookname", b.getBookname());
			s.setAttribute("bookisbn", b.getBookisbn());
			s.setAttribute("bookprice", b.getBookprice());
			if(b.getBookstudent()==null) s.setAttribute("available", "yes");
			else s.setAttribute("available", "no");
			return "bookavailability";
		}
		else return "error";
	}
	
	@RequestMapping(value ="/bookissued" , method = RequestMethod.POST)
	public String bookIssued(@RequestParam("bookid") String bookid,@RequestParam("studentid") String studid,@RequestParam("issuedate") String idate) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		LoginDAO ld = (LoginDAO) context.getBean("ldao");
		if(ld.updateBook(bookid, studid, idate)) {
			return "bookissued";
		}
		else return "error";
	}
	
	@RequestMapping(value ="/gotoissuedbookdetails" , method = RequestMethod.POST)
	public String goToIssuedBookDetails(HttpSession s) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		LoginDAO ld = (LoginDAO) context.getBean("ldao");
		
		List<Book> l = ld.getAllIssuedBook();
		
		s.setAttribute("bookList", l);
		
		return "displayissuedbook";
	}
	
	@RequestMapping(value ="/gotoreturncheck" , method = RequestMethod.POST)
	public String goToCheckIssuedBook() {
		return "returncheck";
	}
	
	@RequestMapping(value = "/returnbook" , method = RequestMethod.POST)
	public String returnBook(@RequestParam("bookid") String bookid, HttpSession s) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		LoginDAO ld = (LoginDAO) context.getBean("ldao");
		
		Book b = ld.getBook(bookid);
		
		if(b!=null) { 
			s.setAttribute("bookid", b.getBookid());
			s.setAttribute("bookname", b.getBookname());
			s.setAttribute("bookisbn", b.getBookisbn());
			s.setAttribute("bookprice", b.getBookprice());
			if(b.getReturnedby()==null) s.setAttribute("issued", "yes");
			else s.setAttribute("issued", "no");
			return "returnbook";
		}
		else return "error";
	}
	
	@RequestMapping(value ="/bookreturned" , method = RequestMethod.POST)
	public String bookReturned(@RequestParam("bookid") String bookid,@RequestParam("studentid") String studid,@RequestParam("returndate") String rdate) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		LoginDAO ld = (LoginDAO) context.getBean("ldao");
		if(ld.returnBook(bookid, studid, rdate)) {
			return "bookreturned";
		}
		else return "error";
	}
	
	@RequestMapping(value ="/gotoreturnedbookdetails" , method = RequestMethod.POST)
	public String goToReturnedBookDetails(HttpSession s) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		LoginDAO ld = (LoginDAO) context.getBean("ldao");
		
		List<Book> l = ld.getAllReturnedBook();
		
		s.setAttribute("bookList", l);
		
		return "displayreturnedbook";
	}
}
