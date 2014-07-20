<%-- 
    Document   : file_upload_success
    Created on : 07.07.2014, 15:09:37
    Author     : apple
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />
<jsp:include page="menu.jsp" />

    <div id="content">
        <div class="site-padding">
            <table id="select_plase_box" class="select_plase_box">
                ${rowsAndSeats}
            </table>
        </div>
    </div><!--content-->

<jsp:include page="footer.jsp" />