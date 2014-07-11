

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>


    <jsp:include page="header.jsp" />    
    
    <div id="content">
        <h1>HELLO</h1>
        <div>
            <a href="${pageContext.request.contextPath}/upload_file_form">Upload Files</a>
            <h2>Схема стадиона Черноморец</h2>
            <img src="${pageContext.request.contextPath}/images/shema.jpg" height="70%" width="70%">
        </div>
    </div>
    
    <jsp:include page="footer.jsp" />  
   
    