<%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>

<html>
<head>
<title> <tiles:getAsString name="titel"/></title>
</head>
<body id="basic-body">
<div>
<tiles:insertAttribute name="header"/>
</div>
<div id="container">
<tiles:insertAttribute name="body"/>
</div>
<footer>
<tiles:insertAttribute name="footer"/>
</footer>
</body>
</html>

      