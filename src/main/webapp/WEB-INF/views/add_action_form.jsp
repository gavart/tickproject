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
    <div id="content" class="min-height-content">
        <div class="transparent-div">

            <form class="form-horizontal" id="form_add_action" method="get" action="${pageContext.request.contextPath}/addaction">
                <fieldset>
                    <div id="legend">
                        <legend style="text-align:center;">Информация о новом мероприятии</legend>
                    </div>
                    <div id="errmsg"></div>
                    <div class="control-group">
                        <!-- Name Action -->
                        <div class="controls">
                            <input type="text" id="nameaction" name="nameaction" placeholder="Название мероприятия" class="input-xxlarge">
                            <!--<p class="help-block">Пожалуйста, напишите название мероприятия</p>-->
                        </div>
                    </div>
                    <div class="control-group">
                        <!-- Date and Time Action-->
                        <div class="controls">
                            <input type="datetime-local" id="datetimeaction" name="datetimeaction" placeholder="Дата и время мероприятия" class="input-xxlarge">
                            <!--<p class="help-block">Пожалуйста, выберите дату и время, на которое заплонированно мероприятие</p>-->
                        </div>
                    </div>
                    <div class="control-group">
                        <!-- CheckBox and Button -->
                        <div class="controls">
                            <label class="checkbox">
                                <input type="checkbox" value="true" id="isNewPrices" name="isNewPrices" /> установить новые цены
                            </label>

                            <jsp:include page="set_prices.jsp" />
                            <button class="btn btn-primary" id="addActionButton" type="submit">Создать мероприятие</button>
                        </div>
                    </div>

                </fieldset>
            </form>

        </div>
    </div><!--content-->


<jsp:include page="footer.jsp" />