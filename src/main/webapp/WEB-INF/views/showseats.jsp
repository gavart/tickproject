<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 11.07.14
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp" />
<jsp:include page="menu.jsp" />

    <div id="content" class="actions min-height-content">
        <div class="transparent-div">
            <div id="oneAction">
                <h2>Сектор №4</h2>
                <span>выбрано билетов на сумму: </span>
                <span class="details"></span>
            </div>
            <table id="select-plase-box" class="select-plase-box">
                ${rowsAndSeats}
            </table>
            <div class="div-button">
                <button class="btn btn-primary" id="clear_pick" type="button">Отменить выбор</button>
                <button class="btn btn-primary" data-toggle="modal" data-target="#myModal" id="sell" type="submit">Продать</button>
                <button class="btn btn-primary btn" data-toggle="modal" data-target="#myModal" id="booking" type="submit">Бронь</button>
                <button class="btn btn-primary" id="return_seats" type="submit">Вернуть в продажу</button>
            </div>
        </div>
    </div><!--content-->
<jsp:include page="dialog_booking.jsp" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/td.js" charset="UTF-8"></script>
<jsp:include page="footer.jsp" />
