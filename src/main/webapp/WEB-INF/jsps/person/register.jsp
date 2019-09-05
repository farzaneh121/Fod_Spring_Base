<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/pageCss.css">
<title>Register new user</title>
</head>
<body>
<br>
<c:if test="${not empty errors}">
<c:forEach items="${errors}" var="error">
<c:out value="${error.defaultMessage}"/>
<br>
</c:forEach>
</c:if>
<form action="/person/register" method="post">
<table>
<tr>
<td>first name </td>
<td>
<input name="firstName" type="text" >
</td>
</tr>
<tr>
<td>last name </td>
<td>
<input name="lastName" type="text" >
</td>
</tr>
<tr>
<td>email address </td>
<td>
<input name="emailAddress" type="text">
</td>
</tr>
<tr>
<td>user name </td>
<td>
<input name="principalName" type="text">
</td>
</tr>
<tr>
<td>
<input  type="submit" value="save">
</td>
</tr>
</table>

</form>
</body>
</html>