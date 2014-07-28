<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.mycompany.tickproject.models.Action" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 20.07.14
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />
<jsp:include page="menu.jsp" />
<div style = "clear:both"></div>

<div id="content" class="min-height-content">
<div class = "transparent-div">
<form class="form-horizontal" id="form_add_action" method="get" action="${pageContext.request.contextPath}/addaction">
<fieldset>
<div id="legend">
    <legend class = "title-font">Регистрация нового мероприятия</legend>
</div>
<div id="errmsg"></div>

<div class = "control-group">
    <div class="left-side-block">
        <p class="input-title title-font">Название Мероприятия</p>
        <input tabindex = "4" type="text" id="nameaction" name="nameaction" class="input-xxlarge">
        <p class="input-title title-font">Начало Мероприятия</p>
        <%
            SimpleDateFormat ftDate = new SimpleDateFormat ("yyyy-MM-dd");
            SimpleDateFormat ftTime = new SimpleDateFormat ("HH:mm");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.HOUR_OF_DAY, 2);

            out.println("<input type=\"datetime-local\" id=\"startdatetimeaction\" name=\"startdatetimeaction\" class=\"input-xxlarge\" value=\""+ftDate.format(cal.getTime())+"T"+ftTime.format(cal.getTime())+"\" min=\""+ftDate.format(cal.getTime())+"T"+ftTime.format(cal.getTime())+"\" >");%>
    </div>

    <div class="right-side-block">
        <p class="input-title title-font">Таймаут брони</p>
        <%
            Action action = (Action) request.getAttribute("defaultAction");

            out.println("<input tabindex = \"7\" type=\"time\" id=\"timelimitbooking\" name=\"timelimitbooking\" class=\"input-xxlarge\" value=\""+ftTime.format(action.getTimeLimitBooking())+"\" min=\"00:01\" >");%>
        <p class="input-title title-font">Конец Мероприятия</p>
        <%
            Calendar cal2 = cal;
            cal2.add(Calendar.MINUTE, 30);

            out.println("<input type=\"datetime-local\" id=\"enddatetimeaction\" name=\"enddatetimeaction\" class=\"input-xxlarge\" value=\""+ftDate.format(cal2.getTime())+"T"+ftTime.format(cal2.getTime())+"\" min=\""+ftDate.format(cal2.getTime())+"T"+ftTime.format(cal2.getTime())+"\" >");%>
    </div>
</div>
<jsp:include page="set_prices.jsp" />

<div class = "confirm-block">
    <label class="checkbox title-font" for = "isNewPrices">Установить новые цены
        <input tabindex = "8" type="checkbox" value="true" id="isNewPrices" name="isNewPrices">
    </label>
    <button class="confirm-button title-font" id="addActionButton" type="submit">Готово</button>
</div>
</fieldset>
</form>


</div>
</div><!--content-->


<jsp:include page="footer.jsp" />