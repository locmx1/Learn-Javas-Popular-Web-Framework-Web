<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/9/2016
  Time: 11:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
    <c:forEach var="row" items="${requestScope.student}">
        Id: ${row.id} - Name: ${row.name} - Score: ${row.score} <br/>
    </c:forEach>
</body>
</html>
