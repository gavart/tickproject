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

    <div class="content actions min-height-content">
        <div class="transparent-div">
            ${actionString}
            <div class="div-sectors clearfix">
                ${listSections}
            </div>
        </div>
    </div><!--content-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/localS.js" charset="UTF-8"></script>

<jsp:include page="footer.jsp" />
