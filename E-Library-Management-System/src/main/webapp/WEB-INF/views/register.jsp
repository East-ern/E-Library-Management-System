<html>
<body>
<div align="center">
<h1>REGISTRATION FORM</h1>
<form action="savelibrarian" method="post">
	<table>
		<tr>
			<td>Username : </td>
			<td><input type="text" name = "username"></td>
		</tr>
		<tr>
			<td>Name : </td>
			<td><input type="text" name = "name"></td>
		</tr>
		<tr>
			<td>Password : </td>
			<td><input type="password" name = "password"></td>
		</tr>
		<tr>
			<td>Security Question : </td>
			<td>
				<select name="securityQuestion" id="securityQuestion">
				  <option value="What's your favourite book?">What's your favourite book?</option>
				  <option value="Name of you favourite teacher?">Name of you favourite teacher?</option>
				  <option value="What's your favourite dish?">What's your favourite dish?</option>
				  <option value="What's your childhood nickname?">What's your childhood nickname?</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Security Answer : </td>
			<td><input type="text" name = "securityAnswer"></td>
		</tr>
		<tr>
			<td><input type="submit" value = "REGISTER"></td>
			<td><input type="reset" value = "CLEAR"></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>
