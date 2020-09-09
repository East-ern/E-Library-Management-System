<html>
<body>
<div align="center">
<h1>PASSWORD RETRIEVED</h1>
<form action="" method="post">
	<table>
		<tr>
			<td>Password : </td>
			<td><input type="text" name = "password" value="<%= (String)session.getAttribute("PASSWORD") %>"/></td>
		</tr>
	</table>
</form>
<jsp:include page="/index.jsp"></jsp:include>
</div>
</body>
</html>
