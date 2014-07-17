<%-- 
    Document   : file_upload_form
    Created on : 07.07.2014, 15:08:35
    Author     : apple
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />
<jsp:include page="menu.jsp" />

    <div id="content">
        <h1>Загрузка текстовых файлов с местами</h1>
        <form:form method="post" action="${pageContext.request.contextPath}/upload_files"
                   modelAttribute="uploadForm" enctype="multipart/form-data">
            <table id="fileTable">
                <c:forEach items="${sectionOfStadiumList}" var="section" varStatus="loop">
                    <tr>
                        <td><input type="hidden" value="${section.id}" name="sectionsId[${loop.index}]" id="sectionsId" /></td>
                        <td>Сектор ${section.name}</td>
                        <td><input name="files[${loop.index}]" type="file" /></td>
                    </tr>
                </c:forEach>
            </table>
            <br/><input type="submit" value="Добавить" />
        </form:form>
    </div><!--content-->


<jsp:include page="footer.jsp" />

