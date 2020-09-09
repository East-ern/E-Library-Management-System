<%@page import="java.util.List"%>
<%@page import="com.librarymanagementsystem.dto.Book"%>
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
	
	<% ArrayList<Book> books = (ArrayList<Book>) session.getAttribute("bookList");  %>
	<form action="" method=post>
	<table style="border:1px solid black;margin-top: 150px;margin-left: auto;margin-right: auto;">
	<!-- margin-top: 150px;margin-left: auto;margin-right: auto; -->
		<tr>
			<th style="border:1px solid black;"> Book ID </th>
			<th style="border:1px solid black;"> Book Name </th>
			<th style="border:1px solid black;"> Book ISBN </th>
			<th style="border:1px solid black;"> Book Price </th>
			<th style="border:1px solid black;"> Student ID(issued to) </th>
			<th style="border:1px solid black;"> Issue Date </th>
		</tr>
	
	<% 
	if(session.getAttribute("bookList")!=null)
	{
		Iterator<Book> it = books.iterator();
		while(it.hasNext()){
			Book b = it.next();
		%>
		<tr>
			<td style="border:1px solid black;"><%=b.getBookid() %></td>
			<td style="border:1px solid black;"><%=b.getBookname() %></td>
			<td style="border:1px solid black;"><%=b.getBookisbn()%></td>
			<td style="border:1px solid black;"><%=b.getBookprice()%></td>
			<td style="border:1px solid black;"><%=b.getBookstudent().getStudid()%></td>
			<td style="border:1px solid black;"><%=b.getIssuedate()%></td>
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