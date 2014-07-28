<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 27.07.14
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />
<jsp:include page="menu.jsp" />
<jsp:include page="notice.jsp" />
    <div class="content">
        <div class="transparent-div">
            <form class="form-search">
                <input type="text" name="q" placeholder="ФАМИЛИЯ пробел ИМЯ" class="input-large search-query">
                <button type="submit" class="btn">Найти</button>
            </form>
            <ol>
                <c:forEach items="${customerList}" var="customer">
                    <li><span class="firstName"> ${customer.firstName}</span><span class="lastName"> ${customer.lastName}</span></li>
                </c:forEach>
            </ol>
        </div>
    </div>


<jsp:include page="footer.jsp" />

