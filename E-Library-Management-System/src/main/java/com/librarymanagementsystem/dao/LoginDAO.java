package com.librarymanagementsystem.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.librarymanagementsystem.dto.Book;
import com.librarymanagementsystem.dto.Librarian;
import com.librarymanagementsystem.dto.Student;

public class LoginDAO {
	private SessionFactory sessionFactory;

	public LoginDAO() {
		super();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean checkLibrarian(Librarian ref) {
		boolean b = false;
		try {
			Session s = sessionFactory.getCurrentSession();
			Query q = s.createQuery("From Librarian l Where l.username =:un and l.password =:pass");
			q.setParameter("un", ref.getUsername());
			q.setParameter("pass", ref.getPassword());
			
			List<Librarian> lst = q.list();
			if(!lst.isEmpty()) b =true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return b;
	}
	
	@Transactional
	public boolean saveLibrarian(Librarian ref) {
		boolean b = false;
		
		try {
			Session s = sessionFactory.getCurrentSession();
			s.save(ref);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return b;
	}
	
	@Transactional
	public Librarian getLibrarianDetails(String username) {
		Librarian l = null;
		try {
			Session s = sessionFactory.getCurrentSession();
			l = (Librarian)s.get(Librarian.class,username);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return l;
	}
	
	@Transactional
	public boolean checkAnswer(String username,String securityAnswer)
	{
		boolean b = false;
		
		try {
			Librarian l = getLibrarianDetails(username);
			if(l.getSecurityAnswer().equals(securityAnswer)) b = true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return b;
	}
	
	@Transactional
	public boolean addBook(Book ref) {
		boolean b = false;
		
		try {
			Session s = sessionFactory.getCurrentSession();
			s.save(ref);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return b;
	}
	
	@Transactional
	public boolean addStudent(Student ref) {
		boolean b = false;
		
		try {
			Session s = sessionFactory.getCurrentSession();
			s.save(ref);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return b;
	}
	
	@Transactional
	public List<Book> getAllBook() {
		try {
			Session s = sessionFactory.getCurrentSession();
			Criteria c = s.createCriteria(Book.class);
			return c.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public List<Student> getAllStudent() {
		try {
			Session s = sessionFactory.getCurrentSession();
			Criteria c = s.createCriteria(Student.class);
			return c.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public Book getBook(String bookid) {
		Book b = null;
		try {
			Session s = sessionFactory.getCurrentSession();
			b = (Book)s.get(Book.class,bookid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return b;
	}
	
	@Transactional
	public boolean updateBook(String bookid,String studentid,String issuedate) {
		boolean b = false;
		try {
			Session s = sessionFactory.getCurrentSession();
			Book book = (Book)s.get(Book.class,bookid);
			Student stud = (Student)s.get(Student.class, studentid);
			String stud1 = null;
			String issuedate1 = null;
			if(book.getBookstudent()==null) {
				Query q = s.createQuery("Update Book b set b.bookstudent =:sid, b.issuedate =:idate Where b.bookid =:bid");
				q.setParameter("sid",stud);
				q.setParameter("idate",issuedate);
				q.setParameter("bid",bookid);
				int i =q.executeUpdate();
				Query q1 = s.createQuery("Update Book b set b.returnedby =:sid, b.returndate =:idate Where b.bookid =:bid");
				q1.setParameter("sid",stud1);
				q1.setParameter("idate",issuedate1);
				q1.setParameter("bid",bookid);
				int j =q1.executeUpdate();
				if(i>0&&j>0) {
				b = true;}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return b;
	}
	
	@Transactional
	public List<Book> getAllIssuedBook() {
		try {
			Session s = sessionFactory.getCurrentSession();
			Criteria c = s.createCriteria(Book.class);
			c.add(Restrictions.isNotNull("bookstudent"));
			return c.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public boolean returnBook(String bookid,String studentid,String returndate) {
		boolean b = false;
		try {
			Session s = sessionFactory.getCurrentSession();
			Book book = (Book)s.get(Book.class,bookid);
			String issuedate = null;
			Student stud = null;
			if(book.getBookstudent()!=null) {
				Query q = s.createQuery("Update Book b set b.bookstudent =:sid, b.issuedate =:idate Where b.bookid =:bid");
				q.setParameter("sid",stud);
				q.setParameter("idate",issuedate);
				q.setParameter("bid",bookid);
				int i = q.executeUpdate();
				Query q1 = s.createQuery("Update Book b set b.returnedby =:sid, b.returndate =:rdate Where b.bookid =:bid");
				q1.setParameter("sid",studentid);
				q1.setParameter("rdate",returndate);
				q1.setParameter("bid",bookid);
				int j =q1.executeUpdate();
				if(i>0&&j>0) {
				b = true;}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return b;
	}
	
	@Transactional
	public List<Book> getAllReturnedBook() {
		try {
			Session s = sessionFactory.getCurrentSession();
			Criteria c = s.createCriteria(Book.class);
			c.add(Restrictions.isNotNull("returndate"));
			return c.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
