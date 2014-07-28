<%--
  Created by IntelliJ IDEA.
  User: tverd.alex
  Date: 24.07.2014
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" />
<jsp:include page="menu.jsp" />

<h3>Поиск забронированных билетов:</h3>

<form action="${pageContext.request.contextPath}/search">
    <p>Номер заказа: <input type="text" name="id"><br>
    <p>Фамилия: <input type="text" name="lastname"><br>
    <p>Имя: <input type="text" name="firstname"><br>
        <input type="submit" value="Поиск">
</form>
<p></p>

<jsp:include page="footer.jsp" />

