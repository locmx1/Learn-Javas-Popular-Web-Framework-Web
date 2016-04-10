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
    <title>Student Create</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/student/create" method="POST">
        <input name="name" type="text" placeholder="Enter student name"/>
        <br />
        <input name="score" type="text" placeholder="Enter student score" />
        <br />
        <button type="submit">Save student</button>
    </form>
</body>
</html>
