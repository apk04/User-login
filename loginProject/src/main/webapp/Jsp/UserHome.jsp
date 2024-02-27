<html>
<head>
<title>User Home</title>
<script>
function chkPass() 
{
	password=document.getElementById("password");
	confirm_password=document.getElementById("confirm_password");
	
	if(password.value != confirm_password.value)
	{
		document.getElementById("res").innerHTML="New Password does not Match!";
		document.getElementById("res").style.color="red";
		return false;
	}
	else
	{
		return true;
	}
}
</script>
</head>
<body bgcolor=#58A19F>
<center>
<h1>Welcome User!!</h1>
<form method="post" action="ChangePass" onsubmit="return chkPass()">
<table>
<caption>Change Password</caption>
<tr>
<td>Current Password
<td><input type="password" name="cpsw" required>
</tr>

<tr>
<td>New Password
<td><input type="password" id="password" name="psw" required>
</td></tr>

<tr>
<td>Confirm New Password
<td><input type="password" id="confirm_password"  name="npsw" required>
</td></tr>

<tr>
<td><input type="submit" value="Submit">
<td><h1 id="res"></h1>
</td></tr></table>
</form>

<a href="index.html">Home</a>
</body></html>
