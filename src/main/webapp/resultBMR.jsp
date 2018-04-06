<%--
  Created by IntelliJ IDEA.
  User: osamah
  Date: 4/4/18
  Time: 1:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BMR Result Page</title>
    <h2>BMR Result</h2>
</head>
<body>
    <p>${resultBMR}</p>

    <div>
        <span>Request URL</span>
        <code>https://www.AWS.com/fitness/service/bmr/${format}/${weight}/${height}/${age}/${gender}/${activity}</code>
    </div>

    <p><a href="index.jsp">Back to HomePage</a></p>
</body>
</html>
