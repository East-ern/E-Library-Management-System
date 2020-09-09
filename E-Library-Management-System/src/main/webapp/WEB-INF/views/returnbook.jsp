<html>
<body>
<div align="center">
<h1>BOOK RETURN</h1>
<form action="bookreturned" method="post">
	<table>
		<tr>
			<td>Book Id : </td>
			<td><input type="text" name = "bookid" value="<%= (String)session.getAttribute("bookid") %>"></td>
		</tr>
		<tr>
			<td>Book Name : </td>
			<td><input type="text" name = "bookname" value="<%= (String)session.getAttribute("bookname") %>"></td>
		</tr>
		<tr>
			<td>ISBN : </td>
			<td><input type="text" name = "bookisbn" value="<%= (String)session.getAttribute("bookisbn") %>" ></td>
		</tr>
		<tr>
			<td>Price : </td>
			<td><input type="text" name = "bookprice" value="<%= (Double)session.getAttribute("bookprice") %>" ></td>
		</tr>
		<tr>
			<td>Issued : </td>
			<td><input type="text" name = "available" value="<%= (String)session.getAttribute("issued") %>" ></td>
		</tr>
		
		<tr>
			<td>Student Id : </td>
			<td><input type="text" name = "studentid"></td>
		</tr>
		<tr>
			<td>Date Of Issue : </td>
			<td><input type="date" name = "returndate"></td>
		</tr>
		<tr>
			<td><input type="submit" value = "RETURN BOOK"></td>
			<td><input type="submit" formaction="backtohome" value = "BACK"></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>
