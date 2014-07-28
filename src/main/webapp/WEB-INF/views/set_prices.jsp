<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 21.07.14
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table id="setPricesDIV" class="pricing-sectors-table hide">
    <tr>
    <c:forEach items="${defaultPrices}" var="defaultPrice" varStatus="loop">
        <c:if test="${loop.index>1&&(loop.index+1)%7==1}">
    </tr>
    <tr>
        </c:if>

        <td class = "${sectionsColor[loop.index]}">
            <div id="section[${loop.index}]" class = "sector-number">${defaultPrice.sectionOfStadium.name}</div>
            <input type="hidden" value="${defaultPrice.sectionOfStadium.id}" name="sectionsId[${loop.index}]" id="sectionsId[${loop.index}]" />
            <input type="hidden" value="${defaultPrice.action.id}" name="actionsId[${loop.index}]" id="actionsId[${loop.index}]" />
            <div class = "quad-content">
                <input type = "text" placeholder="${defaultPrice.price}" name="prices[${loop.index}]" value="${defaultPrice.price}" maxlength = "7">
</div>
</td>
</c:forEach>
</tr>
</table>