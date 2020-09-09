<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h1 style="color: green;"> Hi <%= (String)session.getAttribute("username") %></h1>
	<form action="" method="post">
		<table>
			<tr>
				<td><input type="submit" name = "gotodisplaystudents" formaction="gotodisplaystudents" value="STUDENT DETAILS" ></td>
				<td><input type="submit" name = "gotodisplaybooks" formaction="gotodisplaybooks" value="BOOK DETAILS"></td>
				<td><input type="submit" name = "gotoaddbook" formaction="gotoaddbook" value="ADD BOOK"></td>
				<td><input type="submit" name = "gotoaddstudent" formaction="gotoaddstudent" value="ADD STUDENT"></td>
			</tr>
			<tr>
				<td><input type="submit" name = "gotobookcheck" formaction="gotobookcheck" value="ISSUE BOOK"></td>
				<td><input type="submit" name = "gotoreturncheck" formaction="gotoreturncheck" value="RETURN BOOK"></td>
				<td><input type="submit" name = "gotoissuedbookdetails" formaction="gotoissuedbookdetails" value="ISSUED BOOK DETAILS"></td>
				<td><input type="submit" name = "gotoreturnedbookdetails" formaction="gotoreturnedbookdetails" value="RETURNED BOOK DETAILS"></td>
			</tr>
			
		</table>
	</form>
	</div>
	
</body>
</html>