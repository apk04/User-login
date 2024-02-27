<html>
<head>
<title>Login</title>
</head>
<body>
<center>
<form method="post" action="Forget">
<table>
<tr>
<td>User Id
<td>
<input type="text" pattern="[a-zA-Z0-9]+@[a-zA-Z]+(\.[a-zA-Z0-9]+)+" 
required name="email" placeholder="email">
</td></tr>
<tr>
<td>Date of birth
<td>
<input type="text" name="date"  pattern="\d{4}-\d{1,2}-\d{1,2}" required
placeholder="YYYY-MM-DD">
</td></tr>
<tr>
<td>
<input type="submit" value="submit">
</table>
</form>
<br><br>
<a href="../index.html">Home</a>
</body>
</html>