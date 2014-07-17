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

    <div id="content">
        <div class="site-padding">
            <table id="select-plase-box" class="select-plase-box">
                ${rowsAndSeats}
            </table>
        </div>
    </div><!--content-->

<jsp:include page="footer.jsp" />
