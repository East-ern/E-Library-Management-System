<html>
<body>
<div align="center">
<h1>LOGIN FORM</h1>
<form action="checklibrarian" method="post">
	<table>
		<tr>
			<td>Username : </td>
			<td><input type="text" name = "username"></td>
		</tr>
		<tr>
			<td>Password : </td>
			<td><input type="password" name = "password"></td>
		</tr>
		<tr>
			<td><input type="submit" value = "SIGN IN"></td>
			<td><input type="submit" formaction="registerlibrarian" value = "SIGN UP"></td>
		</tr>
		<tr>
			<td>Having trouble signing in?</td>
			<td><input type="submit" formaction="forgotpassword" value = "FORGOT PASSWORD"></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>
