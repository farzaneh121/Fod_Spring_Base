<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/pageCss.css">
<title>product</title>
</head>
<body>
<form action="/product/search">
<table>
<tr>
<td>
<select name="categoryId" title="product category">
<option value=""> <c:out value="choose one item"> </c:out> </option>
<c:forEach items="${categoryList}" var="category">
<option value="${category.categoryId}"><c:out value="${category.categoryName}"></c:out> </option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td>
<input type="text" name="productName">
</td>
</tr>
<tr>
<td>
<input type="submit" name="search" value="search">
</td>
</tr>
</table>
</form>
<c:if test="${message ne null}">
<c:out value="${message}"/>
</c:if>
<table id="main-table">
<c:forEach items="${productList}" var="product">
<c:set var="counter" value="${counter+1}" scope="request"/>
<c:if test="${counter mod 4 eq 0 }">
<tr>
</c:if>
<td>
<table id="mini-table">
<tr>
<td>
<c:out value="${product.productName}"/>
</td>
</tr>
<tr>
<td>
<c:out value="${product.productCategory.categoryName}"/>
</td>
</tr>
<tr>
<td>
<c:out value="${product.productStatus}"/>
</td>
</tr>
<tr>
<td>
<c:out value="${product.costPrice}"/>
</td>
</tr>
<tr>
<td>
<a href="${pageContext.request.contextPath}/product/addToCart/${product.productId}">Add To Cart</a>
</td>
</tr>
</table>
</td>
</c:forEach>
</table>
</body>
</html>