<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.mycompany.tickproject.models.Action" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 23.07.14
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />
<jsp:include page="menu.jsp" />
<div id="content" class="min-height-content">
    <div class="transparent-div">

        <form class="form-horizontal" id="form_add_action" method="get" action="${pageContext.request.contextPath}/addaction">
            <fieldset>
                <div id="legend">
                    <legend style="text-align:center;">Редактирование мероприятия</legend>
                </div>
                <div id="errmsg"></div>
                <div class="control-group">
                    <!-- Name Action -->
                    <div class="controls">
                        <input type="text" id="nameaction" name="nameaction" placeholder="${action.nameAction}" class="input-xxlarge" value="${action.nameAction}">
                        <!--<p class="help-block">Пожалуйста, напишите название мероприятия</p>-->
                    </div>
                </div>
                <div class="control-group">
                    <!-- Date and Time Action-->
                    <div class="controls">
                        <%
                            Action action = (Action) request.getAttribute("action");
                            SimpleDateFormat ftDate = new SimpleDateFormat ("dd-MM-yyyy");
                            SimpleDateFormat ftTime = new SimpleDateFormat ("HH:mm:ss");
                            out.println("<input type=\"datetime-local\" id=\"datetimeaction\" name=\"datetimeaction\" placeholder=\""+ftDate.format(action.getDateTimeAction())+"T"+ftTime.format(action.getDateTimeAction())+"\" class=\"input-xxlarge\" value=\""+ftDate.format(action.getDateTimeAction())+"T"+ftTime.format(action.getDateTimeAction())+"Z"+"\">");%>

                            <!--<p class="help-block">Пожалуйста, выберите дату и время, на которое заплонированно мероприятие</p>-->
                    </div>
                </div>
                <div class="control-group">
                    <!-- CheckBox and Button -->
                    <div class="controls">
                        <label class="checkbox">
                            <input type="checkbox" value="true" id="isNewPrices" name="isNewPrices" /> редактировать цены
                        </label>

                        <jsp:include page="set_prices.jsp" />
                        <button class="btn btn-primary" id="addActionButton" type="submit">Редактировать мероприятие</button>
                    </div>
                </div>

            </fieldset>
        </form>

    </div>
</div><!--content-->


<jsp:include page="footer.jsp" />
