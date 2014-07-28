<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 17.07.14
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <ul>
        <li><header>TickProject</header></li>
        <li class="divider-vertical"></li>
        <li><a href="${pageContext.request.contextPath}/index" tabindex = "1">Главная</a></li>
        <li class="divider-vertical"></li>
        <li><a href="${pageContext.request.contextPath}/search" tabindex = "2">Поиск</a></li>
        <li class="divider-vertical"></li>
        <li><a href="${pageContext.request.contextPath}/#" tabindex = "3">О проекте</a></li>
    </ul>
</nav>
