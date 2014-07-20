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

    <div id="content" class="actions">
        <div class="transparent_div">
            <div id="oneAction">
                <h2>№4</h2>
                <span>тут кол-во свободных мест, и</span>
                <span class="details"></span>
            </div>
            <table id="select_plase_box" class="select_plase_box">
                ${rowsAndSeats}
            </table>
            <div class="div_button">
                <a class="clear_seats" href="">Отменить выбор</a>
                <a href="">Продать</a>
                <a href="">Бронь</a>
                <a href="">Освободить</a>
                <a href="">Исключить</a>
            </div>
        </div>
    </div><!--content-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/td.js" charset="UTF-8"></script>
<jsp:include page="footer.jsp" />
