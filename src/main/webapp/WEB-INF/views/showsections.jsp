<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 11.07.14
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp" />
<jsp:include page="menu.jsp" />

    <div id="content">
        ${actionString}
        <table class="select-section-box">
            ${listSections}
                <% //<c:forEach items="${listSections}" var="section">
                    //<td data-idsection="${section.id}"><a href="${pageContext.request.contextPath}/showseats?idsection=${section.id}">Сектор №${section.name}</a></td>
                //</c:forEach> %>
        </table>
    </div><!--content-->

<jsp:include page="footer.jsp" />
