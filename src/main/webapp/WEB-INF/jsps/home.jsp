<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/pageCss.css">

<meta charset="UTF-8">
<title>Shopping Home</title>
</head>
<body>

	<h3>welcome to Fari shop</h3>
	<br>
	<c:if test="${member.firstName ne null}">
		<c:out value="hi ${member.firstName} , welcome to your shop :) "></c:out>
	</c:if>
	<a href="${pageContext.request.contextPath}/person/goLoginPage"><button>Login</button></a>
	<a href="${pageContext.request.contextPath}/person/goRegisterPage"><button>Register</button></a>
	<a href="${pageContext.request.contextPath}/product/showProduct"><button>Show
			Product</button></a>
			<br>
<img alt="home" src="http://s2.picofile.com/file/8370859434/home.png" height="565px" width="400">

</body>
</html>
