<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 10.07.14
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Added sections successfully</title>
</head>
<body>
GOOD
    <ol>
        <c:forEach items="${listWithSections}" var="section">
            <li>Сектор:${section.name}. Описание: ${section.description}. Стадион: ${section.stadium.name}.</li>
        </c:forEach>
    </ol>
</body>
</html>
