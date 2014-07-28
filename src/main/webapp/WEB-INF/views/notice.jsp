<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 26.07.14
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--<div id="notice" class="notice-usual">${msg}</div>-->
<c:choose>
    <c:when test="${typemsg=='error'}">
        <div class="alert alert-error">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            ${msg}
        </div>
    </c:when>
    <c:when test="${typemsg=='success'}">
        <div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            ${msg}
        </div>
    </c:when>
    <c:when test="${typemsg=='info'}">
        <div class="alert alert-info">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
                ${msg}
        </div>
    </c:when>
</c:choose>