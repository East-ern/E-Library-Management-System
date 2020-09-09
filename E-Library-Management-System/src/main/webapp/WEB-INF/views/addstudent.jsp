<html>
<body>
<div align="center">
<h1>ADD STUDENT</h1>
<form action="addstudent" method="post">
	<table>
		<tr>
			<td>Name : </td>
			<td><input type="text" name = "studname"></td>
		</tr>
		<tr>
			<td>Course : </td>
			<td>
				<select name="studcourse" id="studcourse">
				  <option value="be">B.E.</option>
				  <option value="btech">B.Tech</option>
				  <option value="mtech">M.Tech</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Branch : </td>
			<td>
				<select name="studbranch" id="studbranch">
				  <option value="cse">C.S.E.</option>
				  <option value="it">I.T.</option>
				  <option value="me">M.E.</option>
				  <option value="ec">E.C.</option>
				  <option value="civil">Civil</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Year : </td>
			<td>
				<select name="studyear" id="studyear">
				  <option value="1st">1st</option>
				  <option value="2nd">2nd</option>
				  <option value="3rd">3rd</option>
				  <option value="4th">4th</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Semester : </td>
			<td>
				<select name="studsem" id="studsem">
				  <option value="1st">1st</option>
				  <option value="2nd">2nd</option>
				  <option value="3rd">3rd</option>
				  <option value="4th">4th</option>
				  <option value="5th">5th</option>
				  <option value="6th">6th</option>
				  <option value="7th">7th</option>
				  <option value="8th">8th</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value = "ADD"></td>
			<td><input type="submit" formaction = "backtohome" value = "BACK"></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>
