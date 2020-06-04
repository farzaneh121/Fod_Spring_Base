<%@page import="org.apache.taglibs.standard.tlv.JstlCoreTLV"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/pageCss.css">
</head>
<body id="error-body">
<a href="${pageContext.request.contextPath}/home">Go to Home</a>
<br>
<div>
<c:out value="${exception}"/>
<br>
<c:out value="${url}"/>
</div>
<img alt="error" src="http://s2.picofile.com/file/8370858684/err.png">
</body>
</html>