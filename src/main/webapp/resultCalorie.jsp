<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Fat Protein Carbohydrates Result Page</title>
</head>
<body>
<p>
<%=request. getAttribute("resultFPC")%>
</p>

<p><a href="index.jsp">Back to HomePage</a></p>
</body>
</html>
