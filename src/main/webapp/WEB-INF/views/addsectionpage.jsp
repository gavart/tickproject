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

<jsp:include page="header.jsp" />
<jsp:include page="menu.jsp" />

    <div id="content">
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
    </div><!--content-->

<jsp:include page="footer.jsp" />
