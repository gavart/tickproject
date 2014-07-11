<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 09.07.14
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление секторов</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/default.js" charset="UTF-8"></script>
</head>
<body>
    <div>
        <form:form method="post" action="${pageContext.request.contextPath}/addsection"
                   modelAttribute="sectionForm" enctype="multipart/form-data">
        <span>Стадион:
            <select name="stadiums[0]" style="width:285px">
                <option selected="selected">Выберите стадион</option>
                <c:forEach items="${listWithStadiums}" var="stadium">
                    <option value="${stadium.id}">${stadium.name}</option>
                </c:forEach>
            </select>
        </span>
        <input id="addSection" type="button" value="Add Section" />
        <table id="sectionTable">
            <tr>
                <td>Сектор:</td>
                <td><input name="names[0]" type="text" size="40" style="color: #777;" value="Название сектора"  /></td>
                <td><input name="descriptions[0]" type="text" size="100" style="color: #777;" value="Описание сектора" /></td>
            </tr>
        </table>
        <br/><input type="submit" value="Загрузить" />
        </form:form>
    </div>
</body>
</html>
