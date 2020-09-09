<html>
<body>
<div align="center">
<h1>SECURITY ANSWER CHECK</h1>
<form action="passworddisplay" method="post">
	<table>
		<tr>
			<td>Username : </td>
			<td><input type="text" name = "username" value="<%= (String)session.getAttribute("USERNAME") %>"/></td>
		</tr>
		<tr>
			<td>Name : </td>
			<td><input type="text" name = "name" value="<%= (String)session.getAttribute("NAME") %>"/></td>
		</tr>
		<tr>
			<td>Security Question : </td>
			<td><input type="text" name = "securityQuestion" value="<%= (String)session.getAttribute("SECURITY_QUESTION") %>"/></td>
		</tr>
		<tr>
			<td>Security Answer : </td>
			<td><input type="text" name = "securityAnswer"></td>
			<td><input type="submit" value = "RETRIEVE"/></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>
