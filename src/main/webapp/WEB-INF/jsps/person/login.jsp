<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login user</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/pageCss.css">

</head>
<body>

<form action="/person/login">
<table>
<tr>
<td>
user name:
</td>
<td>
<input type="text" name="principalName">
</td>
</tr>
<tr>
<td>
email address:
</td>
<td>
<input type="text" name="emailAddress">
</td>
</tr>
<tr>
<td>
<input type="submit" value="login">
</td>
</tr>
</table>
</form>
</body>
</html>