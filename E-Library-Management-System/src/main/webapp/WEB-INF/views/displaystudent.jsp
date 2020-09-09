<%@page import="com.librarymanagementsystem.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page import="java.util.ArrayList" %>
	<%@page import="com.librarymanagementsystem.dao.LoginDAO" %> 
	<%@page import="java.util.Iterator" %>
	
	<% ArrayList<Student> students = (ArrayList<Student>) session.getAttribute("studentList");  %>
	<form action="" method=post>
	<table style="border:1px solid black;margin-top: 150px;margin-left: auto;margin-right: auto;">
	<!--  -->
		<tr>
			<th style="border:1px solid black;"> Student ID </th>
			<th style="border:1px solid black;"> Student Name </th>
			<th style="border:1px solid black;"> Student Course</th>
			<th style="border:1px solid black;"> Student Branch </th>
			<th style="border:1px solid black;"> Student Year </th>
			<th style="border:1px solid black;"> Student Semester </th>
		</tr>
	
	<% 
	if(session.getAttribute("studentList")!=null)
	{
		Iterator<Student> it = students.iterator();
		while(it.hasNext()){
			Student s = it.next();
		%>
		<tr>
			<td style="border:1px solid black;"><%=s.getStudid() %></td>
			<td style="border:1px solid black;"><%=s.getStudname() %></td>
			<td style="border:1px solid black;"><%=s.getStudcourse()%></td>
			<td style="border:1px solid black;"><%=s.getStudbranch()%></td>
			<td style="border:1px solid black;"><%=s.getStudyear()%></td>
			<td style="border:1px solid black;"><%=s.getStudsem()%></td>
		</tr>
		<%
		}
	}
	%>	
		<tr>
			<td colspan="6"><div align="center"><input type="submit" formaction = "backtohome" value = "BACK"></div></td>
		</tr>
	</table>
	</form>
</body>
</html>