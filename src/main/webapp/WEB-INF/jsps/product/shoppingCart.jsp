<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pageCss.css">
<title>Shopping cart</title>
</head>
<body>

<form action="/product" method="get">
<table id="main-table">
<c:forEach items="${products}" var="product">
<c:set var="countRow" value="${countRow+1}"/>
<c:if test="${countRow mod 4 eq 0}">
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
<a href="${pageContext.request.contextPath}/product/deleteFromCart/${product.productId}">remove from Cart</a>
</td>
</tr>
</table>
</td>
</c:forEach>
</table>
<br>
<c:out value="total cost: ${sumCost}"/>
</form>

</body>
</html>