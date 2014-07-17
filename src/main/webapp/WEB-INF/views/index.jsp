<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" />
<jsp:include page="menu.jsp" />

    <div id="content">
        <a href="${pageContext.request.contextPath}/upload_file_form">Upload Files</a>
        <h1>Список мероприятий:</h1>
        <ul id="actions">
            ${actionListString}
        </ul>
    </div>

<jsp:include page="footer.jsp" />

