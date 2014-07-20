<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" />
<jsp:include page="menu.jsp" />

    <div class="content actions">
        <div class="transparent_div">
            <!--<a href="${pageContext.request.contextPath}/upload_file_form">Upload Files</a>-->
            <div class="div_button  clearfix">
                <a href="">Добавить мероприятие</a>
                <h2>Список мероприятий:</h2>
            </div>
            <ul id="actions">
                ${actionListString}
            </ul>
        </div>
    </div>

<jsp:include page="footer.jsp" />

